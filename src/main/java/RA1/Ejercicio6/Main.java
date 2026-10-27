package RA1.Ejercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String ficheroDepartamentos = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio6\\Departamentos1.xml";
        Scanner sc = new Scanner(System.in);
        OperacionesXML operacionesXML = new OperacionesXML();
        Main main = new Main();
        int opcion;
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
            opcion = sc.nextInt();
            switch (opcion) {
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
        } while (opcion != 0);
        sc.close();
    }

    public void menuCiclosFormativos() {
        Scanner sc = new Scanner(System.in);
        OperacionesXML operacionesXML = new OperacionesXML();
        final String ficheroCiclosFormativos = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio6\\CiclosFormativos.xml";
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
                    // Lógica para añadir ciclo formativo
                    break;
                case 3:
                    // Lógica para modificar ciclo formativo
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}