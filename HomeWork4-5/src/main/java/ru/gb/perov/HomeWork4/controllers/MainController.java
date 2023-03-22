package ru.gb.perov.HomeWork4.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import ru.gb.perov.HomeWork4.SessionFactoryUtils;
import ru.gb.perov.HomeWork4.repositories.ProductDao;
import ru.gb.perov.HomeWork4.services.ProductDaoService;

@SpringBootApplication
@ComponentScan({"ru.gb.perov.HomeWork4"})
@EntityScan("ru.gb.perov.HomeWork4.Data")
public class MainController {



    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();

        SessionFactoryUtils.init();
        try {
            ProductDaoService productDaoService = new ProductDaoService(new ProductDao(sessionFactoryUtils));

//            productDaoService.findAll().forEach(System.out::println);
//            System.out.println("1111111111111111111111111");
//            List<Product> products = productDaoService.findById(3L);
//            System.out.println(products.toString());
//            System.out.println("22222222222222222222222222");
//            productDaoService.deleteById(8L);
//            productDaoService.findAll().forEach(System.out::println);
//            System.out.println("33333333333333333333333333333");
//            productDaoService.addProduct("meat", 29.00);
//            productDaoService.findAll().forEach(System.out::println);
//            System.out.println("44444444444444444444444444");

        } catch (Exception e) {
            sessionFactoryUtils.shutdown();
            e.printStackTrace();
        } finally {
//            sessionFactoryUtils.shutdown();
        }
    }

}