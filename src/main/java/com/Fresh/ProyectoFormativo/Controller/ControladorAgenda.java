package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Agenda;
import com.Fresh.ProyectoFormativo.Service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorAgenda {
    @Autowired
    private AgendaService agendaService;

    @GetMapping("/ConsultarAgendas")
    public ResponseEntity<List<Agenda>> consultarAgendas() {
        List<Agenda> agendas = agendaService.ConsultarAgendas();
        return ResponseEntity.ok(agendas);
    }

    @PostMapping("/CrearAgenda")
    public ResponseEntity<String> crearAgenda(@RequestBody Agenda agenda) {
        Agenda nuevaAgenda = agendaService.CrearAgenda(agenda);
        String mensaje = "Agenda creada";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }


    @PutMapping("/ModificarAgenda/{id}")
    public ResponseEntity<String> modificarAgenda(@PathVariable int id, @RequestBody Agenda agenda) {
        Agenda agendaExistente = agendaService.BuscarAgenda(id);
        agendaExistente.setFecha_agenda(agenda.getFecha_agenda());
        // Actualizar los demás campos de la agenda según sea necesario
        Agenda agendaActualizada = agendaService.ModificarAgenda(agendaExistente);
        String mensaje = "Agenda modificada";
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/BuscarAgenda/{id}")
    public ResponseEntity<Agenda> buscarAgenda(@PathVariable int id) {
        Agenda agenda = agendaService.BuscarAgenda(id);
        return ResponseEntity.ok(agenda);
    }

    @DeleteMapping("/EliminarAgenda/{id}")
    public ResponseEntity<String> eliminarAgenda(@PathVariable int id) {
        agendaService.EliminarAgenda(id);
        String mensaje = "Agenda eliminada";
        return ResponseEntity.ok(mensaje);
    }


}
