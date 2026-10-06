package RA6.Ejercicio2;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pedido {
    private int id;
    private String descripcion;
    private int cantidad;
    private int idCliente;
    private int idProducto;

    public Pedido() {
    }

    public Pedido(int id, String descripcion, int cantidad, int idCliente, int idProducto) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
    }

}