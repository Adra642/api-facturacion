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
@Table(name = "SUPPLIERS")
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 11)
    private String ruc;

    private String name;
    private String email;
    private String address;

    @Column(length = 20)
    private String phone;

    @OneToMany(mappedBy = "supplier")
    @JsonManagedReference(value = "supplier-products")
    private List<Product> products = new ArrayList<>();
}
