package edu.cue.aplication.service;

import edu.cue.domain.Articulo;

public interface ArticuloServicio {
    Articulo obtenerArticulo(String idArticulo) throws Exception;
    void crearArticulo(String nombre, int precio, String id) throws Exception;
}
