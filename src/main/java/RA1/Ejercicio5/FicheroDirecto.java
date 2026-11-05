package RA1.Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class FicheroDirecto {
    static final int TAM_CAMPO = 15;
    static final int TAM_REG = 4 + TAM_CAMPO * 2 + TAM_CAMPO * 2;  // 64
    static final String RUTA = "C:\\Users\\Marcos\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio5\\Alumnos.dat";
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws IOException {
        int op;
        do {
            System.out.println("\n--- FICHERO DIRECTO ---");
            System.out.println("1. Grabar");
            System.out.println("2. Visualizar");
            System.out.println("3. Búsqueda secuencial");
            System.out.println("0. Volver");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1: grabar(); break;
                case 2: visualizar(); break;
                case 3: buscar(); break;
            }
        } while (op != 0);
    }

    // ---------- utilidades ----------
    static String ajustar(String s) {          // rellena hasta 15 chars
        StringBuffer b = new StringBuffer(s);
        b.setLength(TAM_CAMPO);
        return b.toString();
    }

    static String leerCampo(RandomAccessFile f) throws IOException {
        char c[] = new char[TAM_CAMPO];
        for (int i = 0; i < TAM_CAMPO; i++) c[i] = f.readChar();
        return new String(c).trim();           // trim quita el relleno
    }

    static void escribirRegistro(RandomAccessFile f, int num, String nom, String ape) throws IOException {
        f.seek((num - 1) * (long) TAM_REG);    // la posición la da el número
        f.writeInt(num);
        f.writeChars(ajustar(nom));
        f.writeChars(ajustar(ape));
    }

    // ---------- 1. GRABAR ----------
    static void grabar() throws IOException {
        System.out.print("Número de alumno ");
        int num = Integer.parseInt(sc.nextLine()); // o sc.nextInt() y luego sc.nextLine() para limpiar el buffer
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Fecha de nacimiento: ");
        String ape = sc.nextLine();

        if (num <= 0) { System.out.println("Número no válido."); return; }

        RandomAccessFile f = new RandomAccessFile(RUTA, "rw");
        escribirRegistro(f, num, nom, ape);
        f.close();
        System.out.println("Alumno grabado.");
    }

    // ---------- 2. VISUALIZAR ----------
    static void visualizar() throws IOException {
        RandomAccessFile f = new RandomAccessFile(RUTA, "r");
        while (f.getFilePointer() < f.length()) {
            int num = f.readInt();
            String nom = leerCampo(f);
            String ape = leerCampo(f);
            if (num != 0) {                    // saltamos los huecos
                System.out.println(num + " - " + nom + " " + ape);
            }
        }
        f.close();
    }

    // ---------- 3. BÚSQUEDA SECUENCIAL ----------
    static void buscar() throws IOException {
        System.out.print("Nombre a buscar: ");
        String buscado = sc.nextLine();

        RandomAccessFile f = new RandomAccessFile(RUTA, "rw");
        boolean encontrado = false;

        while (f.getFilePointer() < f.length()) {
            long posRegistro = f.getFilePointer();   // guardamos dónde empieza
            int num = f.readInt();
            String nom = leerCampo(f);
            String ape = leerCampo(f);

            if (num != 0 && nom.equalsIgnoreCase(buscado)) {
                System.out.println("Encontrado: " + num + " - " + nom + " " + ape);
                System.out.print("¿Es el alumno que buscabas? (SI/NO): ");
                String resp = sc.nextLine();

                if (resp.equalsIgnoreCase("SI")) {
                    encontrado = true;
                    System.out.print("NUEVO NUMERO: ");
                    int nuevo = Integer.parseInt(sc.nextLine());

                    // ¿está ocupada la posición nueva?
                    long posNueva = (nuevo - 1) * (long) TAM_REG;
                    boolean ocupado = false;
                    if (posNueva < f.length()) {
                        f.seek(posNueva);
                        ocupado = f.readInt() != 0;
                    }

                    if (nuevo <= 0 || ocupado) {
                        System.out.println("Número no válido o ya ocupado.");
                    } else {
                        f.seek(posRegistro);
                        f.write(new byte[TAM_REG]);          // vaciamos el registro viejo
                        escribirRegistro(f, nuevo, nom, ape); // lo escribimos en su nueva posición
                        System.out.println("Número cambiado. Compruébalo con la opción 2.");
                    }
                    break;      // salimos del bucle
                }
                // si dice NO, seguimos buscando
            }
        }
        if (!encontrado) System.out.println("No se ha encontrado el alumno.");
        f.close();
    }
}