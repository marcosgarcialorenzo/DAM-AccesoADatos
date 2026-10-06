package RA6.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Cliente> clientes;
    private List<Producto> productos;

    public GestorDatos() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
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
    }

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
}