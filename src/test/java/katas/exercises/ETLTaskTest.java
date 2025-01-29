package katas.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class ETLTaskTest {
    private static final String SOURCE_DB_PATH = "source.db";
    private static final String TARGET_DB_PATH = "target.db";

    @BeforeEach
    void setupTargetDatabase() throws SQLException {
        try (Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + TARGET_DB_PATH);
             Statement targetStmt = targetConn.createStatement() ){

                 targetStmt.execute("DROP TABLE IF EXISTS transformed_users");
        }
    }

    @Test
    void testPerformETL() throws SQLException {
        ETLTask.performETL(SOURCE_DB_PATH, TARGET_DB_PATH);

        try (Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + TARGET_DB_PATH);
             Statement targetStmt = targetConn.createStatement();
             ResultSet rs = targetStmt.executeQuery("SELECT * FROM transformed_users")) {


            assertTrue(rs.next());
            assertEquals(1, rs.getInt("user_id"));
            assertEquals("Elon Musk", rs.getString("full_name"));
            assertEquals("elon@spacex.com", rs.getString("email"));
            assertEquals("30-60", rs.getString("age_group"));
            assertTrue(rs.getInt("years_registered") > 20);

            assertTrue(rs.next());
            assertTrue(rs.next());
            assertFalse(rs.next());
        }
    }

    @AfterEach
    void cleanup() {
        new java.io.File(TARGET_DB_PATH).delete();
    }
}
