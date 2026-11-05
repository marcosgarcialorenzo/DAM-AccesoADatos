package RA1.Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class EscribirFichAleatorio {

    public static void escribir() throws IOException {
        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        StringBuffer buffer = new StringBuffer("GONZALEZ"); // buffer para almacenar apellido
        buffer.setLength(10); // rellena hasta 10 caracteres
        file.writeInt(20); // id
        file.writeChars(buffer.toString()); // apellido
        file.writeInt(10); // departamento
        file.writeDouble(1230.87); // salario
        file.close(); // Cierra el fichero
    }

    public static void escribirVarios() throws IOException {
        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        String nombre[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
        int dep[] = {10, 20, 10, 10, 30, 30, 20};
        double salario[] = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};
        for (int i = 0; i < nombre.length; i++) {
            StringBuffer buffer = new StringBuffer(nombre[i]); // buffer para almacenar apellido
            buffer.setLength(10); // rellena hasta 10 caracteres
            file.writeInt(i + 1); // ID
            file.writeChars(buffer.toString()); // Apellido
            file.writeInt(dep[i]); // Departamento
            file.writeDouble(salario[i]); // Salario
        }
        file.close(); // Cierra el fichero
    }

    public static void insertarAlFinal() throws IOException {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        long numRegistros = file.length() / 36; // Cada registro ocupa 36 bytes
        int nuevoId = (int) numRegistros + 1; // Nuevo ID basado en el número de registros existentes
        System.out.print("Nombre: ");      
        String nom = sc.next();
        System.out.print("Departamento: "); 
        int dep = sc.nextInt();
        System.out.print("Salario: ");      
        double sal = sc.nextDouble();
        file.seek(numRegistros * 36); // Posiciona al final del archivo
        StringBuffer buffer = new StringBuffer(nom); // buffer para almacenar apellido
        buffer.setLength(10); // rellena hasta 10 caracteres
        file.writeInt(nuevoId); // Escribe el nuevo ID
        file.writeChars(buffer.toString()); // Escribe el apellido
        file.writeInt(dep); // Escribe el departamento
        file.writeDouble(sal); // Escribe el salario
        file.close(); // Cierra el fichero
    }
}