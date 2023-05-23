package com.Fresh.ProyectoFormativo.Service.HistorialServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Historial;
import com.Fresh.ProyectoFormativo.Repository.HistorialRepo;
import com.Fresh.ProyectoFormativo.Service.HistorialService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistorialServiceIMPL implements HistorialService {
    private final HistorialRepo repo;
    private final EntityManager entityManager;

    @Autowired
    public HistorialServiceIMPL(HistorialRepo repo, EntityManager entityManager) {
        this.repo = repo;
        this.entityManager = entityManager;
    }

    @Override
    public List<Historial> ConsultarHistoriales() {
        return (List<Historial>)this.repo.findAll();
    }
    @Override
    public Historial CrearHistorial(Historial historial) {
        return repo.save(historial);
    }

    @Override
    public Historial ModificarHistorial(Historial historial) {
        return repo.save(historial);
    }

    @Override
    public Historial BuscarHistorial(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Historial clínico no encontrado con id: " + id));
    }

    @Override
    public void EliminarHistorial(int id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public void ActualizarEstadoHistorial(Historial historial) {
        entityManager.merge(historial);
    }
}