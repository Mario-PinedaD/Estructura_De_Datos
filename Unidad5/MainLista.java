package Estructura_De_Datos.Unidad5;

import java.util.Scanner;

public class MainLista {
    public static void main(String[] args) {
        MainLista orden = new MainLista();
        orden.menu();
    }
    public void menu(){
        Scanner en = new Scanner(System.in);
        int op = 0;
        Lista ord = new Lista();
        do {
            System.out.println("Opciones:" +
                    "\n1.-  Agregar" +
                    "\n2.-  Eliminar" +
                    "\n3.-  Mostrar datos" +
                    "\nOrdenamientos Internos:" +
                    "\n4.-  Burbuja" +
                    "\n5.-  Quicksor" +
                    "\n6.-  Shell" +
                    "\n7.-  Radix" +
                    "\nOrdenamientos Externos" +
                    "\n8.-  Intercalacion" +
                    "\n9.-  Mezcla directa" +
                    "\n10.- Mezcla natural" +
                    "\n11.- Salir");
            System.out.print("Opcion: "); op=en.nextInt();
            if (op < 12){
                switch (op){
                    case 1: ord.Agregar(); break;
                    case 2: ord.Eliminar(); break;
                    case 3: ord.mosArreglo(); break;
                    case 4: ord.Burbuja(); break;
                    case 5: ord.QuickSort(); break;
                    case 6: ord.Shell(); break;
                    case 7: ord.Radix(); break;
                    case 8: ord.Intercalacion(); break;
                    case 9: ord.MezclaDirecta(); break;
                    case 10: ord.MezclaNatural(); break;
                    case 11: break;
                }
            }else {
                System.out.println("Intenta de nuevo");
            }
            System.out.println("******************\n");
        }while (op!=11);
    }
}

class Lista {

    private Nodo inicio;
    private Nodo fin;
    int[] arreglo;
    int tam,dato = 0;
    Scanner en = new Scanner(System.in);

    public Lista() {
        inicio = fin = null;
    }

    void Agregar(){
        System.out.println("Inotroduzca el dato: "); dato = en.nextInt();
        agregar(dato);
        creaArreglo();
    }

    public void agregar(int info) {
        Nodo nuevo = new Nodo(info, null);
        if(inicio == null) {
            inicio = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tam++;
    }

    void Eliminar(){
        if (!esVacia()){
            System.out.print("Datos: ");imprimir();
            System.out.println("\nIngrese el dato a eliminar: ");
            dato = en.nextInt();
            eliminar(dato);
        }else {
            System.out.println("No existen datos");
        }
    }

    public void eliminar(int valor) {
        if (contiene(valor)){
           if (tam == 1){
               inicio = fin = null;
               System.out.println("El valor "+valor+" ha sido eliminado");
               tam--;
           }else {
               if ( inicio.getDato() == valor){
                   System.out.print("dato "+inicio.getDato()+" Eliminado");
                   inicio = inicio.getSiguiente();
               }else {
                   Nodo temp = inicio;
                   while (temp.getSiguiente().getDato()!=valor){
                       temp=temp.getSiguiente();
                   }
                   Nodo siguiente = temp.getSiguiente().getSiguiente();
                   temp.setSiguiente(siguiente);
                   System.out.println("El valor "+valor+" ha sido eliminado");
               }
               tam--;
               creaArreglo();
           }

        }else {
            System.out.println("El valor no existe");
        }
    }

    boolean esVacia(){
        return inicio == null;
    }

    boolean contiene(int dato){
        boolean existe = false;
        Nodo aux = inicio;
        while (aux != null && existe !=true){
            if (dato == aux.getDato()){
                existe = true;
            }else {
                aux = aux.getSiguiente();
            }
        }
        return existe;
    }

    //Metodo para imprimir los datos
    public void imprimir() {
        Nodo aux = inicio;
        while(aux != null) {
            System.out.print(" - " + aux.getDato());
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    void mosArreglo(){
        if (!esVacia()){
            for (int i = 0; i < arreglo.length; i++){
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        }else {
            System.out.println("No hay datos");
        }
    }

    void creaArreglo(){
        arreglo= new int[tam];
        Nodo aux = inicio;
        int i = 0;
        while(aux != null) {
            arreglo[i] = aux.getDato();
            aux = aux.getSiguiente();
            i++;
        }
    }
    void mArreglo(int arr[]){
        for (int i=0; i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    void Burbuja(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            burbuja(arreglo);//
            mosArreglo();
            creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void burbuja(int []arr){
        int aux, i = 0;
        while ( i < arr.length){
            //[5,4,3,2,1]
            /* aux = 5
            5 = 4
            4 = 5
            [4,3,2,1,5]
            * */
            for (int j = 0; j < (arr.length - 1); j++){
                if (arr[j] > arr[j+1]){
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
            i++;
        }
    }

    void QuickSort(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            quicksort(arreglo, 0, arreglo.length-1);
            mosArreglo(); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void quicksort(int []arr, int izq, int der){
        //[ 4 3 7 11 44]
        //    ^    ^
        int inicio = arr[izq]; //el valor de inicio será igual al Arr posicion 0
        int i = izq, d = der, aux; // i=0, d = longitud-1
        while (i < d){
            while (arr[i] <= inicio && i < d) i++;
            while (arr[d] > inicio) d--;
            if (i < d){
                aux = arr[i];
                arr[i] = arr[d];
                arr[d] = aux;
            }
        }
        arr[izq] = arr[d];
        arr[d] = inicio;
        if (izq < d-1) quicksort(arr, izq, d-1);
        if (d+1 < der) quicksort(arr, d+1 , der);
    }

    void Shell(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            shell(arreglo);
            mosArreglo(); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void shell(int arr[]){
        int salto = 0, temp = 0, i = 0;
        boolean cambio;
        /* [9,8,7,6,5,4,3,2,1] = 9
            0,1,2,3,4,5,6,7,8
        * salto = (9)/2 = 4

        * [4,3,2,1] [9,  8,7,6,5]
        * if 4 > 1
        * temp = 1
        * 1 = 4
        * 4 = 1
        * [1,3,2,4]
        * */
        for (salto = arr.length / 2; salto != 0; salto /= 2){
            cambio = true;
            while (cambio){
                cambio = false;
                for (i = salto; i < arr.length; i++){
                    if (arr[i-salto] > arr[i]){ // si la posicion izquierda es mayor a la derecha
                        temp = arr[i];
                        arr[i] = arr[i-salto];
                        arr[i-salto] = temp;
                        cambio = true;
                    }
                }
            }
        }
    }

    void Radix(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            radix(arreglo); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    /*12
    * 13
    * 14
    * 17
    * 26 */

    void radix(int arr[]){
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--){ //31
            int aux[] = new int[arr.length];
            j = 0;
            for (i = 0; i < arr.length; i++) {
                //si la posicion en el arreglo es mayor o igual a cero entonces es true
                boolean mover = arr[i] << x >=0; // 30 = 3 || 0
                //en el caso de que x sea igual a cero, devolverá el contrario del booleano en
                //otro caso devolverá el booleano
                if(x == 0 ? !mover : mover){
                    aux[j] = arr[i];
                    j++;
                }else {
                    arr[i-j] = arr[i];
                }
            }

            for (i = j; i < aux.length; i++){
                aux[i]=arr[i-j];
            }
            arr = aux;
        }
        mArreglo(arr);
    }

    void Intercalacion(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            int n = arreglo.length;

            int m1[] = new int[(n + 1)/2];// 5

            int m2[] = new int[n - m1.length]; // 9 - 5 = 4

            for (int i = 0; i < n; i++) {
                if (i < m1.length) {
                    m1[i] = arreglo[i];
                } else {
                    m2[i - m1.length] = arreglo[i];
                }
            }
            System.out.println("Arreglo 1");
            mArreglo(m1);
            System.out.println("Arreglo 2");
            mArreglo(m2);
            System.out.println("Datos Ordenados: ");
            intercalacion(m1,m2);
            creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void intercalacion(int a1[],int a2[]){
        int i, j, k;
        int afinal[] = new int[a1.length + a2.length];
        burbuja(a1);
        burbuja(a2);
        //[1,3,4]
        //[2,5,6,7,8,9] a2
        //
        for (i = j = k = 0; i < a1.length && j < a2.length; k++){//1
            if (a1[i] < a2[j]){
                afinal[k] = a1[i];
                i++;
            }else {
                afinal[k] = a2[j];
                j++;
            }
        }
        for(; i < a1.length; i++, k++){
            afinal[k] = a1[i];
        }
        for (; j < a2.length; j++, k++){
            afinal[k] = a2[j];
        }
        mArreglo(afinal);
    }

    void MezclaDirecta(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            mArreglo( mezdir(arreglo) );
            creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    int[] mezdir(int arr[]){
        int i, j, k;

        if (arr.length > 1){
            int izq = arr.length/2;
            int der = arr.length - izq;
            int arizq[] = new int[izq];
            int arder[] = new int[der];
            for (i = 0; i < izq; i++){
                arizq[i] = arr[i];
            }
            for (i = izq; i < izq + der; i++){
                arder[i-izq] =  arr[i];
            }
            arizq = mezdir(arizq);
            arder = mezdir(arder);
            i = 0; j = 0; k = 0;
            while (arizq.length != j && arder.length != k){
                if (arizq[j] < arder[k]){
                    arr[i] = arizq[j];
                    i++; j++;
                }else {
                    arr[i] = arder[k];
                    i++; k++;
                }
            }
            while (arizq.length != j){
                arr[i]= arizq[j];
                i++; j++;
            }
            while (arder.length != k){
                arr[i] = arder[k];
                i++; k++;
            }
        }
        return arr;
    }

    void MezclaNatural(){
        if (!esVacia()){
            System.out.println("Datos sin ordenar: ");
            imprimir();
            System.out.println("Datos Ordenados: ");
            mezNat(arreglo);
            mosArreglo();
            creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void mezNat(int arr[]){
        int izquierda = 0, iz = 0, derecha = arr.length-1, der = derecha;
        boolean ordenao = false;

        do {
            ordenao = true;
            izquierda = 0;

            while (izquierda < derecha){
                iz = izquierda;
                while (iz < derecha && arr[iz] <= arr[iz + 1]){

                    iz++;
                }
                der =  iz + 1;

                while (der == derecha - 1 || der < derecha && arr[der] <= arr[der + 1]){
                    der++;
                }
                if (der <= derecha){
                    mezdir(arr);
                    ordenao = false;
                }
                izquierda = iz;
            }
        }while (!ordenao);
    }
}
//
class Nodo {

    //Declaración de atributos
    private int dato;
    private Nodo siguiente;

    //Constructores de la clase Nodo
    public Nodo (int dato, Nodo siguiente){
        this.dato=dato;

        this.siguiente=siguiente;
    }

    public Nodo (int datos){
        this.dato=datos;
        this.siguiente=null;
    }

    //Metodos getter and setter
    public int getDato()
    {
        return dato;
    }

    public void setDato(int dato)
    {
        this.dato = dato;
    }

    public Nodo getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }
}

