package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tarea2_Matriz {
    public static void main(String[] args) {

        int Arreglo[][]=new int[2][5];//Aqui debe de ser de 10*20, pero me dijo que podía cambialo
        Scanner sc=new Scanner(System.in);

        for (int i=0;i<=1;i++){
            for (int j=0;j<=4;j++){
                System.out.printf("Digite los contenidos: Arreglo["+i+"]["+j+"]: ");
                Arreglo[i][j]=sc.nextInt();
            }
        }

        System.out.printf("El Arreglo es: ");
        for (int i=0;i<=1;i++){
            for (int j=0;j<=4;j++){
                System.out.print(Arreglo[i][j]+" ");
            }
        }
    }
}
