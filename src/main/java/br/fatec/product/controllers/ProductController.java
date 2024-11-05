package br.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.entities.Product;
import br.fatec.product.services.ProductSevice;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductSevice service;

    @GetMapping
    public List<Product> geProducts() {
        return service.getALLProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable long id) {
        return service.getProductById(id);

    }

}
