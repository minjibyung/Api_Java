package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "historial_odontologico")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PacienteHistorial")
    private int  ID_Paciente ;
    @Column(name = "Fecha_Visita")
    private Date Fecha_Visita;
    @Column(name = "Problema")
    private String  Problema ;
    @Column(name = "Tratamiento")
    private String  Tratamiento ;
    @Column(name = "Proxima_Cita")
    private LocalDate proximaCita;
    @Column(name = "Notas")
    private String  Notas;

    @Column(name = "Estado")
    private boolean Estado;

    public int getID_Paciente() {
        return ID_Paciente;
    }

    public void setID_Paciente(int ID_Paciente) {
        this.ID_Paciente = ID_Paciente;
    }

    public Date getFecha_Visita() {
        return Fecha_Visita;
    }

    public void setFecha_Visita(Date fecha_Visita) {
        Fecha_Visita = fecha_Visita;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String problema) {
        Problema = problema;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }

    public LocalDate getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(LocalDate proximaCita) {
        this.proximaCita = proximaCita;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String notas) {
        Notas = notas;
    }

    public Historial() {
        this.Estado = true;
    }

    public String getEstado() {
        if (Estado) {
            return "Activo";
        } else {
            return "Desactivo";
        }
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
}
