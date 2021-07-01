package modules.functional;

import modules.City;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionalImpl implements FunctionalForBook {
    @Override
    public void sortByName(List<City> listCity) {
        listCity = listCity.stream().
                sorted((o1,o2) -> -o2.getName().compareToIgnoreCase(o1.getName())).
                collect(Collectors.toList());

        System.out.println("Отсортрованный лист по имени города");
        System.out.println(listCity.toString());
        System.out.println("------");

    }

    @Override
    public void sortByDistrictAndName(List<City> listCity) {
        listCity =listCity.stream().
                sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName)).collect(Collectors.toList());

        System.out.println("Отсортрованный лист по имени округа и городу");
        System.out.println(listCity.toString());
        System.out.println("------");

    }

    @Override
    public void searchMaxPopulation(List<City> listCity) {
        City[] arrCity = listCity.toArray(new City[0]);

        long maxPopulation = 0L;
        int index = 0;

        for (int i = 0; i < arrCity.length; i++) {
            if (arrCity[i].getPopulation() > maxPopulation) {
                maxPopulation = arrCity[i].getPopulation();
                index = i;
            }
        }

        System.out.println("population = " + maxPopulation);
        System.out.println("index = " + index);
        System.out.println("------");

    }

    @Override
    public void countCitiesInRegion(List<City> listCity) {
        Map<Object, Long> countCitiesInRegion = listCity.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));

        System.out.println(countCitiesInRegion.toString());
        System.out.println("------");
    }
}
