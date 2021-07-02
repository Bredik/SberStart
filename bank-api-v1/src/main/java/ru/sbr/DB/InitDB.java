package ru.sbr.DB;

import ru.sbr.DTO.Cards;
import ru.sbr.parser.ToJson;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitDB {
    // Драйвер и путь к базе данных
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:/Users/u19305189/Desktop/projects/DataBase/DB/test1";

    //  Юзер и пароль к БД
    static final String USER = "sa";
    static final String PASS = "";

    static Connection connection;
    static Statement statement;

    public static void requestAddTable() {
        String sql = "CREATE TABLE   REG1 " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        try {
            statement.executeUpdate(sql);
            System.out.println("База данных создана");
        } catch (SQLException e) {
            System.out.println("Ошибка sql в методе requestAddTable");
            e.printStackTrace();
        }
        System.out.println("Created table in given database...");
    }

    public static List<Cards> readTable() {
        String sql = "SELECT * FROM Card";
        ResultSet rs = null;
        List<Cards> listCards = null;

        try {
            rs = statement.executeQuery(sql);
            

            while(rs.next()) {
                int id  = rs.getInt("id");
                String first = rs.getString("first");

                listCards = new ArrayList<>(Arrays.asList(
                        new Cards(id, first)
                ));

                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
                System.out.println("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCards;
    }

    public static void connect() throws SQLException {
        try {
            // Регистрируем драйвер
            Class.forName(JDBC_DRIVER);

            // Открываем соединение
            System.out.println("Соединяемся с базой...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Создаем запрос
            System.out.println("Подготавливаем запрос...");
            statement = connection.createStatement();

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
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) connection.close();
            System.out.println("База отключена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
