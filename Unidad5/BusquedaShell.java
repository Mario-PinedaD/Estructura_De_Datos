package Estructura_De_Datos.Unidad5;
import java.util.Random;
import java.util.Scanner;

public class BusquedaShell {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int Arreglo[]=new int [20];
        int numero=0,i,j,k,incremento,aux;

        do {
            System.out.print("\n\nIngrese dimension del arreglo: ");
            numero=teclado.nextInt();

            for(i=1;i<=numero;i++){//Se introducen los valores del arreglo
                System.out.print("A["+i+"]= ");
                Arreglo[i]=teclado.nextInt();
            }


            incremento=numero/2;

            while(incremento>0){
                for(i=incremento+1;i<=numero;i++){
                    j=i-incremento;
                    while(j>0){
                        if(Arreglo[j]>=Arreglo[j+incremento]){
                            aux = Arreglo[j];
                            Arreglo[j] = Arreglo[j+incremento];
                            Arreglo[j+incremento] = aux;
                        }
                        else{
                            j=0;
                        }
                        j=j-incremento;
                    }
                }
                incremento=incremento/2;
            }


            System.out.println("EL ARREGLO ORDENADO");
            for(i=1;i<=numero;i++){
                System.out.print(" "+Arreglo[i]);
            }

        }while (numero!=0);

    }
}
class BusquedaQuicksort{
static int n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("\nIngrese la cantidad de datos: ");
            n=sc.nextInt();
            int[] v =new int[n];
            generar(v);
            mostrar(v);
            System.out.println("Elementos ordenados: ");

            quick(0,(v.length-1),v);
            mostrar(v);
        }while (n!=0);
    }

    static void mostrar(int[] v){
        System.out.println();
        for (int i=0;i<v.length;i++){
            System.out.print(v[i]+" - ");
        }
        System.out.println();
    }

    static void generar(int[] v){
        Random r=new Random();
        for (int i=0;i<v.length;i++){
            v[i]=r.nextInt(20);
        }
    }

    static void quick(int primero, int ultimo, int[] v){
        int i = primero, j = ultimo;
        int central = v[(primero+ultimo) / 2];

        do {
            while (central > v[i]){
                i++;
            }
            while (central < v[j]){
                j--;
            }
            if (i <= j){
                int temp=v[i];
                v[i]=v[j];
                v[j]=temp;
                i++;
                j--;
            }
        }while (i <= j);

        if (primero < j){
            quick(primero, j, v);
        }
        if (ultimo > i){
            quick(i, ultimo, v);
        }
    }
}
