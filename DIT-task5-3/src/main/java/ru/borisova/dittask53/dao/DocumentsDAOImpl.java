package ru.borisova.dittask53.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.borisova.dittask53.dto.SaveDocumentDTO;
import ru.borisova.dittask53.entity.Box;
import ru.borisova.dittask53.entity.Document;

import javax.persistence.EntityManager;
import java.util.List;

/*
Что бы дао мог подключаться к БД через хибернэйт, дао должен иметь доступ к
сешнфэктори, который мы прописали в апликейшенКонтекст
 */
@Repository
public class DocumentsDAOImpl implements DocumentDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Document> getAllDocument() {
        Session session = entityManager.unwrap(Session.class);
        Query<Document> query = session.createQuery("from Document", Document.class);
        List<Document> allDocument = query.getResultList();
        System.out.println("Список документов = " + allDocument.toString());
        return allDocument;
    }

    @Override
    public Document getDocument(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Document document = session.get(Document.class, id);
        return document;
    }

    @Override
    public void saveDoc(SaveDocumentDTO document) {
        Session session = entityManager.unwrap(Session.class);
        // todo проверка на null
        Box box = session.get(Box.class, document.getBox_id());
        box.addDocument(document.getDocument());
        session.saveOrUpdate(box);
    }
}
