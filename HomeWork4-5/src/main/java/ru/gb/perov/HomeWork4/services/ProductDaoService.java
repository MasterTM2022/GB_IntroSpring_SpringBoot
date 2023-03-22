package ru.gb.perov.HomeWork4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.perov.HomeWork4.Data.Product;
import ru.gb.perov.HomeWork4.repositories.ProductDao;

import java.util.List;
@Service
public class ProductDaoService {
    @Autowired
    private ProductDao productDao;

    public ProductDaoService() {
    }

    public ProductDaoService(ProductDao productDao) {
        this.productDao = productDao;
    }
    public List<Product> findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void addProduct(String title, double cost) {
        productDao.add(title, cost);
    }
}
