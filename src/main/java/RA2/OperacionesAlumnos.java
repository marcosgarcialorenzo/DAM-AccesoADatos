package RA2;

import java.sql.*;
import java.util.Scanner;

import jdk.swing.interop.SwingInterOpUtils;

public class OperacionesAlumnos {

    private static boolean existeAlumno(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id FROM alumnos WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // OPCION 1
    public static void listarTodosAlumnos() {
        String sql = "SELECT * FROM alumnos";

        try (Connection connection = ConexionAlumnos.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Conexión CORRECTA a la base de datos MYSQL.");
            while (resultSet.next()) {
                System.out.println("Identificador : " + resultSet.getInt("id"));
                System.out.println("Nombre        : " + resultSet.getString("nombre"));
                System.out.println("Apellido      : " + resultSet.getString("apellido"));
                System.out.println("Edad          : " + resultSet.getInt("edad"));
                System.out.println("Nota          : " + resultSet.getInt("nota"));
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }

    // OPCION 2
    public void insertarAlumnoBasico() {
        String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionAlumnos.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexión establecida correctamente a la base de datos.");
            // Validación 1: el ID no puede existir ya
            int id;
            while (true) {
                System.out.println("Ingrese el ID del alumno: ");
                id = sc.nextInt();
                if (existeAlumno(conn, id)) {
                    System.out.println("Error: Hay un alumno con ese ID " + id);
                } else {
                    break;
                }
            }
            sc.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Ingrese los apellidos del alumno: ");
            String apellido = sc.nextLine().trim();
            // Validación 2: la edad debe tener como máximo dos dígitos
            int edad;
            while (true) {
                System.out.println("Ingrese la edad del alumno: ");
                edad = sc.nextInt();
                if (edad < 0 || edad > 99) {
                    System.out.println("Error: La edad debe tener como máximo dos dígitos.");
                } else {
                    break;
                }
            }
            sc.nextLine(); // Limpiar el buffer de entrada
            System.out.println("Ingrese la nota del alumno: ");
            int nota = sc.nextInt();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setInt(4, edad);
                ps.setInt(5, nota);
                if (ps.executeUpdate() > 0) {
                    System.out.println("El registro ha sido insertado correctamente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos:");
            e.printStackTrace();
        }
    }

    // OPCION 4
    public void modificarNotaAlumno() {
        // Implementación para modificar la nota de un alumno
    }

    // OPCION 5
    public void borrarAlumnoPorID() {
        // Implementación para borrar un alumno por ID
    }

    // OPCION 6
    public void listarPrimerRegistro() {
        // Implementación para listar el primer registro
    }

    // OPCION 7
    public void listarUltimoRegistro() {
        // Implementación para listar el último registro
    }

    // OPCION 8
    public void listarSegundoTercerRegistro() {
        // Implementación para listar el segundo y tercer registro
    }

    // OPCION 9
    public void listarPenultimoRegistro() {
        // Implementación para listar el penúltimo registro
    }

    // OPCION 10
    public void visualizarColumnas() {
        // Implementación para visualizar las columnas de la tabla alumnos
    }

    public void MostrarAlumnosHTML() {
        // Implementación para generar HTML simple de alumnos
    }

    public void MostrarAlumnosHTMLEncabezadoRojo() {
        // Implementación para generar HTML con encabezado rojo
    }

    public void MostrarAlumnosHTMLFilasColoreadas() {
        // Implementación para generar HTML con filas coloreadas
    }
}