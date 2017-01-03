package ru.epam.salynskii.core.biritch.db.service;

import java.io.Serializable;

/**
 * Created by Alimantu on 19/09/16.
 */
public interface Service<T, Id extends Serializable>{

    void persist(T entity);

    T findById(Id id);

    void update(T entity);

    void delete(T entity);

}
