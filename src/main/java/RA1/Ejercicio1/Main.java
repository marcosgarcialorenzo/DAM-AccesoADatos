package RA1.Ejercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

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
                    OPERACIONESTEXTOS.infoFichero(rutaF1, rutaDir);
                    break;
                case 2:
                    System.out.print("Ruta del directorio: ");
                    String rutaDir2 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    System.out.print("Nombre del nuevo directorio: ");
                    String nombreDirectorio = sc.nextLine();
                    OPERACIONESTEXTOS.crearFicheroDirectorio(rutaDir2, nombreArchivo, nombreDirectorio);
                    break;
                case 3:
                    System.out.print("Ruta del fichero: ");
                    String rutaF3 = sc.nextLine();
                    OPERACIONESTEXTOS.leerCaracteres(rutaF3);
                    break;
                case 4:
                    System.out.print("Ruta del fichero: ");
                    String rutaF4 = sc.nextLine();
                    OPERACIONESTEXTOS.leerLineas(rutaF4);
                    break;
                case 5:
                    System.out.print("Ruta del fichero: ");
                    String rutaF5 = sc.nextLine();
                    OPERACIONESTEXTOS.leerLineasPares(rutaF5);
                    break;
                case 6:
                    System.out.print("Ruta del fichero: ");
                    String rutaF6 = sc.nextLine();
                    System.out.println("Ingrese las líneas a escribir (separadas por ';'):");
                    String[] lineas6 = sc.nextLine().split(";");
                    OPERACIONESTEXTOS.escribirFichero(rutaF6, lineas6);
                    break;
                case 7:
                    System.out.print("Ruta del fichero: ");
                    String rutaF7 = sc.nextLine();
                    System.out.println("Ingrese las líneas a escribir (separadas por ';'):");
                    String[] lineas7 = sc.nextLine().split(";");
                    OPERACIONESTEXTOS.escribirLineasImpares(rutaF7, lineas7);
                    break;
                case 8:
                    System.out.print("Ruta del fichero origen: ");
                    String rutaOrigen8 = sc.nextLine();
                    System.out.print("Ruta del fichero destino: ");
                    String rutaDestino8 = sc.nextLine();
                    OPERACIONESTEXTOS.copiarFicheroConFin(rutaOrigen8, rutaDestino8);
                    break;
                case 9:
                    System.out.print("Ruta del fichero origen: ");
                    String rutaOrigen9 = sc.nextLine();
                    System.out.print("Ruta del fichero pares: ");
                    String rutaPares = sc.nextLine();
                    System.out.print("Ruta del fichero impares: ");
                    String rutaImpares = sc.nextLine();
                    OPERACIONESTEXTOS.separarParesImpares(rutaOrigen9, rutaPares, rutaImpares);
                    break;
                case 10:
                    System.out.print("Ruta del fichero: ");
                    String rutaF10 = sc.nextLine();
                    System.out.print("Texto a buscar: ");
                    String lineaBuscada = sc.nextLine();
                    OPERACIONESTEXTOS.buscarPalabra(rutaF10, lineaBuscada);
                    break;
                case 11:
                    System.out.print("Ruta del fichero de entrada: ");
                    String rutaEntrada11 = sc.nextLine();
                    System.out.print("Ruta del fichero de salida: ");
                    String rutaSalida11 = sc.nextLine();
                    OPERACIONESTEXTOS.copiarLineasMayores10(rutaEntrada11, rutaSalida11);
                    break;
                case 12:
                    System.out.print("Ruta del fichero origen: ");
                    String rutaOrigen12 = sc.nextLine();
                    System.out.print("Ruta del fichero destino: ");
                    String rutaDestino12 = sc.nextLine();
                    OPERACIONESTEXTOS.copiarFicheros(rutaOrigen12, rutaDestino12);
                    break;
                case 13:
                    if (args.length != 2) {
                        System.out.println("Error hay que pasar  2 argumentos: ");
                    } else {
                        String rutaOrigen13 = args[0];
                        String rutaDestino13 = args[1];
                        OPERACIONESTEXTOS.copiarFicheros(rutaOrigen13, rutaDestino13);
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
        sc.close();
    }
}