import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbr.service.Service;

import java.io.IOException;

public class ServiceTest {
    @BeforeAll
    public static void startServerAndDB() {
        String response = new Service().getAllCards();

    }

    @AfterAll
    public static void stopServerAndDB() {

    }

    @Test
    public void QQQ() throws IOException {

    }
}
