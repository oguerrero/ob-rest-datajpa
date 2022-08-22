package com.oguerrero.obrestdatajpa;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.oguerrero.obrestdatajpa.entities.Book;
import com.oguerrero.obrestdatajpa.entities.Laptop;
import com.oguerrero.obrestdatajpa.repositories.BookRepository;
import com.oguerrero.obrestdatajpa.repositories.LaptopRepository;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		// CRUD
		// Crear Libro
		System.out.println("Creando libros...");
		Book book1 = new Book(null, "Harry Potter y la Piedra Filosofal", "J.K. Rowling", 400, 20.0,
				LocalDate.of(1997, 12, 31), true);
		Book book2 = new Book(null, "Harry Potter y la Camara Secreta", "J.K. Rowling", 400, 20.0,
				LocalDate.of(1998, 12, 31), false);
		// Almacenar Libro
		System.out.println("Almacenando libro 1...");
		repository.save(book1);
		System.out.println("Almacenando libro 2...");
		repository.save(book2);
		// Recuperar Libros
		System.out.println("Libros:");
		System.out.println(repository.findAll().size());
		for (Book book : repository.findAll()) {
			System.out.println(book);
		}
		// Borrar Libro
		/*
		 * System.out.println("Borrando libro 2...");
		 * repository.deleteById(book2.getId());
		 */
		// Recuperar Libros
		System.out.println("Libros:");
		System.out.println(repository.findAll().size());
		for (Book book : repository.findAll()) {
			System.out.println(book);
		}

		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		System.out.println("Creando laptops...");
		Laptop laptop1 = new Laptop(null, "HP", "Pavillion", "Intel i5", "8GB", "1TB");
		Laptop laptop2 = new Laptop(null, "Lenovo", "IdeaPad", "Intel i5", "8GB", "1TB");
		Laptop laptop3 = new Laptop(null, "Dell", "XPS", "Intel i5", "8GB", "1TB");
		Laptop laptop4 = new Laptop(null, "Acer", "Aspire", "Intel i5", "8GB", "1TB");
		// Almacenar Laptop
		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		laptopRepository.save(laptop3);
		laptopRepository.save(laptop4);
	}

}
