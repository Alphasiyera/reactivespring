package com.crossasyst.reactivespring.repository;


import com.crossasyst.reactivespring.entity.PersonEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;



@Repository
public interface PersonRepository extends ReactiveCrudRepository<PersonEntity,Long> {

}
