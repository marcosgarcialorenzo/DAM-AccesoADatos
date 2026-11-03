package RA6.Examen;

import java.util.ArrayList;

public class Datos {

    public static ArrayList<Empleado> empleados = new ArrayList<>();
    public static ArrayList<Departamento> departamentos = new ArrayList<>();
    public static ArrayList<Proyecto> proyectos = new ArrayList<>();

    private static boolean cargado = false;

    public static void cargarDatos() {

        if (cargado)
            return;

        cargado = true;

        departamentos.add(new Departamento(10, "CONTABILIDAD", "SEVILLA"));
        departamentos.add(new Departamento(20, "INFORMATICA", "MADRID"));
        departamentos.add(new Departamento(30, "VENTAS", "BARCELONA"));
        departamentos.add(new Departamento(40, "PRODUCCION", "BILBAO"));
        departamentos.add(new Departamento(50, "RRHH", "VALENCIA"));
        departamentos.add(new Departamento(60, "MARKETING", "MALAGA"));
        departamentos.add(new Departamento(70, "LOGISTICA", "ZARAGOZA"));
        departamentos.add(new Departamento(80, "CALIDAD", "VALLADOLID"));
        departamentos.add(new Departamento(90, "INVESTIGACION", "A CORUÑA"));
        departamentos.add(new Departamento(100, "COMPRAS", "MURCIA"));

        empleados.add(new Empleado(1, "LOPEZ", "DEV", 2500, 20));
        empleados.add(new Empleado(2, "GARCIA", "DEV", 3200, 20));
        empleados.add(new Empleado(3, "RUIZ", "ANALISTA", 2800, 20));
        empleados.add(new Empleado(4, "MARTIN", "DEV", 2600, 20));

        empleados.add(new Empleado(5, "SANTOS", "VENDEDOR", 1800, 30));
        empleados.add(new Empleado(6, "DIAZ", "VENDEDOR", 1900, 30));
        empleados.add(new Empleado(7, "FERNANDEZ", "VENDEDOR", 2000, 30));

        empleados.add(new Empleado(8, "PEREZ", "ADMIN", 1700, 10));
        empleados.add(new Empleado(9, "GOMEZ", "ADMIN", 1650, 10));

        empleados.add(new Empleado(10, "TORRES", "DEV", 3000, 40));
        empleados.add(new Empleado(11, "NAVARRO", "DEV", 3100, 40));

        empleados.add(new Empleado(12, "RAMOS", "RRHH", 2200, 50));
        empleados.add(new Empleado(13, "SUAREZ", "RRHH", 2100, 50));

        empleados.add(new Empleado(14, "CASTRO", "MARKETING", 2400, 60));
        empleados.add(new Empleado(15, "BLANCO", "MARKETING", 2300, 60));

        empleados.add(new Empleado(16, "ROMERO", "LOGISTICA", 2600, 70));
        empleados.add(new Empleado(17, "HERRERA", "LOGISTICA", 2550, 70));

        empleados.add(new Empleado(18, "VEGA", "CALIDAD", 2700, 80));
        empleados.add(new Empleado(19, "CANO", "INVESTIGACION", 3500, 90));
        empleados.add(new Empleado(20, "MORALES", "COMPRAS", 2800, 100));

        proyectos.add(new Proyecto(1, "ERP", 120000, 20));
        proyectos.add(new Proyecto(2, "APP WEB", 80000, 20));
        proyectos.add(new Proyecto(3, "CRM", 60000, 30));
        proyectos.add(new Proyecto(4, "NOMINAS", 40000, 50));
        proyectos.add(new Proyecto(5, "STOCK", 90000, 70));
        proyectos.add(new Proyecto(6, "CALIDAD TOTAL", 70000, 80));
        proyectos.add(new Proyecto(7, "IA ANALYTICS", 200000, 90));
        proyectos.add(new Proyecto(8, "E-COMMERCE", 150000, 30));
        proyectos.add(new Proyecto(9, "LOGISTICA 4.0", 110000, 70));
        proyectos.add(new Proyecto(10, "AUDITORIA", 50000, 10));


        for (Empleado e : empleados) {

            Departamento d = buscarDepartamento(e.getDeptId());

            if (d != null) {
                d.addEmpleado(e);
            }
        }

        buscarEmpleado(1).addEspecialidad("Java");
        buscarEmpleado(1).addEspecialidad("Spring");
        buscarEmpleado(1).addEspecialidad("SQL");

        buscarEmpleado(2).addEspecialidad("Java");
        buscarEmpleado(2).addEspecialidad("Oracle");

        buscarEmpleado(3).addEspecialidad("Analisis");
        buscarEmpleado(3).addEspecialidad("UML");
        buscarEmpleado(3).addEspecialidad("Testing");
        buscarEmpleado(3).addEspecialidad("Scrum");

        buscarEmpleado(5).addEspecialidad("Ventas");
        buscarEmpleado(5).addEspecialidad("Marketing");
        buscarEmpleado(5).addEspecialidad("CRM");

        asignar(1, 1);
        asignar(1, 2);

        asignar(2, 1);

        asignar(3, 7);

        asignar(5, 3);
        asignar(5, 8);

        asignar(8, 1);   // ERP tendrá empleados de varios departamentos

        asignar(10, 4);

        asignar(16, 5);
        asignar(17, 5);

        asignar(20, 9);

    }


    private static Empleado buscarEmpleado(int id) {

        for (Empleado e : empleados) {

            if (e.getId() == id) {
                return e;
            }

        }

        return null;
    }

    private static Departamento buscarDepartamento(int id) {

        for (Departamento d : departamentos) {

            if (d.getId() == id) {
                return d;
            }

        }

        return null;
    }

    private static Proyecto buscarProyecto(int id) {

        for (Proyecto p : proyectos) {

            if (p.getId() == id) {
                return p;
            }

        }

        return null;
    }

    private static void asignar(int idEmpleado, int idProyecto) {

        Empleado emp = buscarEmpleado(idEmpleado);
        Proyecto pro = buscarProyecto(idProyecto);

        if (emp != null && pro != null) {

            emp.addProyecto(pro);
            pro.addEmpleado(emp);

        }

    }

}