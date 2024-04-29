package edu.cue.infraestructure.repository;

import edu.cue.domain.Articulo;
import edu.cue.interfaces.ArticuloRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticuloRepositoryImpl implements ArticuloRepository {
    private static final String RUTA_ARCHIVO = "src/main/resources/archivoArticulos.dat";

    @Override
    public List<Articulo> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            return (ArrayList<Articulo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Articulo findById(String id) {
        return findAll().stream()
                .filter(c -> c.getCodigo().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void save(Articulo articulo) {
        List<Articulo> articulos = findAll();
        articulos.add(articulo);
        saveAll(articulos);
    }

    @Override
    public void update(Articulo articulo) {
        List<Articulo> articulos = findAll();
        articulos = articulos.stream()
                .map(p -> p.getCodigo().equals( articulo.getCodigo()) ? articulo : p)
                .collect(Collectors.toList());
        saveAll(articulos);
    }

    @Override
    public void delete(String id) {
        List<Articulo> articulos = findAll();
        articulos = articulos.stream()
                .filter(p -> !p.getCodigo().equals(id))
                .collect(Collectors.toList());
        saveAll(articulos);
    }

    private void saveAll(List<Articulo> articulos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO  ))) {
            oos.writeObject(articulos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
