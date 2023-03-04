package Estructura_De_Datos.Unidad2.Tareas;
import java.util.Scanner;

//Realizar un programa que devuelva si el numero ingresado es primo o nel
public class T1_Devuelve_NumPrimos {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un numero: ");
        int numero = sc.nextInt();
        System.out.printf("%nEl numero %d ", numero);
        System.out.print(numeroPrimo(numero, 2)?"es un numero primo.":"no es un numero primo.");
    }
    private static boolean numeroPrimo(int num, int divisor){
        if(num/2 < divisor){
            return true;
        } else {
            if(num%divisor==0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }
}
