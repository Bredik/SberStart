package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ShowUnique implements Exec {

    @Override
    public void exec(List<Person> data) throws Exception {
        Set<Person> uniqueList= new TreeSet<>(data);
        for (Person p: uniqueList) {
            System.out.println(p);
        }
    }
}
