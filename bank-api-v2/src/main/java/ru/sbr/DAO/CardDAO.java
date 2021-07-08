package ru.sbr.DAO;

import ru.sbr.entity.Cards;
import ru.sbr.entity.Deposite;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sbr.DAO.ConnectionDB.connection;

public class CardDAO {
    public  List<Cards> getAllCards() {
        String sql = "SELECT * FROM Cards";
        ResultSet resultSet;
        List<Cards> listCards = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            System.out.println("посылаю запрос на чтение карт из БД");
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                long id  = resultSet.getInt("id");
                String number = resultSet.getString("card_number");
                listCards.add(new Cards(id, number));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listCards;
    }

    public Map<Long, Float> checkBalance(long idCard) {
        ResultSet resultSet;
        Map<Long, Float> cardBalance = new HashMap<>();
        String sql = "SELECT balance FROM CARDS WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,idCard);

            System.out.println("посылаю запрос на проверку баланса в БД");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                float number = resultSet.getFloat("balance");
                cardBalance.put(idCard, number);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cardBalance;
    }

    public int depFundsToCard(Deposite deposite) {
        int codeResponce = 0;
        float sum = deposite.getSum();
        long idCard = deposite.getId();
        String sql = "UPDATE CARDS SET BALANCE = BALANCE + ? WHERE ID = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, sum);
            preparedStatement.setLong(2,idCard);
            System.out.println("посылаю запрос на внесение сумму в БД");
            codeResponce = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codeResponce;
    }

    public int addNewCard(Deposite deposite) {
        int codeResponse = 0;
        String sql = "INSERT INTO CARDS (balance, id_account) VALUES (?, ?)";
        long idAccount = deposite.getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setLong(2, idAccount);
            System.out.println("посылаю запрос на добавление новой карты в БД");
            codeResponse = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLIntegrityConstraintViolationException throwables) {
            System.out.println("ERROR! Нет такого счета: " + idAccount);
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codeResponse;
    }
}
