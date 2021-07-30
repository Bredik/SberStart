package ru.borisova.dittask53.service;

import ru.borisova.dittask53.entity.Document;

public interface DocumentService {
    // метод отвечает за создание и изменение
    //public Document createDocuments(Document document);
    //public Document changeDocuments();
    public Document getDocument(int id);
}
