import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbr.DAO.CardDAO;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;
import ru.sbr.entity.Cards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerTest {
    @Before
    public void beforeAll() throws IOException {
        Server.start();
        LaunchDB.connect();
    }

    @After
    public void afterAll() {
        LaunchDB.disconnect();
        Server.stop();
    }

    @Test
    public void checkBalanceTest() {
        CardDAO cardDAO = new CardDAO();
        Map<Long, Float> actual = cardDAO.checkBalance(16);
        Map<Long, Float> expected = new HashMap<>();
        expected.put(16L, 500F);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllCardTest() {
        CardDAO cardDAO = new CardDAO();
        List<Cards> actual = cardDAO.getAllCards();

        List<Cards> listCards = new ArrayList<>();
        listCards.add(new Cards(1, "111000000011"));
        listCards.add(new Cards(2, "111000000012"));
        listCards.add(new Cards(3, "111000000013"));

        Assert.assertEquals(actual, listCards);
    }

    @Test
    public void depFundsToCardTest() {
        CardDAO cardDAO = new CardDAO();
    }


}
