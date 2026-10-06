package RA6.Ejercicio2;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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