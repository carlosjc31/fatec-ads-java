package br.fatec.product.mappers;

import br.fatec.product.dtos.ProductResponse;
import br.fatec.product.entities.Product;
import main.java.br.fatec.product.dtos.ProductResquest;

public class ProductMapper {

    public static Product toEntity(ProductResquest productResquest){
        Product product = new Product();
        product.setName(productResquest.name());
        product.setPrice(productResquest.price());
        product.setCategory(productResquest.category());

        return product;
    }

    public static ProductResponse toDTO(Product product) {
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory());
    }
}
