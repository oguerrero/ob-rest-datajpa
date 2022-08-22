package com.oguerrero.obrestdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguerrero.obrestdatajpa.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
