package ru.borisova.dittask53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.borisova.dittask53.entity.Box;
import ru.borisova.dittask53.entity.Document;
import ru.borisova.dittask53.service.BoxService;
import ru.borisova.dittask53.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private BoxService boxService;

    @GetMapping("/allDoc")
    public List<Document> showAllDocument() {
        List<Document> allDocument = documentService.getAllDocument();
        return allDocument;
    }

    @GetMapping("/doc/{id}")
    public Document getDocument(@PathVariable long id) {
        Document document = documentService.getDocument(id);
        System.out.println(document.toString());

        if (document == null) {
            throw new RuntimeException("No such documents");
        }
        return document;
    }

    @GetMapping("/allBox")
    public List<Box> showAllBox() {
        List<Box> allBox = boxService.getAllBox();
        return allBox;
    }

    @GetMapping("/box/{id}")
    public Document getBox(@PathVariable long id) {

        return null;
    }
}
