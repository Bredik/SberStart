package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.util.List;

public interface Exec {
    void exec(List<Person> data) throws Exception;
}
