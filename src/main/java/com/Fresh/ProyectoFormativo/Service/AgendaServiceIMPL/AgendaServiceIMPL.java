package com.Fresh.ProyectoFormativo.Service.AgendaServiceIMPL;
import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Repository.AgendaRepo;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceIMPL implements AgendaService {
    private final AgendaRepo repo;

    @Autowired
    public AgendaServiceIMPL(AgendaRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Agenda> ConsultarAgendas() {
        return (List<Agenda>)this.repo.findAll();
    }
    @Override
    public Agenda CrearAgenda(Agenda agenda) {
        return repo.save(agenda);
    }

    @Override
    public Agenda ModificarAgenda(Agenda agenda) {
        return repo.save(agenda);
    }

    @Override
    public Agenda BuscarAgenda(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Agenda no encontrada con id: " + id));
    }

    @Override
    public void EliminarAgenda(int id) {
        repo.deleteById(id);
    }

}