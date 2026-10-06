package RA1.Ejercicio3;

import java.io.DataOutputStream;
import java.io.IOException;

public class Libro {


    private String codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private double precio;

    public Libro(String codigo, String titulo, String autor,
                 String editorial, double precio) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public double getPrecio() {
        return precio;
    }

    // Escribe el libro en el fichero binario
    public void escribir(DataOutputStream out) throws IOException {

        out.writeUTF(codigo);
        out.writeUTF(titulo);
        out.writeUTF(autor);
        out.writeUTF(editorial);
        out.writeDouble(precio);
    }

    // Muestra el libro por pantalla
    public void mostrar() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        return "Código: " + codigo
                + ", Título: " + titulo
                + ", Autor: " + autor
                + ", Editorial: " + editorial
                + ", Precio: " + precio + " €";
    }


}