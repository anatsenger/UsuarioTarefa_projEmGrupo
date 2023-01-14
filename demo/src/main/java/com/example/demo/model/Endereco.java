package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;
    private String CEP;
    private String logradouro;
    private String numero;
    private String cidade;
}
