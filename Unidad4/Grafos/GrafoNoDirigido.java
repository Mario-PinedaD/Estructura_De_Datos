package Estructura_De_Datos.Unidad4.Grafos;

/*Insertar vértice
La operación de inserción de un nuevo vértice es una operación muy sencilla,
únicamente consiste en añadir una nueva entrada en la tabla de vértices (estructura de datos que almacena los vértices)
para el nuevo nodo. A partir de ese momento el grafo tendrá un vértice más, inicialmente aislado, ya que ningúna arista llegará a él.

Insertar arista
Esta operación es también muy sencilla. Cuando se inserte una nueva arista en el grafo,
habrá que añadir un nuevo nodo a la lista de adyacencia (lista que almacena los nodos a los que un vértice
puede acceder mediante una arista) del nodo origen, así si se añade la arista (A,C), se deberá incluir
en la lista de adyacencia de A el vértice C como nuevo destino.

Eliminar vértice
Esta operación es inversa a la inserción de vértice. En este caso el procedimiento a realizar
es la eliminación de la tabla de vértices del vértice en sí. A continuación habrá que eliminar las aristas
que tuviesen al vértice borrado como origen o destino.

Eliminar arista
Mediante esta operación se borra un arco del grafo.
Para llevar a cabo esta acción es necesario eliminar de la lista de
adyacencia del nodo origen el nodo correspondiente al nodo destino.
https://www.deltapci.com/java-listas-enlazadas-simples/
https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/#:~:text=Arista%20(Edge)%20%3A%20Es%20un,l%C3%ADnea%20que%20conecta%202%20v%C3%A9rtices
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrafoNoDirigido {

    public static void main(String[] args) {
        GrafoNoDirigido grafo=numeros();

        System.out.println(grafo);



    }
    List<nodografo> nodografos;

    Scanner sc=new Scanner(System.in);
    nodografo primero;
    nodografo ultimo;
    nodografo nodo;
    int tamaño=0,ori=0,des=0,dato=0;

    void agregar(){
        System.out.print("Ingrese el dato: ");
        dato=sc.nextInt();
        nodografo pa=new nodografo(dato);
        agrevertice(pa);
    }
    void agrevertice(nodografo nodo){
        if (nodografos==null){
            nodografos=new ArrayList<>();
        }
        nodografos.add(nodo);
    }

    void mostrarVertices(){
       for (int i=0;i<nodografos.size();i++)
           System.out.print(nodografos.get(i)+" - ");
    }

    void agregarvertice(int dato){
        /*nodografo nodo=new nodografo();
        nodo.dato=dato;
        if (esVacio()){
            primero=nodo;
            ultimo=nodo;
        }else {
            nodografo aux=primero;
            while (aux.siguiente!=null){
                aux=aux.siguiente;
            }
            aux.siguiente=nodo;
        }
        tamaño++;*/
    }
    void arista(){
        if (!esVacio()){
            nodografo origen = null,destino = null;
            System.out.print("Ingrese el origen: ");
            ori=sc.nextInt();
            System.out.print("Ingrese el destino");
            des=sc.nextInt();
            origen.dato=ori;
            destino.dato=des;
            arista nueva=new arista(origen,destino);
            nueva.toString();

        }else {
            System.out.println("Ta vacio krnal");
        }
    }

    void mostrar(){
       if (!esVacio()){
           nodografo aux=primero;
           while (aux!=null){
               System.out.print(aux.dato+" - ");
               aux=aux.siguiente;
           }
           System.out.println();
       }else {
           System.out.println("Esta vacio");
       }
    }

    public List<nodografo> mostrararis(){
            return nodografos;
    }

    boolean esVacio(){
        return primero==null;
    }

    public String toString(){
        return "nodos: "+ nodografos+" .";
    }


    void menu(){
        int opcion=0;
        do {
        ;
            System.out.print("\n\n1.- agregar" +
                    "\n2.- eliminar vertice " +
                    "\n3.- Agregar Arista" +
                    "\n4.- Eliminar Arista" +
                    "\n5.- Mostrar vertices" +
                    "\n6.- Mostrar grafo completo" +
                    "\n7.- Salir" +
                    "\nIngrese una opcion: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1: agregar(); break;
                case 2: break;
                case 3: mostrarVertices(); break;
                case 4: arista(); break;
                case 5: ; break;
            }
        }while (opcion!=7);
    }

    public static GrafoNoDirigido numeros(){
        nodografo n1=new nodografo(1);
        nodografo n2=new nodografo(2);
        nodografo n3=new nodografo(3);
        nodografo n4=new nodografo(4);
        nodografo n5=new nodografo(5);
        nodografo n6=new nodografo(6);
        nodografo n7=new nodografo(7);
        nodografo n8=new nodografo(8);
        nodografo n9=new nodografo(9);
        nodografo n10=new nodografo(10);
        nodografo n11=new nodografo(11);
        nodografo n12=new nodografo(12);

        n1.agreArista(new arista(n1,n5));
        n3.agreArista(new arista(n3,n5));
        n5.agreArista(new arista(n5,n5));
        n7.agreArista(new arista(n7,n5));
        n9.agreArista(new arista(n9,n5));

        GrafoNoDirigido grafo=new GrafoNoDirigido();

        grafo.agrevertice(n1);
        grafo.agrevertice(n2);
        grafo.agrevertice(n3);
        grafo.agrevertice(n4);
        grafo.agrevertice(n5);
        grafo.agrevertice(n6);
        grafo.agrevertice(n7);
        grafo.agrevertice(n8);
        grafo.agrevertice(n9);
        grafo.agrevertice(n10);
        grafo.agrevertice(n11);
        grafo.agrevertice(n12);

        return grafo;
    }
}

class nodografo{
    nodografo siguiente;
    int dato;
    List<arista> aristas;

    nodografo(int dato){
        this.dato=dato;
    }
    void agreArista(arista ar){
        if (aristas==null){
            aristas=new ArrayList<>();
        }
        aristas.add(ar);
    }

    public void setSiguiente(nodografo siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodografo getSiguiente() {
        return siguiente;
    }

    public int getDato() {
        return dato;
    }

    public String toString(){
        return "dato: "+dato+" - aristas: "+aristas;
    }


}

class arista{
    nodografo origen,destino;

    arista(nodografo origen,nodografo destino){
        this.origen=origen;
        this.destino=destino;
    }

    public nodografo getOrigen() {
        return origen;
    }
    public nodografo getDestino() {
        return destino;
    }
    public void setOrigen(nodografo origen) {
        this.origen = origen;
    }
    public void setDestino(nodografo destino) {
        this.destino = destino;
    }

    public String toString(){
        return "Origen "+origen.dato + " - Destino: "+ destino.dato;
    }
}