package com.example.OAuth2Security.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private UUID id;
    private String email;
    private String name;
    private String password;
}
