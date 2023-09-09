package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void testReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("One");
        tracker.add(item);
        Item newItem = new Item("New One");
        tracker.replace(tracker.findById(item.getId()).getId(), newItem);
        assertThat(tracker.findById(item.getId())).isEqualTo(newItem);
    }

    @Test
    public void testDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item one = new Item("One");
        Item two = new Item("Two");
        tracker.add(one);
        tracker.add(two);
        tracker.delete(one.getId());
        assertThat(tracker.findById(one.getId())).isNull();
    }

    @Test
    public void testFIndAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item one = new Item("One");
        Item two = new Item("Two");
        tracker.add(one);
        tracker.add(two);
        assertThat(tracker.findAll()).hasSize(2);
    }
}
