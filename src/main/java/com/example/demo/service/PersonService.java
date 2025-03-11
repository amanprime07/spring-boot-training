package com.example.demo.service;

import com.example.demo.repository.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPerson();

    Person getPersonById(long id);
}
