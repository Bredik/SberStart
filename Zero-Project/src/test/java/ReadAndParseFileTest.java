import modules.City;
import modules.ReadAndParseFile;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ReadAndParseFileTest {
    private static ReadAndParseFile readAndParseFile;

    @BeforeClass
    public static void createReadAndParseFile() {
        readAndParseFile = new ReadAndParseFile();
    }

    @Test
    public void wrongPathToFileShouldThrowException() {
        try {
            String fileName = "";
            readAndParseFile.reading(fileName);
            assert true;
        } catch (Exception e) {

        }
    }

    @Test
    public void readingShouldReturnListCities() {
        City city1 = new City("Name1", "REgion1", "District1", 10, 1951);
        City city2 = new City("Name2", "REgion2", "District2", 20, 1952);
        City city3 = new City("Name3", "REgion3", "District3", 30, 1953);

        List<City> expected = readAndParseFile.reading("TEST_ReadAndParseFileTest.txt");

        List<City> actual = new ArrayList<>();
        actual.add(city1);
        actual.add(city2);
        actual.add(city3);

        Assert.assertEquals(expected, actual);
    }
}
