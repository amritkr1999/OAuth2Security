package com.example.OAuth2Security.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,UUID>{
    public Optional <PersonEntity> findByEmail(String email);

}
