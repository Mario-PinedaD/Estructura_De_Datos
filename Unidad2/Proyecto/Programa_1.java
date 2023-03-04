package Estructura_De_Datos.Unidad2.Proyecto;
import java.util.Scanner;

public class Programa_1 {
    public static void main(String[] args)
    {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduzca la cantidad de digitos binarios: ");
        int n = entrada.nextInt();

        String str = "";
        Encontrar(str, n, 0, 0);
    }

    public static void Encontrar(String str, int n, int ceros, int unos){
        // continúa solo si el número total de unos es más que igual al numero de ceros
        if (unos < ceros) {
            return;
        }

        // si el número se convierte en 0 Imprimir el string vacio ya que no hay "1"
        else if (n == 0){
            System.out.println(str);
            return;
        }

        // agregar 1 al resultado y repetir con un dígito menos
        Encontrar(str + '1', n - 1, ceros, unos + 1);

        // agregar 0 al resultado y repetir con un dígito menos
        Encontrar(str + '0', n - 1, ceros + 1, unos);
    }
}
