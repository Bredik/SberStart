package ru.borisova.dittask53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.borisova.dittask53.entity.Box;
import ru.borisova.dittask53.entity.Document;
import ru.borisova.dittask53.service.BoxService;
import ru.borisova.dittask53.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerBox {

    @Autowired
    private BoxService boxService;

    @GetMapping("/allBox")
    public List<Box> showAllBox() {
        List<Box> allBox = boxService.getAllBox();
        return allBox;
    }

    @GetMapping("/box/{id}")
    public Box getBox(@PathVariable long id) {
        Box box = boxService.getBox(id);
        System.out.println("id = " + id);

        if (box == null) {
            throw new RuntimeException("No such documents");
        }
        return box;
    }

    @PostMapping("/saveBox")
    public Box addNewBox(@RequestBody Box box) {
        boxService.saveBox(box);
        return box;
    }
}
