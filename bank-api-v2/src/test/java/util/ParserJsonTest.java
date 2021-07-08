package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbr.entity.Cards;
import ru.sbr.utils.ParserJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserJsonTest {
    @Test
    void parserJsonForCardsTestShouldBeSame() {
        ParserJson parserJson = new ParserJson();
        List<Cards> listCards = new ArrayList<>();
        listCards.add(new Cards(1, "111000000000"));
        listCards.add(new Cards(2, "111000000001"));
        listCards.add(new Cards(3, "111000000002"));
        String actual = parserJson.toJson(listCards);
        String expected = "[{\"id\":1,\"card_number\":\"111000000000\"},{\"id\":2,\"card_number\":\"111000000001\"},{\"id\":3,\"card_number\":\"111000000002\"}]";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void parserJsonForMapTestShouldBeSame() {
        ParserJson parserJson = new ParserJson();
        Map<Long, Float> map = new HashMap<>();
        map.put(1L, 1000F);

        String actual = parserJson.toJson(map);
        String expected = "{\"1\":1000.0}";
        Assertions.assertEquals(actual, expected);
    }
}
