package edu.cue.aplication;

import edu.cue.aplication.service.ArticuloServiciolmpl;
import edu.cue.aplication.service.ClienteServicioImpl;
import edu.cue.domain.CajaRegistradora;
import edu.cue.domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private static ClienteServicioImpl clienteServicio = new ClienteServicioImpl();
    private static ArticuloServiciolmpl articuloServicio = new ArticuloServiciolmpl();

    public static void main(String[] args) throws Exception {
        iniciarCajasRegistradoras();
        //crearDatos();
        System.out.println("Gracias por usar el sistema.");
    }
    private static void iniciarCajasRegistradoras(){
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = clienteServicio.obtenerClientes();
        CajaRegistradora cajaRegistradora1 = new CajaRegistradora("Caja 1",listaClientes);
        CajaRegistradora cajaRegistradora2 = new CajaRegistradora("Caja 2",listaClientes);

        cajaRegistradora1.start();
        cajaRegistradora2.start();
    }

    private static void crearDatos() throws Exception {
        //Se crean 8 articulos y se guardan con persistencia usando ArticuloRepositoryImpl
        articuloServicio.crearArticulo("Queso Mozzarella La Serenísima 200g", 6500, "17");
        articuloServicio.crearArticulo("Espaguetis Barilla 500g", 4300, "18");
        articuloServicio.crearArticulo("Lentejas La Castellana 500g", 2800, "19");
        articuloServicio.crearArticulo("Aceitunas verdes rellenas de pimiento 200g", 7200, "20");
        articuloServicio.crearArticulo("Mostaza Heinz 200g", 3600, "21");
        articuloServicio.crearArticulo("Sopa instantánea Maruchan 100g", 1500, "22");
        articuloServicio.crearArticulo("Café instantáneo Nescafé 100g", 8300, "23");
        articuloServicio.crearArticulo("Té verde Lipton caja de 25 bolsitas", 3100, "24");


        //Se crea un cliente y se le añaden 6 articulos, y se guarda usando ClienteRepositoryImpl

        clienteServicio.crearCliente("Alba","Cardona","41924982","Carrera 3");
        clienteServicio.agregarProductoCesta("41924982","24");
        clienteServicio.agregarProductoCesta("41924982","23");
        clienteServicio.agregarProductoCesta("41924982","22");
        clienteServicio.agregarProductoCesta("41924982","21");
        clienteServicio.agregarProductoCesta("41924982","20");
        clienteServicio.agregarProductoCesta("41924982","19");
    }
}

