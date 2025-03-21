import paquetes.Verificador;

public class Main {
    public static void main(String[] args) {
        Verificador calcular = new Verificador();
        System.out.println(calcular.esPositivoYPar(2));
	System.out.println(calcular.esPositivoYPar(-2));
	System.out.println(calcular.esPositivoYPar(3));
	
    }
}
