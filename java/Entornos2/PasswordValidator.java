import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean isValid = false;

        // While: Reintentos hasta 3 veces
        while (attempts < 3 && !isValid) {
            System.out.println("Ingrese su contraseña: ");
            String password = scanner.nextLine();

            // If-else: Validar fortaleza
            if (password.length() < 8) {
                System.err.println("La contraseña debe tener al menos 8 caracteres.");
            } else {
                // For: Verificar si tiene al menos un número
                boolean hasNumber = false;
                for (char c : password.toCharArray()) {
                    if (Character.isDigit(c)) {
                        hasNumber = true;
                        break;
                    }
                }

                if (!hasNumber) {
                    System.err.println("La contraseña debe incluir al menos un número.");
                } else {
                    isValid = true;
                    System.err.println("¡Contraseña válida!");
                }
            }

            attempts++;
            if (!isValid && attempts < 3) {
                System.err.println("Intento " + (attempts + 1) + " de 3.");
            }
        }

        if (!isValid) {
            System.err.println("Demasiados intentos. Cuenta bloqueada.");
        }

        scanner.close();
    }
}
