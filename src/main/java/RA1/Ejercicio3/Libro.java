package RA1.Ejercicio3;

import java.io.DataOutputStream;
import java.io.IOException;

import lombok.Data;

@Data
public class Libro {

    private String codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private double precio;

    public Libro(String codigo, String titulo, String autor, String editorial, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
    }

    public void escribir(DataOutputStream out) throws IOException {
        out.writeUTF(codigo);
        out.writeUTF(titulo);
        out.writeUTF(autor);
        out.writeUTF(editorial);
        out.writeDouble(precio);
    }

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