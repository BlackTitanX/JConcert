package services;
import models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.EntradaRepository;
import repositories.EventoRepository;
import models.Evento;
import models.Entrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventoService {

 EventoRepository eventoRepository;
 EntradaRepository entradaRepository;

 @Autowired
 Optional<Evento> evento;
 List<Entrada> entradasEncontradas = new ArrayList<>();

   public List<Evento> buscarEventos(){

       return (List<Evento>) (ArrayList<Evento>) eventoRepository.findAll();
   }

    public boolean crearEvento(Evento evento){

        try{
            eventoRepository.save(evento);
            return true;
        }catch (Exception e){

            return false;
        }


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
