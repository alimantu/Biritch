package ru.epam.salynskii.core.biritch.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.epam.salynskii.core.biritch.db.dao.NewsMetaDAO;
import ru.epam.salynskii.core.biritch.db.entities.NewsMeta;

/**
 * Created by Alimantu on 28/09/16.
 */
@org.springframework.stereotype.Service("newsMetaService")
public class NewsMetaService implements Service<NewsMeta, Long> {

    @Autowired
    NewsMetaDAO newsMetaDAO;

    @Override
    @Transactional
    public void persist(NewsMeta entity) {
        newsMetaDAO.persist(entity);
    }

    @Override
    @Transactional
    public NewsMeta findById(Long aLong) {
        return newsMetaDAO.findById(aLong);
    }

    @Override
    @Transactional
    public void update(NewsMeta entity) {
        newsMetaDAO.update(entity);
    }

    @Override
    @Transactional
    public void delete(NewsMeta entity) {
        newsMetaDAO.delete(entity);
    }

}
