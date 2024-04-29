package edu.cue.infraestructure.repository;

import edu.cue.domain.Cliente;
import edu.cue.interfaces.ClienteRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepositoryImpl implements ClienteRepository {

    private static final String RUTA_ARCHIVO = "src/main/resources/archivoClientes.dat";

    @Override
    public List<Cliente> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente findById(String id) {
        return findAll().stream()
                .filter(c -> c.getID().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void save(Cliente producto) {
        List<Cliente> clientes = findAll();
        clientes.add(producto);
        saveAll(clientes);
    }

    @Override
    public void update(Cliente cliente) {
        List<Cliente> productos = findAll();
        productos = productos.stream()
                .map(p -> p.getID().equals( cliente.getID()) ? cliente : p)
                .collect(Collectors.toList());
        saveAll(productos);
    }

    @Override
    public void delete(String id) {
        List<Cliente> productos = findAll();
        productos = productos.stream()
                .filter(p -> !p.getID().equals(id))
                .collect(Collectors.toList());
        saveAll(productos);
    }

    private void saveAll(List<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO  ))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


