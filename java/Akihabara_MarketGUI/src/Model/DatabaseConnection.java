package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/akihabara_db"; // Database
        String usuario = "root"; // User
        String contraseña = "1234"; // Password

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            return conexion;
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
            return null;
        }
    }
}