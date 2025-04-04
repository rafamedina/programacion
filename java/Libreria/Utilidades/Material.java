package Utilidades;

public abstract class Material {
	   String codigo;
	String titulo;
	   int año;
	
	
	public Material(String codigo, String titulo, int año) {
		this.codigo=codigo;
		this.titulo=titulo;
		this.año=año;	
	}
	

	abstract void mostrar();
	
	public String getCodigo() {
		return codigo;
	}
	
	
}
