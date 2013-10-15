package com.irssolucoes.infrastructure.persistence;

import com.irssolucoes.domain.repository.Repository;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nicolas Ibanheiz
 */
public abstract class DAO<T> implements Repository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public DAO() {
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(T obj) {
        entityManager.persist(obj);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(T obj) {
        entityManager.merge(obj);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(Object obj, int id) {
        entityManager.remove(entityManager.getReference(obj.getClass(), id));
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public <E> E findById(Class<E> obj, Serializable id) {
        return (E) entityManager.find(obj, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
