package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.util.List;

public class Show implements Exec {

    @Override
    public void exec(List<Person> data) throws Exception {
        if (!data.isEmpty()) {
            for (Person p: data) {
                System.out.println(p);
            }
        } else System.out.println("List is Empty");
    }
}
