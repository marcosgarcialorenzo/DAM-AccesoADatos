package RA1.Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperacionesBinarios operaciones = new OperacionesBinarios();
        int opcion;
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
            opcion = sc.nextInt();
            switch (opcion) {
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
        } while (opcion != 0);
        sc.close();
    }
}