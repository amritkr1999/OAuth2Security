package com.example.OAuth2Security.Person;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface PersonService  {

    public PersonEntity signup(PersonEntity personEntity);
    public PersonEntity login(Map<String,String> credentials);
}
