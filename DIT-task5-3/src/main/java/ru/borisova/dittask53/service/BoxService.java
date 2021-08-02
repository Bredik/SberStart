package ru.borisova.dittask53.service;

import ru.borisova.dittask53.entity.Box;

import java.util.List;

public interface BoxService {
    List<Box> getAllBox();
    Box getBox(long id);
    void saveBox(Box box);
}
