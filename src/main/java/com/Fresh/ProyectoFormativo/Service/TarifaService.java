package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Tarifa;

import java.util.List;

public interface TarifaService {
    public List<Tarifa> ConsultarTarifas();
    public Tarifa CrearTarifa(Tarifa tarifa);
    public Tarifa ModificarTarifa(Tarifa tarifa);
    public Tarifa BuscarTarifa(int id);
    public void EliminarTarifa(int id);
}
