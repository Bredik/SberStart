import modules.City;
import modules.ReadAndParseFile;
import modules.functional.FunctionalForBook;
import modules.functional.FunctionalImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionalImplTest {
    private static FunctionalForBook action;
    private static List<City> testList;
/*
    @BeforeClass
    public static void createReadAndParseFile() {
        action = new FunctionalImpl();
        testList = new ArrayList<>();
        testList.add(new City("A", "REgion1", "District1", 10, 1951));
        testList.add(new City("Y", "REgion2", "District2", 20, 1952));
        testList.add(new City("B", "REgion3", "District3", 30, 1953));
    }

    @Test
    public void shouldByName() {
        System.out.println(testList.toString());
        action.sortByName(testList);
        System.out.println(testList.get(0).getName());
        System.out.println(testList.get(1).getName());
        System.out.println(testList.get(2).getName());
        Assert.assertEquals("A", testList.get(0).getName());
        Assert.assertEquals("B", testList.get(1).getName());
        Assert.assertEquals("Y", testList.get(2).getName());

    }

    @Test
    public void shouldoSortByDistrictAndName() {

    }

    @Test
    public void shouldSearchMaxPopulation() {

    }

    @Test
    public void shouldCountCitiesInRegion() {

    }*/
}







    /*@Test
    public void testCitySort1() throws FileNotFoundException {
        CitiesHandler cs = new CitiesHandler();
        cs.read();
        cs.sortByName();
        assert(!cs.list.get(0).equals(new City("1;Абаза;Хакасия;Сибирский;17111;1867")));
        assert(!cs.list.get(1).equals(new City("2;Абакан;Хакасия;Сибирский;165183;1734")));
        assert(!cs.list.get(2).equals(new City("3;Абдулино;Оренбургская область;Приволжский;20663;1795")));
    }

    @Test
    public void testCitySort2() throws FileNotFoundException {
        CitiesHandler cs = new CitiesHandler();
        cs.read();
        cs.sortByDistrictAndName();
        assert(!cs.list.get(0).equals(new City("15;Алдан;Якутия;Дальневосточный;21277;1924")));
        assert(!cs.list.get(1).equals(new City("19;Александровск-Сахалинский;Сахалинская область;Дальневосточный;10613;1869")));
        assert(!cs.list.get(2).equals(new City("26;Амурск;Хабаровский край;Дальневосточный;42977;1958")));
    }*/