package RA6.Ejercicio3;

import java.io.Serializable;

import lombok.Data;

@Data
public class Pedido implements Serializable {
    private int numeroPedido;
    private String fechaPedido;
    private int numeroCliente;
    private int numeroEmpleado;
    private String codigoFabrica;
    private String codigoProducto;
    private int cantidad;
    private double importe;

    public Pedido() {
    }

    public Pedido(int numeroPedido, String fechaPedido, int numeroCliente,
                  int numeroEmpleado, String codigoFabrica, String codigoProducto,
                  int cantidad, double importe) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.numeroCliente = numeroCliente;
        this.numeroEmpleado = numeroEmpleado;
        this.codigoFabrica = codigoFabrica;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.importe = importe;
    }
}