package RA2;

import java.sql.*;
import java.util.Scanner;

public class OperacionesAlumnos {

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

    public void insertarAlumnoBasico() {
        try (Connection conn = ConexionAlumnos.getConnection();
             Scanner sc = new Scanner(System.in)) {

            String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("ID: "); int id = sc.nextInt();
            System.out.print("Nombre: "); String nombre = sc.next();
            System.out.print("Apellido: "); String apellido = sc.next();
            System.out.print("Edad: "); int edad = sc.nextInt();
            System.out.print("Nota: "); double nota = sc.nextDouble();

            ps.setInt(1, id); ps.setString(2, nombre); ps.setString(3, apellido);
            ps.setInt(4, edad); ps.setDouble(5, nota);

            int filas = ps.executeUpdate();
            System.out.println(filas > 0 ? "Alumno insertado correctamente." : "Error al insertar.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarAlumnoVerificandoID() {
        // Implementación para insertar un alumno verificando ID
    }


    public void modificarNotaAlumno() {
        // Implementación para modificar la nota de un alumno
    }

    public void borrarAlumnoPorID() {
        // Implementación para borrar un alumno por ID
    }

    public void listarPrimerRegistro() {
        // Implementación para listar el primer registro
    }

    public void listarUltimoRegistro() {
        // Implementación para listar el último registro
    }

    public void listarSegundoTercerRegistro() {
        // Implementación para listar el segundo y tercer registro
    }

    public void listarPenultimoRegistro() {
        // Implementación para listar el penúltimo registro
    }

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