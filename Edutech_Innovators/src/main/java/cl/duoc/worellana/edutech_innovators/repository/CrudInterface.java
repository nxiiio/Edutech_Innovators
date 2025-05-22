package cl.duoc.worellana.edutech_innovators.repository;

import java.util.List;
import java.util.Optional;

public interface CrudInterface<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T entity);
    boolean update(Long id, T entity);
    boolean delete(T entity);
}
