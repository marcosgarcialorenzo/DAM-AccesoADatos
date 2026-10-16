package RA1.Ejercicio4;

import java.io.*;

public class OperacionesDepartamentos {

    private static final String FICHERO = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio4\\F1.dat";
    private static final String FICHERO_AUX = "C:\\Users\\marco\\IdeaProjects\\DAM-AccesoADatos\\src\\main\\java\\RA1\\Ejercicio4\\F1aux.dat";

    public void crearFicheroInicial() {
        File f = new File(FICHERO);
        if (f.exists()) return; // solo funciona si se crea el fichero la primera vez con este método(si lo creas tu antes del primer uso no funciona), si ya existe no hace nada
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            out.writeObject(new Departamento("Contabilidad", 10, "Madrid"));
            out.writeObject(new Departamento("Informática", 20, "Sevilla"));
            out.writeObject(new Departamento("RRHH", 30, "Valencia"));
            out.writeObject(new Departamento("Marketing", 40, "Barcelona"));
            out.writeObject(new Departamento("Ventas", 50, "Bilbao"));
            out.writeObject(new Departamento("Producción", 60, "Zaragoza"));
            out.writeObject(new Departamento("Logística", 70, "Murcia"));
            out.writeObject(new Departamento("Calidad", 80, "Valladolid"));
            out.writeObject(new Departamento("I+D", 90, "Málaga"));
            out.writeObject(new Departamento("Atención al Cliente", 100, "Alicante"));
            System.out.println("Fichero de departamentos creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modificarDepartamento(int depBuscado, String nuevoNombre, String nuevaLoc) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHERO)); // input es leer, leo desde el fichero original
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO_AUX))) { //output es escribir, escribo en el fichero auxiliar
            while (true) {
                Departamento dep = (Departamento) in.readObject(); // lee el original
                if (dep.getDep() == depBuscado) {
                    dep.setNombre(nuevoNombre); //pone los datos nuevos en un objeto
                    dep.setLoc(nuevaLoc);
                }
                out.writeObject(dep); // escribe el objeto en el aux
            }
        } catch (EOFException e) {
            // final esperado
        } catch (Exception e) {
            e.printStackTrace();
        }
        reemplazarFichero();
        System.out.println("\n>>> MODIFICACIÓN COMPLETADA con éxito <<<\n");
    }

    public void eliminarDepartamento(int depEliminar) {
        int contador = 0;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHERO)); //lee el original
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO_AUX))) { // escribe en el aux
            while (true) {
                Departamento dep = (Departamento) in.readObject();
                if (dep.getDep() != depEliminar) {
                    out.writeObject(dep); //esribe en el aux todos excepto el que se quiere eliminar
                    contador++;
                }
            }
        } catch (EOFException e) {
            // final esperado
        } catch (Exception e) {
            e.printStackTrace();
        }
        reemplazarFichero();
        System.out.println("\n>>> DEPARTAMENTO ELIMINADO <<<");
        System.out.println("Departamentos restantes: " + contador);
    }

    private void reemplazarFichero() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHERO_AUX)); //lee el aux
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO))) { //escribe en el original
            while (true) {
                Departamento dep = (Departamento) in.readObject();
                out.writeObject(dep);
            }
        } catch (EOFException e) {
            // final esperado
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarDepartamentos() {
        System.out.println("\n=== LISTADO DE DEPARTAMENTOS ===");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FICHERO))) {
            while (true) {
                Departamento dep = (Departamento) in.readObject();
                dep.mostrar();
            }
        } catch (EOFException e) {
            System.out.println("Fin del listado.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}