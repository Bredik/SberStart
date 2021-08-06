package ru.borisova.dittask53_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.borisova.dittask53_v2.entity.Box;
import ru.borisova.dittask53_v2.entity.Document;
import ru.borisova.dittask53_v2.service.BoxService;

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

    @PostMapping("/updateBox")
    public Box updateNewBox(@RequestBody Box box) {
        boxService.saveBox(box);
        return box;
    }

    @GetMapping("/getDocByBox/{id}")
    public List<Document> getDocByBox(@PathVariable long id) {
        return boxService.getDocByBox(id);
    }
}
