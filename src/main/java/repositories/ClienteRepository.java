package repositories;

import java.util.List;
import models.Cliente;

import models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findByEvento(Evento evento);

    Cliente findById(long id);

}
