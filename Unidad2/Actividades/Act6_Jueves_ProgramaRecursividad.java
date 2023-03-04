package Estructura_De_Datos.Unidad2.Actividades;
import java.util.*;
// 2 programas recursivos y que nosotros lo inventemos

public class Act6_Jueves_ProgramaRecursividad {
    public static void main(String[] args) {
        Scanner en=new Scanner(System.in);
        int n,m=30;
        Programa1 P1=new Programa1();
        Programa3 P3=new Programa3();

        System.out.println("Para el programa 1, Introduzca el numero que desea sumar: ");
        P1.sum(n=en.nextInt());
        System.out.println("Resultado del programa uno: " + P1.sum(n));
        System.out.println("El resultado del programa 2 es: " );
        decre(m);
        System.out.println("El resultado del programa 3 (el que suma los digitos de un numero es) es: "+P3.potencia(3,3));


    }
    //ESto debería ir en el programa 2 pero la verdad no pude hacerlo como objeto XD
    static void decre(int n)//Este a diferencia muestra todos los numeros desde n hasta 1, como decrementa
    {
        if(n>0)
        {
            System.out.print(n);
            decre(n-1);
        }
        else
            System.out.println();
    }


}

class Programa1{

    static int sum(int n) //ESte programa suma todos los numeros desde 0 hasta n;

    {
        //Si el numero es igual a 1
        if(n==1)
            return 1;

            //llamada recursiva
        else
            return n+sum(n-1);
    }

}

class Programa3 { // Este programa permite sumar los digitos de un numero
    static int potencia (int x, int n)
    {
        int aux;
        if (n==0) {
            return 1;
        } else {
            aux = potencia(x, n / 2);
            if (n % 2 == 0)
                return aux * aux;
            else
                return x * aux * aux;
        }
    }
}