package ru.borisova.dittask53.dao;

import ru.borisova.dittask53.entity.Document;

public interface DocumentDAO {
    // метод отвечает за создание и изменение
    //public Document createDocuments(Document document);
    //public Document changeDocuments();
    public Document getDocument(int id);
}
