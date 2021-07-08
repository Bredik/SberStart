package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbr.utils.ParserURI;

public class ParserURITest {
    @Test
    void parserURITestShould9() {
        ParserURI parserURI = new ParserURI();
        Long actual = parserURI.getNumberFromUri("/bank/card/9");
        Long expected = 9L;
        Assertions.assertEquals(actual, expected);
    }
}
