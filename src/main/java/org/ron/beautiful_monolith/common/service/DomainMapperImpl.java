package org.ron.beautiful_monolith.common.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DomainMapperImpl implements DomainMapper {
    private final ModelMapper modelMapper;

    public DomainMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <D, E> D convertToDomain(E source, Class<? extends D> classLiteral) {
        return modelMapper.map(source, classLiteral);
    }

}
