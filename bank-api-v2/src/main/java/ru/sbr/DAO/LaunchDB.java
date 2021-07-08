package ru.sbr.DAO;

import java.sql.SQLException;

public class LaunchDB {
    public static void connect() {
        try {
            ConnectionDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        ConnectionDB.disconnect();
    }
}
