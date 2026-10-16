package RA1.Ejercicio4;

import java.io.Serializable;

public class Departamento implements Serializable {
    private String nombre;
    private String loc;
    private int dep;

    public Departamento(String nombre, int dep, String loc) {
        this.nombre = nombre;
        this.dep = dep;
        this.loc = loc;
    }

    public Departamento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public void mostrar() {
        System.out.println("Departamento: " + dep +
                " | Nombre: " + nombre +
                " | Localidad: " + loc);
    }
}