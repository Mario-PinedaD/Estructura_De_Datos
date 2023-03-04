package Estructura_De_Datos.Unidad2.Actividades;

/*
* Algoritmo recursivo que descomponga numeros primos
* */

import java.util.*;

public class Act4_Descomponer_Primos {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int m = leer.nextInt();
        System.out.println("Los factores primo son:");
        FactoresPrimos(m);
        System.out.println("\n");
    }


    public static void FactoresPrimos(int n){
        if (esPrimo(n)){
            System.out.print("*"+n+" ");
            return;
        }
        int factor1 = (int) Math.sqrt(n);
        while (n % factor1 !=0) {
            factor1++;
        }
        FactoresPrimos(factor1);
        FactoresPrimos(n/factor1);

    }


    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0) {
                primo = false;
            }
            if (numero == 1) {
                primo = true;
                return primo;
            }
            contador++;
        }
        return primo;
    }

}
