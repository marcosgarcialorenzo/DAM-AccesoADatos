package RA6.Ejercicio3;

import java.util.Scanner;

public class Menu {

    private OperacionesCRUD crud;

    public Menu(OperacionesCRUD crud) {
        this.crud = crud;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========= MENÚ PRINCIPAL =========");
            System.out.println("1. Listar oficinas");
            System.out.println("2. Insertar oficina");
            System.out.println("3. Borrar oficina");
            System.out.println("4. Buscar oficina");

            System.out.println("5. Listar vendedores");
            System.out.println("6. Insertar vendedor");
            System.out.println("7. Borrar vendedor");
            System.out.println("8. Buscar vendedor");

            System.out.println("9. Listar clientes");
            System.out.println("10. Insertar cliente");
            System.out.println("11. Borrar cliente");
            System.out.println("12. Buscar cliente");

            System.out.println("13. Listar productos");
            System.out.println("14. Insertar producto");
            System.out.println("15. Borrar producto");
            System.out.println("16. Buscar producto");

            System.out.println("17. Listar pedidos");
            System.out.println("18. Insertar pedido");
            System.out.println("19. Borrar pedido");
            System.out.println("20. Buscar pedido");

            System.out.println("21. Mostrar todas las oficinas juntos con sus vendedores y clientes");
            System.out.println("22. Mostrar el Vendedor que tiene MÁS ventas");
            System.out.println("23. Mostrar el Cliente que tenga MAYOR crédito");
            System.out.println("24. Mostrar el Producto que tenga el MENOR stock");

            System.out.println("25. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> listarOficinas();
                case 2 -> insertarOficina(sc);
                case 3 -> borrarOficina(sc);
                case 4 -> buscarOficina(sc);

                case 5 -> listarVendedores();
                case 6 -> insertarVendedor(sc);
                case 7 -> borrarVendedor(sc);
                case 8 -> buscarVendedor(sc);

                case 9 -> listarClientes();
                case 10 -> insertarCliente(sc);
                case 11 -> borrarCliente(sc);
                case 12 -> buscarCliente(sc);

                case 13 -> listarProductos();
                case 14 -> insertarProducto(sc);
                case 15 -> borrarProducto(sc);
                case 16 -> buscarProducto(sc);

                case 17 -> listarPedidos();
                case 18 -> insertarPedido(sc);
                case 19 -> borrarPedido(sc);
                case 20 -> buscarPedido(sc);

                case 21 -> relacionOficinaVendedorCliente();
                case 22 -> vendedorMasVentas();
                case 23 -> clienteMayorCredito();
                case 24 -> productoMenorStock();

                case 25 -> System.out.println("FIN DEL PROGRAMA");
                default -> System.out.println("Opción incorrecta.");
            }

        } while (opcion != 25);
    }

    private void listarOficinas() {
        var lista = crud.listarOficinas();
        if (lista.isEmpty()) System.out.println("NO HAY OFICINAS");
        else
            lista.forEach(o -> System.out.println(o.getNumeroOficina() + " " + o.getCiudad() + " " + o.getRegion() + " " + o.getNumeroDirector() + " " + o.getObjetivo() + " " + o.getVentas()));
    }

    private void insertarOficina(Scanner sc) {
        System.out.print("Número oficina: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Ciudad: ");
        String c = sc.nextLine();
        System.out.print("Región: ");
        String r = sc.nextLine();
        System.out.print("Número director: ");
        int d = sc.nextInt();
        System.out.print("Objetivo: ");
        double o = sc.nextDouble();
        System.out.print("Ventas: ");
        double v = sc.nextDouble();

        if (crud.insertarOficina(new Oficina(n, c, r, d, o, v))) System.out.println("INSERTADO");
        else System.out.println("NO SE PUEDE INSERTAR (YA EXISTE)");
    }

    private void borrarOficina(Scanner sc) {
        int numeroOficina;
        System.out.println("Introduce el número de oficina a borrar: ");
        numeroOficina = sc.nextInt();
        if (crud.borrarOficina(numeroOficina)) {
            System.out.println("Oficina " + numeroOficina + " borrada correctamente.");
        } else {
            System.err.println("NO SE PUEDE BORRAR (NO EXISTE)");
        }
    }

    private void buscarOficina(Scanner sc) {
        int numeroOficina;
        System.out.println("Introduce el número de oficina a buscar: ");
        numeroOficina = sc.nextInt();
        Oficina oficina = crud.buscarOficina(numeroOficina);
        if (oficina != null) {
            System.out.println("Oficina encontrada: " + oficina.getNumeroOficina() + " " + oficina.getCiudad() + " " + oficina.getRegion() + " " + oficina.getNumeroDirector() + " " + oficina.getObjetivo() + " " + oficina.getVentas());
        } else {
            System.err.println("NO SE PUEDE BUSCAR (NO EXISTE)");
        }
    }

    private void listarVendedores() {
        var lista = crud.listarVendedores();
        if (lista.isEmpty()) System.out.println("NO HAY VENDEDORES");
        else lista.forEach(v -> System.out.println(v.getNumeroEmpleado() + " " + v.getNombre() + " " + v.getVentas()));
    }

    private void insertarVendedor(Scanner sc) {
        System.out.print("Número empleado: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Número oficina: ");
        int no = sc.nextInt();
        sc.nextLine();
        System.out.print("Oficio: ");
        String oficio = sc.nextLine();
        System.out.print("Fecha contrato: ");
        String fecha = sc.nextLine();
        System.out.print("Número director: ");
        int nd = sc.nextInt();
        System.out.print("Cuota: ");
        double cuota = sc.nextDouble();
        System.out.print("Ventas: ");
        double ventas = sc.nextDouble();

        if (crud.insertarVendedor(new Vendedor(n, nombre, edad, no, oficio, fecha, nd, cuota, ventas)))
            System.out.println("INSERTADO");
        else System.out.println("NO SE PUEDE INSERTAR");
    }

    private void borrarVendedor(Scanner sc) {
        int numeroEmpleado;
        System.out.println("Introduce el número de empleado a borrar: ");
        numeroEmpleado = sc.nextInt();
        if (crud.borrarVendedor(numeroEmpleado)) {
            System.out.println("Vendedor " + numeroEmpleado + " borrado correctamente.");
        } else {
            System.err.println("NO SE PUEDE BORRAR (NO EXISTE)");
        }
    }

    private void buscarVendedor(Scanner sc) {
        int numeroEmpleado;
        System.out.println("Introduce el número de empleado a buscar: ");
        numeroEmpleado = sc.nextInt();
        Vendedor vendedor = crud.buscarVendedor(numeroEmpleado);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado: " + vendedor.getNumeroEmpleado() + " " + vendedor.getNombre() + " " + vendedor.getVentas());
        } else {
            System.err.println("NO SE PUEDE BUSCAR (NO EXISTE)");
        }

    }

    private void listarClientes() {
        var lista = crud.listarClientes();
        if (lista.isEmpty()) System.out.println("NO HAY CLIENTES");
        else
            lista.forEach(c -> System.out.println(c.getNumeroCliente() + " " + c.getEmpresa() + " " + c.getLimiteCredito()));
    }

    private void insertarCliente(Scanner sc) {
        System.out.print("Número cliente: ");
        int nc = sc.nextInt();
        sc.nextLine();
        System.out.print("Empresa: ");
        String emp = sc.nextLine();
        System.out.print("Número empleado: ");
        int ne = sc.nextInt();
        System.out.print("Límite crédito: ");
        double lim = sc.nextDouble();

        if (crud.insertarCliente(new Cliente(nc, emp, ne, lim))) System.out.println("INSERTADO");
        else System.out.println("NO SE PUEDE INSERTAR");
    }

    private void borrarCliente(Scanner sc) {
        int numeroCliente;
        System.out.println("Introduce el número de cliente a borrar: ");
        numeroCliente = sc.nextInt();
        if (crud.borrarCliente(numeroCliente)) {
            System.out.println("Cliente " + numeroCliente + " borrado correctamente.");
        } else {
            System.err.println("NO SE PUEDE BORRAR (NO EXISTE)");
        }
    }

    private void buscarCliente(Scanner sc) {
        int numeroCliente;
        System.out.println("Introduce el número de cliente a buscar: ");
        numeroCliente = sc.nextInt();
        Cliente cliente = crud.buscarCliente(numeroCliente);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNumeroCliente() + " " + cliente.getEmpresa() + " " + cliente.getLimiteCredito());
        } else {
            System.err.println("NO SE PUEDE BUSCAR (NO EXISTE)");
        }
    }

    private void listarProductos() {
        var lista = crud.listarProductos();
        if (lista.isEmpty()) System.out.println("NO HAY PRODUCTOS");
        else
            lista.forEach(p -> System.out.println(p.getCodigoProducto() + " " + p.getDescripcion() + " " + p.getExistencias()));
    }

    private void insertarProducto(Scanner sc) {
        sc.nextLine();
        System.out.print("Código fábrica: ");
        String cf = sc.nextLine();
        System.out.print("Código producto: ");
        String cp = sc.nextLine();
        System.out.print("Descripción: ");
        String des = sc.nextLine();
        System.out.print("Precio: ");
        double pr = sc.nextDouble();
        System.out.print("Existencias: ");
        int ex = sc.nextInt();

        if (crud.insertarProducto(new Producto(cf, cp, des, pr, ex))) System.out.println("INSERTADO");
        else System.out.println("NO SE PUEDE INSERTAR");
    }

    private void borrarProducto(Scanner sc) {
        String codigoProducto;
        System.out.print("Código producto: ");
        codigoProducto = sc.nextLine();
        if (crud.borrarProducto(codigoProducto)) {
            System.out.println("Producto " + codigoProducto + " borrado correctamente.");
        } else {
            System.err.println("NO SE PUEDE BORRAR (NO EXISTE)");
        }
    }

    private void buscarProducto(Scanner sc) {
        String codigoProducto;
        System.out.print("Introduzca el código del producto: ");
        codigoProducto = sc.nextLine();
        Producto producto = crud.buscarProducto(codigoProducto);
        if (crud.buscarProducto(codigoProducto) != null) {
            System.out.println("Producto encontrado: " + producto.getCodigoProducto() + " " + producto.getDescripcion() + " " + producto.getExistencias());
        } else {
            System.err.println("NO SE PUEDE BUSCAR (NO EXISTE)");
        }
    }

    private void listarPedidos() {
        var lista = crud.listarPedidos();
        if (lista.isEmpty()) System.out.println("NO HAY PEDIDOS");
        else
            lista.forEach(p -> System.out.println(p.getNumeroPedido() + " " + p.getFechaPedido() + " " + p.getImporte()));
    }

    private void insertarPedido(Scanner sc) {
        System.out.print("Número pedido: ");
        int np = sc.nextInt();
        sc.nextLine();

        System.out.print("Fecha pedido: ");
        String fp = sc.nextLine();

        System.out.print("Número cliente: ");
        int nc = sc.nextInt();

        System.out.print("Número empleado: ");
        int ne = sc.nextInt();
        sc.nextLine();

        System.out.print("Código fábrica: ");
        String cf = sc.nextLine();

        System.out.print("Código producto: ");
        String cp = sc.nextLine();

        System.out.print("Cantidad: ");
        int cant = sc.nextInt();

        System.out.print("Importe: ");
        double imp = sc.nextDouble();

        if (crud.insertarPedido(new Pedido(np, fp, nc, ne, cf, cp, cant, imp))) System.out.println("INSERTADO");
        else System.out.println("NO SE PUEDE INSERTAR");
    }

    private void borrarPedido(Scanner sc) {
        int numeroPedido;
        System.out.print("Introduzca el número del pedido a borrar: ");
        numeroPedido = sc.nextInt();
        if (crud.borrarPedido(numeroPedido)) {
            System.out.println("Pedido " + numeroPedido + " borrado correctamente.");
        } else {
            System.err.println("NO SE PUEDE BORRAR (NO EXISTE)");
        }
    }

    private void buscarPedido(Scanner sc) {
        int numeroPedido;
        System.out.print("Introduzca el número del pedido a buscar: ");
        numeroPedido = sc.nextInt();
        Pedido pedido = crud.buscarPedido(numeroPedido);
        if (pedido != null) {
            System.out.println("Pedido encontrado: " + pedido.getNumeroPedido() + " " + pedido.getFechaPedido() + " " + pedido.getImporte());
        } else {
            System.err.println("NO SE PUEDE BUSCAR (NO EXISTE)");
        }
    }

    private void relacionOficinaVendedorCliente() { //21. Mostrar todas las oficinas juntos con sus vendedores y clientes;
        String resultado = crud.MostrarOficinasVendedoresClientes();
        if (resultado.isEmpty()) {
            System.out.println("NO HAY OFICINAS");
        } else {
            System.out.println(resultado);
        }
    }

    private void vendedorMasVentas() { //("22. Mostrar el Vendedor que tiene MÁS ventas");
        Vendedor vendedor = crud.MostrarVendedorConMasVentas();
        if (vendedor != null) {
            System.out.println("Vendedor con más ventas es: " + vendedor.getNombre() + " con " + vendedor.getVentas());
        } else {
            System.err.println("NO HAY VENDEDORES");
        }
    }

    private void clienteMayorCredito() { //("23. Mostrar el Cliente que tenga MAYOR crédito");
        Cliente cliente = crud.MostrarClienteconMayorCredito();
        if (cliente != null) {
            System.out.println("Cliente con mayor crédito es: " + cliente.getEmpresa() + " con " + cliente.getLimiteCredito());
        } else {
            System.err.println("NO HAY CLIENTES");
        }
    }

    private void productoMenorStock() { // ("24. Mostrar el Producto que tenga el MENOR stock");
        Producto producto = crud.MostrarProductoconMenorStock();
        if (producto != null) {
            System.out.println("Producto con menor stock es: " + producto.getDescripcion() + " con " + producto.getExistencias());
        } else {
            System.err.println("NO HAY PRODUCTOS");
        }
    }
}
