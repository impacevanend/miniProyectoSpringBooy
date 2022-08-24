package com.yoandypv.ejemplos.springcrud.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auto")
public class Auto {
    @Id
    private Long id;
    private String marca;
    private int anno;
    private int capacidad;
    private double precio;
}
