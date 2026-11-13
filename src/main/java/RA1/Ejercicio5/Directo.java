package RA1.Ejercicio5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Directo {
    final String FICHERO="directo.txt";
    final int CAPACIDAD=44;
    void menu(Scanner sc) throws IOException {
        int opcion;
        do{
        System.out.println("--- FICHERO DIRECTO ---");
        System.out.println("""
                1.Grabar
                2.Visualizar
                3.Buscar secuencial
                0.Volver
                """);
        opcion = sc.nextInt();

        switch (opcion) {

            case 1 -> {Grabar(sc);}

            case 2 -> {Visualizar();}

            case 3 -> {BuscaSecuencial(sc);}
            case 0 -> System.out.println("Saliendo...");

            default -> System.out.println("Opción incorrecta");
        }

    } while (opcion != 0);

    }

    private void BuscaSecuencial(Scanner sc) throws IOException {
        File fichero = new File(FICHERO);
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        System.out.println("Nombre a buscar:  ");
        String nombre = sc.next().trim();
        int codigo =0;
        int  cod;
        char aux;
        char nomb[] = new char[10];
        char fecha[] = new char[10];
        boolean mod=false;
        boolean existe=false;
        int posicion=0;//para situarnos al principio
        int posAux = 0;
        for(;;){  //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            cod=file.readInt();
            for (int i = 0; i < nomb.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del nombre
                nomb[i] = aux;    //los voy guardando en el array
            }
            for (int i = 0; i < fecha.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres de la fecha
                fecha[i] = aux;    //los voy guardando en el array
            }
            String nombres= new String(nomb).trim();
            String fechas = new String(fecha).trim();


            if (nombres.equalsIgnoreCase(nombre)){
                existe=true;
                System.out.println(cod+" "+nombres+" "+fechas);
                System.out.println("¿Es este?(SI/NO)");
                String  opcion = sc.next().toUpperCase().trim();
                switch (opcion) {
                    case "SI" -> {
                        System.out.println("Nuevo codigo: ");
                        codigo=sc.nextInt();
                        mod=true;
                    }
                    case "NO" -> {
                        System.out.println("No se ha modificado");
                        mod=false;
                    }
                }
                posAux=posicion;
                break;
            }
            posicion= posicion + CAPACIDAD; // me posiciono para el sig empleado
            if (file.getFilePointer()==file.length())break;

        }//fin bucle for
        if (existe==false){
            System.out.println("El nombre "+nombre+" no existe");
        }
        if (mod){
        file.seek(posAux);
        file.writeInt(codigo);
        }
        file.close();
    }

    private void Visualizar() throws IOException {
        File fichero = new File(FICHERO);
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        //
        int  cod;
        char aux;
        char nombre[] = new char[10];
        char fecha[] = new char[10];

        int posicion=0;  //para situarnos al principio
        System.out.println("Listado completo");
        for(;;){  //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            cod=file.readInt();
            for (int i = 0; i < nombre.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del nombre
                nombre[i] = aux;    //los voy guardando en el array
            }
            for (int i = 0; i < fecha.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres de la fecha
                fecha[i] = aux;    //los voy guardando en el array
            }
            String nombres= new String(nombre).trim();
            String fechas = new String(fecha).trim();

            System.out.println(cod+" "+nombres+" "+fechas);
            posicion= posicion + CAPACIDAD; // me posiciono para el sig empleado
            if (file.getFilePointer()==file.length())break;

        }//fin bucle for
        file.close();
    }

    private void Grabar(Scanner sc) throws IOException {
        File fich=new File(FICHERO);
        RandomAccessFile file = new RandomAccessFile(fich, "rw");
        System.out.println("Codigo: ");
        int cod = sc.nextInt();
        System.out.println("Nombre:  ");
        String nombre = sc.next();
        System.out.println("Fecha: ");
        String fecha = sc.next();
        StringBuffer bufferNombre = null;
        StringBuffer bufferFecha = null;
        long posicion = (long) (cod - 1) * CAPACIDAD;

        file.seek(posicion); //nos posicionamos

        file.writeInt(cod);

        bufferNombre = new StringBuffer(nombre);
        bufferNombre.setLength(10);
        file.writeChars(bufferNombre.toString());

        bufferFecha = new StringBuffer(fecha);
        bufferFecha.setLength(10);
        file.writeChars(bufferFecha.toString());

        file.close();
    }

}
