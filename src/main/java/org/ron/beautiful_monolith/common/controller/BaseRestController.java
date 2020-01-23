package org.ron.beautiful_monolith.common.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.ron.beautiful_monolith.common.service.BaseService;
import org.ron.beautiful_monolith.common.service.DomainMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseRestController<E, D, ID> {
    private final DomainMapper domainMapper;
    private final BaseService<E, ID> baseService;
    private Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public BaseRestController(DomainMapper domainMapper, BaseService<E, ID> baseService) {
        this.domainMapper = domainMapper;
        this.baseService = baseService;

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type type = genericSuperclass.getActualTypeArguments()[1];

        if (type instanceof ParameterizedType) {
            this.dtoClass = (Class<D>) ((ParameterizedType) type).getRawType();
        } else {
            this.dtoClass = (Class<D>) type;
        }
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        List<D> response = baseService.findAll().stream().map(e->domainMapper.convertToDomain(e, dtoClass)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
