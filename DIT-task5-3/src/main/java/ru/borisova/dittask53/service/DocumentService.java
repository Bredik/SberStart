package ru.borisova.dittask53.service;

import ru.borisova.dittask53.dto.SaveDocumentDTO;
import ru.borisova.dittask53.entity.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getAllDocument();
    Document getDocument(long id);

    void saveDoc(SaveDocumentDTO document);
}
