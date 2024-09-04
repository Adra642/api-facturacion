package com.api.facturacion.controllers;

import com.api.facturacion.entities.Supplier;
import com.api.facturacion.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<Supplier> findAllSuppliers() {
        return supplierService.getAll();
    }

    @GetMapping("/supplier/{id}")
    public Supplier findSupplierById(@PathVariable long id) {
        return supplierService.getById(id);
    }

    @PostMapping("/supplier")
    public void saveSupplier(@RequestBody Supplier supplier) {
        supplierService.save(supplier);
    }

    @PutMapping("/supplier")
    public void editSupplier(@RequestBody Supplier supplier) {
        supplierService.save(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    public void deleteSupplier(@PathVariable long id) {
        supplierService.deleteById(id);
    }
}
