package RA2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        // Implementación para insertar un alumno básico
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