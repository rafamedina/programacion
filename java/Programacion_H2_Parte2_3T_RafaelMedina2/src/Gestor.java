import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Gestor {

    // FUNCION PARA AÑADIR UNA NUEVA PELICULA A LA BASE DE DATOS
	public static void anadirPelicula() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("ID DE LA PELICULA: ");
	    String id = scanner.nextLine();

	    Connection conexion = Conexion.conectar();
	    if (conexion != null) {
	        try {
	            String consulta = "SELECT * FROM Pelicula WHERE idPelicula = ?";
	            PreparedStatement psConsulta = conexion.prepareStatement(consulta);
	            psConsulta.setString(1, id);
	            ResultSet rs = psConsulta.executeQuery();

	            if (rs.next()) {
	                System.out.println("YA EXISTE UNA PELICULA CON ESE ID.");
	                return;
	            } else {
	                System.out.print("TITULO: ");
	                String titulo = scanner.nextLine();
	                System.out.print("DIRECTOR: ");
	                String director = scanner.nextLine();
	                System.out.print("DURACION (MINUTOS): ");
	                int duracion = scanner.nextInt();
	                System.out.print("AÑO: ");
	                int año = scanner.nextInt();
	                scanner.nextLine(); 

	                // NUEVO BLOQUE: Pido el nombre de la categoría
	                System.out.print("NOMBRE DE LA CATEGORIA: ");
	                String nombreCategoria = scanner.nextLine();

	                String buscarCategoria = "SELECT idCategoria FROM Categoria WHERE nombre = ?";
	                PreparedStatement psCat = conexion.prepareStatement(buscarCategoria);
	                psCat.setString(1, nombreCategoria);
	                ResultSet rsCat = psCat.executeQuery();

	                if (!rsCat.next()) {
	                    System.out.println("ESA CATEGORIA NO EXISTE.");
	                    return;
	                }

	                int idCategoria = rsCat.getInt("idCategoria");

	                // Inserto la película con el ID de categoría obtenido
	                String insert = "INSERT INTO Pelicula VALUES (?, ?, ?, ?, ?, ?)";
	                PreparedStatement psInsert = conexion.prepareStatement(insert);
	                psInsert.setString(1, id);
	                psInsert.setString(2, titulo);
	                psInsert.setString(3, director);
	                psInsert.setInt(4, duracion);
	                psInsert.setInt(5, año);
	                psInsert.setInt(6, idCategoria);

	                psInsert.executeUpdate();
	                System.out.println("PELICULA AÑADIDA CORRECTAMENTE.");
	            }

	            conexion.close();

	        } catch (SQLException e) {
	            System.out.println("ERROR AL AÑADIR PELICULA: " + e.getMessage());
	        }
	    }
	}


    // FUNCION PARA ELIMINAR UNA PELICULA
    public static void eliminarPelicula() {
        Scanner scanner = new Scanner(System.in);

        // Pido al usuario el ID de la película que quiere borrar
        System.out.print("ID DE LA PELICULA A ELIMINAR: ");
        String id = scanner.nextLine();

        // Me conecto a la base de datos
        Connection conexion = Conexion.conectar();
        if (conexion != null) {
            try {
                // Preparo la consulta para eliminar usando el ID
                String delete = "DELETE FROM Pelicula WHERE idPelicula = ?";
                PreparedStatement ps = conexion.prepareStatement(delete);
                ps.setString(1, id);

                // Ejecuto la eliminación
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    // Si se eliminó alguna fila, informo que fue borrada
                    System.out.println("PELICULA ELIMINADA.");
                    
                } else {
                    // Si no se eliminó nada, es porque no existe esa película
                    System.out.println("NO EXISTE UNA PELICULA CON ESE ID.");
                    return;
                }
                

                // Cierro la conexión
                conexion.close();

            } catch (SQLException e) {
                // Capturo errores de SQL y los muestro
                System.out.println("ERROR AL ELIMINAR: " + e.getMessage());
            }
        }
    }

    // FUNCION PARA MODIFICAR DOS CAMPOS DE UNA PELICULA
    public static void modificarPelicula() {
        Scanner scanner = new Scanner(System.in);

        // Pido el ID de la película que se quiere modificar
        System.out.print("ID DE LA PELICULA A MODIFICAR: ");
        String id = scanner.nextLine();

        // Me conecto a la base de datos
        Connection conexion = Conexion.conectar();
        if (conexion != null) {
            try {
                // Compruebo que la película exista
                String check = "SELECT * FROM Pelicula WHERE idPelicula = ?";
                PreparedStatement psCheck = conexion.prepareStatement(check);
                psCheck.setString(1, id);
                ResultSet rs = psCheck.executeQuery();

                if (!rs.next()) {
                    System.out.println("NO EXISTE UNA PELICULA CON ESE ID.");
                    return;
                } else {
                    // Pido los nuevos datos
                    System.out.print("NUEVO TITULO: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("NUEVO DIRECTOR: ");
                    String nuevoDirector = scanner.nextLine();
                    System.out.print("NUEVA DURACION (MINUTOS): ");
                    int nuevaDuracion = scanner.nextInt();
                    System.out.print("NUEVO AÑO: ");
                    int nuevoAño = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("NUEVA CATEGORIA (NOMBRE): ");
                    String nuevaCategoriaNombre = scanner.nextLine();

                    // Busco el ID de la nueva categoría
                    String buscarCategoria = "SELECT idCategoria FROM Categoria WHERE nombre = ?";
                    PreparedStatement psCat = conexion.prepareStatement(buscarCategoria);
                    psCat.setString(1, nuevaCategoriaNombre);
                    ResultSet rsCat = psCat.executeQuery();

                    if (!rsCat.next()) {
                        System.out.println("ESA CATEGORIA NO EXISTE.");
                        return;
                    }

                    int nuevoIdCategoria = rsCat.getInt("idCategoria");

                    // Actualizo todos los campos de la película
                    String update = "UPDATE Pelicula SET titulo = ?, director = ?, duracion = ?, año = ?, idCategoria = ? WHERE idPelicula = ?";
                    PreparedStatement psUpdate = conexion.prepareStatement(update);
                    psUpdate.setString(1, nuevoTitulo);
                    psUpdate.setString(2, nuevoDirector);
                    psUpdate.setInt(3, nuevaDuracion);
                    psUpdate.setInt(4, nuevoAño);
                    psUpdate.setInt(5, nuevoIdCategoria);
                    psUpdate.setString(6, id);

                    psUpdate.executeUpdate();
                    System.out.println("PELICULA MODIFICADA CORRECTAMENTE.");
                }

                conexion.close();

            } catch (SQLException e) {
                System.out.println("ERROR AL MODIFICAR: " + e.getMessage());
            }
        }
    }

}

