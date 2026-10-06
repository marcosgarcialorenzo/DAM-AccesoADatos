package RA6.Ejercicio1;

import java.io.Serializable;

import lombok.Data;

@Data
public class Producto implements Serializable {
    private int id;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}