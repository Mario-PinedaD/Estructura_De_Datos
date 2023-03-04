package Estructura_De_Datos.Unidad2.Proyecto;
import java.util.Scanner;
public class Proyecto_Recursividad {

    //Realizar 3 codigos distintos utilizando recursividad
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        /*========== Aqui van mis variables ================*/

        int opcion=0,n1=0,n2=0;
        String palabraprograma;

        /*==================================================*/


        do {
            System.out.println("\n**********************\nQue programa desea ejecutar?" +
                    "\n1.-Programa 1: Invierte el orden de una palabra" +
                    "\n2.-Programa 2: Muestra las combinaciones posibles de una cadena de letras" +
                    "\n3.-Prgrama 3: Multiplicacion rusa" +
                    "\n4.-Salir" +
                    "\nIngrese la opcion que desea:");
            opcion=sc.nextInt();

            switch (opcion){
            case 1:
                System.out.println("Ejecutando el programa 1");
                System.out.println("Ingrese la palabra que quiere invertir: ");
                palabraprograma=sc.next();
                System.out.println("La palabra invertida es: "+invertirPalabra(palabraprograma));
                System.out.println("Volviendo al menu");

                break;
            case 2:
                System.out.println("En teoría aqui va el 2");
                System.out.println("Introduzca una palabra, considerando que entre mayor sea su longitud mas tardará el programa" +
                        " de ser posible no pase de 5 letras");
                String cadena = sc.next();
                combinaciones(cadena);

                break;
            case 3:
                System.out.println("Este es el programa de la multiplicacion rusa");
                System.out.println("Solamente ingrese numeros ENTEROS :D");
                System.out.println("Introduzca un valor: ");
                n1=sc.nextInt();
                System.out.println("Introduzca otro valor: ");
                n2=sc.nextInt();

                System.out.println("\nEl resultado de la multiplicacion es: " + multiplicacionRusa(n1,n2));
                break;
            case 4:
                System.out.println("Hasta la proxima");
        }
    }while (opcion!=4);
}

/*======================================================*/
public static String invertirPalabra(String palabra){//Esta va a invertir el orden de una palabra cualsea

    if((palabra==null)||(palabra.length()<=1)){
        return palabra;
    }else{
        return invertirPalabra(palabra.substring(1))+palabra.charAt(0);
        }
}

    public static void combinaciones(String str) {

        // Inicialmente se llama a la función sin prefijo y con la cadena completa
        combinaciones("", str);
    }

    private static void combinaciones(String prefijo, String str) {
        int n = str.length();
        String b,c;
        char a;

        if (n == 0)
            System.out.println(prefijo);
        else {
            for (int i = 0; i < n; i++){
                // Se vuelve a llamar a la función con el prefijo (inicialmente null) más la siguiente letra de la cadena.
                //
                a = str.charAt(i);
                b = str.substring(0, i);
                c = str.substring(i+1, n);

                combinaciones(prefijo + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }

public static int multiplicacionRusa(int a,int b){
    if (a==1){
        return b;
    } if (a%2!=0) {
        return b+multiplicacionRusa(a/2,b*2);
    }else {
        return multiplicacionRusa(a/2,b*2);
    }
}

}






