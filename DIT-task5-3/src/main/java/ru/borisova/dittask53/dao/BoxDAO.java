package ru.borisova.dittask53.dao;

import ru.borisova.dittask53.entity.Box;

import java.util.List;

public interface BoxDAO {
    List<Box> getAllBox();
    Box getBox(Long id);
    void saveBox(Box box);
}
