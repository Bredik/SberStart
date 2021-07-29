package ru.borisova.solution1;

import ru.borisova.solution1.entity.Person;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            String firstName = args[0];
            String lastName = args[1];
            Person person = new Person(firstName, lastName);
            System.out.println(person);
        }
    }
}
