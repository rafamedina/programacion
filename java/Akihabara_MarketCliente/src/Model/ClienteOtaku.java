package Model;

import java.sql.Date;

public class ClienteOtaku {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private Date fecha_registro;

    // Este constructor lo uso cuando voy a crear un nuevo producto que aún no tiene ID (el ID se asignará en la base de datos)
    public ClienteOtaku(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        
    }
    
    public ClienteOtaku( String nombre, String email, String telefono, Date fecha_registro) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }

    // Este constructor lo uso cuando ya conozco el ID del producto (por ejemplo, al leer desde la base de datos)
    public ClienteOtaku(int id, String nombre, String email, String telefono, Date fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }

    // Constructor vacío. Lo uso cuando necesito crear un objeto sin valores iniciales.
    public ClienteOtaku() {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

    // Métodos getter y setter para acceder y modificar cada campo del producto
    
}


















