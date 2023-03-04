package Estructura_De_Datos.Unidad2.Actividades;
/*
* Funcion Recursiva que diga si es palíndromo
* */

public class Act5_Palindromo {

    public static void main(String[] args) {

        System.out.println("resultado:" + Act5_Palindromo.esPalindrome("Roberto el de creativo"));

    }

    public static boolean esPalindrome(String texto)
    {
        texto=texto.replaceAll(" ","");
        if(texto.length() <= 1)
        {
            return true;
        }else
        {
            if(texto.charAt(0) == texto.charAt(texto.length()-1))
            {
                return esPalindrome(texto.substring(1,texto.length()-1));
            }else
            {
                return false;
            }
        }
    }

}
