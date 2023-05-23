package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Tarifa;
import com.Fresh.ProyectoFormativo.Service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ControladorTarifa {
    @Autowired
    private TarifaService tarifaService;
    private TarifaService impl;

    @GetMapping("/ConsultarTarifas")
    public ResponseEntity<List<Tarifa>> consultarTarifas() {
        List<Tarifa> tarifa = tarifaService.ConsultarTarifas();
        return ResponseEntity.ok(tarifa);
    }

    @PostMapping("/CrearTarifa")
    public ResponseEntity<String> crearTarifa(@RequestBody Tarifa tarifa) {
        Tarifa nuevaTarifa = tarifaService.CrearTarifa(tarifa);
        String mensaje = "Tarifa creada";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }


    @PutMapping("/ModificarTarifa/{id}")
    public ResponseEntity<String> modificarTarifa(@PathVariable int id, @RequestBody Tarifa tarifa) {
        Tarifa tarifaExistente = tarifaService.BuscarTarifa(id);
        tarifaExistente.setCosto(Tarifa.getCosto());
        Tarifa tarifaActualizada = tarifaService.ModificarTarifa(tarifaExistente);
        String mensaje = "Tarifa modificada";
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/BuscarTarifa/{id}")
    public ResponseEntity<Tarifa> buscarTarifa(@PathVariable int id) {
        Tarifa tarifa = tarifaService.BuscarTarifa(id);
        return ResponseEntity.ok(tarifa);
    }

    @DeleteMapping("/EliminarTarifa/{id}")
    public ResponseEntity<String> eliminarTarifa(@PathVariable int id) {
        tarifaService.EliminarTarifa(id);
        String mensaje = "Tarifa eliminada";
        return ResponseEntity.ok(mensaje);
    }


}