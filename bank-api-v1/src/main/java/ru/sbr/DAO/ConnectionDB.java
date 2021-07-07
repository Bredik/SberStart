package ru.sbr.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {
    public static Connection connection;

    public static void connect() throws SQLException {
        FileInputStream inputStream;
        Properties property = new Properties();

        try {
            inputStream = new FileInputStream("src/main/resources/configDB.properties");
            property.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден конфиг");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = property.getProperty("db.login");
        String pass = property.getProperty("db.password");
        String jdbc_driver = property.getProperty("jdbc_driver");
        String dbName = property.getProperty("dbName");
        String db_url = property.getProperty("db_url") + System.getProperty("user.dir") + dbName;;

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
