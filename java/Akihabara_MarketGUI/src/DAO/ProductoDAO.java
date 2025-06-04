package DAO;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Model.ProductoOtaku;
import Model.DatabaseConnection;
public class ProductoDAO {
	
	
	ProductoOtaku productoOtaku = new ProductoOtaku();
	
	public void AgregarProducto(ProductoOtaku producto) {
		Connection conexion = DatabaseConnection.conectar();
		PreparedStatement stmt = null;
		try {
			if(conexion !=null) {
				String Sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?,?,?,?) ";
				
				stmt = conexion.prepareStatement(Sql);
				stmt.setString(1, producto.getNombre());
				stmt.setString(2, producto.getCategoria());
				stmt.setDouble(3, producto.getPrecio());
				stmt.setInt(4, producto.getStock());
				stmt.executeUpdate();
				System.out.println("Producto Agregado Correctamente");
				
			}
		} catch (SQLException e) {
			System.out.println("ERROR AGREGANDO PRODUCTO " + e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CERRAR CONEXIONES: " + e.getMessage());
		}
	}
	}

	public ProductoOtaku obtenerProductoPorId(int id) {
	    Connection conexion = DatabaseConnection.conectar();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    ProductoOtaku producto = null;

	    try {
	        if (conexion != null) {
	            String sql = "SELECT id, nombre, categoria, precio, stock FROM productos WHERE id = ?";
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                int idBD = rs.getInt("id");
	                String nombre = rs.getString("nombre");
	                String categoria = rs.getString("categoria");
	                double precio = rs.getDouble("precio");
	                int stock = rs.getInt("stock");

	                producto = new ProductoOtaku(idBD, nombre, categoria, precio, stock);
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
	                int id = rs.getInt("id");
	                String nombre = rs.getString("nombre");
	                String categoria = rs.getString("categoria");
	                double precio = rs.getDouble("precio");
	                int stock = rs.getInt("stock");

	                ProductoOtaku producto = new ProductoOtaku(id, nombre, categoria, precio, stock);
	                lista.add(producto);
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

	    return lista;
	}

		
	public boolean actualizarProducto(ProductoOtaku producto) {
		 Connection conexion = DatabaseConnection.conectar();
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    boolean actualizado = false;
		    try {
		    	if(conexion != null) {
		    		String sql = "Update productos set nombre = ?, categoria = ?, precio = ?, stock =? where id = ?";
		    		stmt = conexion.prepareStatement(sql);
		    		stmt.setString(1, producto.getNombre());
					stmt.setString(2, producto.getCategoria());
					stmt.setDouble(3, producto.getPrecio());
					stmt.setInt(4, producto.getStock());
					stmt.setInt(5, producto.getId());
					 int filasAfectadas = stmt.executeUpdate();

			            if (filasAfectadas > 0) {
			                System.out.println("PRODUCTO ACTUALIZADO CORRECTAMENTE");
			                actualizado = true;
			            } else {
			                System.out.println("NO SE ENCONTRO NINGUN PRODUCTO CON ESE ID");
			            }
			        }
			    } catch (SQLException e) {
		    	System.out.println("ERROR ACTUALIZANDO CLIENTE " + e.getMessage());
		    }finally {
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
		List<ProductoOtaku> lista = new ArrayList<>();
		
		  Connection conexion = DatabaseConnection.conectar();
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    ProductoOtaku producto = null;

		    try {
		        if (conexion != null) {
		            String sql = "SELECT * FROM productos WHERE nombre COLLATE utf8mb4_general_ci = ?";
		            stmt = conexion.prepareStatement(sql);		   
		            stmt.setString(1, nombre);
		            rs = stmt.executeQuery();

		            if (rs.next()) {
		            	int id = rs.getInt("id");
		                String categoria = rs.getString("categoria");
		                double precio = rs.getDouble("precio");
		                int stock = rs.getInt("stock");

		                producto = new ProductoOtaku(id, nombre, categoria, precio, stock);
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

	
	
	
		
		















		
		
