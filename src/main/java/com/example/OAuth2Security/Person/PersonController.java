package com.example.OAuth2Security.Person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class PersonController {

    private PersonService personService;
    private ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/signup")
    public PersonDTO signup(@RequestBody PersonEntity personEntity){
        PersonEntity temp = personService.signup(personEntity);
        return modelMapper.map(temp, PersonDTO.class);
    }

    @PostMapping("/login")
    public PersonDTO login(@RequestBody Map<String,String> Credentials){
        PersonEntity temp = personService.login(Credentials);
        return modelMapper.map(temp, PersonDTO.class);


    }

}
