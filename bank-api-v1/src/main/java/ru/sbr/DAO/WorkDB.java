package ru.sbr.DAO;

import java.sql.SQLException;

public class WorkDB {
    public static void init() {
        try {
            InitDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        InitDB.disconnect();
    }
}
