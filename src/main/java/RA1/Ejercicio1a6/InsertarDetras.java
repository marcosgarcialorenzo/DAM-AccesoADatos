package RA1.Ejercicio1a6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertarDetras {
    String fichero,apellido;
    int dept;
    Double salario;
    public InsertarDetras(String fichero,String apellido,int dept,Double salario) throws IOException {
        this.fichero = fichero;
        this.dept = dept;
        this.salario = salario;
        this.apellido = apellido;
    }
    public  void anadiruno() throws IOException {
        File fich=new File(fichero);
        RandomAccessFile file = new RandomAccessFile(fich, "rw");

        StringBuffer buffer = null;
        int id=(int)(file.length()/36)+1;
        long posicion = file.length();

        file.seek(posicion); //nos posicionamos
        file.writeInt(id); //uso id para identificar empleado
        buffer = new StringBuffer( apellido);
        buffer.setLength(10); //10 caracteres para el apellido
        file.writeChars(buffer.toString());//insertar apellido
        file.writeInt(dept);       //insertar departamento
        file.writeDouble(salario);//insertar salario

        file.close();
    }
}
