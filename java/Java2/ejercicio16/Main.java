import paquetes.Verificador;

public class Main {
    public static void main(String[] args) {
        Verificador verificador = new Verificador();
        System.out.println(verificador.esMayorYPar(2));
	System.out.println(verificador.esMayorYPar(11));
	System.out.println(verificador.esMayorYPar(12));
    }
}