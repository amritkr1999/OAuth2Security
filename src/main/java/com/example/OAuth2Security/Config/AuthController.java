package com.example.OAuth2Security.Config;

import com.example.OAuth2Security.Person.PersonDTO;
import com.example.OAuth2Security.Person.PersonEntity;
import org.antlr.v4.runtime.misc.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@CrossOrigin("*")
public class AuthController {


    private JwtTokenHelper helper;

    private CustomUserDetailsService service;

    private AuthenticationManager manager;

    private ModelMapper modelMapper;

    @Autowired
    public AuthController(JwtTokenHelper helper, CustomUserDetailsService service, AuthenticationManager manager, ModelMapper modelMapper) {
        this.helper = helper;
        this.service = service;
        this.manager = manager;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/get-current-user")
//    @CrossOrigin("http://localhost:4200")
    public PersonDTO user(@NotNull Principal principal){
//        System.out.println(principal);
        PersonEntity personToFind = (PersonEntity) this.service.loadUserByUsername(principal.getName());
        return modelMapper.map(personToFind, PersonDTO.class);
    }

    @PostMapping("/login")
//    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<JwtAuthResponse> createToken(@NotNull @RequestBody JwtAuthRequest request)
    {
        System.out.println("*******************************");
//        this.password = request.getPassword();
        UserDetails userDetails = this.service.loadUserByUsername(request.getEmail());
        this.authenticate(request.getEmail(), request.getPassword());
        String generateToken = this.helper.generateToken(userDetails);

        JwtAuthResponse authResponse = new JwtAuthResponse();
        authResponse.setAccessToken(generateToken);
        authResponse.setMessage("User logged in");

        return new ResponseEntity<JwtAuthResponse>(authResponse, HttpStatus.OK);

    }

    private void authenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(email, password);
        try {
            this.manager.authenticate(authtoken);
        }
        catch(Exception ex){
            throw new RuntimeException("Invalid Crediantials");
        }
    }
}
