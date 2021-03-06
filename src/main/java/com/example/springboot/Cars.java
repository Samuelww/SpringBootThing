package com.example.springboot;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cars {

    private @Id @GeneratedValue Long id;
    private String brand;
    private String model;

    Cars() {}

    public Cars(String brand, String model) {

        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Cars))
            return false;
        Cars car = (Cars) o;
        return Objects.equals(this.id, car.id) && Objects.equals(this.brand, car.brand)
                && Objects.equals(this.model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.brand, this.model);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + this.id + ", brand='" + this.brand + '\'' + ", model='" + this.model + '\'' + '}';
    }
}