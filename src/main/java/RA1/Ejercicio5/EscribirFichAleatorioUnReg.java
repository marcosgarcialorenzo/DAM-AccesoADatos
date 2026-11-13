package RA1.Ejercicio5;
import java.io.*;
public class EscribirFichAleatorioUnReg {
 String fichero,apellido;
 int id,dept;
 Double salario;
 public EscribirFichAleatorioUnReg(String fichero,int id,String apellido,int dept,Double salario) throws IOException {
  this.fichero = fichero;
  this.id = id;
  this.dept = dept;
  this.salario = salario;
  this.apellido = apellido;
 }
 public  void anadiruno() throws IOException {
  File fich=new File(fichero);
  RandomAccessFile file = new RandomAccessFile(fich, "rw");

  StringBuffer buffer = null;
  long posicion = (id -1 ) * 36;

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