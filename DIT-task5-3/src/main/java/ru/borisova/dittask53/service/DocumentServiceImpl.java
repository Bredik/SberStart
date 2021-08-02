package ru.borisova.dittask53.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borisova.dittask53.dao.DocumentDAO;
import ru.borisova.dittask53.entity.Document;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    /*
   При использовании этой аннотации спринг берет на себя ответственность
   за открытие и закрытие транзакций
   */
    @Override
    @Transactional
    public Document getDocument(long id) {
        return documentDAO.getDocument(id);
    }

    @Override
    @Transactional
    public List<Document> getAllDocument() {
        return documentDAO.getAllDocument();
    }
}
