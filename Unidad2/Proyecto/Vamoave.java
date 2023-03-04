package Estructura_De_Datos.Unidad2.Proyecto;
import java.util.*;

public class Vamoave {
    //son los que ponen los "margenes" en las separaciones
    private static String BrechaAbierta = "|";
    private static String BrechaCerrada = "|";
    private static String Vacio = "";

    // Función para dividir una string en todas las combinaciones posibles de
    // subcadenas no superpuestas encerradas entre paréntesis
    public static void recursar(String cadena, int i, String salida)
    {
        // caso base
        if (cadena == null || cadena.length() == 0) {//Si la cadena es 0 o no hay no da nada
            return ;
        }

        if (i == cadena.length()) { //Si i es del mismo
            System.out.println(salida);
        }

        // considera cada subcadena S[i, j]
        for (int j = cadena.length() - 1; j >= i; j--)
        {
            /*  */
            String nuevacadena = BrechaAbierta + cadena.substring(i, j + 1) + BrechaCerrada;

            // agregar la subcadena al resultado y repetir con un índice de
            // el siguiente caracter a ser procesado y la string de resultado
            recursar(cadena, j + 1, salida + nuevacadena);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca una cadena de letras: ");
        String s = sc.next();

        int ElementosDeinicio = 0; //Determinan cuantos elementos del inicio se quieren eliminar
        recursar(s, ElementosDeinicio, Vacio);//Decimos que la salida es ""
    }
}