package ru.borisova.dittask53.service;

import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface DocumentService {
    // метод отвечает за создание и изменение
    //public Document saveDocuments(Document document);

    List<Document> getAllDocument();

    public Document getDocument(long id);
}
