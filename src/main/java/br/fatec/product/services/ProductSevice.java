package br.fatec.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.product.dtos.ProductResponse;
import br.fatec.product.entities.Product;
import br.fatec.product.mappers.ProductMapper;
import br.fatec.product.repositoties.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import main.java.br.fatec.product.dtos.ProductResquest;

@Service
public class ProductSevice {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponse> getALLProducts() {
        return repository.findAll().stream().map(p -> ProductMapper.toDTO(p)).collect(Collectors.toList());
    }

    public Product getProductById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto não cadastrado"));
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.existsById(id);

        } else {
            throw new EntityNotFoundException("Produto não cadastrado");
        }
    }

    public Product save(ProductResquest product) {
        Product newProduct = repository.save(ProductMapper.toEntity(product));
        return ProductMapper.toDTO(newProduct);
    }

    public void update(ProductResquest product, long id) {
        Product aux = repository.getReferenceById(id);

        aux.setCategory(product.Category());
        aux.setName(product.Name());
        aux.setPrice(product.Price());

        repository.save(aux);

    }
}
