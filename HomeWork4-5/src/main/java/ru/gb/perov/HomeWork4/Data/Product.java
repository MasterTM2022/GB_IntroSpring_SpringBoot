package ru.gb.perov.HomeWork4.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {
//    private static Long counter = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private double cost;

    public Product() {
    }

    public Product(String title, double cost) {
//        this.id = null;
        this.title = title;
        this.cost = cost;
    }
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\nProduct " + id + ": " + title + " - " + cost;
    }

}