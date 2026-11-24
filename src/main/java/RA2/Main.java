package RA2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperacionesEmpleados empleados = new OperacionesEmpleados();
        OperacionesAlumnos alumnos = new OperacionesAlumnos();
        int opcion = - 1;

        do {
            System.out.println("\\n========== APLICACIÓN JDBC UNIFICADA ==========");
            System.out.println("--- ALUMNOS (base de datos aplicacion1jdbc) ---");
            System.out.println("1. Mostrar todos los alumnos");
            System.out.println("2. Insertar alumno");
            System.out.println("3. Insertar alumno verificando ID");
            System.out.println("4. Modificar nota por ID");
            System.out.println("5. Borrar alumno por ID");
            System.out.println("6. Mostrar primer registro");
            System.out.println("7. Mostrar último registro");
            System.out.println("8. Mostrar segundo y tercer registro");
            System.out.println("9. Mostrar penúltimo registro");
            System.out.println("10. Mostrar columnas de la tabla alumnos");
            System.out.println("11. Generar HTML simple de alumnos");
            System.out.println("12. Generar HTML con encabezado rojo");
            System.out.println("13. Generar HTML con filas coloreadas");
            System.out.println("--- EMPLEADOS (base de datos aplicacion2jdbc) ---");
            System.out.println("14. Mostrar empleados del departamento 10");
            System.out.println("15. Mostrar empleado con mayor salario");
            System.out.println("16. Insertar empleado");
            System.out.println("17. Mostrar empleados por departamento");
            System.out.println("18. Exportar empleados a HTML");
            System.out.println("19. Mostrar vendedores");
            System.out.println("20. Mostrar empleados dept. 10 (versión Java)");
            System.out.println("21. Mostrar empleado con mayor salario (versión Java)");
            System.out.println("22. Mostrar empleados por departamento (versión Java)");
            System.out.println("23. Exportar empleados a HTML (versión Java)");
            System.out.println("24. Mostrar vendedores (versión Java)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = - 1;
            }

            switch (opcion) {
                case 1 -> alumnos.listarTodosAlumnos();
                case 2 -> alumnos.insertarAlumnoBasico();
                case 3 -> alumnos.insertarAlumnoVerificandoID();
                case 4 -> alumnos.modificarNotaAlumno();
                case 5 -> alumnos.borrarAlumnoPorID();
                case 6 -> alumnos.listarPrimerRegistro();
                case 7 -> alumnos.listarUltimoRegistro();
                case 8 -> alumnos.listarSegundoTercerRegistro();
                case 9 -> alumnos.listarPenultimoRegistro();
                case 10 -> alumnos.visualizarColumnas();
                case 11 -> alumnos.MostrarAlumnosHTML();
                case 12 -> alumnos.MostrarAlumnosHTMLEncabezadoRojo();
                case 13 -> alumnos.MostrarAlumnosHTMLFilasColoreadas();
                case 14 -> empleados.mostrarEmpleadosDept10();
                case 15 -> empleados.mostrarEmpleadoMaxSalario();
                case 16 -> {
                    try {
                        System.out.print("Emp_no: ");
                        int empNo = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Oficio: ");
                        String oficio = sc.nextLine();
                        System.out.print("Dir: ");
                        int dir = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Salario: ");
                        double salario = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("Comisión: ");
                        int comision = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Dept_no: ");
                        int dept = Integer.parseInt(sc.nextLine().trim());
                        empleados.insertarEmpleado(empNo, apellido, oficio, dir, salario, comision, dept);
                    } catch (NumberFormatException e) {
                        System.out.println("Dato numérico no válido.");
                    }
                }
                case 17 -> {
                    try {
                        System.out.print("Dept_no: ");
                        empleados.mostrarEmpleadosPorDept(Integer.parseInt(sc.nextLine().trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Número de departamento no válido.");
                    }
                }
                case 18 -> empleados.exportarHTML();
                case 19 -> empleados.mostrarVendedores();
                case 20 -> empleados.mostrarEmpleadosDept10VersionJava();
                case 21 -> empleados.mostrarEmpleadoMaxSalarioVersionJava();
                case 22 -> {
                    try {
                        System.out.print("Dept_no: ");
                        empleados.mostrarEmpleadosPorDeptVersionJava(Integer.parseInt(sc.nextLine().trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Número de departamento no válido.");
                    }
                }
                case 23 -> empleados.exportarHTMLVersionJava();
                case 24 -> empleados.mostrarVendedoresVersionJava();
                case 0 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
