package ru.sbr.DAO;

import ru.sbr.entity.Cards;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sbr.DAO.ConnectionDB.connection;

public class CardDAO {
    public static List<Cards> getAllCards() {
        System.out.println("Чтение из БД...");
        String sql = "SELECT * FROM Cards";
        ResultSet resultSet = null;
        List<Cards> listCards = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id  = resultSet.getInt("id");
                String number = resultSet.getString("card_number");
                listCards.add(new Cards(id, number));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listCards;
    }

    public int addNewCard(long idAccount) {
        int codeResponce = 0;
        String sql = "INSERT INTO CARDS (balance, id_account) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setLong(2,idAccount);
            System.out.println("посылаю запрос в БД");
            codeResponce = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLIntegrityConstraintViolationException throwables) {
            System.out.println("ERROR! Нет такого счета: " + idAccount);
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codeResponce;
    }

    public int depFundsToCard(float sum, long idCard) {
        int codeResponce = 0;

        String sql = "UPDATE CARDS SET BALANCE = BALANCE + ? WHERE ID = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, sum);
            preparedStatement.setLong(2,idCard);
            System.out.println("посылаю запрос в БД");
            codeResponce = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codeResponce;
    }

    public Map<Long, Float> checkBalance(long idCard) {
        ResultSet resultSet = null;
        Map<Long, Float> cardBalance = new HashMap<>();

        String sql = "SELECT balance FROM CARDS WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,idCard);
            System.out.println("посылаю запрос в БД");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //long id  = resultSet.getInt("id");
                float number = resultSet.getFloat("balance");
                cardBalance.put(idCard, number);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cardBalance;
    }
}
