package edu.cue.aplication.service;

import edu.cue.domain.Articulo;
import edu.cue.infraestructure.repository.ArticuloRepositoryImpl;

public class ArticuloServiciolmpl implements ArticuloServicio {
    ArticuloRepositoryImpl articuloRepositoryImpl = new ArticuloRepositoryImpl();
    @Override
    public Articulo obtenerArticulo(String idArticulo) throws Exception {
        Articulo articulo = articuloRepositoryImpl.findById(idArticulo);
        if (articulo == null){
            throw new Exception("El producto no existe");
        }
        return articulo;
    }
}
