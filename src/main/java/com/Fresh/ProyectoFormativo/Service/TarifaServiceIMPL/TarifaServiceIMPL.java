package com.Fresh.ProyectoFormativo.Service.TarifaServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Tarifa;
import com.Fresh.ProyectoFormativo.Repository.TarifaRepo;
import com.Fresh.ProyectoFormativo.Service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaServiceIMPL implements TarifaService {
    private final TarifaRepo repo;

    @Autowired
    public TarifaServiceIMPL(TarifaRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Tarifa> ConsultarTarifas() {
        return (List<Tarifa>)this.repo.findAll();
    }

    @Override
    public Tarifa CrearTarifa(Tarifa tarifa) {
        return repo.save(tarifa);
    }

    @Override
    public Tarifa ModificarTarifa(Tarifa tarifa) {
        return repo.save(tarifa);
    }

    @Override
    public Tarifa BuscarTarifa(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Tarifa no encontrada con id: " + id));
    }

    @Override
    public void EliminarTarifa(int id) {
        repo.deleteById(id);
    }
}