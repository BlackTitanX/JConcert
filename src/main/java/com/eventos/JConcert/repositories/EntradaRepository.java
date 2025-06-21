package com.eventos.JConcert.repositories;

import com.eventos.JConcert.models.Entrada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends CrudRepository<Entrada, Long > {

    Entrada findById(long id);
}
