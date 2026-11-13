package RA1.Ejercicio1a6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    String fich;

    public LeerFichAleatorio(String fich) {
        this.fich = fich;
    }
    public void leer() throws IOException {
        File fichero = new File(fich);
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        //
        int  id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;

        posicion=0;  //para situarnos al principio

        for(;;){  //recorro el fichero
            file.seek(posicion); //nos posicionamos en posicion
            id=file.readInt();   // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux;    //los voy guardando en el array
            }
            String apellidoS= new String(apellido).trim();//convierto a String el array
            dep=file.readInt();//obtengo dep
            salario=file.readDouble();  //obtengo salario

            System.out.println("ID: " + id + ", Apellido: "+  apellidoS +
                    ", Departamento: "+dep + ", Salario: " + salario);
            posicion= posicion + 36; // me posiciono para el sig empleado
            //Cada empleado ocupa 36 bytes (4+20+4+8)
            //Si he recorrido todos los bytes salgo del for
            if (file.getFilePointer()==file.length())break;

        }//fin bucle for
        file.close();  //cerrar fichero
    }
    }
