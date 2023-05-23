package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Historial;
import com.Fresh.ProyectoFormativo.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorHistorial {

    @Autowired
    private HistorialService historialService;
    private HistorialService impl;

    @GetMapping("/ConsultarHistorialesClinicos")
    public ResponseEntity<List<Historial>> consultarhistorialesActivos() {
        List<Historial> historialesActivos = this.impl.ConsultarHistoriales()
                .stream()
                .filter(historial -> "Activo".equalsIgnoreCase(historial.getEstado()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(historialesActivos);
    }



    @PostMapping
    @RequestMapping(value = "/CrearHistorialClinico",method = RequestMethod.POST)
    public ResponseEntity<?>CrearHistorialClinico(@RequestBody Historial historial){
        Historial HistorialCreado=this.impl.CrearHistorial(historial);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Historial Clinico creado con éxito");
        response.put("HistorialClinicoCreado", HistorialCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    @RequestMapping(value = "/ModificarHistorialClinico",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarHistorialClinco(@RequestBody Historial historial){
        Historial HistorialModificado=this.impl.ModificarHistorial(historial);
        String message = "Historial Clinico modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("historial", HistorialModificado);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/ConsultarHistorialesDesactivados")
    public ResponseEntity<List<Historial>> listarHistorialesDesactivados() {
        List<Historial> historialDesactivados = impl.ConsultarHistoriales().stream()
                .filter(historial -> historial.getEstado().equalsIgnoreCase("Desactivo"))
                .collect(Collectors.toList());
        return ResponseEntity.ok(historialDesactivados);
    }


    @GetMapping("/BuscarHistorialClinico/{id}")
    public ResponseEntity<?> buscarhistorial(@PathVariable int id) {
        Historial historial = impl.BuscarHistorial(id);
        if (historial == null) {
            return ResponseEntity.notFound().build();
        }
        if (!historial.getEstado().equalsIgnoreCase("Activo")) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Este historial se encuentra innactivo");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(historial);
    }


    @DeleteMapping("/EliminarHistorialClinico/{id}")
    public ResponseEntity<Map<String, Object>> desactivarHistorial(@PathVariable int id) {
        Historial historialDesactivado = impl.BuscarHistorial(id);
        historialDesactivado.setEstado(false);
        impl.ModificarHistorial(historialDesactivado);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Historial desactivado con éxito");
        response.put("historialDesactivado", historialDesactivado);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/ActivarHistorialClinico/{id}")
    public ResponseEntity<Map<String, Object>> activarHistorial(@PathVariable int id) {
        Historial historialActivado = impl.BuscarHistorial(id);
        historialActivado.setEstado(true);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Historial Clinico activado con éxito");
        response.put("historialActivado", historialActivado);

        return ResponseEntity.ok().body(response);
    }



}