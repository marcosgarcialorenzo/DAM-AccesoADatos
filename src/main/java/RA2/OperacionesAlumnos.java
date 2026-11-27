package RA2;

import java.sql.*;
import java.util.Scanner;

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
        try (Connection conn = ConexionAlumnos.getConnection();
             Scanner sc = new Scanner(System.in)) {
            String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Nombre: ");
            String nombre = sc.next();
            System.out.print("Apellido: ");
            String apellido = sc.next();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Nota: ");
            double nota = sc.nextDouble();
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setInt(4, edad);
            ps.setDouble(5, nota);
            int filas = ps.executeUpdate();
            System.out.println(filas > 0 ? "Alumno insertado correctamente." : "Error al insertar.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //OPCION 3
    public void insertarAlumnoVerificandoID() {
        String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionAlumnos.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexión establecida correctamente a la base de datos.");

            // Validación 1: el ID no puede existir ya
            int id;
            while (true) {
                System.out.println("Introduce el ID del alumno:");
                id = sc.nextInt();
                if (existeAlumno(conn, id)) {
                    System.out.println("Error: Hay un alumno con ese ID " + id);
                } else {
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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