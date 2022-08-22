package com.oguerrero.obrestdatajpa.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.oguerrero.obrestdatajpa.entities.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    //@Test
    /*void findAll() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getBody());

        List<Object> books =  Arrays.asList(response.getBody());
        System.out.println(books.size());
    }*/

    @Test
    void findOneById() {

    }

    @Test
    void create() {

    }
}
