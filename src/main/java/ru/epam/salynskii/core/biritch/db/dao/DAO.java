package ru.epam.salynskii.core.biritch.db.dao;

import java.io.Serializable;

/**
 * Created by Alimantu on 19/09/16.
 */
public interface DAO<T, Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

}

