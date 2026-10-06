package RA1.Ejercicio3;

import java.io.*;

public class OperacionesBinarios {

    private static final String FICH_LIBROS = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio3\\FLibros.dat";
    private static final String FICH_EMPLEADOS = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio3\\FEmpleados.dat";

    public void generarFicheroLibros() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FICH_LIBROS))) {
            Libro[] lista = {
                    new Libro("0100", "Largo Pétalo de Mar", "Allende", "P&J", 21.76),
                    new Libro("0200", "Come comida Real", "Carlos Rios", "Paidos", 16.15),
                    new Libro("0300", "Los asquerosos", "Santiago Lorenzo", "Blackie Books", 19.95),
                    new Libro("0400", "Lo mejor de ir es volver", "Espinosa", "Grijalbo", 17.00),
                    new Libro("1000", "Malaherba", "Jabois", "Alfaguara", 17.00),
                    new Libro("0500", "The Emperor of Gladness", "Ocean Vuong", "Penguin Press", 24.50),
                    new Libro("0600", "Fourth Wing", "Rebecca Yarros", "Red Tower Books", 22.00),
                    new Libro("0700", "Onyx Storm", "Rebecca Yarros", "Red Tower Books", 22.00),
                    new Libro("0800", "The Let Them Theory", "Mel Robbins", "Harmony", 20.00),
                    new Libro("0900", "Sunrise on the Reaping", "Suzanne Collins", "Scholastic", 23.00),
                    new Libro("1100", "Great Big Beautiful Life", "Emily Henry", "Berkley", 18.50),
                    new Libro("1200", "The Wilderness", "Angela Flournoy", "Riverhead", 21.00),
                    new Libro("1300", "Heart the Lover", "Lily King", "G.P. Putnam's Sons", 22.50),
                    new Libro("1400", "Braiding Sweetgrass", "Robin Wall Kimmerer", "Milkweed", 19.95),
                    new Libro("1500", "The Housemaid", "Freida McFadden", "Berkley", 17.99),
                    new Libro("1600", "Archipelago of the Sun", "Yoko Tawada", "FSG Originals", 24.00),
                    new Libro("1700", "El viento conoce mi nombre", "Isabel Allende", "Plaza & Janés", 21.00),
                    new Libro("1800", "La anomalía", "Hervé Le Tellier", "Seix Barral", 19.00),
                    new Libro("1900", "Cómo no ser un esclavo del tiempo", "Oliver Burkeman", "Planeta", 18.90),
                    new Libro("2000", "Le dedico mi silencio", "Mario Vargas Llosa", "Alfaguara", 22.50)
            };

            for (Libro l : lista) {
                l.escribir(out);
                l.mostrar();
            }
            System.out.println("Fichero LIBROS generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error generando fichero libros: " + e.getMessage());
        }
    }

    public void mostrarTodosLibros() {
        try (DataInputStream in = new DataInputStream(new FileInputStream(FICH_LIBROS))) {
            while (true) {
                String codigo = in.readUTF();
                String titulo = in.readUTF();
                String autor = in.readUTF();
                String editorial = in.readUTF();
                double precio = in.readDouble();
                Libro libro = new Libro(codigo, titulo, autor, editorial, precio);
                libro.mostrar();
            }
        } catch (IOException e) {
            System.err.println("Error leyendo fichero libros: " + e.getMessage());
        }
    }


    public void mostrarLibrosCodigoOPrecio() {
        try (DataInputStream in = new DataInputStream(new FileInputStream(FICH_LIBROS))) {
            while (true) {
                String codigo = in.readUTF();
                String titulo = in.readUTF();
                String autor = in.readUTF();
                String editorial = in.readUTF();
                double precio = in.readDouble();
                if (codigo.equals("0100") || precio == 17.00) {
                    Libro libro = new Libro(codigo, titulo, autor, editorial, precio);
                    libro.mostrar();
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo fichero libros: " + e.getMessage());
        }
    }

    public void mostrarLibroMayorPrecio() {
        Libro libroMasCaro = null;
        try (DataInputStream in = new DataInputStream(new FileInputStream(FICH_LIBROS))) {
            while (true) {
                String codigo = in.readUTF();
                String titulo = in.readUTF();
                String autor = in.readUTF();
                String editorial = in.readUTF();
                double precio = in.readDouble();
                Libro libro = new Libro(codigo, titulo, autor, editorial, precio);
                if (libroMasCaro == null || precio > libroMasCaro.getPrecio()) {
                    libroMasCaro = libro;
                }
            }
        } catch (EOFException e) { //salta cuando ha terminado de leer el fichero
            if (libroMasCaro != null) {
                libroMasCaro.mostrar();
            }
        } catch (IOException e) {
            System.err.println("Error leyendo fichero libros: " + e.getMessage());
        }
    }

    public void generarFicheroEmpleados() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FICH_EMPLEADOS))) {
            Empleado[] lista = {
                    new Empleado("Ana", "López", 2),
                    new Empleado("Juan", "Martínez", 1),
                    new Empleado("Carmen", "Delgado Pérez", 3),
                    new Empleado("Luis", "García", 0),
                    new Empleado("María", "Sánchez Romero", 4),
                    new Empleado("Pedro", "Nuñez", 1),
                    new Empleado("Elena", "Hernández Rubio", 2),
                    new Empleado("Raúl", "Villar", 0),
                    new Empleado("Lucía", "Fernández", 3),
                    new Empleado("Jorge", "Prieto Zamora", 2),
                    new Empleado("Sofía", "Torres", 1),
                    new Empleado("Adrián", "Molina Pérez", 4),
                    new Empleado("Beatriz", "Calvo", 0),
                    new Empleado("Diego", "Serrano Montes", 3),
                    new Empleado("Paula", "Rivas Martín", 2)
            };
            for (Empleado e : lista) {
                e.escribir(out);
                e.mostrar();
            }
            System.out.println("Fichero EMPLEADOS generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error generando fichero empleados: " + e.getMessage());
        }
    }

    public void mostrarTodosEmpleados() {
        try (DataInputStream in = new DataInputStream(new FileInputStream(FICH_EMPLEADOS))) {
            while (true) {
                String nombre = in.readUTF();
                String apellido = in.readUTF();
                int numerohijos = in.readInt();
                Empleado emp = new Empleado(nombre, apellido, numerohijos);
                emp.mostrar();
            }
        } catch (IOException e) {
            System.err.println("Error leyendo fichero empleados: " + e.getMessage());
        }
    }

    public void empleadoNombreMasLargo() {

    }

    public void empleadosConMasDeDosHijos() {

    }
}