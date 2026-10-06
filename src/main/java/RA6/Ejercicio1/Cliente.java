package RA6.Ejercicio1;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}