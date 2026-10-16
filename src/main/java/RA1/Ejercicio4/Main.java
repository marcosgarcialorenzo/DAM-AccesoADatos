package RA1.Ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OperacionesDepartamentos op = new OperacionesDepartamentos();
        op.crearFicheroInicial();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("""
                    
                    ===== MENÚ DEPARTAMENTOS =====
                    1. Modificar departamento
                    2. Eliminar departamento
                    3. Listar departamentos
                    0. Salir
                    Seleccione opción:
                    """);

            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Número del departamento a modificar: ");
                    int dep = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nueva localidad: ");
                    String loc = sc.nextLine();
                    op.modificarDepartamento(dep, nombre, loc);
                }
                case 2 -> {
                    System.out.print("Número del departamento a eliminar: ");
                    int dep = sc.nextInt();
                    op.eliminarDepartamento(dep);
                }
                case 3 -> op.listarDepartamentos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }
        } while (opcion != 0);
    }
}
