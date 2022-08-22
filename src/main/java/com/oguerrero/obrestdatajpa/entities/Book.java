package com.oguerrero.obrestdatajpa.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "books")
@ApiModel(description = "Entidad libro para representar un libro")
public class Book {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated book ID")
    private Long id;
    private String title;
    private String author;
    private int numberOfPages;
    @ApiModelProperty(notes = "Precio en dolares")
    private double price;
    private LocalDate publicationDate;
    private boolean online;

    // constructors
    
    public Book() {
    }

    public Book(Long id, String title, String author, int numberOfPages, double price, LocalDate publicationDate, boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.publicationDate = publicationDate;
        this.online = online;
    }
    
    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isOnline() {
        return this.online;
    }

    public boolean getOnline() {
        return this.online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Book id(Long id) {
        setId(id);
        return this;
    }

    public Book title(String title) {
        setTitle(title);
        return this;
    }

    public Book author(String author) {
        setAuthor(author);
        return this;
    }

    public Book numberOfPages(int numberOfPages) {
        setNumberOfPages(numberOfPages);
        return this;
    }

    public Book price(double price) {
        setPrice(price);
        return this;
    }

    public Book publicationDate(LocalDate publicationDate) {
        setPublicationDate(publicationDate);
        return this;
    }

    public Book online(boolean online) {
        setOnline(online);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && numberOfPages == book.numberOfPages && price == book.price && Objects.equals(publicationDate, book.publicationDate) && online == book.online;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, numberOfPages, price, publicationDate, online);
    }

    // toString
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", numberOfPages='" + getNumberOfPages() + "'" +
            ", price='" + getPrice() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            ", online='" + isOnline() + "'" +
            "}";
    }
}
