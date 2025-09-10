package edu.tennis.score.homasapienss.DAO;

import edu.tennis.score.homasapienss.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T> implements BaseDAO<T>{
    private final Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override public List<T> findAll() {
        Session session = getSession();
        return session.createQuery("FROM " + entityClass.getSimpleName(),entityClass).list();
    }

    @Override public Optional<T> findById(int id) {
        Session session = getSession();
        return Optional.of(session.get(entityClass, id));
    }

    @Override public T create(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override public T update(T entity) {

        return null;
    }

    @Override public void deleteById(int id) {
        Session session = getSession();
        session.beginTransaction();
        T entity =  session.get(entityClass, id);
        if (entity != null){
            session.delete(entity);
        }
        session.getTransaction().commit();
    }
}
