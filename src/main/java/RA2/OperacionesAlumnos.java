package RA2;

import java.sql.*;
import java.util.Scanner;

public class OperacionesAlumnos {

    public boolean verificarIDExistente(int id) {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        try (Connection conn = ConexionAlumnos.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return true; // El ID ya existe
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Devuelve false si ocurre un error o el ID no existe
    }

    // OPCION 1
    public static void listarTodosAlumnos() {
        String sql = "SELECT * FROM alumnos";

        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Nombre        : " + rs.getString("nombre"));
                System.out.println("Apellido      : " + rs.getString("apellido"));
                System.out.println("Edad          : " + rs.getInt("edad"));
                System.out.println("Nota          : " + rs.getInt("nota"));
            }

        } catch (SQLException e) {
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
            System.out.print("Ingrese el ID del alumno: ");
            int id;
            id = sc.nextInt();
            if (verificarIDExistente(id)) {
                System.out.println("Error: El ID ya existe en la base de datos. Por favor, ingrese un ID diferente.");
                return; // Salir del método si el ID ya existe
            }
            sc.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Ingrese los apellidos del alumno: ");
            String apellido = sc.nextLine().trim();
            // Validación 2: la edad debe tener como máximo dos dígitos
            int edad;
            System.out.println("Ingrese la edad del alumno: ");
            edad = sc.nextInt();
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
        String sql = "UPDATE alumnos SET NOTA = ? WHERE ID = ?";
        try (Connection conn = ConexionAlumnos.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexión establecida correctamente a la base de datos.");
            System.out.print("Ingrese el ID del alumno: ");
            int id = sc.nextInt();
            if (verificarIDExistente(id)) {
                System.out.println("Error: El ID ya existe en la base de datos. Por favor, ingrese un ID diferente.");
                return; // Salir del método si el ID ya existe
            }
            sc.nextLine(); // Limpiar el buffer de entrada
            System.out.println("Ingrese la nota del alumno: ");
            int nota = sc.nextInt();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setInt(2, nota);
                System.out.println(ps.executeUpdate() > 0 ? "Nota modificada correctamente." : "Error al modificar la nota.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos:");
            e.printStackTrace();
        }
    }

    // OPCION 5
    public void borrarAlumnoPorID() {
        String sql = "DELETE FROM alumnos WHERE ID = ?";
        try (Connection conn = ConexionAlumnos.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Conexión establecida correctamente a la base de datos.");
            System.out.print("Ingrese el ID del alumno: ");
            int id = sc.nextInt();
            if (! verificarIDExistente(id)) {
                System.out.println("Error: El ID no existe en la base de datos. Por favor ingrese un ID diferente.");
                return; // Salir del método si el ID no existe
            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                System.out.println(ps.executeUpdate() > 0 ? "Alumno eliminado correctamente." : "Error al eliminar el alumno.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos:");
            e.printStackTrace();
        }
    }

    // OPCION 6
    public void listarPrimerRegistro() {
        String sql = "SELECT * FROM alumnos ORDER BY id ASC LIMIT 1";
        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Nombre        : " + rs.getString("nombre"));
                System.out.println("Apellido      : " + rs.getString("apellido"));
                System.out.println("Edad          : " + rs.getInt("edad"));
                System.out.println("Nota          : " + rs.getInt("nota"));
            } else {
                System.out.println("La tabla alumnos está vacía.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OPCION 7
    public void listarUltimoRegistro() {
        String sql = "SELECT * FROM alumnos ORDER BY id DESC LIMIT 1";
        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Nombre        : " + rs.getString("nombre"));
                System.out.println("Apellido      : " + rs.getString("apellido"));
                System.out.println("Edad          : " + rs.getInt("edad"));
                System.out.println("Nota          : " + rs.getInt("nota"));
            } else {
                System.out.println("La tabla alumnos está vacía.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OPCION 8
    public void listarSegundoTercerRegistro() {
        String sql = "SELECT * FROM alumnos ORDER BY id ASC LIMIT 2 OFFSET 1";
        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Nombre        : " + rs.getString("nombre"));
                System.out.println("Apellido      : " + rs.getString("apellido"));
                System.out.println("Edad          : " + rs.getInt("edad"));
                System.out.println("Nota          : " + rs.getInt("nota"));
            } else {
                System.out.println("La tabla alumnos está vacía.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OPCION 9
    public void listarPenultimoRegistro() {
        String sql = "SELECT * FROM alumnos ORDER BY id DESC LIMIT 1 OFFSET 1";
        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Nombre        : " + rs.getString("nombre"));
                System.out.println("Apellido      : " + rs.getString("apellido"));
                System.out.println("Edad          : " + rs.getInt("edad"));
                System.out.println("Nota          : " + rs.getInt("nota"));
            } else {
                System.out.println("La tabla alumnos está vacía.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OPCION 10
    public void visualizarColumnas() {
        String sql = "SELECT * FROM alumnos";
        try (Connection conn = ConexionAlumnos.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            ResultSetMetaData resultado = rs.getMetaData();
            int numerocolumnas = resultado.getColumnCount();
            System.out.println("Número de columnas recuperadas: " + numerocolumnas);
            for (int i = 1; i <= numerocolumnas; i++) {
                System.out.println("Columna " + i + ":");
                System.out.println("  Nombre : " + resultado.getColumnName(i));
                System.out.println("  Tipo   : " + resultado.getColumnTypeName(i));
                System.out.println("  ¿Puede ser nula? : " + (resultado.isNullable(i) == ResultSetMetaData.columnNoNulls ? "NO" : "SI"));
                System.out.println("  Máximo ancho de la columna: " + resultado.getColumnDisplaySize(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OPCION 11
    public void MostrarAlumnosHTML() {
        // Implementación para generar HTML simple de alumnos
    }

    // OPCION 12
    public void MostrarAlumnosHTMLEncabezadoRojo() {
        // Implementación para generar HTML con encabezado rojo
    }

    // OPCION 13
    public void MostrarAlumnosHTMLFilasColoreadas() {
        // Implementación para generar HTML con filas coloreadas
    }
}