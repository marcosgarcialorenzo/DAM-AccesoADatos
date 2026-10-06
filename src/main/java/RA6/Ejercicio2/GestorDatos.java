package RA6.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Producto> productos;

    public GestorDatos() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        clientes.add(new Cliente(1, "Carlos Pérez", "carlos@mail.com", "600123123"));
        clientes.add(new Cliente(2, "Ana María", "ana@mail.com", "600987987"));
        clientes.add(new Cliente(3, "Maximiliano Fernández", "maxi@mail.com", "611222333"));
        clientes.add(new Cliente(4, "Lucía Gómez", "lucia@mail.com", "612345678"));
        clientes.add(new Cliente(5, "Jorge Ramírez", "jorge@mail.com", "623456789"));
        clientes.add(new Cliente(6, "Beatriz López", "bea@mail.com", "634567890"));
        clientes.add(new Cliente(7, "Santiago Torres", "santi@mail.com", "645678901"));
        clientes.add(new Cliente(8, "Marina Ortiz", "marina@mail.com", "656789012"));
        clientes.add(new Cliente(9, "Felipe Díaz", "felipe@mail.com", "667890123"));
        clientes.add(new Cliente(10, "Valeria Martínez", "valeria@mail.com", "678901234"));

        productos.add(new Producto(1, "Ratón inalámbrico", 19.99));
        productos.add(new Producto(2, "Teclado mecánico", 49.90));
        productos.add(new Producto(3, "Monitor 27 pulgadas", 199.99));
        productos.add(new Producto(4, "Auriculares Bluetooth", 29.99));
        productos.add(new Producto(5, "Webcam Full HD", 39.95));
        productos.add(new Producto(6, "Silla ergonómica", 149.99));
        productos.add(new Producto(7, "Disco SSD 1TB", 89.90));
        productos.add(new Producto(8, "Impresora multifunción", 129.50));
        productos.add(new Producto(9, "Alfombrilla gaming", 12.99));
        productos.add(new Producto(10, "Hub USB 3.0", 17.49));

        pedidos.add(new Pedido(1, "Pedido ratón para Carlos", 2, 1, 1));
        pedidos.add(new Pedido(2, "Teclado mecánico para Ana", 1, 2, 2));
        pedidos.add(new Pedido(3, "Monitor para Maximiliano", 1, 3, 3));
        pedidos.add(new Pedido(4, "Auriculares para Lucía", 3, 4, 4));
        pedidos.add(new Pedido(5, "Webcam para Jorge", 1, 5, 5));
        pedidos.add(new Pedido(6, "Silla ergonómica para Beatriz", 1, 6, 6));
        pedidos.add(new Pedido(7, "SSD para Santiago", 2, 7, 7));
        pedidos.add(new Pedido(8, "Impresora para Marina", 1, 8, 8));
        pedidos.add(new Pedido(9, "Alfombrilla para Felipe", 4, 9, 9));
        pedidos.add(new Pedido(10, "Hub USB para Valeria", 2, 10, 10));
    }

    // CLIENTES

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public boolean agregarCliente(Cliente cliente) {
        if (!existeCliente(cliente.getId())) {
            clientes.add(cliente);
            return true;
        } else {
            System.err.println("Error: Ya existe un cliente con el ID " + cliente.getId());
            return false;
        }
    }

    private boolean existeCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //PRODUCTOS

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public boolean agregarProducto(Producto producto) {
        if (!existeProducto(producto.getId())) {
            productos.add(producto);
            return true;
        } else {
            System.err.println("Error: Ya existe un producto con el ID " + producto.getId());
            return false;
        }
    }

    private boolean existeProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // PEDIDOS

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    public boolean agregarPedido(Pedido pedido) {
        if (!existePedido(pedido.getId())) {
            pedidos.add(pedido);
            return true;
        } else {
            System.err.println("Error: Ya existe un pedido con el ID " + pedido.getId());
            return false;
        }
    }

    private boolean existePedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    String obtenerNombreCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                return cliente.getNombre();
            }
        }
        return null;
    }

    String obtenerNombreProducto(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == idProducto) {
                return producto.getNombre();
            }
        }
        return null;
    }
}