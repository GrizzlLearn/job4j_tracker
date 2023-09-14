package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    private final String tableName = "items";

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            new SqlTracker(cn);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sql = String.format("INSERT INTO %s(name, created) VALUES(?, ?)",
                this.tableName);
        Item result = new Item(item.getName());

        try (PreparedStatement ps = this.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated().withNano(0)));
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Вставка не удалась, ни одна запись не была изменена.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                    result.setId(generatedKeys.getInt(1));
                    result.setCreated(item.getCreated());
                } else {
                    throw new SQLException("Не удалось получить сгенерированный ключ.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean replace(int id, Item item) {
        int tmp = 0;

        String sql = String.format("UPDATE %s SET name = ?, created = ? WHERE id = ?",
                this.tableName);
        Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());

        try (PreparedStatement ps = this.cn.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, timestampFromLDT);
            ps.setInt(3, id);
            tmp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tmp > 0;
    }

    @Override
    public void delete(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?",
                this.tableName);

        try (PreparedStatement ps = this.cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        String sql = String.format("SELECT * FROM %s",
                this.tableName);

        return getItems(sql);
    }

    @Override
    public List<Item> findByName(String name) {
        String sql = String.format("SELECT * FROM %s WHERE name = '%s'",
                this.tableName,
                name);

        return getItems(sql);
    }

    private List<Item> getItems(String sql) {
        List<Item> result = new ArrayList<>();

        try (PreparedStatement ps = this.cn.prepareStatement(sql)) {
            result = fillingObject(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = new Item();
        String sql = String.format("SELECT * FROM %s WHERE id = ?",
                this.tableName
        );

        try (PreparedStatement ps = this.cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            List<Item> tmp = fillingObject(ps);
            result = tmp.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Item> fillingObject(PreparedStatement ps) throws SQLException {
        List<Item> result = new ArrayList<>();
        try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                result.add(item);
            }
        }

        return result;
    }
}
