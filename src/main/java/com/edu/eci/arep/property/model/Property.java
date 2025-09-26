package com.edu.eci.arep.property.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "property")


public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Double size; // mts2

    @Column(columnDefinition = "TEXT")
    private String description;

    public Property() {}


    public Property(String address, BigDecimal price, Double size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public Double getSize() {
        return size;
    }
    public String getDescription() {
        return description;
    }

}
