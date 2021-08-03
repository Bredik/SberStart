package ru.borisova.dittask53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.borisova.dittask53.dto.SaveDocumentDTO;
import ru.borisova.dittask53.entity.Document;
import ru.borisova.dittask53.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerDocument {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/allDoc")
    public List<Document> showAllDocument() {
        List<Document> allDocument = documentService.getAllDocument();
        return allDocument;
    }

    @GetMapping("/doc/{id}")
    public Document getDocument(@PathVariable long id) {
        Document document = documentService.getDocument(id);

        if (document == null) {
            throw new RuntimeException("No such documents");
        }
        return document;
    }

    @PostMapping("/saveDoc")
    public SaveDocumentDTO addNewDoc(@RequestBody SaveDocumentDTO document) {
        if (document == null) {
            throw new RuntimeException("No such documents");
        } else {
            documentService.saveDoc(document);
        }

        return document;
    }
}
