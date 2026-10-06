package RA6.Ejercicio3;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cliente implements Serializable {
    private int numeroCliente;
    private String empresa;
    private int numeroEmpleado;
    private double limiteCredito;

    public Cliente() {
    }

    public Cliente(int numeroCliente, String empresa, int numeroEmpleado, double limiteCredito) {
        this.numeroCliente = numeroCliente;
        this.empresa = empresa;
        this.numeroEmpleado = numeroEmpleado;
        this.limiteCredito = limiteCredito;
    }
}