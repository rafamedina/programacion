package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection conectar() {
        // Este método se encarga de establecer la conexión con la base de datos.
        // Defino la URL de conexión, el usuario y la contraseña.
        String url = "jdbc:mysql://localhost:3306/akihabara_db"; // Dirección y nombre de la base de datos
        String usuario = "root"; // Usuario de la base de datos
        String contraseña = "1234"; // Contraseña del usuario

        try {
            // Intento conectarme usando los datos anteriores.
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            // Si la conexión es exitosa, la devuelvo.
            return conexion;
        } catch (SQLException e) {
            // Si hay un error al conectar, lo informo y devuelvo null para que el programa pueda manejarlo.
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
            return null;
        }
    }
}
