package ejercicio73;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>tareas = new ArrayList<>();
		tareas.add("Sacar Perro");
		tareas.add("hacer Java");
		tareas.add("Boxeo");
		System.out.println(tareas);
		tareas.remove(2);
		System.out.println(tareas);
	}

}
