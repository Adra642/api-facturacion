package com.api.facturacion.services;

import com.api.facturacion.entities.Product;
import com.api.facturacion.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
