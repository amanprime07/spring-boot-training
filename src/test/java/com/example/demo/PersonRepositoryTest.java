package com.example.demo;

import com.example.demo.repository.Person;
import com.example.demo.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test_getAllPerson() {
        List<Person> p = personRepository.findAll();
        Assertions.assertThat(p.size()).isEqualTo(2);
    }

    @Test
    public void test_getPersonById(){
        Person p = personRepository.getPersonById(1);
        Assertions.assertThat(p.getEmail()).isEqualTo("test@gmail.com");
    }
}
