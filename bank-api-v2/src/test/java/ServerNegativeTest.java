import org.junit.jupiter.api.*;
import ru.sbr.controller.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServerNegativeTest {
    private String address;
    private String requestBody;
    private HttpURLConnection connection;
    URL url;

    @BeforeAll
    public static void startServerAndDB() throws IOException {
        Server.start();
    }

    @AfterAll
    public static void stopServerAndDB() {
        Server.stop();
    }

    @Test
    void getAllCards_POST_TestShouldThrowException() throws IOException {
        address = "http://localhost:8000/getAllCards";
        requestBody = "{\"id\":2}";
        url = new URL(address);

        Throwable thrown = assertThrows(IOException.class, () -> {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write(requestBody);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        });

        Assertions.assertNotNull(thrown.getMessage());
    }

    @Test
    void checkBalance_POST_TestShouldThrowException() throws IOException {
        address = "http://localhost:8000/checkBalance/1";
        requestBody = "{\"id\":2}";
        url = new URL(address);

        Throwable thrown = assertThrows(IOException.class, () -> {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("POST");

            connection.setDoOutput(true);
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write(requestBody);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        });

        Assertions.assertNotNull(thrown.getMessage());
    }

    @Test
    void addCard_GET_TestShouldThrowException() throws IOException {
        address = "http://localhost:8000/addCard";
        url = new URL(address);

        Throwable thrown = assertThrows(IOException.class, () -> {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.disconnect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        });

        Assertions.assertNotNull(thrown.getMessage());
    }

    @Test
    void depFund_POST_TestShouldThrowException() throws IOException {
        address = "http://localhost:8000/depFunds";

        url = new URL(address);

        Throwable thrown = assertThrows(IOException.class, () -> {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.disconnect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        });

        Assertions.assertNotNull(thrown.getMessage());
    }
}
