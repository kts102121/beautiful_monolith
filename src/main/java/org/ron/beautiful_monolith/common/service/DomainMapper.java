package org.ron.beautiful_monolith.common.service;

public interface DomainMapper {
    <D,E> D convertToDomain(E source, Class<? extends D> classLiteral);
}
