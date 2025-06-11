package services;


import jakarta.persistence.EntityNotFoundException;
import models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClienteRepository;

@Service
public class ClienteService {
    ClienteRepository clienteRepository;

    @Autowired
    public boolean crearCliente(Cliente cliente){

        try{
            clienteRepository.save(cliente);
            return true;
        }catch (Exception e){

            return false;
        }
    }


    public Cliente buscarCliente(Long id){
        Cliente cliente;

            cliente =  clienteRepository.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

            return  cliente;
    }


    public boolean actualizarCliente(Cliente cliente, Long id) {
        try {
            Cliente clienteEncontrado = clienteRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

            clienteEncontrado.setFirstName(cliente.getFirstName());
            clienteEncontrado.setLastName(cliente.getLastName());


            clienteRepository.save(clienteEncontrado);
            return true;

        } catch (EntityNotFoundException e) {

            return false;

        } catch (Exception e) {

            return false;
        }
    }


}
