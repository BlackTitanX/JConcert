package com.eventos.JConcert.services;

import com.eventos.JConcert.models.Cliente;
import com.eventos.JConcert.models.Entrada;
import com.eventos.JConcert.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import com.eventos.JConcert.repositories.ClienteRepository;
import com.eventos.JConcert.repositories.EntradaRepository;
import com.eventos.JConcert.repositories.EventoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.Year;
import java.util.Optional;
import java.util.UUID;





public class EntradaService {
    
    // Trayendo los repositorios
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EntradaRepository entradaRepository;
    
    // Declarando variables comunes
    Optional<Evento> evento;
    Optional<Cliente> cliente;
    Optional<Entrada> entrada;
    

    //crear metodo para generar numero de entrada y entrada de forma segura
    // buscar informacion de entrada
    //Asignar asiento al momento de comprar entrada

    
    // Funcion para crear numero unido
    private static String generarIdDinamico(String tipoDeEntrada, int fila, char columna) {
        // 1. Obtiene el año actual de forma dinámica
        String anioActual = Year.now().toString();

        // 2. Obtiene la hora actual en milisegundos para una alta granularidad
        long timestamp = Instant.now().toEpochMilli();

        // 3. Genera un UUID y toma una parte para añadir más aleatoriedad
        String randomUUIDPart = UUID.randomUUID().toString().substring(0, 8);

        // 4. Concatena todos los elementos para formar el ID final
        return "EV-" + anioActual + "-"+ tipoDeEntrada +"-" +columna + fila +"-"+timestamp + "-" + randomUUIDPart;
    }
    
    @Transactional
    public boolean crearEntrada(Long idEvento, Long idCliente, double precio,String tipoDeEntrada, int fila, char columna  ){
        
        try {
            evento = eventoRepository.findById(idEvento);
            cliente = clienteRepository.findById(idCliente);

            Entrada entrada = new Entrada();

            if(evento.isPresent() && cliente.isPresent()){


                entrada.setEvento(evento.get());
                entrada.setCliente(cliente.get());
                entrada.setNumeroDeEntrada(generarIdDinamico(tipoDeEntrada, fila, columna));
                entrada.setPrecio(precio);
                entradaRepository.save(entrada);


                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Entrada> getEntrada(Long idEntrada) {
        try {
            return entradaRepository.findById(idEntrada);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
