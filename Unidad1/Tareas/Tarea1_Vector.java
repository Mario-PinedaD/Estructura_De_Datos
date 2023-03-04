package Estructura_De_Datos.Unidad1.Tareas;
import java.util.Scanner;

public class Tarea1_Vector {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] Posiciones = new int[15];
        for (int i = 0; i < Posiciones.length; i++) {
            System.out.printf("Porfavor Introduzca un numero: ");
            Posiciones[i] = sc.nextInt();
        }
        System.out.printf("Los numeros son: ");
        for (int i = 0; i < Posiciones.length; i++) {
            System.out.printf((Posiciones[i]) + ", ");
        }
    }
}