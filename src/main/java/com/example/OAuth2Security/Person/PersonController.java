package com.example.OAuth2Security.Person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class PersonController {

    private PersonService personService;
    private ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    public PersonDTO signup(@RequestBody PersonEntity personEntity){
        PersonEntity temp = personService.signup(personEntity);
        return modelMapper.map(temp, PersonDTO.class);

    }

}
