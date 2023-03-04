package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tarea6_ListaSimple {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tarea6_ListaSimple lista=new Tarea6_ListaSimple();
        int opcion=0, nodo_informacion=0, valor=0;

        do {
            System.out.print("Menú" +
                    "\n1.- Mostrar elementos de la lista" +
                    "\n2.- Agregar elemento" +
                    "\n3.- Juimonos" +
                    "\nIngrese una opcion: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Los elementos en la lista son: ");
                    lista.MostrarLista();
                    break;
                case 2:
                    System.out.println("Ingrese el valor");
                    valor=sc.nextInt();
                    lista.AgregarInicio(valor);
                    break;
                case 3:
                    System.out.println("Chau");
                    opcion=3;
                    break;

            }
        }while (opcion!=3);

    }


    protected Nodo3 inicio,fin;//donde apuntan

    public Tarea6_ListaSimple(){
        inicio=null;
        fin=null;
    }

    public void AgregarInicio(int dato){
        inicio=new Nodo3(dato,inicio);

        if(fin==null){
            fin=inicio;
        }
    }
    public void MostrarLista(){
        Nodo3 recorrer=inicio;

        while (recorrer!=null){
            System.out.print("["+recorrer.dato+"]->");
            recorrer=recorrer.siguiente;
        }
    }
}

class Nodo3{
    public int dato;
    public Nodo3 siguiente;

    public Nodo3(int d){//Se inserta al final
        this.dato=d;
    }
    public Nodo3(int d, Nodo3 n){
        dato=d;
        siguiente=n;
    }
}