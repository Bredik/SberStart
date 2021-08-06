package ru.borisova.dittask53_v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borisova.dittask53_v2.dao.BoxRepository;
import ru.borisova.dittask53_v2.entity.Box;
import ru.borisova.dittask53_v2.entity.Document;

import java.util.List;
import java.util.Optional;

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public List<Box> getAllBox() {
        return boxRepository.findAll();
    }

    @Override
    public Box getBox(long id) {
        Box box = null;
        Optional<Box> optionalBox = boxRepository.findById(id);
        if (optionalBox.isPresent()) {
            box = optionalBox.get();
        } else {
            throw new NullPointerException("Нет такого бокса");
        }
        return box;
    }

    @Override
    public void saveBox(Box box) {
        boxRepository.save(box);
    }

    @Override
    public List<Document> getDocByBox(long id) {
        Box box = null;
        List<Document> documentList;
        Optional<Box> optionalBox = boxRepository.findById(id);
        if (optionalBox.isPresent()) {
            documentList = optionalBox.get().getDocumentList();
        } else {
            throw new NullPointerException("Нет такого бокса");
        }

        return documentList;
    }
}
