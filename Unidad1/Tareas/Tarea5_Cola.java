package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tarea5_Cola {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Tarea5_Cola cola=new Tarea5_Cola();
    int opcion=0, nodo_informacion=0, valor=0;

    do {
        System.out.print("Menú" +
                "\n1.- Mostrar elementos de la cola" +
                "\n2.- Agregar elemento" +
                "\n3.- Eliminar elemento" +
                "\n4.- Juimonos" +
                "\nIngrese una opcion: ");
        opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Los elementos en la cola son: ");
                cola.MostrarCola();
                break;
            case 2:
                System.out.println("Ingrese el valor");
                valor=sc.nextInt();
                cola.Agregar(valor);
                break;
            case 3:
                System.out.println("Se ha eliminado el elemento");
                cola.Eliminar();
                break;
            case 4:
                System.out.println("Chau");
                opcion=4;
                break;

        }
    }while (opcion!=4);

    }
/*
* 1.- Ver si está llena
* 2.- Agregar
* 3.- Eliminar
*/

    private Nodo2 IC;
    private Nodo2 FC;
    String cola="";

    public Tarea5_Cola(){
        IC=null;
        FC=null;
    }

    public boolean colavacia(){
        if (IC==null){
            return true;
        }else{
            return false;
        }
    }

    public void Agregar(int dato){
        Nodo2 nuevo = new Nodo2();
        nuevo.informacion = dato;
        nuevo.siguiente = null;
        if (colavacia()){
            IC=nuevo;
            FC=nuevo;
        }else {
            FC.siguiente=nuevo;
            FC=nuevo;
        }
    }
    public int Eliminar(){
        if (!colavacia()){
            int informacion= IC.informacion;

            if (IC==FC){
            IC=null;
            FC=null;
            }else{
                IC=IC.siguiente;
            }
            return informacion;
        }else {
            return 0;
        }

    }

    public void MostrarCola(){
        Nodo2 recorrido=IC;
        String CI = "";
        if (!colavacia()){
            while (recorrido!=null){
                cola+=recorrido.informacion+" ";
                recorrido=recorrido.siguiente;

            }
            String cadena[]=cola.split(" ");
            for (int i=cadena.length-1; i>=0 ;i--){
                CI += " "+cadena[i];
            }
            System.out.println(CI);
            cola="";
        }else{
            System.out.println("la cola está vacia");
        };
    }
}

class Nodo2{
    int informacion;
    Nodo2 siguiente;
}