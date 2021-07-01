package modules.functional;

import modules.City;

import java.util.List;

public interface FunctionalForBook {
    public void sortByName(List<City> listCity);

    public void sortByDistrictAndName(List<City> listCity);

    public void searchMaxPopulation(List<City> listCity);

    public void countCitiesInRegion(List<City> listCity);
}
