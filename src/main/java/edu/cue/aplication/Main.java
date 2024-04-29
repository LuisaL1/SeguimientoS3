package edu.cue.aplication;

import edu.cue.domain.Articulo;
import edu.cue.domain.Cliente;
import edu.cue.domain.CestaDeCompra;
import edu.cue.infraestructure.repository.ClienteRepositoryImpl;

import java.util.Scanner;

public class Main {

    private static ClienteRepositoryImpl clienteRepositoryImpl = new ClienteRepositoryImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    mostrarCliente();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
        System.out.println("Gracias por usar el sistema.");
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Menú Principal ***");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Mostrar Cliente");
        System.out.println("3. Salir");
    }

    private static void registrarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese ID del cliente: ");
        String id = scanner.nextLine();
        System.out.println("Ingrese El apellido del Cliente");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese dirección del cliente: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido,  id, direccion);
        cliente.setCestaDeCompra(new CestaDeCompra()); // Inicializa con una cesta vacía
        clienteRepositoryImpl.save(cliente); // Guarda el cliente
        System.out.println("Cliente registrado con éxito.");
    }

    private static void mostrarCliente() {
        System.out.print("Ingrese ID del cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = clienteRepositoryImpl.findById(idCliente);
        if (cliente != null) {
            System.out.println("Nombre: " + cliente.getName());
            System.out.println("ID: " + cliente.getID());
            System.out.println("Dirección: " + cliente.getAddress());
            CestaDeCompra cesta = cliente.getCestaDeCompra();
            if (cesta != null && !cesta.getArticulos().isEmpty()) {
                System.out.println("Artículos en la cesta:");
                for (Articulo articulo : cesta.getArticulos()) {
                    System.out.println(" - " + articulo.getName() + " $" + articulo.getPrecio());
                }
                System.out.println("Total de la cesta: $" + cesta.calcularTotal());
            } else {
                System.out.println("La cesta está vacía.");
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }
}

