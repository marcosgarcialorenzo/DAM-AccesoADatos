package RA6.Ejercicio3;

import java.io.Serializable;

import lombok.Data;

@Data
public class Oficina implements Serializable {
    private int numeroOficina;
    private String ciudad;
    private String region;
    private int numeroDirector;
    private double objetivo;
    private double ventas;

    public Oficina() {
    }

    public Oficina(int numeroOficina, String ciudad, String region, int numeroDirector, double objetivo, double ventas) {
        this.numeroOficina = numeroOficina;
        this.ciudad = ciudad;
        this.region = region;
        this.numeroDirector = numeroDirector;
        this.objetivo = objetivo;
        this.ventas = ventas;
    }
}