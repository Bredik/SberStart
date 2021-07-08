import org.junit.jupiter.api.*;
import ru.sbr.DAO.CardDAO;
import ru.sbr.DAO.CreateDB;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;
import ru.sbr.entity.Deposite;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static ru.sbr.DAO.ConnectionDB.connection;

/*
Тестирование ИЗМЕНЕНИЯ данных из БД
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardDaoChangeTest {
    @BeforeAll
    public static void startServerAndDB() throws IOException, SQLException {
        Server.start();
        LaunchDB.connect();
        CreateDB.dbCreate();
        Statement statement = connection.createStatement();
        System.out.println("Добавление тестовых данных");
        statement.executeUpdate("INSERT INTO CLIENTS (ID, NAME) VALUES ( 99, 'Vladimir Rekov' )");
        statement.executeUpdate("INSERT INTO ACCOUNTS (ID, ACCOUNT, ID_CLIENT) " +
                "VALUES ( 99, 1000000000099, 99);");
        statement.executeUpdate("INSERT INTO CARDS (ID, CARD_NUMBER, BALANCE, ID_ACCOUNT) " +
                "VALUES (99, 111000000099, 1000, 99);");
    }

    @AfterAll
    public static void stopServerAndDB() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM CARDS WHERE ID_ACCOUNT=99");
        statement.executeUpdate("DELETE FROM ACCOUNTS WHERE ID=99");
        statement.executeUpdate("DELETE FROM CLIENTS WHERE ID=99");
        System.out.println("Тестовые данные удалены");
        LaunchDB.disconnect();
        Server.stop();
    }

    @Test
    @Order(1)
    public void addNewCardTestShouldOne() {
        CardDAO cardDAO = new CardDAO();
        int expected = cardDAO.addNewCard(new Deposite(99, 0));

        Assertions.assertEquals(1, expected);
    }

    @Test
    @Order(2)
    public void depFundsTestShould() {
        CardDAO cardDAO = new CardDAO();
        int expected = cardDAO.depFundsToCard(new Deposite(99, 100));

        Assertions.assertEquals(1, expected);
    }

    @Test
    @Order(3)
    public void checkBalanceTestShouldOne() {
        CardDAO cardDAO = new CardDAO();
        Map<Long, Float> actual = cardDAO.checkBalance(99);

        Map<Long, Float> expected = new HashMap<>();
        expected.put(99L, 1100F);

        Assertions.assertEquals(actual, expected);
    }
}
