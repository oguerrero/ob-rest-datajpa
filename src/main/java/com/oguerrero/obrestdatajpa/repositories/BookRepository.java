package com.oguerrero.obrestdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguerrero.obrestdatajpa.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
