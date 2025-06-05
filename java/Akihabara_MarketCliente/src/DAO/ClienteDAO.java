package DAO;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Model.ProductoOtaku;
import Model.ClienteOtaku;
import Model.DatabaseConnection;
public class ClienteDAO {

	ClienteOtaku clienteotaku = new ClienteOtaku(); // Instancia base, no se usa directamente aquí

	public void agregarCliente(ClienteOtaku cliente) {
		// Me conecto a la base de datos y preparo un INSERT para guardar el nuevo producto.
		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		try {
			if(conexion != null) {
				ClienteOtaku buscarcliente=buscarPorEmail(cliente.getEmail());
				if(buscarcliente == null) {
				String Sql = "INSERT INTO clientes (nombre, email, telefono, fecha_registro) VALUES (?,?,?,CURDATE()) ";
				stmt = conexion.prepareStatement(Sql);
				// Asigno los valores del objeto ProductoOtaku al statement
				stmt.setString(1, cliente.getNombre());
				stmt.setString(2, cliente.getEmail());
				stmt.setString(3, cliente.getTelefono());
				stmt.executeUpdate(); // Ejecuto el INSERT
				System.out.println("Cliente Agregado Correctamente");
			}
			} else {
				System.out.println("YA EXISTE ESE CLIENTE");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AGREGANDO CLIENTE " + e.getMessage());
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

	public ClienteOtaku obtenerClientePorId(int id) {
	    // Busco un producto por su ID específico. Si lo encuentro, lo devuelvo como objeto.
	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    ClienteOtaku cliente = null;

	    try {
	        if (conexion != null) {
	            String sql = "SELECT * FROM clientes WHERE id = ?";
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id); // Paso el ID como parámetro
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                // Si hay resultados, construyo el objeto con los datos de la BD
					cliente = new ClienteOtaku(
	                	rs.getInt("id"),
	                	rs.getString("nombre"),
	                	rs.getString("email"),
	                	rs.getString("telefono"),
	                	rs.getDate("fecha_registro")
	                );
	            } else {
	                System.out.println("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID");
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

	    return cliente;
	}

	public List<ClienteOtaku> obtenerTodosLosClientes() {
	    // Este método trae todos los productos de la tabla y los guarda en una lista.
	    List<ClienteOtaku> lista = new ArrayList<>();

	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        if (conexion != null) {
	            String sql = "SELECT * FROM clientes";
	            stmt = conexion.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                // Si hay resultados, construyo el objeto con los datos de la BD
	            	ClienteOtaku cliente = new ClienteOtaku(
	                	rs.getInt("id"),
	                	rs.getString("nombre"),
	                	rs.getString("email"),
	                	rs.getString("telefono"),
	                	rs.getDate("fecha_registro")
	                );
	                lista.add(cliente); // Lo agrego a la lista
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR AL OBTENER CLIENTES: " + e.getMessage());
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

	public boolean actualizarCliente(ClienteOtaku cliente) {
		// Actualizo un producto existente en la base, usando su ID como referencia.
		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		boolean actualizado = false;

		try {
			if(conexion != null) {
				String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ?, fecha_registro = ? WHERE id = ?";
				stmt = conexion.prepareStatement(sql);
				// Cargo los datos actualizados al statement
				stmt.setString(1, cliente.getNombre());
				stmt.setString(2, cliente.getEmail());
				stmt.setString(3, cliente.getTelefono());
				stmt.setDate(4, cliente.getFecha_registro());
				stmt.setInt(5, cliente.getId());

				int filasAfectadas = stmt.executeUpdate();

				// Si al menos una fila fue afectada, el producto se actualizó correctamente
				if (filasAfectadas > 0) {
					System.out.println("CLIENTE ACTUALIZADO CORRECTAMENTE");
					actualizado = true;
				} else {
					System.out.println("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID");
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

	public boolean eliminarCliente(int id) {
	    // Borro un producto de la base de datos si existe con el ID dado.
	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    boolean eliminado = false;

	    try {
	        if (conexion != null) {
	            String sql = "DELETE FROM clientes WHERE id = ?";
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            int filasAfectadas = stmt.executeUpdate();

	            if (filasAfectadas > 0) {
	                System.out.println("CLIENTE ELIMINADO CORRECTAMENTE");
	                eliminado = true;
	            } else {
	                System.out.println("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR ELIMINANDO CLIENTE: " + e.getMessage());
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

	public ClienteOtaku buscarPorEmail(String email){
		// Busco productos que coincidan exactamente con el nombre dado (sensible a mayúsculas si no uso collation).
		

		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ClienteOtaku cliente = null;
		try {
			if (conexion != null) {
				String sql = "SELECT * FROM clientes WHERE email COLLATE utf8mb4_general_ci = ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, email);
				rs = stmt.executeQuery();

				if (rs.next()) {
	                // Si hay resultados, construyo el objeto con los datos de la BD
					cliente = new ClienteOtaku(
	                	rs.getInt("id"),
	                	rs.getString("nombre"),
	                	rs.getString("email"),
	                	rs.getString("telefono"),
	                	rs.getDate("fecha_registro")
	                );
				} else {
					System.out.println("NO SE ENCONTRO NINGUN CLIENTE");
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL OBTENER CLIENTE: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conexion != null) conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
			}
		}

		return cliente;
	}
}

	
	
	
		
		















		
		
