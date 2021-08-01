package ru.borisova.dittask53.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.borisova.dittask53.entity.Document;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DocumentsDAOImpl implements DocumentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Document> getAllDocument() {
        Session session = entityManager.unwrap(Session.class);
        Query<Document> query = session.createQuery("from Document", Document.class);
        List<Document> allDocument = query.getResultList();
        return allDocument;
    }

    @Override
    public Document getDocument(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Document document = session.get(Document.class, id);
        return document;
    }
}
