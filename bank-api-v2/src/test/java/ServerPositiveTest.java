import org.junit.jupiter.api.*;
import ru.sbr.DAO.CreateDB;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServerPositiveTest {
    private String address;
    private String requestBody;
    private HttpURLConnection connection;
    URL url;

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
    @Order(1)
    void getAllCards_GET_TestShouldReturnString() throws IOException {
        address = "http://localhost:8000/getAllCards";
        url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.disconnect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String actual = in.readLine();

        String expected = "[{\"id\":1,\"card_number\":\"111000000000\"},{\"id\":2,\"card_number\":\"111000000001\"},{\"id\":3,\"card_number\":\"111000000002\"}]";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    void checkBalance_GET_TestShouldReturnString() throws IOException {
        address = "http://localhost:8000/checkBalance/1";
        url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.disconnect();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String actual = in.readLine();

        String expected = "{\"1\":10000.0}";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    void addCard_POST_TestShouldReturnString() throws IOException {
        address = "http://localhost:8000/addCard";
        requestBody = "{\"id\":2}";
        url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(10000);
        connection.setRequestMethod("POST");

        connection.setDoOutput(true);

        try(OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
            writer.write(requestBody);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String actual = in.readLine();

        String expected = "Card add!";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    void depFund_POST_TestShouldReturnString() throws IOException {
        address = "http://localhost:8000/depFunds";
        requestBody = "{\"id\":1, \"sum\":100}";
        url = new URL(address);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(10000);
        connection.setRequestMethod("POST");

        connection.setDoOutput(true);

        try(OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
            writer.write(requestBody);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String actual = in.readLine();

        String expected = "Sum add!";

        Assertions.assertEquals(expected, actual);
    }
}
