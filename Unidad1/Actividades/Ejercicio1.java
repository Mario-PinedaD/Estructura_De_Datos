package Estructura_De_Datos.Unidad1.Actividades;

public class Ejercicio1 {//Arreglo unidimensional
    public static void main(String[] args) {

        int []Arreglo=new int[10];

        for (int i =0; i< Arreglo.length;i++){
            Arreglo[i] = (int) (Math.random()*10);
        }
        for (int i=0;i<Arreglo.length;i++){
            System.out.print(Arreglo[i]+" ");
        }
    }
}
