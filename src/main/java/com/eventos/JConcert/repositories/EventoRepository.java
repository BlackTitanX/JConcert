package com.eventos.JConcert.repositories;


import com.eventos.JConcert.models.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {


    Evento findById(long id);
}
