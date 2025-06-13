package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static Connection conectar() {
        String url = "jdbc:h2:~/akihabara_db";  // Ruta del archivo de base de datos (local)
        String usuario = "sa"; // Usuario predeterminado
        String contraseña = ""; // Contraseña predeterminada

        try {
            // Intentamos conectar a la base de datos H2
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Si la conexión es exitosa, creamos las tablas si no existen
            crearTablas(conexion);

            System.out.println("Conexión establecida con la base de datos H2.");
            return conexion;
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
            return null;
        }
    }

    // Método para crear las tablas 'productos' y 'clientes' si no existen
    private static void crearTablas(Connection conexion) {
        try (Statement stmt = conexion.createStatement()) {
            // SQL para crear la tabla 'productos' si no existe
            String createTableProductosSQL = "CREATE TABLE IF NOT EXISTS productos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "categoria VARCHAR(100), "
                    + "precio DECIMAL(10, 2), "
                    + "stock INT)";
            stmt.executeUpdate(createTableProductosSQL);
            System.out.println("Tabla 'productos' creada o ya existente.");

            // SQL para crear la tabla 'clientes' si no existe
            String createTableClientesSQL = "CREATE TABLE IF NOT EXISTS clientes ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(255) NOT NULL UNIQUE, "
                    + "telefono VARCHAR(20), "
                    + "fecha_registro DATE DEFAULT CURRENT_DATE)";
            stmt.executeUpdate(createTableClientesSQL);
            System.out.println("Tabla 'clientes' creada o ya existente.");

        } catch (SQLException e) {
            System.out.println("ERROR AL CREAR LAS TABLAS: " + e.getMessage());
        }
    }
}



