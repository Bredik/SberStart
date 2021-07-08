package DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbr.DAO.CardDAO;
import ru.sbr.DAO.CreateDB;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;
import ru.sbr.entity.Cards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Тестирование ПОЛУЧЕНИЯ данных (чтения) из БД
 */

public class CardDaoReadTest {
    @BeforeAll
    public static void startServerAndDB() throws IOException {
        Server.start();
        LaunchDB.connect();
        CreateDB.dbCreate();
    }

    @AfterAll
    public static void stopServerAndDB() {
        LaunchDB.disconnect();
        Server.stop();
    }

    @Test
    public void getAllCardTestShouldEquals() {
        CardDAO cardDAO = new CardDAO();
        List<Cards> actual = cardDAO.getAllCards();

        List<Cards> listCards = new ArrayList<>();
        listCards.add(new Cards(1, "111000000000"));
        listCards.add(new Cards(2, "111000000001"));
        listCards.add(new Cards(3, "111000000002"));

        Assertions.assertEquals(actual, listCards);
    }

    @Test
    public void checkBalanceTestShouldOne() {
        CardDAO cardDAO = new CardDAO();
        Map<Long, Float> actual = cardDAO.checkBalance(1);

        Map<Long, Float> expected = new HashMap<>();
        expected.put(1L, 10000F);

        Assertions.assertEquals(actual, expected);
    }
}
