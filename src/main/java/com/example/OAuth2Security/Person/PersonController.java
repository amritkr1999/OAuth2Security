package com.example.OAuth2Security.Person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class PersonController {

    private PersonService personService;
    private ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public PersonDTO signup(@RequestBody PersonEntity personEntity){
        PersonEntity temp = personService.signup(personEntity);
        return modelMapper.map(temp, PersonDTO.class);
    }

    @GetMapping("")
    public void helloWorld() {
        System.out.println("Hello World!");
    }

//    @PostMapping("/login")
//    public PersonDTO login(@RequestBody Map<String,String> Credentials){
//        PersonEntity temp = personService.login(Credentials);
//        return modelMapper.map(temp, PersonDTO.class);
//    }

    @GetMapping("/showPersonDetails")
    public PersonDTO showPersonDetails(@RequestBody String email){
        PersonEntity temp = personService.showPersonDetails(email);
        return modelMapper.map(temp, PersonDTO.class);
    }

    @PutMapping("/editDetails")
    public PersonEntity editDetails(@RequestBody PersonEntity personEntity){
        PersonEntity temp = personService.editDetails(personEntity);
        return personEntity;
    }


}
