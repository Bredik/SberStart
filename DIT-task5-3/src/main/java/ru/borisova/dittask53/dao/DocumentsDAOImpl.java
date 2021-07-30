package ru.borisova.dittask53.dao;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.borisova.dittask53.entity.Document;

import javax.persistence.EntityManager;

@Repository
public class DocumentsDAOImpl implements DocumentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Document getDocument(int id) {
        Session session = entityManager.unwrap(Session.class);
        System.out.println("Запуск DocumentsDAOImpl");
        return null;
    }
}
