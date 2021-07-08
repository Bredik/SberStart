import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ServerTest {
    @BeforeAll
    public static void startServerAndDB() throws IOException {
        Server.start();
        LaunchDB.connect();
    }

    @AfterAll
    public static void stopServerAndDB() {
        LaunchDB.disconnect();
        Server.stop();
    }

    @Test
    public void QQQ() throws IOException {
        String url = "http://localhost:8000/getAllCards";
        URLConnection connection = new URL(url).openConnection();
    }
}
