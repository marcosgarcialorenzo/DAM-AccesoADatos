package RA6.Examen;

import java.util.ArrayList;

public class Departamento {

    private int id;
    private String nombre;
    private String loc;

    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public Departamento() {}

    public Departamento(int id, String nombre, String loc) {
        this.id = id;
        this.nombre = nombre;
        this.loc = loc;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getLoc() { return loc; }

    public static ArrayList<Empleado> getEmpleados() { return empleados; }

    public void addEmpleado(Empleado e) {
        if (!empleados.contains(e)) {
            empleados.add(e);
        }
    }
}

