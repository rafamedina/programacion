package Default;

public class Usuario {
private int id;
private String nombre;
private String email;


public Usuario(String nombre,String email) {
	this.nombre=nombre;
	this.email=email;
}

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}

}