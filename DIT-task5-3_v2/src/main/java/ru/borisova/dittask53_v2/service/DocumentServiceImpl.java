package ru.borisova.dittask53_v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borisova.dittask53_v2.dao.BoxRepository;
import ru.borisova.dittask53_v2.dao.DocumentRepository;
import ru.borisova.dittask53_v2.entity.Box;
import ru.borisova.dittask53_v2.entity.Document;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public Document getDocument(long id) {
        return documentRepository.getById(id);
    }

    @Override
    public List<Document> getAllDocument() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDoc(Document document) {
        Long boxId = document.getBox_id();
        Box box = boxRepository.getById(boxId);
        box.addDocument(document);
        documentRepository.save(document);
    }

    @Override
    public void deleteDoc(long id) {
        documentRepository.deleteById(id);
    }
}
