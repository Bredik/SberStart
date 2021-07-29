package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadFile implements Exec {
    @Override
    public void exec(List<Person> data) throws Exception {
        try (FileReader reader = new FileReader("notes.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
