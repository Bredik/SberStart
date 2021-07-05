package ru.sbr.DAO;

import ru.sbr.entity.Cards;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ru.sbr.DAO.ConnectionDB.connection;

public class CardDAO {
    public static List<Cards> getAllCards() {
        System.out.println("Чтение из БД...");
        String sql = "SELECT * FROM Cards";
        ResultSet rs = null;
        List<Cards> listCards = new ArrayList<>();

        try {
            //???
            // todo нужно ли завершить executeQuery
            //todo нужно ли закрывать statment  и где
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sql);

            while(rs.next()) {
                int id  = rs.getInt("id");
                String number = rs.getString("number");

                listCards.add(new Cards(id, number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCards;
    }

    public int addNewCard() {
        int codeResponce = 0;
        String sql = "INSERT INTO CARDS (NUMBER, BALABCE, ACCOUNT_ID) VALUES ('123-123', 0, 1)";
        try {
            Statement statement = connection.createStatement();
            codeResponce = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return codeResponce;
    }

    public void depFundsToCard() {

    }

    public int checkBalance() {
        return 0;
    }
}
