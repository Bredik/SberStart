package ru.sbr.DAO;

import ru.sbr.entity.Cards;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    public List<Cards> getAllCards() {
        System.out.println("Чтение из БД...");
        String sql = "SELECT * FROM Clients";
        ResultSet rs = null;
        List<Cards> listCards = new ArrayList<>();

        try {
            //???
            // todo нужно ли завершить executeQuery
            rs = InitDB.statement.executeQuery(sql);
            while(rs.next()) {
                int id  = rs.getInt("id");
                String first = rs.getString("name");

                listCards.add(new Cards(id, first));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCards;
    }

    public int addNewCard() {
        int codeResponce = 0;
        String sql = "INSERT INTO Card (id, first) VALUES (6, '666-123-453-767')";
        try {
            codeResponce = InitDB.statement.executeUpdate(sql);
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
