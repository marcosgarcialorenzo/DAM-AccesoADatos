package RA6.Examen;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Utilidades ut = new Utilidades();
        Scanner sc = new Scanner(System.in);
        int op;

        Datos.cargarDatos();

        do {

            System.out.println("\n============= MENU =============");
            System.out.println("1  - Insertar Departamento");
            System.out.println("2  - Insertar Empleado");
            System.out.println("3  - Insertar Proyecto");
            System.out.println("4  - Mostrar Departamentos");
            System.out.println("5  - Mostrar Empleados");
            System.out.println("6  - Mostrar Proyectos");
            System.out.println("7  - Mostrar el empleado que esta justo en el medio");
            System.out.println("8  - Mostrar los Empleados con salario mayor que la media del departamento");
            System.out.println("9 -  Mostrar los Empleados con salario máximo del departamento");
            System.out.println("10 - Mostrar los Empleados con más de un proyecto");
            System.out.println("11 - Mostrar los Proyectos con empleados de varios departamentos");
            System.out.println("12 - Mostrar los empleados con sus proyectos");
            System.out.println("13 - Mostrar los departamentos con sus empleados");
            System.out.println("14 - Mostrar los proyectos con sus empleados");
            System.out.println("15 - Mostrar los empleados por oficio (dado un oficio)");
            System.out.println("16 - Mostrar los empleados con más de dos especialidades");
            System.out.println("0  - Salir");
            System.out.print("\nOpción: ");

            op = sc.nextInt();

            switch (op) {

                case 1 -> {

                    System.out.print("Id departamento: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Localidad: ");
                    String localidad = sc.nextLine();

                    ut.insertarDepartamento(new Departamento(id, nombre, localidad));
                }

                case 2 -> {

                    System.out.print("Id empleado: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Oficio: ");
                    String oficio = sc.nextLine();

                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();

                    System.out.print("Departamento: ");
                    int dept = sc.nextInt();

                    ut.insertarEmpleado(
                            new Empleado(id, apellido, oficio, salario, dept));
                }

                case 3 -> {

                    System.out.print("Id proyecto: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Presupuesto: ");
                    double presupuesto = sc.nextDouble();

                    System.out.print("Departamento responsable: ");
                    int dept = sc.nextInt();

                    ut.insertarProyecto(
                            new Proyecto(id, nombre, presupuesto, dept));
                }

                case 4 -> ut.mostrarDepartamentos();

                case 5 -> ut.mostrarEmpleados();

                case 6 -> ut.mostrarProyectos();

                case 7 -> ut.empleadoCentral();

                case 8 -> ut.salarioMayorMediaDep();

                case 9 -> ut.salarioMaxDep();

                case 10 -> ut.empMasDeUnProyecto();

                case 11 -> ut.proyectosMultiDept();

                case 12 -> ut.empConProyectos();

                case 13 -> ut.depConEmpleados();

                case 14 -> ut.proyectosConEmpleados();

                case 15 -> {

                    sc.nextLine();

                    System.out.print("Introduzca el oficio a buscar: ");
                    String oficio = sc.nextLine();

                    ut.empleadosPorOficio(oficio);
                }

                case 16 -> ut.masDeDosEspecialidades();

                case 0 -> System.out.println("\nFin del programa.");

                default -> System.out.println("\nOpción no válida.");
            }

        } while (op != 0);
        sc.close();
    }
}