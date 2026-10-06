package RA6.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUD {

    private List<Oficina> oficinas;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Pedido> pedidos;

    public OperacionesCRUD() {
        oficinas = new ArrayList<>();
        vendedores = new ArrayList<>();
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();

        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {

        oficinas.add(new Oficina(11, "MADRID", "Este", 106, 575000, 696637));
        oficinas.add(new Oficina(12, "BARCELONA", "Noreste", 107, 620000, 710000));
        oficinas.add(new Oficina(13, "VALENCIA", "Este", 108, 410000, 500000));
        oficinas.add(new Oficina(14, "SEVILLA", "Sur", 109, 385000, 450000));
        oficinas.add(new Oficina(15, "BILBAO", "Norte", 110, 290000, 360000));

        vendedores.add(new Vendedor(105, "Luis Perez", 37, 13, "RepVentas", "12/02/98", 104, 350000, 367911));
        vendedores.add(new Vendedor(106, "Ana Gomez", 42, 11, "RepVentas", "03/05/00", 105, 420000, 430500));
        vendedores.add(new Vendedor(107, "Carlos Ruiz", 29, 12, "RepVentas", "21/09/01", 105, 300000, 310200));
        vendedores.add(new Vendedor(108, "Marta Lopez", 34, 13, "RepVentas", "14/11/99", 106, 280000, 295000));
        vendedores.add(new Vendedor(109, "Javier Martín", 45, 14, "RepVentas", "08/01/95", 106, 390000, 402300));

        clientes.add(new Cliente(2111, "Control S.L", 103, 50000));
        clientes.add(new Cliente(2112, "Tecnored S.A", 105, 75000));
        clientes.add(new Cliente(2113, "InnovaSoft", 106, 60000));
        clientes.add(new Cliente(2114, "Alfa Sistemas", 107, 45000));
        clientes.add(new Cliente(2115, "Beta Solutions", 108, 82000));
        clientes.add(new Cliente(2116, "LogiData", 109, 30000));
        clientes.add(new Cliente(2117, "MacroTech", 105, 92000));
        clientes.add(new Cliente(2118, "Red Global", 106, 51000));
        clientes.add(new Cliente(2119, "DeltaCorp", 107, 67000));

        productos.add(new Producto("REI", "2A45C", "UniónTrinquete", 79, 210));
        productos.add(new Producto("ACI", "3B10X", "SoporteMetal", 120, 150));
        productos.add(new Producto("QSA", "1C22M", "MotorLineal", 560, 80));
        productos.add(new Producto("REI", "4D55P", "PiezaAjuste", 45, 400));
        productos.add(new Producto("ACI", "9Z90R", "Rodamiento", 30, 1000));

        pedidos.add(new Pedido(2961, "17/12/03", 2117, 106, "REI", "2A44R", 7, 31500));
        pedidos.add(new Pedido(2962, "20/12/03", 2112, 105, "ACI", "3B10X", 10, 12000));
        pedidos.add(new Pedido(2963, "05/01/04", 2114, 107, "QSA", "1C22M", 2, 1120));
        pedidos.add(new Pedido(2964, "10/01/04", 2118, 108, "REI", "4D55P", 20, 900));
        pedidos.add(new Pedido(2965, "15/01/04", 2115, 109, "ACI", "9Z90R", 50, 1500));
    }

    public boolean insertarOficina(Oficina o) {
        for (Oficina of : oficinas) {
            if (of.getNumeroOficina() == o.getNumeroOficina()) return false;
        }
        oficinas.add(o);
        return true;
    }

    public List<Oficina> listarOficinas() {
        return oficinas;
    }

    public boolean borrarOficina(int id) {
        for (Oficina o : oficinas) {
            if (o.getNumeroOficina() == id) {
                oficinas.remove(o);
                return true;
            }
        }
        return false;
    }

    public Oficina buscarOficina(int id) {
        for (Oficina o : oficinas) {
            if (o.getNumeroOficina() == id) {
                return o;
            }
        }
        return null;
    }


    public boolean insertarVendedor(Vendedor v) {
        for (Vendedor ve : vendedores) {
            if (ve.getNumeroEmpleado() == v.getNumeroEmpleado()) return false;
        }
        vendedores.add(v);
        return true;
    }

    public List<Vendedor> listarVendedores() {
        return vendedores;
    }

    public boolean borrarVendedor(int id) {
        for (Vendedor v : vendedores) {
            if (v.getNumeroEmpleado() == id) {
                vendedores.remove(v);
                return true;
            }
        }
        return false;
    }

    public Vendedor buscarVendedor(int id) {
        for (Vendedor v : vendedores) {
            if (v.getNumeroEmpleado() == id) {
                return v;
            }
        }
        return null;
    }

    public boolean insertarCliente(Cliente c) {
        for (Cliente cl : clientes) {
            if (cl.getNumeroCliente() == c.getNumeroCliente()) return false;
        }
        clientes.add(c);
        return true;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public boolean borrarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getNumeroCliente() == id) {
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getNumeroCliente() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean insertarProducto(Producto p) {
        for (Producto pr : productos) {
            if (pr.getCodigoProducto().equalsIgnoreCase(p.getCodigoProducto())) return false;
        }
        productos.add(p);
        return true;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public boolean borrarProducto(String cod) {
        for (Producto p : productos) {
            if (p.getCodigoProducto().equalsIgnoreCase(cod)) {
                productos.remove(p);
                return true;
            }
        }
        return false;
    }

    public Producto buscarProducto(String cod) {
        for (Producto p : productos) {
            if (p.getCodigoProducto().equalsIgnoreCase(cod)) {
                return p;
            }
        }
        return null;
    }

    public boolean insertarPedido(Pedido p) {
        for (Pedido pe : pedidos) {
            if (pe.getNumeroPedido() == p.getNumeroPedido()) return false;
        }
        pedidos.add(p);
        return true;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public boolean borrarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getNumeroPedido() == id) {
                pedidos.remove(p);
                return true;
            }
        }
        return false;
    }

    public Pedido buscarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getNumeroPedido() == id) {
                return p;
            }
        }
        return null;
    }

    public String MostrarOficinasVendedoresClientes() {
        StringBuilder sb = new StringBuilder();
        for (Oficina oficina : oficinas) {
            sb.append("OFICINA ").append(oficina.getNumeroOficina()).append(" - ").append(oficina.getCiudad()).append(System.lineSeparator());
            boolean tieneVendedores = false;
            for (Vendedor vendedor : vendedores) {
                if (vendedor.getNumeroOficina() != oficina.getNumeroOficina()) {
                    continue; // para saltar a la siguiente iteración del bucle si el vendedor no pertenece a la oficina actual
                }
                tieneVendedores = true;
                sb.append("  Vendedor: ").append(vendedor.getNombre()).append(System.lineSeparator());
                boolean tieneClientes = false;
                for (Cliente cliente : clientes) {
                    if (cliente.getNumeroEmpleado() != vendedor.getNumeroEmpleado()) {
                        continue; // para saltar a la siguiente iteración del bucle si el cliente no pertenece al vendedor actual
                    }
                    tieneClientes = true;
                    sb.append("    Cliente: ").append(cliente.getEmpresa()).append(System.lineSeparator());
                }
                if (!tieneClientes) {
                    sb.append("    Sin clientes").append(System.lineSeparator());
                }
            }
            if (!tieneVendedores) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public Vendedor MostrarVendedorConMasVentas() {
        Vendedor max = vendedores.get(0); //también se puede poder .getFirst()
        for (Vendedor v : vendedores) {
            if (v.getVentas() > max.getVentas()) {
                max = v;
            }
        }
        return max;
    }

    public Cliente MostrarClienteconMayorCredito() {
        Cliente max = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.getLimiteCredito() > max.getLimiteCredito()) {
                max = c;
            }
        }
        return max;
    }

    public Producto MostrarProductoconMenorStock() {
        Producto min = productos.get(0);
        for (Producto p: productos) {
            if (p.getExistencias() < min.getExistencias()) {
                min = p;
            }
        }
        return min;
    }
}