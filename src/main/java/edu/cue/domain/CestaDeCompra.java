package edu.cue.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CestaDeCompra implements Serializable {
    private List<Articulo> articulos;
    public CestaDeCompra() {
        this.articulos = new ArrayList<>();
    }


    public double calcularTotal() {
        double total = 0.0;
        for (Articulo articulo : this.articulos) {
            total += articulo.getPrecio();
        }
        return total;
    }

    public List <Articulo> getArticulos() {
        return articulos;
    }
}


