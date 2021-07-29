package ru.borisova.solution1;

import ru.borisova.solution1.entity.Person;

import java.util.*;

public class Main2And3 {
    public static void main(String[] args) {
        List<Person> listPerson = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String firstName = scanner.nextLine();
            if (firstName.equals("0")) {
                break;
            }
            String lastName = scanner.nextLine();
            if (lastName.equals("0")) {
                break;
            }
            Person person = new Person(firstName, lastName);
            listPerson.add(person);
        }

        Collections.sort(listPerson);
        for (Person p: listPerson) {
            System.out.println(p);
        }
    }
}
