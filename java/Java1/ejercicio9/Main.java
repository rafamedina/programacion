import paquetes.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        usuario.setNombre("Carlos");

        System.out.println("El nombre del usuario es: " + usuario.getNombre());
    }
}
