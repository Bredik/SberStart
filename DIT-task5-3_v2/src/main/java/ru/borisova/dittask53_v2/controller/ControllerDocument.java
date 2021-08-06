package ru.borisova.dittask53_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.borisova.dittask53_v2.entity.Document;
import ru.borisova.dittask53_v2.service.DocumentService;

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

        //todo сделать свои исключения
        if (document == null) {
            throw new NullPointerException("No such documents");
        }
        return document;
    }

    @PostMapping("/updateDoc")
    public Document addNewDoc(@RequestBody Document document) {
        if (document == null) {
            throw new NullPointerException("No such documents");
        } else {
            documentService.saveDoc(document);
        }
        return document;
    }

    @PostMapping("/saveDoc")
    public Document updateNewBox(@RequestBody Document document) {
        documentService.saveDoc(document);
        return document;
    }

    @PostMapping("/changeBox/")
    public Document changeBoxOfDoc(@RequestBody Document document) {
        documentService.saveDoc(document);
        return document;
    }


}
