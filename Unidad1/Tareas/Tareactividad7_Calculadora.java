package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tareactividad7_Calculadora {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        Tareactividad7_Calculadora introducir=new Tareactividad7_Calculadora();

        do {
            introducir.Menu();

            opcion=sc.nextInt();

            switch (opcion){
                case 1:
                    introducir.PedirDatos();
                    introducir.sumar();
                    break;
                case 2:
                    introducir.PedirDatos();
                    introducir.resta();
                    break;
                case 3:
                    introducir.PedirDatos();
                    introducir.multiplcar();
                    break;
                case 4:
                    introducir.PedirDatos();
                    introducir.dividir();
                    break;
                case 5:
                    System.out.println("Chau chau");
                    break;
            }

        }while (opcion!=5);
    }

     int Dato1,Dato2;
    int resta,mult,suma;
    double divi;
    public void sumar(){
        suma=Dato1+Dato2;
        System.out.println("El resultado de la suma es: "+suma);
        Dato1=0;
        Dato2=0;
    }

    public void resta(){
        resta=Dato1-Dato2;
        System.out.println("El resultado de la resta es: "+resta);
        Dato1=0;
        Dato2=0;
    }
    public void multiplcar(){
        mult=(Dato1*Dato2);
        System.out.println("El resultado de la multiplicacion es: "+mult);
        Dato1=0;
        Dato2=0;
    }
    public void dividir(){
        double Daton1=Dato1;
        double Daton2=Dato2;
        divi=(Daton1/Daton2);
        System.out.println("El resultado de la division es: "+divi);
    }

    public void PedirDatos(){
        System.out.println("Introduzca los valores: ");
        Dato1=sc.nextInt();
        Dato2=sc.nextInt();
    }
    public void Menu(){
        System.out.println("Bienvenido a nuestra calculadora");
        System.out.println("¿Que desea hacer?" +
                "\n1.- Sumar" +
                "\n2.- Restar" +
                "\n3.- Multiplicar" +
                "\n4.- Dividir" +
                "\n5.- Salir");
    }
}
