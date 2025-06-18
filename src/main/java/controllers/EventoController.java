package controllers;

import models.Cliente;
import models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.EventoService;

import java.util.List;



@RestController
@RequestMapping("/api/eventos") // <-- this adds a common prefix
public class EventoController {

    @Autowired
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping // resolves to GET /api/eventos
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoService.buscarEventos();
        if (eventos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PostMapping // resolves to POST /api/eventos
    public ResponseEntity<String> createEvento(@RequestBody Evento evento) {
        if (eventoService.crearEvento(evento)) {
            return new ResponseEntity<>("Evento created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create event. Please check the data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{eventoId}/asistentes") // resolves to GET /api/eventos/{eventoId}/asistentes
    public ResponseEntity<List<Cliente>> getAttendeesForEvento(@PathVariable Long eventoId) {
        List<Cliente> clientes = eventoService.obtenerListaDeAssistente(eventoId);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}