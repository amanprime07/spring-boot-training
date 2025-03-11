package com.example.demo.controllers;

import com.example.demo.repository.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getAllUsers() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getUserById(@PathVariable long id) {
        // add validation for id
        return personService.getPersonById(id);
    }
}
