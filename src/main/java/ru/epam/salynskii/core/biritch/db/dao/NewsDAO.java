package ru.epam.salynskii.core.biritch.db.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.epam.salynskii.core.biritch.db.entities.News;

/**
 * Created by Alimantu on 19/09/16.
 */
@Repository("newsDAO")
public class NewsDAO implements DAO<News, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void persist(News entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public void update(News entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public News findById(Long id) {
        return sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Override
    public void delete(News entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
