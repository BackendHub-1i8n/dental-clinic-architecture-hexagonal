package com.dentalclinic.types;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository <T>{
    T save(T entity);
    List<T> findAll();
    void deleteById(UUID id);
    Optional<?> findById(UUID id);
    void update(T entity, UUID id);
    T findByUser(UUID userId);
}
