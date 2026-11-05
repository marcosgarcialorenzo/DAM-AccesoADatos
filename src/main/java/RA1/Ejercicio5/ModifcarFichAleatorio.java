package RA1.Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class ModifcarFichAleatorio {

    public static void modificar() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID del empleado a modificar: ");
        int id = sc.nextInt();
        File fichero = new File("C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        long pos = (id - 1) * 36L;
        if (id <= 0 || pos >= file.length()) {
            System.out.println("El empleado con ID " + id + " no existe.");
            file.close();
            return;
        }
        // 1) Leer y mostrar los datos actuales
        file.seek(pos);
        int idLeido = file.readInt();
        char nombre[] = new char[10];
        for (int i = 0; i < 10; i++) nombre[i] = file.readChar();
        int dep = file.readInt();
        double salario = file.readDouble();
        System.out.println("Datos actuales -> ID: " + idLeido + ", nombre: " + new String(nombre).trim() + ", dep: " + dep + ", salario: " + salario);
        // 2) Modificar
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = sc.next();
        System.out.print("Nuevo departamento: ");
        int nuevoDep = sc.nextInt();
        System.out.print("Nuevo salario: ");
        double nuevoSal = sc.nextDouble();
        StringBuffer buffer = new StringBuffer(nuevoNombre); // buffer para almacenar apellido
        buffer.setLength(10); // rellena hasta 10 caracteres
        file.seek(pos + 4); // nos saltamos el ID (4 bytes) y nos posicionamos en el nombre
        file.writeChars(buffer.toString()); // escribimos el nuevo nombre
        file.seek(pos + 24); // nos saltamos el ID (4 bytes) y el nombre (20 bytes) y nos posicionamos en el departamento
        file.writeInt(nuevoDep); // escribimos el nuevo departamento
        file.seek(pos + 28); // nos saltamos el ID (4 bytes), el nombre (20 bytes) y el departamento (4 bytes) y nos posicionamos en el salario
        file.writeDouble(nuevoSal); // escribimos el nuevo salario
        file.close(); // Cierra el fichero
    }
}