package com.api.facturacion.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "CLIENTS")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 11)
    private String ruc;

    private String name;
    private String email;
    private String address;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value = "client-invoice")
    private List<Invoice> invoices = new ArrayList<>();
}
