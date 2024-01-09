package com.example.OAuth2Security.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public PersonEntity login(Map<String,String> credentials) {
        if(personRepository.findByEmail(credentials.get("email")).isPresent()){
            if (personRepository.findByEmail(credentials.get("email")).get().getPassword().equals(credentials.get("password")))
                return personRepository.findByEmail(credentials.get("email")).get();
            else
                throw new RuntimeException("Wrong password");
        }
        else
            throw new RuntimeException("Person not found");
    }

    @Override
    public PersonEntity showPersonDetails(String email) {
        if(personRepository.findByEmail(email).isPresent())
            return personRepository.findByEmail(email).get();
        else
            throw new RuntimeException("Person not found");
    }

    @Override
    public PersonEntity editDetails(PersonEntity personEntity){
        if(personRepository.findByEmail((personEntity.getEmail())).isPresent())
            return personRepository.saveAndFlush(personEntity);
        else
            throw new RuntimeException("Error in editing");

    }
}
