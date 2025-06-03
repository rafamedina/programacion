package Default;

import java.util.ArrayList;

public class UsuarioController {
	UsuarioView vUsuario = new UsuarioView() ;
	UsuarioDAO daoUsuario = new UsuarioDAO();
	
	ArrayList<Usuario>usuarios = new ArrayList<>();
	
	public void manejo() {
		try { 
		daoUsuario.insertarUsuarios(usuarios);
		} catch (Exception e ) {
			vUsuario.mostrarMensaje("Que te jodan");
		}
	}
		
	
	
	
	
	public void eliminar() {
		try {
		int id = vUsuario.pedirID();
		daoUsuario.EliminarUsuario(id);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
