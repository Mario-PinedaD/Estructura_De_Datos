package Estructura_De_Datos.Unidad1.Tareas;

import java.util.Scanner;

public class Tarea4_Pila{
    public static void main(String[] args) {//      Memoria estática
    int opcion=0,nodo=0;
    Tarea4_Pila Pila=new Tarea4_Pila();
    Scanner sc=new Scanner(System.in);
    do {
        try {

            System.out.printf("Menú de opciones\n\n" +
                    "1 Insertar un nodo\n" +
                    "2 Eliminar nodo\n" +
                    "3 Verificar si la pila está vacía\n" +
                    "4 Ultimo Valor de la Pila\n" +
                    "5 Cuantos nodos tiene la pila\n" +
                    "6 Vacia pila\n" +
                    "7 Mostrar lo que contiene la pila\n" +
                    "8 Salir nomas\n");
            opcion=sc.nextInt();                             // Memoria dinámica

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el valor que quiere asignar");
                    nodo=sc.nextInt();
                    Pila.InsertarNodo(nodo);
                    break;
                case 2:
                    if (!Pila.PilaVacia()){
                    System.out.println("Se ha elimimnado un nodo con valor de "+Pila.Eliminarnodo()+"\n");
                }else{
                        System.out.println("La pila está vacia\n");
                    }
                    break;
                case 3:
                    if (Pila.PilaVacia()){
                        System.out.println("La pila está vacia\n");
                    }else{
                        System.out.println("la pila no está vacia\n");
                    }
                    break;
                case 4:
                    if (!Pila.PilaVacia()){
                        System.out.println("El ultimo valor de la pila es: "+Pila.muvi()+"\n");
                    }else{
                        System.out.println("La pila está vacía\n");
                    }
                    break;
                case 5:
                    System.out.println("la pila contiene "+Pila.tamañopila()+" nodos.\n");
                    break;
                case 6:
                    if (!Pila.PilaVacia()){
                        System.out.println("Se vació correctamente\n");
                    }else{
                        System.out.println("Está vacia\n");
                    }
                    break;
                case 7:
                    Pila.mostrar();
                    break;
                case 8:
                    break;
            }


        }catch (NumberFormatException e){

        }

    }while (opcion!=8);
    }
    private Nodo uvi;//Ultimo Valor Ingresado
    int tamaño=0;
    String lista="";

    public Tarea4_Pila(){
        uvi=null;
        tamaño=0;
    }

    public boolean PilaVacia(){
        return uvi == null;
    }

    public void InsertarNodo(int nodo){//Inserta informacion|| Tambien puede ser memoria dinámica
        Nodo nuevonodo=new Nodo(nodo);
        nuevonodo.siguiente=uvi;
        uvi=nuevonodo;
        tamaño++;//Aumenta el tamaño de la pila
    }

    public int Eliminarnodo(){
        int auxiliar=uvi.informacion;
        uvi=uvi.siguiente;
        tamaño--;
        return auxiliar;
    }

    public int muvi(){
        return uvi.informacion;
    }

    public int tamañopila(){
        return tamaño;
    }

    public void vaciar(){
        while (!PilaVacia()){
            Eliminarnodo();
        }
    }

    public void mostrar(){                  //Memoria automática
        Nodo recorrido=uvi;

        while (recorrido!=null){
            lista+=recorrido.informacion+"\n";
            recorrido=recorrido.siguiente;
        }
        System.out.println(lista);
        lista="";
    }

}
class Nodo{
    int informacion;
    Nodo siguiente;

    public Nodo(int valor) {
        informacion=valor;
        siguiente=null;

    }
}
