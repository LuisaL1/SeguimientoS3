package edu.cue.domain;

import java.io.Serializable;

public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L; // Esto es opcional pero recomendado

    private String name;
    private int precio;
    private String codigo;

    public Articulo(String name, int precio, String codigo) {
        this.name = name;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

