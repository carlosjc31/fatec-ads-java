package br.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.dtos.ProductResponse;
import br.fatec.product.dtos.ProductResquest;
import br.fatec.product.services.ProductSevice;


@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductSevice service;

    @GetMapping
    public ResponseEntity<List<Product>> geProducts() {
        return ResponseEntity.ok(service.getALLProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        return ResponseEntity.ok(service.getProductById(id));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, 
                                              @Validated @RequestBody ProductResquest product) {
        service.update(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> saveProduct(@Validated @RequestBody ProductResquest product) {
        ProductResponse newProduct = service.save(product);
        return ResponseEntity.created(null).body(newProduct);

    }

}
