package ru.borisova.solution1;

import ru.borisova.solution1.entity.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainFrom4To6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> listPerson = new ArrayList<>();
        boolean flag = true;

        System.out.println("Menu:");
        System.out.println("1. Add");
        System.out.println("2. Show");
        System.out.println("3. Exit");
        System.out.println("4. Show sorted unique");
        System.out.println("5. Save to file");

        while (flag) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Enter data");
                    String firstName = scanner.nextLine();
                    String lastName = scanner.nextLine();
                    Person person = new Person(firstName, lastName);
                    listPerson.add(person);
                    System.out.println("Added!");
                    System.out.println("Enter command");
                    break;
                case "2":
                    System.out.println("Show list");
                    for (Person p: listPerson) {
                        System.out.println(p);
                    }
                    break;
                case "3":
                    System.out.println("Exit");
                    flag = false;
                    break;
                case "4":
                    System.out.println("Show sorted unique");
                    Set<Person> uniqueList= new TreeSet<>(listPerson);
                    for (Person p: uniqueList) {
                        System.out.println(p);
                    }
                case "5":
                    try(FileWriter writer = new FileWriter("notes.txt", false))
                    {
                        writer.write(String.valueOf(listPerson));
                        writer.flush();
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
}
