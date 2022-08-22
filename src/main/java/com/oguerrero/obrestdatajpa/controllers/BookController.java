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

import com.oguerrero.obrestdatajpa.entities.Book;
import com.oguerrero.obrestdatajpa.repositories.BookRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // attributes
    private BookRepository bookRepository;

    // constructors
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre Book
    // Buscar todos los libros
    /**
     * http://localhost:8080/api/books
     * 
     * @return List<Book>
     */
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Buscar un libro por id
    /**
     * http://localhost:8080/api/books/{id}
     * 
     * @param id
     * @return Book
     */
    @GetMapping("/api/books/{id}")
    @ApiOperation(value = "Buscar un libro por id", notes = "Buscar un libro por id")   
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un libro
    /**
     * POST
     * http://localhost:8080/api/books
     * 
     * @param book
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        if (book.getId() != null) { // id already exists, bad request
            logger.info("Trying to create a book with an id");
            return ResponseEntity.badRequest().build();
        }
        // create the book
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // Actualizar un libro
    /**
     * PUT
     * http://localhost:8080/api/books/{id}
     * 
     * @param id
     * @param book
     * @return
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (book.getId() == null) { // Book without id
            logger.info("Trying to update a book without an id");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())) { // Book not found
            logger.info("Trying to update a book that does not exist");
            return ResponseEntity.notFound().build();
        }
        // Update book
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // Eliminar un libro
    /**
     * DELETE
     * http://localhost:8080/api/books/{id}
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) { // Book not found
            logger.info("Trying to delete a book that does not exist");
            return ResponseEntity.notFound().build();
        }
        // Delete book
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Borrar todos libros
    /**
     * DELETE
     * http://localhost:8080/api/books
     * 
     * @return
     */
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll() {
        logger.info("REST request delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
