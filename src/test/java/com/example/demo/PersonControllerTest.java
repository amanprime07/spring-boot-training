package com.example.demo;

import com.example.demo.controllers.PersonController;
import com.example.demo.repository.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @TestConfiguration
    static class PersonControllerConfig{
        @Bean
        public PersonService personService(){
            var dao = Mockito.mock(PersonRepository.class);
            Mockito.when(dao.findAll()).thenReturn(List.of(new Person(1, "abcd", "test@gmail.com")));
            return new PersonServiceImpl(dao);
        }
    }

    @Autowired
    private MockMvc mvc;

//    @MockitoBean
//    private PersonService personService;

    @Test
    public void testGetAll() throws Exception {
//        Mockito.when(personService.getAllPerson())
//                .thenReturn(List.of(new Person(1, "abcd", "test@gmail.com")));
        mvc.perform(get("/v1/user/all"))
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers.
                        jsonPath("$[0].email", CoreMatchers.is("test@gmail.com")));
    }

}
