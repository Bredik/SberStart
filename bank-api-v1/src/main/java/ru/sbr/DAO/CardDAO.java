package ru.sbr.DAO;

import ru.sbr.entity.Cards;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    public List<Cards> getAllCards() {
        System.out.println("Чтение из БД...");
        String sql = "SELECT * FROM Card";
        ResultSet rs = null;
        List<Cards> listCards = new ArrayList<>();

        try {
            //???
            // todo нужно ли завершить executeQuery
            rs = InitDB.statement.executeQuery(sql);
            while(rs.next()) {
                int id  = rs.getInt("id");
                String first = rs.getString("first");

                listCards.add(new Cards(id, first));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCards;
    }

    public void addNewCard() {

    }

    public void depFundsToCard() {

    }

    public int checkBalance() {
        return 0;
    }
}
