import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbr.DAO.CardDAO;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServerTest {
    @Before
    static void beforeAll() throws IOException {
        Server.start();
        LaunchDB.connect();
    }

    @After
    static void afterAll() {
        LaunchDB.disconnect();
        Server.stop();
    }


}
