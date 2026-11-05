package RA1.Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class LeerFichAleatorio {
    
    public static void leerPorId() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        long posicion = (id - 1) * 36L;

        if (id <= 0 || posicion >= file.length()) {
            System.out.println("El empleado con ID " + id + " no existe.");
        } else {
            file.seek(posicion);
            int idLeido = file.readInt();
            char nombre[] = new char[10];
            for (int i = 0; i < 10; i++) {
                nombre[i] = file.readChar();
            }
            int dep = file.readInt();
            double salario = file.readDouble();
            System.out.println("ID: " + idLeido + ", Nombre: " + new String(nombre).trim() + ", Departamento: " + dep + ", Salario: " + salario);
        }
        file.close();
    }

    public static void visualizarTodo() throws IOException {
        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        while (file.getFilePointer() < file.length()) { // Mientras no se llegue al final del archivo, se puede poner for(;;) y luego un break al final del bucle
            int id = file.readInt(); // Lee el ID
            char nombre[] = new char[10]; // Array para almacenar el nombre
            for (int i = 0; i < 10; i++) nombre[i] = file.readChar(); // Lee el nombre
            int dep = file.readInt(); // Lee el departamento
            double salario = file.readDouble(); // Lee el salario
            System.out.println("ID: " + id + ", nombre: " + new String(nombre).trim() + ", dep: " + dep + ", salario: " + salario);
        }
        file.close(); // Cierra el fichero
    }
}