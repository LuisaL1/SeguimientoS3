package edu.cue.domain;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
public class CajaRegistradora extends Thread {
    private AtomicInteger totalCaja = new AtomicInteger(0);

    public CajaRegistradora(String nombre, List<Cliente> clientesPorCaja) {
        super(nombre); // Asigna un nombre al hilo, útil para depuración y seguimiento
    }

    // Método para añadir monto a la caja de manera segura
    public void agregarVenta(int monto) {
        totalCaja.addAndGet(monto);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " está lista para atender clientes.");

        // Simular atender a un cliente
        try {
            while (!interrupted()) {
                // Aquí podrías simular una venta, por ejemplo:
                int venta = (int) (Math.random() * 100 + 1);  // Simula el total de una venta
                agregarVenta(venta);
                System.out.println(Thread.currentThread().getName() + " procesó una venta de: $" + venta);

                // Simular el tiempo que toma procesar una venta
                Thread.sleep((int) (Math.random() * 2000 + 500));
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " ha sido interrumpida.");
        }

        System.out.println(Thread.currentThread().getName() + " ha terminado el día con un total de: $" + totalCaja);
    }
}

