package RA1.Ejercicio2;

import java.io.*;
import java.util.Scanner;

public class OperacionesEjemplo {

    public void ejemploSimple(String rutaFichero, Scanner sc) throws IOException {
        System.out.println("Introduce el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento del empleado: ");
        String fecha = sc.nextLine();
        System.out.println("Introduce el código del empleado: ");
        long codigo = sc.nextLong();
        System.out.println("Introduce el salario del empleado: ");
        long salario = sc.nextLong();

        Empleado E1 = new Empleado(codigo, nombre, salario, fecha);
        E1.grabarEmpleado(new DataOutputStream(new FileOutputStream(rutaFichero)));

        E1.leerEmpleado(new DataInputStream(new FileInputStream(rutaFichero)));
        E1.mostrarEmpleado();
    }


    public void ejemploEmpleados(String rutaFichero) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaFichero))) {
            while (true) { // Bucle infinito hasta llegar al final del fichero
                Empleado E1 = new Empleado();
                E1.leerEmpleado(dis);
                E1.mostrarEmpleado();
            }
        } catch (EOFException e) {
            // Se alcanza esta excepción de manera normal al llegar al final del archivo
            System.out.println("Fin de la lectura del fichero.");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}