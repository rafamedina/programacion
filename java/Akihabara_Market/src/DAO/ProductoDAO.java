package DAO;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Model.ProductoOtaku;
import Model.DatabaseConnection;
public class ProductoDAO {

	ProductoOtaku productoOtaku = new ProductoOtaku(); // Instancia base, no se usa directamente aquí

	public void AgregarProducto(ProductoOtaku producto) {
		// Me conecto a la base de datos y preparo un INSERT para guardar el nuevo producto.
		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		try {
			if(conexion != null) {
				String Sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?,?,?,?) ";
				stmt = conexion.prepareStatement(Sql);
				// Asigno los valores del objeto ProductoOtaku al statement
				stmt.setString(1, producto.getNombre());
				stmt.setString(2, producto.getCategoria());
				stmt.setDouble(3, producto.getPrecio());
				stmt.setInt(4, producto.getStock());
				stmt.executeUpdate(); // Ejecuto el INSERT
				System.out.println("Producto Agregado Correctamente");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AGREGANDO PRODUCTO " + e.getMessage());
		} finally {
			// Siempre cierro recursos para evitar fugas de memoria o bloqueo de conexiones
			try {
				if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
			}
		}
	}

	public ProductoOtaku obtenerProductoPorId(int id) {
	    // Busco un producto por su ID específico. Si lo encuentro, lo devuelvo como objeto.
	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    ProductoOtaku producto = null;

	    try {
	        if (conexion != null) {
	            String sql = "SELECT id, nombre, categoria, precio, stock FROM productos WHERE id = ?";
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id); // Paso el ID como parámetro
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                // Si hay resultados, construyo el objeto con los datos de la BD
	                producto = new ProductoOtaku(
	                	rs.getInt("id"),
	                	rs.getString("nombre"),
	                	rs.getString("categoria"),
	                	rs.getDouble("precio"),
	                	rs.getInt("stock")
	                );
	            } else {
	                System.out.println("NO SE ENCONTRO NINGUN PRODUCTO CON ESE ID");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR AL OBTENER PRODUCTO: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
	        }
	    }

	    return producto;
	}

	public List<ProductoOtaku> obtenerTodosLosProductos() {
	    // Este método trae todos los productos de la tabla y los guarda en una lista.
	    List<ProductoOtaku> lista = new ArrayList<>();

	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        if (conexion != null) {
	            String sql = "SELECT * FROM productos";
	            stmt = conexion.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                // Recorro cada fila del resultado y creo un objeto por cada producto
	                ProductoOtaku producto = new ProductoOtaku(
	                	rs.getInt("id"),
	                	rs.getString("nombre"),
	                	rs.getString("categoria"),
	                	rs.getDouble("precio"),
	                	rs.getInt("stock")
	                );
	                lista.add(producto); // Lo agrego a la lista
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR AL OBTENER PRODUCTOS: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
	        }
	    }

	    return lista; // Devuelvo la lista completa
	}

	public boolean actualizarProducto(ProductoOtaku producto) {
		// Actualizo un producto existente en la base, usando su ID como referencia.
		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		boolean actualizado = false;

		try {
			if(conexion != null) {
				String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
				stmt = conexion.prepareStatement(sql);
				// Cargo los datos actualizados al statement
				stmt.setString(1, producto.getNombre());
				stmt.setString(2, producto.getCategoria());
				stmt.setDouble(3, producto.getPrecio());
				stmt.setInt(4, producto.getStock());
				stmt.setInt(5, producto.getId());

				int filasAfectadas = stmt.executeUpdate();

				// Si al menos una fila fue afectada, el producto se actualizó correctamente
				if (filasAfectadas > 0) {
					System.out.println("PRODUCTO ACTUALIZADO CORRECTAMENTE");
					actualizado = true;
				} else {
					System.out.println("NO SE ENCONTRO NINGUN PRODUCTO CON ESE ID");
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR ACTUALIZANDO CLIENTE " + e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conexion != null) conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
			}
		}

		return actualizado;
	}

	public boolean eliminarProducto(int id) {
	    // Borro un producto de la base de datos si existe con el ID dado.
	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    boolean eliminado = false;

	    try {
	        if (conexion != null) {
	            String sql = "DELETE FROM productos WHERE id = ?";
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            int filasAfectadas = stmt.executeUpdate();

	            if (filasAfectadas > 0) {
	                System.out.println("PRODUCTO ELIMINADO CORRECTAMENTE");
	                eliminado = true;
	            } else {
	                System.out.println("NO SE ENCONTRO NINGUN PRODUCTO CON ESE ID");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR ELIMINANDO PRODUCTO: " + e.getMessage());
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            System.out.println("ERROR AL CERRAR CONEXION: " + e.getMessage());
	        }
	    }

	    return eliminado;
	}

	public List<ProductoOtaku> buscarProductosPorNombre(String nombre){
		// Busco productos que coincidan exactamente con el nombre dado (sensible a mayúsculas si no uso collation).
		List<ProductoOtaku> lista = new ArrayList<>();

		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			if (conexion != null) {
				String sql = "SELECT * FROM productos WHERE nombre COLLATE utf8mb4_general_ci = ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, nombre);
				rs = stmt.executeQuery();

				if (rs.next()) {
					// Si hay coincidencia, creo el objeto y lo agrego a la lista
					ProductoOtaku producto = new ProductoOtaku(
						rs.getInt("id"),
						nombre,
						rs.getString("categoria"),
						rs.getDouble("precio"),
						rs.getInt("stock")
					);
					lista.add(producto);
				} else {
					System.out.println("NO SE ENCONTRO NINGUN PRODUCTO");
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL OBTENER PRODUCTO: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conexion != null) conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
			}
		}

		return lista;
	}
}

	
	
	
		
		















		
		
