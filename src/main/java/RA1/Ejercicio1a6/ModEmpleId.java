package RA1.Ejercicio1a6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModEmpleId {
    public int mod(String fich,int id,String apellido,int dep,double salario) throws IOException {
        File fichero = new File(fich);
        int dev=-1;
        //declara el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        //

        int registro = id  ;//id a modificar

        long posicion = (registro -1 ) * 36;
        if (posicion> file.length() || posicion < 0) {
            System.out.println("El ID " + id + " no existe");
            file.close();
            return dev; // Retorna -1
        }
        file.seek(posicion);
        file.writeInt(id);
        StringBuffer buffer = new StringBuffer(apellido);
        buffer.setLength(10); //10 caracteres para el apellido
        file.writeChars(buffer.toString());
        file.writeInt(dep);   //modif departamento
        file.writeDouble(salario);//modif salario
        dev=0;
        file.close();  //cerrar fichero
        return dev;
    }
}

