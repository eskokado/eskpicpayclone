package br.com.dio.eskpicpayclone.converters;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<E, D> {
    public abstract D convertEntityToDto(E entity);

    public abstract E convertDtoToEntity(D dto);

    public List<D> convertEntitiesToDtos(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    public List<E> convertDtosToEntities(List<D> dtos) {
        List<E> entities = new ArrayList<>();
        dtos.stream().forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }
}
