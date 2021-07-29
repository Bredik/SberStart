package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.util.List;

public class ClearFile implements Exec {
    @Override
    public void exec(List<Person> data) throws Exception {
        data.clear();
        System.out.println("List has clear!");
    }
}
