package ru.borisova.dittask53.dao;

import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface DocumentDAO {
    List<Document> getAllDocument();
    Document getDocument(Long id);
    void saveDoc(Document document);
}
