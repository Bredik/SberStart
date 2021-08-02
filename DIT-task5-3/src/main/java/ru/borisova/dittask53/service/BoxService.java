package ru.borisova.dittask53.service;

import ru.borisova.dittask53.entity.Box;
import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface BoxService {
    List<Box> getAllBox();

    public Box getBox(long id);
}
