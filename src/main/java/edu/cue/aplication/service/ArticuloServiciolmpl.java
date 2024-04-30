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

    @Override
    public void crearArticulo(String nombre, int precio, String id) throws Exception {
        if (id.isBlank() || id.isEmpty()){
            throw new Exception("El id está vacio");
        }
        if (articuloRepositoryImpl.findById(id) != null){
            throw new Exception("Ya hay un articulo con este id");
        }
        if (nombre.isEmpty() || nombre.isBlank()){
            throw new Exception("El nombre está vacio");
        }
        if (precio<=0){
            throw new Exception("El precio no puede ser menor o igual a 0");
        }

        Articulo articulo = new Articulo(nombre,precio,id);
        articuloRepositoryImpl.save(articulo);
    }
}
