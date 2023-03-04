package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tarea3_Multidimensional {
    public static void main(String[] args) {

        int Arreglo[][][]=new int[2][3][4];//igual cambié los valores
        Scanner sc=new Scanner(System.in);

        for (int i=0;i<=1;i++){
            for (int j=0;j<=2;j++){
                for (int k=0;k<3;k++){
                    System.out.printf("Digite los contenidos: Arreglo["+i+"]["+j+"]["+k+"]");
                    Arreglo[i][j][k]=sc.nextInt();
                }
            }
        }

        System.out.printf("El Arreglo es: ");
        for (int i=0;i<=1;i++){
            for (int j=0;j<=2;j++){
                for (int k=0;k<3;k++){
                    System.out.print(Arreglo[i][j][k]+" ");
                }
            }
        }
    }
}

