package RA6.Ejercicio3;

import java.io.Serializable;

import lombok.Data;

@Data
public class Vendedor implements Serializable {
    private int numeroEmpleado;
    private String nombre;
    private int edad;
    private int numeroOficina;
    private String oficio;
    private String fechaContrato;
    private int numeroDirector;
    private double cuota;
    private double ventas;

    public Vendedor() {
    }

    public Vendedor(int numeroEmpleado, String nombre, int edad, int numeroOficina, String oficio,
                    String fechaContrato, int numeroDirector, double cuota, double ventas) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.numeroOficina = numeroOficina;
        this.oficio = oficio;
        this.fechaContrato = fechaContrato;
        this.numeroDirector = numeroDirector;
        this.cuota = cuota;
        this.ventas = ventas;
    }
}