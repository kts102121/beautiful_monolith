package org.ron.beautiful_monolith.common.service;

import org.ron.beautiful_monolith.common.exception.model.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<E, ID> {
    private final JpaRepository<E, ID> jpaRepository;

    protected BaseService(JpaRepository<E, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<E> findAll() {
        return jpaRepository.findAll();
    }

    public E find(ID id) {
        return jpaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
    }
}
