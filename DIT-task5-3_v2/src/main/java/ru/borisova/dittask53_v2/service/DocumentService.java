package ru.borisova.dittask53_v2.service;

import ru.borisova.dittask53_v2.entity.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAllDocument();
    Document getDocument(long id);
    void saveDoc(Document document);
    void deleteDoc(long id);
}
