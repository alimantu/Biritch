package ru.epam.salynskii.core.biritch.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.epam.salynskii.core.biritch.db.dao.NewsDAO;
import ru.epam.salynskii.core.biritch.db.entities.News;

/**
 * Created by Alimantu on 19/09/16.
 */
@org.springframework.stereotype.Service("newsService")
public class NewsService implements Service<News, Long> {

    @Autowired
    NewsDAO newsDAO;

    @Override
    @Transactional
    public void persist(News entity) {
        newsDAO.persist(entity);
    }

    @Override
    @Transactional
    public News findById(Long aLong) {
        return newsDAO.findById(aLong);
    }

    @Override
    @Transactional
    public void update(News entity) {
        newsDAO.update(entity);
    }

    @Override
    @Transactional
    public void delete(News entity) {
        newsDAO.delete(entity);
    }
}
