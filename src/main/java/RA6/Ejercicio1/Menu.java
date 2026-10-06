package RA6.Ejercicio1;

import java.util.Scanner;

public class Menu {
    private GestorDatos gestorDatos;

    public Menu(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Listar Productos");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Agregar Producto");
            System.out.println("5. Producto con precio más alto");
            System.out.println("6. Cliente con el nombre más largo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> listarClientes();
                case 2 -> listarProductos();
                case 3 -> agregarCliente(scanner);
                case 4 -> agregarProducto(scanner);
                case 5 -> productoPrecioMasAlto();
                case 6 -> clienteNombreMasLargo();
                case 7 -> System.out.println("Fin!");
                default -> System.out.println("Opción errónea, intente de nuevo.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    private void listarClientes() {
        for (Cliente cliente : gestorDatos.obtenerClientes()) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() +
                    ", Correo: " + cliente.getCorreo() + ", Teléfono: " + cliente.getTelefono());
        }
    }

    private void listarProductos() {
        for (Producto producto : gestorDatos.obtenerProductos()) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() +
                    ", Precio: " + producto.getPrecio());
        }
    }

    private void agregarCliente(Scanner scanner) {
        int id;
        String nombre, correo, telefono;

        System.out.print("Ingrese el ID del cliente: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del cliente: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese el correo del cliente: ");
        correo = scanner.nextLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        telefono = scanner.nextLine();

        gestorDatos.agregarCliente(new Cliente(id, nombre, correo, telefono));
    }

    private void agregarProducto(Scanner scanner) {
        int id;
        String nombre;
        double precio;

        System.out.println("Ingrese el ID del producto: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del producto: ");
        nombre = scanner.nextLine();

        System.out.println("Ingrese el precio del producto: ");
        precio = scanner.nextDouble();
        scanner.nextLine();

        gestorDatos.agregarProducto(new Producto(id, nombre, precio));
    }

    private void productoPrecioMasAlto() {
        Producto productoMasCaro = null;
        for (Producto producto : gestorDatos.obtenerProductos()) {
            if (productoMasCaro == null || producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        if (productoMasCaro != null) {
            System.out.println("Producto con precio más alto: " + productoMasCaro.getNombre() + " - $" + productoMasCaro.getPrecio());
        } else {
            System.out.println("No hay productos disponibles.");
        }
    }

    private void clienteNombreMasLargo() {
        Cliente clienteConNombreMasLargo = null;
        for (Cliente cliente : gestorDatos.obtenerClientes()) {
            if (clienteConNombreMasLargo == null || cliente.getNombre().length() > clienteConNombreMasLargo.getNombre().length()) { // || esto es un OR
                clienteConNombreMasLargo = cliente;
            }
        }
        if (clienteConNombreMasLargo != null) {
            System.out.println("Cliente con nombre más largo: " + clienteConNombreMasLargo.getNombre());
        } else {
            System.out.println("No hay clientes disponibles.");
        }
    }
}