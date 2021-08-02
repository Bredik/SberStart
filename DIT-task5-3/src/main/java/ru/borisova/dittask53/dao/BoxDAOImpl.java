package ru.borisova.dittask53.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.borisova.dittask53.entity.Box;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BoxDAOImpl implements BoxDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Box> getAllBox() {
        Session session = entityManager.unwrap(Session.class);
        Query<Box> query = session.createQuery("from Box", Box.class);
        List<Box> allBox = query.getResultList();
        return allBox;
    }

    @Override
    public Box getBox(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Box box = session.get(Box.class, id);
        return box;
    }

    @Override
    public void saveBox(Box box) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(box);
    }
}
