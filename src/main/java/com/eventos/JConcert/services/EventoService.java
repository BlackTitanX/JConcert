package com.eventos.JConcert.services;
import com.eventos.JConcert.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import com.eventos.JConcert.repositories.EntradaRepository;
import com.eventos.JConcert.repositories.EventoRepository;
import com.eventos.JConcert.models.Evento;
import com.eventos.JConcert.models.Entrada;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
 @Autowired
 EventoRepository eventoRepository;
 @Autowired
 EntradaRepository entradaRepository;


 Optional<Evento> evento;
 List<Entrada> entradasEncontradas = new ArrayList<>();

   public List<Evento> buscarEventos(){

       return (List<Evento>) (ArrayList<Evento>) eventoRepository.findAll();
   }

    @Transactional
    public Evento crearEvento(Evento evento){

       eventoRepository.save(evento);

     return evento;
    }

    public List<Cliente> obtenerListaDeAssistente(Long eventoId){
        List<Cliente> clientes = new ArrayList<>();

       try{
           entradasEncontradas = (List<Entrada>) entradaRepository.findAll();

           for (Entrada entrada : entradasEncontradas) {
              if(entrada.getEvento().getId().equals(eventoId)){
                  clientes.add(entrada.getCliente());
              }
           }

       } catch (Exception e) {
           clientes = new ArrayList<>();
       }

        return clientes;

     }





}
