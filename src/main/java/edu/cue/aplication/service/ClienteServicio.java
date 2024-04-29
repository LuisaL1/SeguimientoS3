package edu.cue.aplication.service;

public interface ClienteServicio {
    void agregarProductoCesta(String idCliente, String idProducto) throws Exception;
    void eliminarProductoCesta(String idCliente, String idProducto) throws Exception;

}
