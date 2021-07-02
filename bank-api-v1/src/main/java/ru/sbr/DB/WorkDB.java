package ru.sbr.DB;

import java.sql.SQLException;

public class WorkDB {
    public static void exe() {
        try {
            InitDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
