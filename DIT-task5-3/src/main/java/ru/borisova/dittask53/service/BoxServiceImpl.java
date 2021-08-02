package ru.borisova.dittask53.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borisova.dittask53.dao.BoxDAO;
import ru.borisova.dittask53.entity.Box;

import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    private BoxDAO boxDAO;

    @Override
    @Transactional
    public List<Box> getAllBox() {
        return boxDAO.getAllBox();

    }

    @Override
    @Transactional
    public Box getBox(long id) {
        return null;
    }
}
