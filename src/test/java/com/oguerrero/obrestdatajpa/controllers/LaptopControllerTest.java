package com.oguerrero.obrestdatajpa.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import com.oguerrero.obrestdatajpa.entities.Laptop;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopControllerTest {

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

   /*@Test
    void testCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Libro creado desde Spring Test",
                    "author": "Yuval Noah",
                    "pages": 650,
                    "price": 19.99,
                    "releaseDate": "2019-12-01",
                    "online": false
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request,
                Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Libro creado desde Spring Test", result.getBrand());

    }
*/
    @Test
    void testDelete() {

    }

    @Test
    void testDeleteAll() {

    }

    @Test
    void testFindAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void testFindById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/Laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdate() {

    }

}
