package edu.cue.aplication.service;

import edu.cue.domain.Articulo;
import edu.cue.domain.Cliente;
import edu.cue.infraestructure.repository.ClienteRepositoryImpl;

import java.util.List;

public class ClienteServicioImpl implements ClienteServicio{
    private final ClienteRepositoryImpl clienteRepository = new ClienteRepositoryImpl();

    @Override
    public void agregarProductoCesta(String idCliente, String idProducto) throws Exception {
        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null){
            throw new Exception("No hay un cliente");
        }
        cliente.getListaArticulos().add(idProducto);

        clienteRepository.save(cliente);

    }

    @Override
    public void eliminarProductoCesta(String idCliente, String idProducto) throws Exception {
        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null){
            throw new Exception("No hay un cliente");
        }
        cliente.getListaArticulos().remove(idProducto);

        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public void crearCliente(String nombre, String apellido, String cedula, String direccion) throws Exception {
        //Faltan validaciones
        if (clienteRepository.findById(cedula) != null){
            throw new Exception("Ya hay un cliente con esta identificación");
        }
        Cliente cliente = new Cliente(nombre,apellido,cedula,direccion);
        clienteRepository.save(cliente);
    }
}
