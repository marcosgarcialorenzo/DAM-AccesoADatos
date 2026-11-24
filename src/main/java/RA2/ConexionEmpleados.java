package RA2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionEmpleados {

    private static final String URL = "jdbc:mysql://localhost:3306/aplicacion2jdbc";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}