package edu.cue.aplication.service;

import edu.cue.domain.Cliente;

import java.util.List;

public interface ClienteServicio {
    void agregarProductoCesta(String idCliente, String idProducto) throws Exception;
    void eliminarProductoCesta(String idCliente, String idProducto) throws Exception;
    List<Cliente> obtenerClientes();
    void crearCliente(String nombre, String apellido, String cedula, String direccion) throws Exception;
}
