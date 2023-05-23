package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tarifas")
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifa")
    private int id_tarifa;

    @Column(name = "tipo_cita")
    private String tipo_cita;

    @Column(name = "costo")
    private static BigDecimal costo;

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public static BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
