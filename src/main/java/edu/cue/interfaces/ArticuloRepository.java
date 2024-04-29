package edu.cue.interfaces;

import edu.cue.domain.Articulo;

import java.util.List;

public interface ArticuloRepository<T> {
    List<Articulo> findAll();
    Articulo findById(String id);
    void save(Articulo articulo);
    void update(Articulo articulo);
    void delete(String id);
}
