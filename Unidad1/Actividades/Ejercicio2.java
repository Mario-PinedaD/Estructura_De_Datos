package Estructura_De_Datos.Unidad1.Actividades;

public class Ejercicio2 {//Arreglo bidimensional
    public static void main(String[] args) {

        int[][] Arreglo=new int[10][20];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 20; j++) {
                Arreglo[i][j] = (int) (Math.random()*10);
            }
        }
        //Impresion
        for(int i = 0; i < Arreglo.length; i++){
            for(int j = 0; j < Arreglo[i].length; j++){
                System.out.print(Arreglo[i][j] + " ");	// Imprime elemento
            }
            System.out.println();	// Imprime salto de línea
        }
        }
    }