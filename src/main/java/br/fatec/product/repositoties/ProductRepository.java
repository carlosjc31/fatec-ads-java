package br.fatec.product.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{




}
