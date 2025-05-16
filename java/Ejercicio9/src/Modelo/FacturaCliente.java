package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaCliente {

    public void mostrar() {
        Connection conexion = Conexion.conectar();
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        String sql = "SELECT c.id_cliente, c.nombre AS nombre_cliente, a.nombre AS articulo, v.cantidad, " +
                     "a.precio_unitario, (v.cantidad * a.precio_unitario) AS total_linea, v.fecha_venta " +
                     "FROM Ventas v " +
                     "JOIN Clientes c ON v.id_cliente = c.id_cliente " +
                     "JOIN Articulos a ON v.id_articulo = a.id_articulo " +
                     "ORDER BY c.id_cliente, v.fecha_venta;";

        try {
            if (conexion != null) {
                psSelect = conexion.prepareStatement(sql);
                rs = psSelect.executeQuery();

                System.out.printf("%-10s %-25s %-20s %-10s %-15s %-15s %-15s\n",
                        "ID CLIENTE", "NOMBRE CLIENTE", "ARTICULO", "CANTIDAD",
                        "PRECIO UNITARIO", "TOTAL LINEA", "FECHA VENTA");

                while (rs.next()) {
                    System.out.printf("%-10d %-25s %-20s %-10d %-15.2f %-15.2f %-15s\n",
                            rs.getInt("id_cliente"),
                            rs.getString("nombre_cliente"),
                            rs.getString("articulo"),
                            rs.getInt("cantidad"),
                            rs.getDouble("precio_unitario"),
                            rs.getDouble("total_linea"),
                            rs.getDate("fecha_venta").toString());
                }
            } else {
                System.out.println("NO SE HA PODIDO ESTABLECER CONEXION CON LA BASE DE DATOS.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL MOSTRAR LAS FACTURAS POR CLIENTE.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (psSelect != null) psSelect.close();
                if (conexion != null) conexion.close(); // IMPORTANTE: cerrar conexión si ya no se reutiliza
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



