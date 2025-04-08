package ejercicio83;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Empleado> empleados = new HashMap<>();

        empleados.put(1, new EmpleadoPorHoras(1, "Rafa", 160, 15));
        empleados.put(2, new EmpleadoFijo(2, "Iker", 18720));

        for (Empleado empleado : empleados.values()) {
            System.out.println("Empleado: " + empleado.nombre + 
                               ", Salario mensual: " + ((Pagable) empleado).calcularSalarioMensual());
        }
    }
}

