package edu.cue.aplication.service;

import edu.cue.domain.Articulo;
import edu.cue.domain.Cliente;
import edu.cue.infraestructure.repository.ClienteRepositoryImpl;

public class ClienteServicioImpl implements ClienteServicio{
    private final ClienteRepositoryImpl clienteRepository = new ClienteRepositoryImpl();
    private final ArticuloServiciolmpl articuloServiciolmpl;

    public ClienteServicioImpl(ArticuloServiciolmpl articuloServiciolmpl) {
        this.articuloServiciolmpl = articuloServiciolmpl;
    }

    @Override
    public void agregarProductoCesta(String idCliente, String idProducto) throws Exception {
        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null){
            throw new Exception("No hay un cliente");
        }
        Articulo articulo = articuloServiciolmpl.obtenerArticulo(idProducto);

        cliente.getCestaDeCompra().getArticulos().add(articulo);

        clienteRepository.save(cliente);

    }

    @Override
    public void eliminarProductoCesta(String idCliente, String idProducto) throws Exception {
        Cliente cliente = clienteRepository.findById(idCliente);
        if (cliente == null){
            throw new Exception("No hay un cliente");
        }
        Articulo articulo = articuloServiciolmpl.obtenerArticulo(idProducto);

        if (cliente.getCestaDeCompra().getArticulos().contains(articulo)){
            cliente.getCestaDeCompra().getArticulos().remove(articulo);
        }

        clienteRepository.save(cliente);
    }
}
