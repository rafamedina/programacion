package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Facturas {

    // Método para buscar si el cliente ya existe por email
    public boolean buscarFactura(int idFactura) {
        Connection conexion = Conexion.conectar();
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            if (conexion != null) {
                String query = "SELECT * FROM Facturas_Recibidas WHERE id_factura=?";
                psSelect = conexion.prepareStatement(query);
                psSelect.setInt(1, idFactura);
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
    public boolean insertarFactura(int idProveedor, String fecha, double total) {

        Connection conexion = Conexion.conectar();
        PreparedStatement psInsert = null;

        try {
            if (conexion != null) {
                String query = "INSERT INTO Facturas_Recibidas (id_proveedor, fecha, total) VALUES (?, ?, ?)";
                psInsert = conexion.prepareStatement(query);
                psInsert.setInt(1, idProveedor);
                psInsert.setString(2, fecha);
                psInsert.setDouble(3, total);
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
    public void mostrarFacturas() {
        Connection conexion = Conexion.conectar();
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            if (conexion != null) {
                String query = "SELECT * FROM Facturas_Recibidas";
                psSelect = conexion.prepareStatement(query);
                rs = psSelect.executeQuery();

                while (rs.next()) {
                    System.out.printf("%-10s %-25s %-20s %-15s\n",
                            rs.getInt("id_factura"),
                            rs.getString("id_proveedor"),
                            rs.getString("fecha"),
                            rs.getString("total"));
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
    public boolean eliminarFactura(int idFactura) {
        if (!buscarFactura(idFactura)) {
            return false;  // Cliente no encontrado
        }

        Connection conexion = Conexion.conectar();
        PreparedStatement psDelete = null;

        try {
            if (conexion != null) {
                String query = "DELETE FROM Facturas_Recibidas WHERE id_factura=?";
                psDelete = conexion.prepareStatement(query);
                psDelete.setInt(1, idFactura);
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
    public boolean editarFactura(int idProveedor, String fecha, double total, int idFactura) {

        Connection conexion = Conexion.conectar();
        PreparedStatement psUpdate = null;

        try {
            if (conexion != null) {
                String query = "UPDATE Facturas_Recibidas SET id_proveedor=?, fecha=?,total=? WHERE id_factura=?";
                psUpdate = conexion.prepareStatement(query);
                psUpdate.setInt(1, idProveedor);
                psUpdate.setString(2, fecha);
                psUpdate.setDouble(3, total);
                psUpdate.setInt(4, idFactura);
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