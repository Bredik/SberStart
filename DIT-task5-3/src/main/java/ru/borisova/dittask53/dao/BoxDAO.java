package ru.borisova.dittask53.dao;

import ru.borisova.dittask53.entity.Box;
import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface BoxDAO {
    public List<Box> getAllBox();
    public Box getBox(Long id);
}
