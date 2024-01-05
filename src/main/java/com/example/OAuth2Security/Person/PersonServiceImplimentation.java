package com.example.OAuth2Security.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplimentation implements PersonService{

    private PersonRepository personRepository;


    @Autowired
    public PersonServiceImplimentation(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonEntity signup(PersonEntity personEntity) {
        if(personRepository.findByEmail(personEntity.getEmail()).isEmpty())
        return personRepository.save(personEntity);
        else
            throw new RuntimeException("Person already exists");
    }
}
