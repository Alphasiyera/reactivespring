package com.crossasyst.reactivespring.mapper;


import com.crossasyst.reactivespring.dto.PersonRequest;
import com.crossasyst.reactivespring.entity.PersonEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PersonMapper {
    public PersonEntity ModelToEntity(PersonRequest personRequest);

    public PersonRequest entityToModel(Mono<PersonEntity> personEntity);

    public List<PersonRequest> entityToModels(List<PersonEntity> personEntities);


}


