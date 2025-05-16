package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ventas {

    // Constructor con parámetros
    // Método para buscar si el cliente ya existe por email
    public boolean buscarVentas(int id) {
        Connection conexion = Conexion.conectar();
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            if (conexion != null) {
                String query = "SELECT * FROM Ventas WHERE id_venta=?";
                psSelect = conexion.prepareStatement(query);
                psSelect.setInt(1, id);
                rs = psSelect.executeQuery();

                if (rs.next()) {
                    return true;  // Cliente encontrado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psSelect != null) psSelect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;  // Cliente no encontrado
    }
    // Método para insertar un cliente
    public boolean insertarVentas(int id_cliente, int id_articulo, int cantidad, String fecha_venta) {


        Connection conexion = Conexion.conectar();
        PreparedStatement psInsert = null;

        try {
            if (conexion != null) {
                String query = "INSERT INTO Ventas (id_cliente, id_articulo, cantidad, fecha_venta) VALUES (?,?, ?, ?)";
                psInsert = conexion.prepareStatement(query);
                psInsert.setInt(1, id_cliente);
                psInsert.setInt(2, id_articulo);
                psInsert.setInt(3, cantidad);
                psInsert.setString(4, fecha_venta); 
                psInsert.executeUpdate();
                return true; // Cliente insertado correctamente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psInsert != null) psInsert.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;  // Error al insertar el cliente
    }
    // Método para mostrar todos los clientes
    public void mostrarVentas() {
        Connection conexion = Conexion.conectar();
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            if (conexion != null) {
                String query = "SELECT * FROM Ventas";
                psSelect = conexion.prepareStatement(query);
                rs = psSelect.executeQuery();

                while (rs.next()) {
                    System.out.printf("%-10s %-25s %-20s %-15s %-20s\n",
                            rs.getInt("id_venta"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_articulo"),
                            rs.getInt("cantidad"),
                            rs.getString("fecha_venta"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psSelect != null) psSelect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Método para eliminar un cliente por email
    public boolean eliminarVenta(int id) {


        Connection conexion = Conexion.conectar();
        PreparedStatement psDelete = null;

        try {
            if (conexion != null) {
                String query = "DELETE FROM Ventas WHERE id_venta=?";
                psDelete = conexion.prepareStatement(query);
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
                return true; // Cliente eliminado correctamente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psDelete != null) psDelete.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;  // Error al eliminar el cliente
    }
    // Método para editar un cliente
    public boolean editarVentas(int id_cliente, int id_articulo, int cantidad, String fecha_venta, int id_ventas) {


        Connection conexion = Conexion.conectar();
        PreparedStatement psUpdate = null;

        try {
            if (conexion != null) {
                String query = "UPDATE Ventas SET id_cliente=?, id_articulo=?, cantidad=?,fecha_venta=?  WHERE id_venta=?";
                psUpdate = conexion.prepareStatement(query);
                psUpdate.setInt(1, id_cliente);
                psUpdate.setInt(2, id_articulo);
                psUpdate.setInt(3, cantidad);
                psUpdate.setString(4, fecha_venta);
                psUpdate.setInt(5, id_ventas);
                psUpdate.executeUpdate();
                return true; // Cliente actualizado correctamente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psUpdate != null) psUpdate.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;  // Error al actualizar el cliente
    }
}




