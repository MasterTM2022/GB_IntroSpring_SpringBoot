package ru.gb.perov.HomeWork4.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gb.perov.HomeWork4.Data.Product;
import ru.gb.perov.HomeWork4.Interfaces.ProductDaoInterface;
import ru.gb.perov.HomeWork4.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao implements ProductDaoInterface {

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = new ArrayList<>();
            products.add(session.get(Product.class, id));
            session.getTransaction().commit();
            System.out.println(products);
            return products;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.remove(product);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void add(String title, double cost) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(new Product(title, cost));
            session.getTransaction().commit();
        }
    }
}
