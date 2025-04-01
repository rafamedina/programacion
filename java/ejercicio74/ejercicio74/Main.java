package ejercicio74;
import java.util.HashMap;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer>personas= new HashMap<>();
		personas.put("RAFA", 24);
		personas.put("Iker", 24);
		personas.put("marcos", 24);
		System.out.println(personas);
		System.out.println(personas.get("RAFA"));
	}

}
