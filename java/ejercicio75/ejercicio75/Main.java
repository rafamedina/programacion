package ejercicio75;
import java.util.HashSet;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> colores = new HashSet<>();
		colores.add("azul");
		colores.add("verde");
		colores.add("azul");
		System.out.println(colores.size());
		System.out.println(colores);
	}

}
