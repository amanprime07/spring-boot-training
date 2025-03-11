package com.example.demo;

import com.example.demo.repository.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PersonServiceTest {
    private PersonService service;
    private PersonRepository dao;

    @BeforeEach
    public void setup() {
        this.dao = Mockito.mock(PersonRepository.class);
        this.service = new PersonServiceImpl(dao);
    }

    @Test
    public void testGetAll() {
        var p = new Person(1, "abcd", "abcd@test.com");
        Mockito.when(this.dao.getPersonById(Mockito.anyLong())).thenReturn(p);
        this.service.getPersonById(1);
        Mockito.verify(this.dao, Mockito.times(1)).getPersonById(Mockito.anyLong());
    }
}
