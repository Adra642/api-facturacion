package com.api.facturacion.controllers;

import com.api.facturacion.entities.Category;
import com.api.facturacion.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/category")
    public void editById(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
