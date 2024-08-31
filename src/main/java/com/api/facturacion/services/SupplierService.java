package com.api.facturacion.services;

import com.api.facturacion.entities.Supplier;
import com.api.facturacion.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier getById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Supplier not found with id: " + id));
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }
}
