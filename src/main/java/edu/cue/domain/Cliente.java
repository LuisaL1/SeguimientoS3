package edu.cue.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L; // Esto es opcional pero recomendado

    private String name;
    private String lastName;
    private String ID;
    private String address;
    private List<String> listaArticulos = new ArrayList<>();

    public Cliente(String name, String lastName, String ID, String address) {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.lastName = lastName;
    }

    // getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<String> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
}


