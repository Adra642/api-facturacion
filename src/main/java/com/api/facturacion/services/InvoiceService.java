package com.api.facturacion.services;

import com.api.facturacion.entities.Invoice;
import com.api.facturacion.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public Invoice getById(long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice not found with id: " + id));
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void delete(long id) {
        invoiceRepository.deleteById(id);
    }
}
