package paquetes;

public class Acciones {

    public void pasoUno() {
       	System.out.println("Ejecutando paso 1");
    }

    public void pasoDos() {
	pasoUno();
       	System.out.println("Ejecutando paso 2");
    }
}
