package com.oguerrero.obrestdatajpa.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "laptops")
@ApiModel(description = "Entidad laptop para representar un laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated laptop ID")
    private Long id;
    private String brand;
    private String model;
    private String processor;
    private String ram;
    private String hdd;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, String processor, String ram, String hdd) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return this.ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return this.hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public Laptop id(Long id) {
        setId(id);
        return this;
    }

    public Laptop brand(String brand) {
        setBrand(brand);
        return this;
    }

    public Laptop model(String model) {
        setModel(model);
        return this;
    }

    public Laptop processor(String processor) {
        setProcessor(processor);
        return this;
    }

    public Laptop ram(String ram) {
        setRam(ram);
        return this;
    }

    public Laptop hdd(String hdd) {
        setHdd(hdd);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Objects.equals(id, laptop.id) && Objects.equals(brand, laptop.brand)
                && Objects.equals(model, laptop.model) && Objects.equals(processor, laptop.processor)
                && ram == laptop.ram && Objects.equals(hdd, laptop.hdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, processor, ram, hdd);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", brand='" + getBrand() + "'" +
                ", model='" + getModel() + "'" +
                ", processor='" + getProcessor() + "'" +
                ", ram='" + getRam() + "'" +
                ", hdd='" + getHdd() + "'" +
                "}";
    }

}
