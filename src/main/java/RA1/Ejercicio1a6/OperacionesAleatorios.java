package RA1.Ejercicio1a6;

import java.io.IOException;
import java.util.Scanner;

public class OperacionesAleatorios {
    static  final String FICHERO="AleatorioEmple.dat";
    Scanner sc = new Scanner(System.in);
    public void menu() throws IOException {
        int opcion;

        do {
            System.out.println("""
                    
                    ===== MENÚ Ficheros Aleatorios =====
                    1. Escribir un empleado
                    2. Escribir varios empleados
                    3. Leer empleado por ID
                    4. Insertar empleado al final
                    5. Modificar empleado por ID
                    6. Fichero directo (grabar/visualizar/buscar)
                    7. Listar
                    0. salir
                    Seleccione opción:
                    """);

            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {AnadirEmple();}

                case 2 -> {RellenarFichAlea();}

                case 3 -> {LeerPorId();}
                case 4 ->{InsertarAlFinal();}
                case 5 -> {ModEmple();}
                case 6->{
                    Directo d= new Directo();
                d.menu(sc);}
                case 7 ->{Listar();}

                case 0 -> System.out.println("Saliendo...");

                default -> System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);
    }

    private void Listar() throws IOException {
        LeerFichAleatorio leer=new LeerFichAleatorio(FICHERO);
        System.out.println("ID  APELLIDO  DEPARTAMENTO  DEP SALARIO");
        leer.leer();
    }

    private void InsertarAlFinal() throws IOException {
        System.out.println("Ingrese el apellido del empleado: ");
        String apellido = sc.next();
        System.out.println("Ingrese el departamento del empleado: ");
        int departamento = sc.nextInt();
        System.out.println("Ingrese el salario del empleado: ");
        double salario = sc.nextInt();
        InsertarDetras ins=new InsertarDetras(FICHERO,apellido,departamento,salario);
        ins.anadiruno();

    }

    private void LeerPorId() throws IOException {
        System.out.println("Ingrese el id del empleado: ");
        int id = sc.nextInt();
        LeerFichAleatorioUnReg leer=new LeerFichAleatorioUnReg(FICHERO,id);
        leer.LeerUnId();
    }

    private void RellenarFichAlea() throws IOException {
        EscribirFichAleatorio es=new EscribirFichAleatorio(FICHERO);
        es.generarFichAleatorio();

    }

    private void AnadirEmple() throws IOException {
        System.out.println("Ingrese el id del empleado");
        int id = sc.nextInt();
        System.out.println("Ingrese el apellido del empleado: ");
        String apellido = sc.next();
        System.out.println("Ingrese el departamento del empleado: ");
        int departamento = sc.nextInt();
        System.out.println("Ingrese el salario del empleado: ");
        double salario = sc.nextInt();
        EscribirFichAleatorioUnReg es=new EscribirFichAleatorioUnReg(FICHERO,id,apellido,departamento,salario);
        es.anadiruno();
    }
    private void ModEmple() throws IOException {
        System.out.println("Ingrese el id del empleado");
        int id = sc.nextInt();
        System.out.println("Ingrese el apellido del empleado: ");
        String apellido = sc.next();
        System.out.println("Ingrese el departamento del empleado: ");
        int departamento = sc.nextInt();
        System.out.println("Ingrese el salario del empleado: ");
        double salario = sc.nextInt();
        ModEmpleId modEmpleId=new ModEmpleId();
        modEmpleId.mod(FICHERO,id,apellido,departamento,salario);
    }
}
