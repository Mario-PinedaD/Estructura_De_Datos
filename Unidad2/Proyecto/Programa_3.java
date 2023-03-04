package Estructura_De_Datos.Unidad2.Proyecto;
import java.util.Scanner;

public class Programa_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=0,n2=0;

        System.out.println("Este es el programa de la multiplicacion rusa");
        System.out.println("Solamente ingrese numeros ENTEROS y Positivos :D");
        System.out.println("Introduzca un valor: ");//Se introduce el primer numero
        n1=sc.nextInt();
        System.out.println("Introduzca otro valor: ");//Se introduce el segundo numero
        n2=sc.nextInt();

        System.out.println("\nEl resultado de la multiplicacion es: " + multiplicacionRusa(n1,n2));
    }


    public static int multiplicacionRusa(int a,int b){
        if (a==1){ //si el primer multiplo es 1, pues se devuelve el valor inicial
            return b;
        }if (a%2!=0) { //si el módulo de 2 es diferente de 0
            return b+multiplicacionRusa(a/2,b*2);
        }else {
            return multiplicacionRusa(a/2,b*2);
        }
    }
}
