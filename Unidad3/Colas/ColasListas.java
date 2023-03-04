package Estructura_De_Datos.Unidad3.Colas;

import java.util.Scanner;
//https://www.youtube.com/watch?v=WSNHX1Qnjvg&t=861s
/*Agregar datos
eliminar nu elemento
Buscar un elemento
Mostra el frente
Preguntar si está vacia
Consutlar el tamaño de la cola(en el caso de arreglos ponerlo tipo: está ocupada x de y posiciones)
Imprime los valores de la cola*/
public class ColasListas {
    private nodos FrenteCola, FinalCola;
    public static void main(String[] args) {
        ColasListas cola=new ColasListas();
        cola.Menu();
    }
    String cola="";

    public ColasListas(){
        FrenteCola =null;
        FinalCola =null;
    }

    public boolean Colavacia(){
        if (FrenteCola==null){// si la Frente es nula, está Colavacia, en cualqueir otro caso no
            return true;
        }else{
            return false;
        }
    }

    public void Insertar(int dato){
        nodos nuevo=new nodos();
        nuevo.info=dato;
        nuevo.siguiente=null;
        if (Colavacia()){
            FrenteCola =nuevo;
            FinalCola =nuevo;
        }else {
            FinalCola.siguiente=nuevo;
            FinalCola=nuevo;
        }
    }
 /*   public int elimi(){
        if (!Colavacia()){
            int informacion= FrenteCola.info;
            if (FrenteCola==FinalCola){
                FrenteCola=null;
                FinalCola=null;
            }else {
                FrenteCola=FrenteCola.siguiente;
            }
            return informacion;
        }else {
            return 0;
        }
    }*/
    public void eliminar(){
        if (!Colavacia()){
            int dato= FrenteCola.info;
            if (FrenteCola==FinalCola){
                FrenteCola=null;
                FinalCola=null;
            }else {
                FrenteCola=FrenteCola.siguiente;
            }
            System.out.println(dato);
        }else{
            System.out.println("La Cola está Colavacia");;
        }
    }

    public boolean buscar(int elemento){
        nodos aux=FrenteCola;
    boolean existe=false;
    while (existe!=true&&aux!=null){
        if (elemento==aux.info){
            existe=true;
        }else {
            aux=aux.siguiente;
        }
    }
    return existe;
    }

    public void esVacia(){
        if (!Colavacia()){
            System.out.println("La cola contiene datos");
        }else {
            System.out.println("La cola no contiene datos");
        }
    }

    public void MostrarCola(){
        nodos recorrido= FrenteCola;
        String colaI="";
        System.out.println("El contenido de la cola es: ");
        while (recorrido!=null){
            cola += recorrido.info+" ";
            recorrido = recorrido.siguiente;
        }

        String cadena[]=cola.split(" ");

        for (int i= cadena.length-1; i>=0; i--){
            colaI += " " + cadena[i];
        }
        System.out.println(colaI);
        cola="";
    }


    void EliminarCola(){
        FrenteCola=null;
        FinalCola=null;
    }


    void Menu(){
        Scanner sc=new Scanner(System.in);
    int opcion=0,dato=0;
        do {
            System.out.println("\nLas opciones disponibles son: " +
                    "\n1.- Agregar Datos" +
                    "\n2.- Eliminar un elemento" +
                    "\n3.- Buscar un elemento" +
                    "\n4.- Mostrar frente" +
                    "\n5.- Pregunte si está Colavacia" +
                    "\n6.- Consulte el tamaño de la pila" +
                    "\n7.- Imprimir valores" +
                    "\n8.- Salir");
            System.out.print("Ingrese la opcion que desea ejecutar: ");
            opcion = sc.nextInt();
            switch (opcion){
                case 1: System.out.print("Ingrese el dato: ");Insertar(dato=sc.nextInt());break;
                case 2: System.out.print("Ingrese el dato que desea eliminar: ");eliminar();break;
                case 3: System.out.print("Ingrese el valor que desea buscar: ");buscar(sc.nextInt());break;
                case 4: /*Mostrar el frente*/;break;
                case 5: esVacia();break;
                case 6: /*Consulte el tamaño de la pila*/;break;
                case 7: MostrarCola();break;
                case 8:System.out.println("Finalizando...");break;
                default: System.out.println("Ingrese una opcion valida");
            }
        }while (opcion!=8);
    }
}

class nodos{
    int info;
    nodos siguiente;
}