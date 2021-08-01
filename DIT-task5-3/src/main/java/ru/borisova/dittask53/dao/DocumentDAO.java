package ru.borisova.dittask53.dao;

import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface DocumentDAO {
    // метод отвечает за создание и изменение
    //public Document saveDocument(Document document);

    public List<Document> getAllDocument();
    public Document getDocument(Long id);
}
