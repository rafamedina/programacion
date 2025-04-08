package ejercicio83;

public class EmpleadoPorHoras extends Empleado implements Pagable {
    double horasTrabajadas;
    double tarifaHora;

    public EmpleadoPorHoras(int id, String nombre, double horasTrabajadas, double tarifaHora) {
        super(id, nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalarioMensual() {
        return horasTrabajadas * tarifaHora;
    }
}

