package edu.tennis.score.homasapienss.DAO;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    List<T> findAll();
    Optional<T> findById(int id);
    T create(T entity);
    T update(T entity);
    void deleteById(int id);
}
