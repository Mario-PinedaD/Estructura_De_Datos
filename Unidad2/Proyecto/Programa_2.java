package Estructura_De_Datos.Unidad2.Proyecto;
import java.util.Scanner;

public class Programa_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String cadena;

        System.out.println("Introduzca una palabra, considerando que entre mayor sea su longitud mas tardará el programa" +
                " de ser posible no pase de 5 letras");
        cadena = sc.next();
        combinaciones(cadena);
    }

    public static void combinaciones(String str) {
        // Inicialmente se llama a la función sin prefijo y con la cadena completa
        //Este crea un prefijo vacio para despues utilizar el método siguiente
        combinaciones("", str);
    }

    private static void combinaciones(String prefijo, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefijo);
        else {
            for (int i = 0; i < n; i++){
                // Se vuelve a llamar a la función con el prefijo (inicialmente null) más la siguiente letra de la cadena.

                combinaciones(prefijo + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }
}
