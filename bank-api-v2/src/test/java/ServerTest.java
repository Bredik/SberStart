import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;

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
}
