package RA1.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Empleado implements Serializable {

    private long codigo;
    private String nombre;
    private long salario;
    private String fecha;

    public Empleado() {
    }

    public Empleado(long codigo, String nombre, long salario, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.fecha = fecha;
    }

    public void grabarEmpleado(DataOutputStream d) throws IOException {
        d.writeLong(codigo);
        d.writeUTF(nombre);
        d.writeLong(salario);
        d.writeUTF(fecha);
    }

    public void leerEmpleado(DataInputStream d) throws IOException {
        codigo = d.readLong();
        nombre = d.readUTF();
        salario = d.readLong();
        fecha = d.readUTF();
    }

    public void mostrarEmpleado() {
        System.out.println("=== Empleado ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Fecha: " + fecha);
        System.out.println();
    }
}