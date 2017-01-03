package ru.epam.salynskii.core.biritch.db.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.epam.salynskii.core.biritch.db.entities.NewsMeta;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alimantu on 28/09/16.
 */
@Repository("newsMetaDAO")
public class NewsMetaDAO implements DAO<NewsMeta, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void persist(NewsMeta entity) {
        sessionFactory.getCurrentSession().persist(entity);
        HashMap
    }

    @Override
    public void update(NewsMeta entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public NewsMeta findById(Long id) {
        return sessionFactory.getCurrentSession().get(NewsMeta.class, id);
    }

    @Override
    public void delete(NewsMeta entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
