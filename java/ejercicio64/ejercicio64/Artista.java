package ejercicio64;

public class Artista implements Cantante, Bailarin {

	@Override
	public void bailar() {
		System.out.println("el artista baila");

	}

	@Override
	public void cantar() {
		System.out.println("el artista canta");

	}

}
