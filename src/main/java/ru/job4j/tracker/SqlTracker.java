package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
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
        prepareTable(this.tableName);
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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

    private void prepareTable(String tableName) {
        String createTable = String.format("CREATE TABLE IF NOT EXISTS %s(%s, %s, %s);",
                tableName,
                "item_id serial primary key",
                "name VARCHAR(255) NOT NULL",
                "created DATE NOT NULL"
        );
        try (Statement s = cn.createStatement()) {
            s.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
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
        Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());

        try (PreparedStatement ps = this.cn.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, timestampFromLDT);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean replace(int id, Item item) {
        int tmp = 0;

        String sql = String.format("UPDATE %s SET name = ?, created = ? WHERE item_id = ?",
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
        String sql = String.format("DELETE FROM %s WHERE item_id = ?",
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
        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(int id) {
        return null;
    }
}
