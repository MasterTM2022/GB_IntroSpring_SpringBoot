package ru.gb.perov.HomeWork4.Interfaces;

import ru.gb.perov.HomeWork4.Data.Product;

import java.util.List;

public interface ProductDaoInterface {

    List<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product save(Product product);
    void add(String title, double cost);
}
