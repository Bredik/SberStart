package ru.sbr.DAO;

import java.sql.*;

public class ConnectionDB {
    //todo сдеать файл с настройками
    // Драйвер и путь к базе данных
    static  final String root = System.getProperty("user.dir");
    static final String dbName = "/bank-api";

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:" + root + dbName;

    //  Юзер и пароль к БД
    static final String USER = "user";
    static final String PASS = "user";

    public static Connection connection;
    //static Statement statement;

    public static void connect() throws SQLException {
        try {
            // Регистрируем драйвер
            Class.forName(JDBC_DRIVER);

            // Открываем соединение
            System.out.println("Соединяемся с базой...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("База Подключена!");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR! Класс не найден");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println( "Ошибка sql");
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
