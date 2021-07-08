package ru.sbr.DAO;

import java.sql.*;

public class ConnectionDB {
    public static Connection connection;

    public static void connect() throws SQLException {
        ReadDataForConnection readData = new ReadDataForConnection();

        String user = readData.getUser();
        String pass = readData.getPass();
        String jdbc_driver = readData.getJdbc_driver();
        String db_url = readData.getDb_url();

        try {
            Class.forName(jdbc_driver); //Регистрируем драйвер
            System.out.println("Соединяемся с базой...");
            connection = DriverManager.getConnection(db_url, user, pass); //Открываем соединение
            System.out.println("База Подключена!");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR! Класс не найден");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка sql");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Другая ошибка");
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null) connection.close();
            System.out.println("База отключена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
