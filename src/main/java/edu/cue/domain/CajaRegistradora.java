package edu.cue.domain;

import edu.cue.aplication.service.ArticuloServiciolmpl;

import java.util.List;
public class CajaRegistradora extends Thread {
    private Integer totalCaja = 0;
    private List<Cliente> clientesPorCaja;
    ArticuloServiciolmpl articuloServiciolmpl = new ArticuloServiciolmpl();

    public CajaRegistradora(String nombre, List<Cliente> clientesPorCaja) {
        super(nombre);
        this.clientesPorCaja = clientesPorCaja;
        // Asigna un nombre al hilo, útil para depuración y seguimiento
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " está lista para atender clientes.");

        // Simular atender a un cliente
        try {
            while (!interrupted() && !clientesPorCaja.isEmpty()) {

                Cliente cliente = clientesPorCaja.get(0);
                clientesPorCaja.remove(0);

                int totalCliente = 0;
                for (int i = 0; i < cliente.getListaArticulos().size(); i++) {
                    totalCliente += articuloServiciolmpl.obtenerArticulo(cliente.getListaArticulos().get(i)).getPrecio();
                    System.out.println(this.getName()+" ha registrado: "+articuloServiciolmpl.obtenerArticulo(cliente.getListaArticulos().get(i)).getName()+" por: "+articuloServiciolmpl.obtenerArticulo(cliente.getListaArticulos().get(i)).getPrecio());
                }
                System.out.println("El total del cliente "+cliente.getName()+" es de "+totalCliente+" en "+this.getName());
                totalCaja += totalCliente;


                // Simular el tiempo que toma procesar una venta
                Thread.sleep((int) (Math.random() * 2000 + 500));
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " ha sido interrumpida.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " ha terminado el día con un total de: $" + totalCaja);
    }
}

