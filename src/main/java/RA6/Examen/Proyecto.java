package RA6.Examen;

import java.util.ArrayList;

public class Proyecto {

    private int id;
    private String nombre;
    private double presupuesto;
    private int deptId;

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Proyecto() {}

    public Proyecto(int id, String nombre, double presupuesto, int deptId) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.deptId = deptId;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPresupuesto() { return presupuesto; }
    public int getDeptId() { return deptId; }

    public ArrayList<Empleado> getEmpleados() { return empleados; }

    public void addEmpleado(Empleado e) {
        if (!empleados.contains(e)) {
            empleados.add(e);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
