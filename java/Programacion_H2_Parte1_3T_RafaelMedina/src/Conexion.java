import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/cine_RafaelMedina"; // Database
        String usuario = "root"; // User
        String contraseña = "1234"; // Password

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡CONEXION EXITOSA!");
            return conexion;
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
            return null;
        }
    }
}