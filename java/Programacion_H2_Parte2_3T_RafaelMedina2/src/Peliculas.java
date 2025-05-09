import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Peliculas {
    public static void verPeliculas() {
        Connection conexion = Conexion.conectar(); //Creamos la conexion

        if (conexion != null) {
            try {
                Statement stmt = conexion.createStatement(); //Preparamos el objeto para hacer las consultas sobre la conexion
                // guardamos la consulta en una variable
                String consulta = "SELECT p.idPelicula, p.titulo, p.director, p.duracion, p.año, c.nombre " +
                                  "FROM Pelicula p JOIN Categoria c ON p.idCategoria = c.idCategoria";
                //ejecutamos la consulta
                ResultSet rs = stmt.executeQuery(consulta);

                System.out.printf("%-10s %-25s %-20s %-10s %-5s %-15s\n",
                        "ID", "TITULO", "DIRECTOR", "DURACION", "AÑO", "CATEGORIA");
                System.out.println("----------------------------------------------------------------------------");

                while (rs.next()) {
                    System.out.printf("%-10s %-25s %-20s %-10d %-5d %-15s\n",
                            rs.getString("idPelicula"),
                            rs.getString("titulo"),
                            rs.getString("director"),
                            rs.getInt("duracion"),
                            rs.getInt("año"),
                            rs.getString("nombre"));
                }

                stmt.close();
                conexion.close();

            } catch (SQLException e) {
                System.out.println("ERROR AL CONSULTAR: " + e.getMessage());
            }
        }
    }
}