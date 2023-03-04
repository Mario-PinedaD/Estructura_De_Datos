package Estructura_De_Datos.Unidad2.Actividades;
import java.util.Scanner;
/*
* Factorial sin recursividad
* */

public class Act2_Factorial_Recursividad {
    public static void main(String[] args){
        Scanner teclado = new Scanner( System.in );
        int num, factorial;

        System.out.print("Introduce un numero: ");
        num=teclado.nextInt();
        System.out.println("\n");
        factorial=1;

        for (int i=num;i>0;i--)
        {
            factorial=factorial*i;

        }
        System.out.println("El factorial de " + num + " es: " + factorial);

    }

}
