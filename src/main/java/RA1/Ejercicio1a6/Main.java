package RA1.Ejercicio1a6;

import RA1.Ejercicio2.OperacionesEjemplo;
import RA1.Ejercicio3.OperacionesBinarios;
import RA1.Ejercicio4.OperacionesDepartamentos;
import RA1.Ejercicio6.OperacionesXML;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n--- MENÚ OPERACIONES TEXTO ---");
            System.out.println("1. Ficheros de texto");
            System.out.println("2. Ficheros binarios");
            System.out.println("3. Ficheros binarios ");
            System.out.println("4. Ficheros binarios");
            System.out.println("5. Ficheros aleatorios");
            System.out.println("6. Ficheros aleatorios");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            if (!sc.hasNextInt()) {
                System.err.println("La opción debe ser un número entero.");
                sc.nextLine();
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: {
                    while (opcion != 14) {
                        System.out.println("\n--- MENÚ OPERACIONES TEXTO ---");
                        System.out.println("1. Información de fichero y listado de directorio");
                        System.out.println("2. Crear archivo y directorio");
                        System.out.println("3. Leer fichero carácter a carácter");
                        System.out.println("4. Leer fichero línea a línea");
                        System.out.println("5. Leer líneas pares");
                        System.out.println("6. Escribir fichero completo");
                        System.out.println("7. Escribir líneas impares");
                        System.out.println("8. Copiar fichero y añadir mensaje final");
                        System.out.println("9. Copiar fichero en uno de pares y otro de impares");
                        System.out.println("10. Buscar línea en fichero");
                        System.out.println("11. Copiar líneas mayores a 10 caracteres");
                        System.out.println("12. Copiar fichero completo sin argumentos por teclado");
                        System.out.println("13. Copiar fichero completo mediante argumentos");
                        System.out.println("14. Salir");
                        System.out.print("Seleccione una opción: ");

                        if (!sc.hasNextInt()) {
                            System.err.println("La opción debe ser un número entero.");
                            sc.nextLine();
                            continue;
                        }
                        opcion = sc.nextInt();
                        sc.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print("Ruta del fichero: ");
                                String rutaF1 = sc.nextLine();
                                System.out.print("Ruta del directorio: ");
                                String rutaDir = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.infoFichero(rutaF1, rutaDir);
                                break;
                            case 2:
                                System.out.print("Ruta del directorio: ");
                                String rutaDir2 = sc.nextLine();
                                System.out.print("Nombre del archivo: ");
                                String nombreArchivo = sc.nextLine();
                                System.out.print("Nombre del nuevo directorio: ");
                                String nombreDirectorio = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.crearFicheroDirectorio(rutaDir2, nombreArchivo, nombreDirectorio);
                                break;
                            case 3:
                                System.out.print("Ruta del fichero: ");
                                String rutaF3 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.leerCaracteres(rutaF3);
                                break;
                            case 4:
                                System.out.print("Ruta del fichero: ");
                                String rutaF4 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.leerLineas(rutaF4);
                                break;
                            case 5:
                                System.out.print("Ruta del fichero: ");
                                String rutaF5 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.leerLineasPares(rutaF5);
                                break;
                            case 6:
                                System.out.print("Ruta del fichero: ");
                                String rutaF6 = sc.nextLine();
                                System.out.println("Ingrese las líneas a escribir (separadas por ';'):");
                                String[] lineas6 = sc.nextLine().split(";");
                                RA1.Ejercicio1.OPERACIONESTEXTOS.escribirFichero(rutaF6, lineas6);
                                break;
                            case 7:
                                System.out.print("Ruta del fichero: ");
                                String rutaF7 = sc.nextLine();
                                System.out.println("Ingrese las líneas a escribir (separadas por ';'):");
                                String[] lineas7 = sc.nextLine().split(";");
                                RA1.Ejercicio1.OPERACIONESTEXTOS.escribirLineasImpares(rutaF7, lineas7);
                                break;
                            case 8:
                                System.out.print("Ruta del fichero origen: ");
                                String rutaOrigen8 = sc.nextLine();
                                System.out.print("Ruta del fichero destino: ");
                                String rutaDestino8 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.copiarFicheroConFin(rutaOrigen8, rutaDestino8);
                                break;
                            case 9:
                                System.out.print("Ruta del fichero origen: ");
                                String rutaOrigen9 = sc.nextLine();
                                System.out.print("Ruta del fichero pares: ");
                                String rutaPares = sc.nextLine();
                                System.out.print("Ruta del fichero impares: ");
                                String rutaImpares = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.separarParesImpares(rutaOrigen9, rutaPares, rutaImpares);
                                break;
                            case 10:
                                System.out.print("Ruta del fichero: ");
                                String rutaF10 = sc.nextLine();
                                System.out.print("Texto a buscar: ");
                                String lineaBuscada = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.buscarPalabra(rutaF10, lineaBuscada);
                                break;
                            case 11:
                                System.out.print("Ruta del fichero de entrada: ");
                                String rutaEntrada11 = sc.nextLine();
                                System.out.print("Ruta del fichero de salida: ");
                                String rutaSalida11 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.copiarLineasMayores10(rutaEntrada11, rutaSalida11);
                                break;
                            case 12:
                                System.out.print("Ruta del fichero origen: ");
                                String rutaOrigen12 = sc.nextLine();
                                System.out.print("Ruta del fichero destino: ");
                                String rutaDestino12 = sc.nextLine();
                                RA1.Ejercicio1.OPERACIONESTEXTOS.copiarFicheros(rutaOrigen12, rutaDestino12);
                                break;
                            case 13:
                                if (args.length != 2) {
                                    System.out.println("Error hay que pasar  2 argumentos: ");
                                } else {
                                    String rutaOrigen13 = args[0];
                                    String rutaDestino13 = args[1];
                                    RA1.Ejercicio1.OPERACIONESTEXTOS.copiarFicheros(rutaOrigen13, rutaDestino13);
                                    System.out.println("Copia realizada usando argumentos de línea de comandos.");
                                }
                                break;
                            case 14:
                                System.out.println("FIN DEL PROGRAMA.");
                                break;
                            default:
                                System.err.println("OPCION ERRONEA. VUELVE A INTENTARLO.");
                        }
                    }
                    break;
                }
                case 2: {
                    RA1.Ejercicio2.OperacionesEjemplo op = new OperacionesEjemplo();
                    Scanner sc2 = new Scanner(System.in);
                    int opcion2;
                    do {
                        System.out.println("\n===== MENÚ FICHEROS BINARIOS EJEMPLO. =====");
                        System.out.println("1. Ejemplo Fichero Binario sin clases");
                        System.out.println("2. Ejemplo Fichero Binario con clases (Serializable)");
                        System.out.println("0. Salir");
                        System.out.print("Opción: ");
                        opcion2 = sc2.nextInt();
                        sc2.nextLine(); // Limpiar el buffer
                        switch (opcion2) {
                            case 1:
                                System.out.println("Introduce la ruta del fichero binario: ");
                                String rutaFichero = sc2.nextLine();
                                op.ejemploSimple(rutaFichero, sc2);
                                break;
                            case 2:
                                System.out.print("Ruta del fichero serializable: ");
                                String rutaSerializable = sc2.nextLine();
                                op.ejemploEmpleados(rutaSerializable);
                                break;
                            case 0:
                                System.out.println("FIN DEL PROGRAMA");
                                break;
                            default:
                                System.out.println("OPCION ERRONEA");
                        }
                    } while (opcion2 != 0);
                    sc2.close();
                    break;
                }
                case 3: {
                    Scanner sc3 = new Scanner(System.in);
                    RA1.Ejercicio3.OperacionesBinarios operaciones = new OperacionesBinarios();
                    int opcion3;
                    do {
                        System.out.println("\n==============================");
                        System.out.println("       MENÚ PRINCIPAL");
                        System.out.println("==============================");
                        System.out.println("1. Generar fichero de libros");
                        System.out.println("2. Mostrar libros con código 0100 o precio 17");
                        System.out.println("3. Mostrar libro con mayor precio");
                        System.out.println("4. Mostrar todos los libros");
                        System.out.println("5. Generar fichero de empleados");
                        System.out.println("6. Mostrar todos los empleados");
                        System.out.println("7. Mostrar empleado con nombre y apellido más largo");
                        System.out.println("8. Mostrar empleados con más de 2 hijos");
                        System.out.println("0. Salir");
                        System.out.println("==============================");
                        System.out.print("Elige una opción: ");
                        opcion3 = sc3.nextInt();
                        switch (opcion3) {
                            case 1:
                                operaciones.generarFicheroLibros();
                                break;
                            case 2:
                                operaciones.mostrarLibrosCodigoOPrecio();
                                break;
                            case 3:
                                operaciones.mostrarLibroMayorPrecio();
                                break;
                            case 4:
                                operaciones.mostrarTodosLibros();
                                break;
                            case 5:
                                operaciones.generarFicheroEmpleados();
                                break;
                            case 6:
                                operaciones.mostrarTodosEmpleados();
                                break;
                            case 7:
                                operaciones.mostrarEmpleadoMasLargo();
                                break;
                            case 8:
                                operaciones.mostrarEmpleadosMasDeDosHijos();
                                break;
                            case 0:
                                System.out.println("Programa terminado.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } while (opcion3 != 0);
                    sc3.close();
                    break;
                }
                case 4: {
                    RA1.Ejercicio4.OperacionesDepartamentos op = new OperacionesDepartamentos();
                    op.crearFicheroInicial();
                    Scanner sc4 = new Scanner(System.in);
                    int opcion4;
                    do {
                        System.out.println("""
                                
                                ===== MENÚ DEPARTAMENTOS =====
                                1. Modificar departamento
                                2. Eliminar departamento
                                3. Listar departamentos
                                0. Salir
                                Seleccione opción:
                                """);

                        opcion4 = sc4.nextInt();
                        switch (opcion4) {
                            case 1 -> {
                                System.out.print("Número del departamento a modificar: ");
                                int dep = sc4.nextInt();
                                sc4.nextLine();
                                System.out.print("Nuevo nombre: ");
                                String nombre = sc4.nextLine();
                                System.out.print("Nueva localidad: ");
                                String loc = sc4.nextLine();
                                op.modificarDepartamento(dep, nombre, loc);
                            }
                            case 2 -> {
                                System.out.print("Número del departamento a eliminar: ");
                                int dep = sc4.nextInt();
                                op.eliminarDepartamento(dep);
                            }
                            case 3 -> op.listarDepartamentos();
                            case 0 -> System.out.println("Saliendo...");
                            default -> System.out.println("Opción incorrecta");
                        }
                    } while (opcion4 != 0);
                    break;
                }
                case 5: {
                    File fichero = new File("C:\\EJERCICIOS\\UNI1\\AleatorioEmple.dat");
                    //declara el fichero de acceso aleatorio
                    RandomAccessFile file = new RandomAccessFile(fichero, "rw");
                    //

                    int registro = 4;//id a modificar

                    long posicion = (registro - 1) * 36; //(4+20+4+8)  modifico salario y dep
                    posicion = posicion + 4 + 20; //sumo el tama�o de ID+apellido
                    file.seek(posicion); //nos posicionamos
                    file.writeInt(40);   //modif departamento
                    file.writeDouble(4000.87);//modif salario
                    file.close();  //cerrar fichero
                    break;
                }
                case 6: {
                    final String ficheroDepartamentos = "D:\\USERS_NO_BORRAR\\marcos.garcia222\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio6\\Departamentos1.xml";
                    Scanner sc6 = new Scanner(System.in);
                    RA1.Ejercicio6.OperacionesXML operacionesXML = new RA1.Ejercicio6.OperacionesXML();
                    RA1.Ejercicio6.Main main = new RA1.Ejercicio6.Main();
                    int opcion6;
                    do {
                        System.out.println("\n==============================");
                        System.out.println("       MENÚ PRINCIPAL");
                        System.out.println("==============================");
                        System.out.println("1. Leer y listar departamentos");
                        System.out.println("2. Listar departamentos en Guadalajara y mostrar el número de departamento mayor");
                        System.out.println("3. Menu ciclos formativos");
                        System.out.println("0. Salir");
                        System.out.println("==============================");
                        System.out.print("Elige una opción: ");
                        opcion6 = sc6.nextInt();
                        switch (opcion6) {
                            case 1:
                                operacionesXML.listarDepartamentos(ficheroDepartamentos);
                                break;
                            case 2:
                                operacionesXML.listarPorLocalidad(ficheroDepartamentos);
                                operacionesXML.listarNumeroMayor(ficheroDepartamentos);
                                break;
                            case 3:
                                main.menuCiclosFormativos();
                                break;
                            case 0:
                                System.out.println("Programa terminado.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } while (opcion6 != 0);
                    sc6.close();
                    break;
                }
                case 7:
                    System.out.println("FIN DEL PROGRAMA.");
                    break;
                default:
                    System.err.println("OPCION ERRONEA. VUELVE A INTENTARLO.");
            }
        }

    }

    public void menuCiclosFormativos() {
        Scanner sc = new Scanner(System.in);
        RA1.Ejercicio6.OperacionesXML operacionesXML = new OperacionesXML();
        final String ficheroCiclosFormativos = "D:\\USERS_NO_BORRAR\\marcos.garcia222\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio6\\ciclosformativos.xml";
        int opcion;
        do {
            System.out.println("\n==============================");
            System.out.println("       MENÚ CICLOS FORMATIVOS");
            System.out.println("==============================");
            System.out.println("1. Listar ciclos formativos");
            System.out.println("2. Añadir ciclo formativo");
            System.out.println("3. Modificar numero alumnos");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    operacionesXML.listarCiclosFormativos(ficheroCiclosFormativos);
                    break;
                case 2:
                    operacionesXML.añadirCicloFormativo(ficheroCiclosFormativos);
                    break;
                case 3:
                    operacionesXML.modificarCiclosFormativos(ficheroCiclosFormativos);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}