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
    public List<Category> findAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable long id) {
        return categoryService.getById(id);
    }

    @PostMapping("/category")
    public void saveCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping("/category")
    public void editCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteById(id);
    }
}
