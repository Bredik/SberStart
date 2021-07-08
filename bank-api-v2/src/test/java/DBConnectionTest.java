import org.h2.jdbc.JdbcSQLNonTransientException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbr.DAO.LaunchDB;

import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.sbr.DAO.ConnectionDB.connection;

public class DBConnectionTest {

    @Test
    void createConnectionTestShouldNotNull() {
        LaunchDB.connect();
        Assertions.assertNotNull(connection);
    }

   @Test
    void closeConnectionShouldThrowException() {
        LaunchDB.connect();
        LaunchDB.disconnect();

        Throwable thrown = assertThrows(JdbcSQLNonTransientException.class, () -> {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT  * FROM CLIENTS");
        });
       Assertions.assertNotNull(thrown.getMessage());
    }
}
