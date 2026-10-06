package RA1.Ejercicio3;

import java.io.DataOutputStream;
import java.io.IOException;

import lombok.Data;

@Data
public class Empleado {

    private String nombre;
    private String apellido;
    private int numerohijos;

    public Empleado(String nombre, String apellido, int numerohijos) {
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