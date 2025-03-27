package entornos;
/**
*
*/

import java.util.InputMismatchException;
import java.util.Scanner;

/**
*
*/
public class Fibonacci_1 {
   /**
    * @param args n: número entero positivo
    */
  
   static int f(int n) {
       int result = 0;
      
       if (n <= 1) {
           result = 1;
       } else if (n > 1){
           result = f(n-2) + f(n-1);
       }
      
       return result;
   }
  
    public static void main(String[] args) {
       // TODO Auto-generated method stub
        System.out.println("Introduce un número");
        Scanner sc = new Scanner(System.in);
        
       try {
           int n = sc.nextInt();
          
           if (n >= 0) {
               System.out.printf("F(%d) = %d", n, f(n));
           } else {
               System.err.println("El número no puede ser negativo");
           }
       } catch (InputMismatchException e) {
           System.err.println("El formáto del número es incorrecto");
       }
      
       sc.close();
   }
}
