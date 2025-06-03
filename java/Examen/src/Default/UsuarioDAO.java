package Default;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
public class UsuarioDAO {
	Connection conexion;
	Usuario usuario;
	
	public void insertarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		try {
			conexion = Conexion.getConnection();
			}catch(SQLException e){
				System.out.println("Error de conexion" + e.getMessage());
			}
		
		try {
			
			String sql = "INSERT INTO usuarios (nombre, email) VALUES (?,?)";
			 stmt = conexion.prepareStatement(sql);
			 stmt.setString(1, usuario.getNombre());
			 stmt.setString(2, usuario.getEmail());
			 stmt.executeUpdate();
			 stmt.close();
			 conexion.close();
		} catch (SQLException e) {
			System.out.println("Error " + e.getMessage());
		}
		
	
	}
	public void insertarUsuarios(ArrayList<Usuario>usuarios) {
		
		for(Usuario u : usuarios) {
			insertarUsuario(u);
			
	}
	}
	
		public void EliminarUsuario(int id) {
			
			PreparedStatement stmt = null;
			try {
				conexion = Conexion.getConnection();
				}catch(SQLException e){
					System.out.println("Error de conexion" + e.getMessage());
				}
			
			try {
				
				String sql = "delete from usuarios where id = ?";
				 stmt = conexion.prepareStatement(sql);
				 stmt.setInt(1, id);
				 stmt.executeUpdate();
				 stmt.close();
				 conexion.close();
			} catch (SQLException e) {
				System.out.println("Error " + e.getMessage());
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
