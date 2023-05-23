package com.Fresh.ProyectoFormativo.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private int id_agenda;

    @Column(name = "fecha_agenda")
    private Date fecha_agenda;

    @Column(name = "id_agendaCita")
    private int id_cita;

    @Column(name = "id_pacienteAgenda")
    private int id_paciente;

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Date getFecha_agenda() {
        return fecha_agenda;
    }

    public void setFecha_agenda(Date fecha_agenda) {
        this.fecha_agenda = fecha_agenda;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

}