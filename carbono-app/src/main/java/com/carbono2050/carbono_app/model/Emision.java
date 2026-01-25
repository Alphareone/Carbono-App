package com.carbono2050.carbono_app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Emision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fuente;
    private double cantidadCO2;
    private LocalDate fecha;

    // Constructor vacío OBLIGATORIO
    public Emision() {
        this.fecha = LocalDate.now();
    }

    // Constructor con datos
    public Emision(String fuente, double cantidadCO2) {
        this.fuente = fuente;
        this.cantidadCO2 = cantidadCO2;
        this.fecha = LocalDate.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFuente() { return fuente; }
    public void setFuente(String fuente) { this.fuente = fuente; }
    public double getCantidadCO2() { return cantidadCO2; }
    public void setCantidadCO2(double cantidadCO2) { this.cantidadCO2 = cantidadCO2; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}