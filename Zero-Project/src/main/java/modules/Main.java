package modules;

import modules.functional.FunctionalForBook;
import modules.functional.FunctionalImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<City> listCities = new ReadAndParseFile().reading("catalog.txt");

        FunctionalForBook action = new FunctionalImpl();

        action.sortByName(listCities);
        action.sortByDistrictAndName(listCities);

        action.searchMaxPopulation(listCities);
        action.countCitiesInRegion(listCities);

        System.out.println(listCities);
    }
}
