package repositories;


import models.Evento;
import org.springframework.data.repository.CrudRepository;


public interface EventoRepository extends CrudRepository<Evento, Long> {


    Evento findById(long id);
}
