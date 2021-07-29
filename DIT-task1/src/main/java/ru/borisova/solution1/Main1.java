package ru.borisova.solution1;

import ru.borisova.solution1.entity.Person;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        Person person = new Person(firstName, lastName);
        System.out.println(person);
    }
}
