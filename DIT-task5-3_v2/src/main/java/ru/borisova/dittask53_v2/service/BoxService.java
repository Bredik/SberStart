package ru.borisova.dittask53_v2.service;

import ru.borisova.dittask53_v2.entity.Box;
import ru.borisova.dittask53_v2.entity.Document;

import java.util.List;

public interface BoxService {
    List<Box> getAllBox();
    Box getBox(long id);
    void saveBox(Box box);
    List<Document> getDocByBox(long id);
}
