package com.example.OAuth2Security.Person;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonEntity {

    private UUID id;
    private String email;
    private String name;
    private String password;

}
