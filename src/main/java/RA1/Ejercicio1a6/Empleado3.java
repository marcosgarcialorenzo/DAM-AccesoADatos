package RA1.Ejercicio1a6;

import lombok.Data;

import java.io.DataOutputStream;
import java.io.IOException;

@Data
public class Empleado3 {

    private String nombre;
    private String apellido;
    private int numerohijos;

    public Empleado3(String nombre, String apellido, int numerohijos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numerohijos = numerohijos;
    }

    public void escribir(DataOutputStream out) throws IOException {
        out.writeUTF(nombre);
        out.writeUTF(apellido);
        out.writeInt(numerohijos);
    }

    public void mostrar() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + ", Apellido: " + apellido
                + ", Número de hijos: " + numerohijos;
    }
}