package com.irssolucoes.domain.repository;

import java.io.Serializable;

/**
 *
 * @author Nicolas Ibanheiz
 */
public interface Repository<T> {

    void save(T obj);

    void update(T obj);

    void delete(Object obj, int id);

    <E> E findById(Class<E> obj, Serializable id);
    
}
