package RA6.Ejercicio2;

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
            System.out.println("7. Listar Pedidos");
            System.out.println("8. Agregar Pedido");
            System.out.println("9. Listar Pedidos por Cliente");
            System.out.println("10. Listar Pedidos con detalles de Cliente y Producto");
            System.out.println("0. Salir");
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
                case 7 -> listarPedidos();
                case 8 -> agregarPedido(scanner);
                case 9 -> listarPedidosPorCliente(scanner);
                case 10 -> listarPedidosConDetalles(scanner);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción errónea, intente de nuevo.");
            }

        } while (opcion != 0);

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

    public void listarPedidos() {
        for (Pedido pedido : gestorDatos.obtenerPedidos()) {
            System.out.println("ID: " + pedido.getId() + ", Descripción: " + pedido.getDescripcion() +
                    ", Cantidad: " + pedido.getCantidad() + ", ID Cliente: " + pedido.getIdCliente() +
                    ", ID Producto: " + pedido.getIdProducto());
        }
    }

    private void agregarPedido(Scanner scanner) {
        int id, cantidad, idCliente, idProducto;
        String descripcion;

        System.out.print("Ingrese el ID del pedido: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la descripción del pedido: ");
        descripcion = scanner.nextLine();

        System.out.print("Ingrese la cantidad del pedido: ");
        cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID del cliente: ");
        idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID del producto: ");
        idProducto = scanner.nextInt();
        scanner.nextLine();

        gestorDatos.agregarPedido(new Pedido(id, descripcion, cantidad, idCliente, idProducto));
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

    private void listarPedidosPorCliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Pedido pedido : gestorDatos.obtenerPedidos()) {
            if (pedido.getIdCliente() == idCliente) {
                System.out.println("Pedido ID: " + pedido.getId() + ", Nombre: " + pedido.getDescripcion() +
                        ", Cantidad: " + pedido.getCantidad());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron pedidos para el cliente con ID " + idCliente);
        }
    }

    private void listarPedidosConDetalles(Scanner scanner) {
        String nombreCliente, nombreProducto;
        for (Pedido pedido : gestorDatos.obtenerPedidos()) {
            nombreCliente = gestorDatos.obtenerNombreCliente(pedido.getIdCliente());
            nombreProducto = gestorDatos.obtenerNombreProducto(pedido.getIdProducto());
            System.out.println("Pedido ID: " + pedido.getId() + ", Nombre pedido: " + pedido.getDescripcion() +
                    ", Cantidad: " + pedido.getCantidad() + ", Cliente: " + nombreCliente +
                    ", Producto: " + nombreProducto);
        }
    }
}