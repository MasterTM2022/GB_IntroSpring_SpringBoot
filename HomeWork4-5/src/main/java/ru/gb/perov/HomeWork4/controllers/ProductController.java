package ru.gb.perov.HomeWork4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.perov.HomeWork4.Data.Product;
import ru.gb.perov.HomeWork4.repositories.ProductDao;
import ru.gb.perov.HomeWork4.services.ProductDaoService;

import java.util.List;

@RestController
@RequestMapping("")

public class ProductController {

    @Autowired
    private final ProductDaoService productDaoService;

    public ProductController(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productDaoService.findAll();
    }

    @GetMapping("/product/{id}")
    public List<Product> findById(@PathVariable Long id) {
        return productDaoService.findById(id);
    }


    @PostMapping("/add")
    public void addProduct(@RequestParam String title, @RequestParam Double cost) {
        productDaoService.addProduct(title, cost);
    }

    @GetMapping("/delete/{id}")
    public void addProduct(@PathVariable Long id) {
        productDaoService.deleteById(id);
    }

}