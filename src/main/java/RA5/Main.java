
package RA5;

import java.util.Scanner;

import org.w3c.dom.NodeList;

import java.util.Scanner;

import org.w3c.dom.NodeList;

import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.xpath.XPathFactoryImpl;


public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Consultas de productos");
            System.out.println("2. Consultas de sucursales");
            System.out.println("3. Consultas de clínicas/hospitales");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuSucursales();
                    break;
                case 3:
                    // menuClinicas();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero() {
        while (! sc.hasNextInt()) {
            System.out.print("Introduce un número válido: ");
            sc.next();
        }

        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    // ==================================================
    // 1. CONSULTAS DE PRODUCTOS
    // ==================================================

    private static void menuProductos() {

        ConsultasProductos cp = new ConsultasProductos();
        String archivoXML = "D:\\USERS_NO_BORRAR\\marcos.garcia222\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA5\\productos.xml";
        int opcion;
        do {
            System.out.println("\n===== CONSULTAS DE PRODUCTOS =====");
            System.out.println("1. Mostrar productos que sean placas base");
            System.out.println("2. Contar memorias de la zona 10");
            System.out.println("3. Mostrar denominación y precio de todos");
            System.out.println("4. Productos con precio > 60 y zona 20");
            System.out.println("5. Calcular la media del precio de los micros");
            System.out.println("6. Productos cuyo stock mínimo > stock actual");
            System.out.println("7. Denominación y precio: falta de stock en zona 40");
            System.out.println("8. Mostrar el producto más caro");
            System.out.println("9. Mostrar el producto más barato de zona 20");
            System.out.println("10. Mostrar el producto más caro de zona 10");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    cp.imprimirProductos(cp.mostrarProductosPlacaBase(archivoXML));
                    break;

                case 2:
                    System.out.println("Número de memorias: " + cp.contarMemoriasZona10(archivoXML));
                    break;

                case 3:
                    cp.imprimirProductos(cp.mostrarDenominacionYPrecio(archivoXML));
                    break;

                case 4:
                    cp.imprimirProductos(cp.mostrarProductosPrecioMayor60Zona20(archivoXML));
                    break;

                case 5:
                    System.out.println("Media del precio de los micros: " + cp.calcularMediaPrecioMicros(archivoXML) + " euros");
                    break;

                case 6:
                    cp.imprimirProductos(cp.mostrarProductosConFaltaDeStock(archivoXML));
                    break;

                case 7:
                    cp.imprimirDenominacionYPrecio(cp.mostrarProductosZona40ConFaltaDeStock(archivoXML));
                    break;

                case 8:
                    cp.imprimirProductos(cp.mostrarProductoMasCaro(archivoXML));
                    break;

                case 9:
                    cp.imprimirProductos(cp.mostrarProductoMasBaratoZona20(archivoXML));
                    break;

                case 10:
                    cp.imprimirProductos(cp.mostrarProductoMasCaroZona10(archivoXML));
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    // ==================================================
    // 2. CONSULTAS DE SUCURSALES
    // ==================================================

    private static void menuSucursales() {

        ConsultasSucursales cs = new ConsultasSucursales();
        String archivo = "D:\\USERS_NO_BORRAR\\marcos.garcia222\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA5\\sucursales.xml";

        int opcion;

        do {
            System.out.println("\n===== CONSULTAS DE SUCURSALES =====");
            System.out.println("1. Mostrar cuentas de tipo AHORRO");
            System.out.println("2. Código y número de cuentas AHORRO por sucursal");
            System.out.println("3. Cuentas PENSIONES de la sucursal SUC3");
            System.out.println("4. Código, director y saldo haber total por sucursal");
            System.out.println("5. Sucursales con más de 3 cuentas");
            System.out.println("6. Sucursales con más de 3 cuentas AHORRO");
            System.out.println("7. Director y población de sucursales con más de 3 cuentas");
            System.out.println("8. Contar sucursales cuya población sea Madrid");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    cs.imprimirNodos(cs.mostrarCuentasAhorro(archivo));
                    break;

                case 2:
                    cs.mostrarNumeroCuentasAhorroPorSucursal(archivo);
                    break;

               case 3:
                    cs.imprimirNodos(cs.mostrarCuentasPensionesSUC3(archivo));
                    break;

                case 4:
                    cs.mostrarSaldoTotalPorSucursal(archivo);
                    break;

                case 5:
                    cs.imprimirNodos(cs.mostrarSucursalesMasDe3Cuentas(archivo));
                    break;

                case 6:
                    cs.imprimirNodos(cs.mostrarSucursalesMasDe3CuentasAhorro(archivo));
                    break;

                case 7:
                    cs.imprimirNodos(cs.mostrarDirectorYPoblacionMasDe3Cuentas(archivo));
                    break;

                /*case 8:
                    System.out.println("Sucursales de Madrid: " + cs.contarSucursalesMadrid(archivo));
                    break;*/

                case 0:
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ==================================================
    // 3. CONSULTAS XQUERY DE HOSPITALES Y MÉDICOS
    // ==================================================

    /*private static void menuClinicas() {

        ConsultasXquerys cx = new ConsultasXquerys();

        String archivoHospitales = "C:/ejercicios/Hospitales.xml";
        String archivoMedicos = "C:/ejercicios/Medicos.xml";

        int opcion;

        do {
            System.out.println("\n===== CONSULTAS DE CLÍNICAS/HOSPITALES =====");
            System.out.println("1. Listar todos los hospitales");
            System.out.println("2. Hospitales de Madrid");
            System.out.println("3. Direcciones de todos los hospitales");
            System.out.println("4. Teléfono del hospital H3");
            System.out.println("5. Hospitales con más de un teléfono");
            System.out.println("6. Hospitales ordenados por nombre");
            System.out.println("7. Nombre y ciudad de los hospitales");
            System.out.println("8. Médicos de Fundación Jimenez Diaz");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            String xquery = null;
            String archivo = archivoHospitales;

            switch (opcion) {
                case 1:
                    xquery = cx.consulta1();
                    break;

                case 2:
                    xquery = cx.consulta2();
                    break;

                case 3:
                    xquery = cx.consulta3();
                    break;

                case 4:
                    xquery = cx.consulta4();
                    break;

                case 5:
                    xquery = cx.consulta5();
                    break;

                case 6:
                    xquery = cx.consulta6();
                    break;

                case 7:
                    xquery = cx.consulta7();
                    break;

                case 8:
                    xquery = cx.consulta8();
                    archivo = archivoMedicos;
                    break;

                case 0:
                    continue;

                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            try {
                XdmValue resultado =
                        Operaciones.ejecutarConsulta(xquery, archivo);

                if (resultado.size() == 0) {
                    System.out.println("No se encontraron resultados.");
                } else {
                    for (XdmItem item : resultado) {
                        System.out.println(item);
                    }
                }

            } catch (SaxonApiException e) {
                System.out.println("Error al ejecutar la consulta XQuery.");
                e.printStackTrace();
            }

        } while (opcion != 0);
    }*/
}