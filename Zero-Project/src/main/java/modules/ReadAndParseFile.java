package modules;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndParseFile {

    public List<City> reading(String fileName){
        List<City> listCities = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNext()) {
                City city = parseToOb(scanner.nextLine());
                listCities.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return listCities;
    }

    private City parseToOb(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(";");
        int id = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        long population = scanner.nextLong();
        int foundation = scanner.nextInt();
        return new City(name, region, district, population, foundation);
    }
}
