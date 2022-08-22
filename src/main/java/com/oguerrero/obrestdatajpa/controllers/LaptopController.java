package com.oguerrero.obrestdatajpa.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oguerrero.obrestdatajpa.entities.Laptop;
import com.oguerrero.obrestdatajpa.repositories.LaptopRepository;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD sobre Laptop
    // Buscar todos losa laptops
    /**
     * http://localhost:8080/api/laptops
     * 
     * @return List<Laptop>
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    /**
     * http://localhost:8080/api/laptop/{id}
     * 
     * @param id
     * @return Laptop
     */
    // Buscar una Laptop por id
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> Laptop = laptopRepository.findById(id);
        return Laptop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

     // Crear una laptop
    /**
     * POST
     * http://localhost:8080/api/laptops
     * 
     * @param laptop
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) { // id already exists, bad request
            logger.info("Trying to create a laptop with an id");
            return ResponseEntity.badRequest().build();
        }
        // create the laptop
        Laptop savedlaptop = laptopRepository.save(laptop);
        return ResponseEntity.ok(savedlaptop);
    }

     // Actualizar una laptop
    /**
     * PUT
     * http://localhost:8080/api/laptops/{id}
     * 
     * @param id
     * @param laptop
     * @return
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) { // laptop without id
            logger.info("Trying to update a laptop without an id");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) { // laptop not found
            logger.info("Trying to update a laptop that does not exist");
            return ResponseEntity.notFound().build();
        }
        // Update laptop
        Laptop savedlaptop = laptopRepository.save(laptop);
        return ResponseEntity.ok(savedlaptop);
    }

    // Eliminar una laptop
    /**
     * DELETE
     * http://localhost:8080/api/laptops/{id}
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptopRepository.existsById(id)) { // laptop not found
            logger.info("Trying to delete a laptop that does not exist");
            return ResponseEntity.notFound().build();
        }
        // Delete laptop
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Borrar todosa laptops
    /**
     * DELETE
     * http://localhost:8080/api/laptops
     * 
     * @return
     */
    @DeleteMapping("/api/laptops")  
    public ResponseEntity<Laptop> deleteAll() {
        logger.info("REST request delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
