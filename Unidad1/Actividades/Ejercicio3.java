package Estructura_De_Datos.Unidad1.Actividades;

public class Ejercicio3 {//Arreglo Multidimensional
    public static void main(String[] args) {

        int[][][] Arreglito = new int[10][20][30];
        //pa llenar
        for (int i = 0; i <10; i++) {
            for (int j = 0; j <20; j++) {
                for (int k = 0; k <30; k++){
                    Arreglito[i][j][k]=(int) (Math.random()*10);
                }}}
        //Pa imprimir
        for (int i=0; i< Arreglito.length;i++){
            for (int j=0;j<Arreglito.length;j++){
                for (int k=0;k< Arreglito.length;k++){
                    System.out.println("arr[" + i + "][" + j + "][" + k + "] = " + Arreglito[i][j][k]+" ");
                }
            }
        }
        System.out.println("");
    }
}
