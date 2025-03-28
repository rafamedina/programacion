package ejercicio66;

public class triangulo implements Figura {
	int base;
	int altura;
	
	public triangulo(int base,int altura) {
		this.base=base;
		this.altura=altura;
	}

	@Override
	public void calcularArea() {
		// TODO Auto-generated method stub
		System.out.println((base*altura)/2);
	}

}
