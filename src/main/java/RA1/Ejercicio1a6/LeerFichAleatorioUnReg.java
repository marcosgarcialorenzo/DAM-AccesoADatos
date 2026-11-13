package RA1.Ejercicio1a6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorioUnReg {
    String fichero;
    int id;
    public LeerFichAleatorioUnReg(String fichero, int id) {
        this.fichero=fichero;
        this.id = id;
    }
    public void LeerUnId() throws IOException {
        File fich = new File(fichero);
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fich, "r");
        //
        int  dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        int registro = id; //recoger id de empleado a consultar

        posicion = (registro -1 ) * 36;
        if(posicion >= file.length() )
            System.out.println("ID: " + registro + ", NO EXISTE EMPLEADO...");
        else{
            file.seek(posicion); //nos posicionamos
            id=file.readInt(); // obtengo id de empleado
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar();//recorro uno a uno los caracteres del apellido
                apellido[i] = aux;    //los voy guardando en el array
            }

            String apellidoS= new String(apellido);//convierto a String el array
            dep=file.readInt();//obtengo dep
            salario=file.readDouble();  //obtengo salario

            System.out.println("ID: " + registro + ", Apellido: "+  apellidoS +
                    ", Departamento: "+dep + ", Salario: " + salario);
        }
        file.close();  //cerrar fichero
    }
}