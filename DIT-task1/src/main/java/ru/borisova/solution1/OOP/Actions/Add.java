package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.util.List;
import java.util.Scanner;

public class Add implements Exec{
    Scanner scanner;
    public Add(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void exec(List<Person> data) throws Exception {
        System.out.println("Enter data");
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        Person person = new Person(firstName, lastName);
        data.add(person);
        System.out.println("Added!");
        System.out.println("Enter command");
    }
}
