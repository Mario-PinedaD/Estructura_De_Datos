package Estructura_De_Datos.Unidad5;
/*
Ordenamiento interno:
Burbuja
Quicksort
Shell
Radix
Ordenamientos Externos
Intercalación
Mezcla directa
Mizcla natural
* */
import java.util.*;

public class MainOrdenamiento {
    public static void main(String[] args) {
        MainOrdenamiento main = new MainOrdenamiento();
        main.menu();
    }
    public void menu(){
        Scanner en = new Scanner(System.in);
        int op = 0;
        Ordenamiento ord = new Ordenamiento();
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

class Ordenamiento{
    LinkedList<Integer> lista = new LinkedList<>();
    int[] arreglo;
    int dato = 0;
    Scanner en = new Scanner(System.in);

    void Agregar(){
        System.out.print("Dato: "); dato= en.nextInt();
        agregar(dato);
    }
    void agregar(int dato){
        if (!lista.contains(dato)){
            lista.add(dato);
            creaArreglo();
            System.out.println("Dato añadido correctamente");
        }else {
            System.out.println("El dato ya existe");
        }
    }

    void Eliminar(){
        if (!lista.isEmpty()){
            System.out.print("Dato que desea eliminar: "); dato= en.nextInt();
            eliminar(dato);
        }else {
            System.out.println("No existen datos");
        }
    }

    void eliminar(int dato){
        if (lista.contains(dato)){
            int ind = 0;
            while (dato != lista.get(ind)){
                ind++;
            }
            System.out.println("Se ha eliminado el dato: " + lista.get(ind));
            lista.remove(ind);
            creaArreglo();
        }else {
            System.out.println("El dato no se encuentra");
        }
    }

    void mostrarlista(){
        for (int i=0;i<lista.size();i++){
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();
    }

    void creaArreglo(){
        arreglo= new int[lista.size()];
        for (int i=0;i<arreglo.length;i++){
            arreglo[i]= lista.get(i);
        }
    }
    void mosArreglo(){
        if (!lista.isEmpty()){
            for (int i=0; i< arreglo.length;i++){
                System.out.print(arreglo[i]+" ");
            }
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void mArreglo(int arr[]){
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    void Burbuja(){
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
            System.out.println("Datos Ordenados: ");
            burbuja(arreglo);
            mosArreglo(); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void burbuja(int []arr){
        int aux, i = 0;
        //for (int i = 0; i < arr.length; i++){}
        while ( i < arr.length){
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
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
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
        int inicio = arr[izq]; //el valor de inicio será igual al Arr posicion 0
        int i=izq, d=der, aux; // i=0, d = longitud-1
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
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
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

        for (salto = arr.length/2; salto != 0; salto /= 2){
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
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
            System.out.println("Datos Ordenados: ");
            radix(arreglo); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void radix(int arr[]){
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--){
            int aux[] = new int[arr.length];
            j = 0;
            for (i = 0; i < arr.length; i++) {
                boolean mover = arr[i] << x >=0;
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
            arr=aux;
        }
        mArreglo(arr);
    }

    void Intercalacion(){
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
            int n = arreglo.length;
            int m1[] = new int[(n + 1)/2];
            int m2[] = new int[n - m1.length];
            for (int i = 0; i < n; i++) {
                if (i < m1.length) {
                    m1[i] = arreglo[i];
                } else {
                    m2[i - m1.length] = arreglo[i];
                }
            }
            System.out.println("Arreglo 1");
            mArreglo(m1);
            System.out.println("\nArreglo 2");
            mArreglo(m2);
            System.out.println("\nDatos Ordenados: ");
            intercalacion(m1,m2); creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    void intercalacion(int a1[],int a2[]){
        int i,j,k;
        int afinal[] = new int[a1.length + a2.length];
        burbuja(a1);
        burbuja(a2);
        for (i = j = k = 0; i < a1.length && j < a2.length; k++){
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
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
            System.out.println("Datos Ordenados: ");
            mArreglo(mezdir(arreglo));
            creaArreglo();
            System.out.println();
        }else {
            System.out.println("No existen datos");
        }
    }

    int[] mezdir(int arr[]){
        int i,j,k;

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
                i++;j++;
            }
            while (arder.length != k){
                arr[i] = arder[k];
                i++;k++;
            }
        }
        return arr;
    }

    void MezclaNatural(){
        if (!lista.isEmpty()){
            System.out.println("Datos sin ordenar: ");
            mostrarlista();
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
                    ordenao=false;
                }
                izquierda = iz;
            }
        }while (!ordenao);
    }
}
