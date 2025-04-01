package ejercicio72;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]matriz= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		for (int fila = 0; fila < matriz.length; fila++) {
		    for (int columna = 0; columna < matriz[fila].length; columna++) {
		        System.out.print(matriz[fila][columna] + " ");
		    }
		    System.out.println();
		}

	}

}
