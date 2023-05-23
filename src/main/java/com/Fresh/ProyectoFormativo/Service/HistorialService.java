package com.Fresh.ProyectoFormativo.Service;


import com.Fresh.ProyectoFormativo.Entity.Historial;

import java.util.List;

public interface HistorialService  {
    public List<Historial> ConsultarHistoriales();
    public Historial CrearHistorial(Historial historial);
    public Historial ModificarHistorial(Historial historial);
    public Historial BuscarHistorial(int id);
    public void EliminarHistorial(int id);

    void ActualizarEstadoHistorial(Historial historialActivado);
}
