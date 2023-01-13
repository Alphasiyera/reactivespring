package com.crossasyst.reactivespring.service;

import com.crossasyst.reactivespring.entity.PersonEntity;
import com.crossasyst.reactivespring.mapper.PersonMapper;
import com.crossasyst.reactivespring.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;

    }

    public Flux<PersonEntity> getAllPerson() {

        return personRepository.findAll();
    }

    public Mono<PersonEntity> getById(Long id) {

        return personRepository.findById(id);
    }

    public Mono<PersonEntity> addPerson(PersonEntity person) {

        return personRepository.save(person);
    }

    public Mono<Void> deletePerson(Long id) {

        return personRepository.deleteById(id);
    }

    public Mono<PersonEntity> updatePerson(Long id, Mono<PersonEntity> person) {
        return this.personRepository.findById(id).flatMap(p-> person.map(u->{
            p.setFirstName(u.getFirstName());
            p.setLastName(u.getLastName());
            p.setDob(u.getDob());
            return p;
        })).flatMap(p-> this.personRepository.save(p));
    }
}
