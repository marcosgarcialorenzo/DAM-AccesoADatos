package RA1.Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Escribir un empleado");
            System.out.println("2. Escribir varios empleados");
            System.out.println("3. Leer empleado por ID");
            System.out.println("4. Insertar/escribir empleado al final");
            System.out.println("5. Modificar empleado por ID");
            System.out.println("6. Fichero directo");
            System.out.println("7. Visualizar fichero completo");
            System.out.println("0. Salir");
            op = sc.nextInt();
            switch (op) {
                case 1: EscribirFichAleatorio.escribir(); break;
                case 2: EscribirFichAleatorio.escribirVarios(); break;
                case 3: LeerFichAleatorio.leerPorId(); break;
                case 4: EscribirFichAleatorio.insertarAlFinal(); break;
                case 5: ModifcarFichAleatorio.modificar(); break;
                case 6: FicheroDirecto.menu(); break;
                case 7: LeerFichAleatorio.visualizarTodo(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida"); break;
            }
        } while (op != 0);
    }
}