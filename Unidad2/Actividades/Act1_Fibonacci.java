package Estructura_De_Datos.Unidad2.Actividades;
/*
* Hacer la secuencia de fibonacci utilizando la recursividad
* */
public class Act1_Fibonacci {
    public static void main(String[] args) {
        int maxCount = 25;
        for (int i = 0; i <= maxCount; i++) {
            int fibonacciNumber = printFibonacci(i);
            System.out.print(" " + fibonacciNumber);
        }
    }

    public static int printFibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return printFibonacci(n - 1) + printFibonacci(n - 2);
    }
}
