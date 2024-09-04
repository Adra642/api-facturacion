package com.api.facturacion.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference(value = "role-users")
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user-invoice")
    private List<Invoice> invoices = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }
}
