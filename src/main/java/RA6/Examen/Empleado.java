package RA6.Examen;

import java.util.ArrayList;

public class Empleado {

    private int id;
    private String apellido;
    private String oficio;
    private double salario;
    private int deptId;

    private ArrayList<Proyecto> proyectos = new ArrayList<>();

    private ArrayList<String> especialidades = new ArrayList<>();

    public Empleado() {
    }

    public Empleado(int id, String apellido, String oficio, double salario, int deptId) {
        this.id = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public double getSalario() {
        return salario;
    }

    public int getDeptId() {
        return deptId;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public ArrayList<String> getEspecialidades() {
        return especialidades;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }


    public void addProyecto(Proyecto p) {

        if (!proyectos.contains(p)) {
            proyectos.add(p);
        }

    }

    public void addEspecialidad(String esp) {

        if (!especialidades.contains(esp)) {
            especialidades.add(esp);
        }

    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", salario=" + salario +
                ", deptId=" + deptId +
                ", especialidades=" + especialidades +
                ", proyectos=" + proyectos.size() +
                '}';
    }
}

