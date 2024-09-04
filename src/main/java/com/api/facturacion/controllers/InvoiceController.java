package com.api.facturacion.controllers;

import com.api.facturacion.entities.Invoice;
import com.api.facturacion.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/invoices")
    public List<Invoice> findAllInvoices() {
        return invoiceService.getAll();
    }

    @GetMapping("/invoice/{id}")
    public Invoice findInvoiceById(@PathVariable long id) {
        return invoiceService.getById(id);
    }

    @PostMapping("/invoice")
    public void saveInvoice(@RequestBody Invoice invoice) {
        invoiceService.save(invoice);
    }

    @PutMapping("/invoice")
    public void editInvoice(@RequestBody Invoice invoice) {
        invoiceService.save(invoice);
    }

    @DeleteMapping("/invoice/{id}")
    public void deleteInvoice(@PathVariable long id) {
        invoiceService.delete(id);
    }
}
