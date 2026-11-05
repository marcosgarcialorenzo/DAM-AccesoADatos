package RA1.Ejercicio5;

import java.io.*;
public class LeerFichAleatorioUnReg {
  public static void main(String[] args) throws IOException {     
   File fichero = new File("C:\\EJERCICIOS\\UNI1\\AleatorioEmple.dat");
   //declara el fichero de acceso aleatorio
   RandomAccessFile file = new RandomAccessFile(fichero, "r");
   //
   int  id, dep, posicion;    
   Double salario;  
   char apellido[] = new char[10], aux;
   int registro = Integer.parseInt(args[0]); //recoger id de empleado a consultar      
   
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