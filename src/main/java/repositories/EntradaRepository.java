package repositories;

import java.util.List;

import models.Entrada;
import org.springframework.data.repository.CrudRepository;


public interface EntradaRepository extends CrudRepository<Entrada, Long > {

    Entrada findById(long id);
}
