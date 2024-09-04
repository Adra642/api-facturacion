package com.api.facturacion.controllers;

import com.api.facturacion.entities.Product;
import com.api.facturacion.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable long id) {
        return productService.getById(id);
    }

    @PostMapping("/product")
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/product")
    public void editProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
    }
}
