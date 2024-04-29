package edu.cue.interfaces;

import edu.cue.domain.Cliente;

import java.util.List;

public interface ClienteRepository<T> {
    List<Cliente> findAll();
    Cliente findById(String id);
    void save(Cliente producto);
    void update(Cliente producto);
    void delete(String id);
}
