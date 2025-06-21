package com.eventos.JConcert.repositories;

import java.util.List;
import com.eventos.JConcert.models.Cliente;

import com.eventos.JConcert.models.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {


    Cliente findById(long id);

}
