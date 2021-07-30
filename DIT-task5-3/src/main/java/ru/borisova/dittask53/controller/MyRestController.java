package ru.borisova.dittask53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.borisova.dittask53.entity.Document;
import ru.borisova.dittask53.service.DocumentService;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/doc/{id}")
    public Document getDocument(@PathVariable int id) {
        System.out.println("Запуск MyRestController");
        /*Document document = documentService.getDocument(id);

        if (document == null) {
            throw new RuntimeException("No such documents");
        }*/
        return null;
    }
}
