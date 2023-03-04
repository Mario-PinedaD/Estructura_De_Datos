package Estructura_De_Datos.Unidad3.Clase;
import java.util.*;
import Estructura_De_Datos.Unidad3.Colas.ColasListas;

/*
* Elabora el metodo int Cola::nodoinicio() y el metodo int Cola::nodoFinal(). Es decir el método para obtener el
* dato del frente y del final de la cola.
*
* Ok, hacer con arreglos y listas (dinámicas y estáticas)
Agregar datos
eliminar nu elemento
Buscar un elemento
Mostra el frente
Preguntar si está vacia
Consutlar el tamaño de la cola(en el caso de arreglos ponerlo tipo: está ocupada x de y posiciones)
Imprime los valores de la cola
* */
public class ColaArreglo {
    int[] cola;
    int frente,fin,max,tamaño;
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
    int tamaño=0;

    do {
        System.out.print("Introduzca el tamaño de la cola: ");tamaño=sc.nextInt();
        if (tamaño==0){
            System.out.println("No se puede trabajar asi joben, no manche\n");
        }else {
            ColaArreglo cola= new ColaArreglo(tamaño);
            cola.Menu();
        }
    }while (tamaño==0);

    }

    public ColaArreglo(int dato){
        this.max=dato;
        this.frente=0;
        this.fin=0;
        this.cola=new int[this.max+1];
        this.tamaño=dato;
    }
    public boolean Estallena(){
        if (this.fin==this.max){
            return true;
        }else {
            return false;
        }
    }
    public boolean EstaVacia(){
        if (this.frente==this.fin){
            return true;
        }else{
            return false;
        }
    }
    public void vacia(){
        if (EstaVacia()){
            System.out.println("La cola esta vacia");
        }else {
            System.out.println("La cola contiene datos, es decir no esta vacia");
        }
    }

    public void Agregar(){
        if (Estallena()){
            System.out.println("la cola está llena");
        }else {
            System.out.println("Ingrese el dato que desea agregar: ");int dato=sc.nextInt();
            this.fin++;
            this.cola[fin]=dato;
        }
    }
    public void quitar(){
        if (EstaVacia()){
            System.out.println("la cola está vacia");
        }else {
            for (int i=frente;i<fin-1;i++){
                cola[i]=cola[i+1];
            }
            fin--;
        }
    }

    public void Frente(){
        if (EstaVacia()){
            System.out.println("la cola está vacia");
        }else {

            String frent="";
            frent=Integer.toString(cola[frente+1]);
            System.out.println("primer dato de la cola es: "+frent);
        }
    }
    public void Fin(){
        if (EstaVacia()){
            System.out.println("la cola no tiene datos");
        }else{
            String finali="";
            finali=Integer.toString(cola[fin]);
            System.out.println("El fin es: "+finali);
        }

    }
    public void buscar(){
        boolean existe=false;
        if (EstaVacia()){
            System.out.println("No hay datos que buscar");
        }else{
            System.out.println("Que valor desea encontrar?: ");int numero=sc.nextInt();
            while (existe==true){
                if(frente==numero){
                    System.out.println("El numero es: "+frente);
                }
                else {
                    for (int i=0;i<cola.length;i++){

                    }

                }
            }
        }
    }
    public void Mostrarcola(){
        for (int i=this.frente;i<cola.length;i++){
            System.out.print(cola[i]+" ");
        }
    }
    public void ConsultarTamaño(){
            System.out.println("El tamaño de la cola es de: "+this.tamaño);
        }

    public void Menu(){
        int opcion=0;
        do {
            System.out.println("\nLas opciones disponibles son: " +
                    "\n1.- Agregar Datos" +
                    "\n2.- Eliminar el ultimo dato" +
                    "\n3.- Mostrar frente" +
                    "\n4.- Mostrar fin" +
                    "\n5.- Esta vacia?" +
                    "\n6.- Consultar tamaño" +
                    "\n7.- Mostrar cola" +
                    "\n8.- Buscar un dato" +
                    "\n9.- Salir");

            System.out.print("Ingrese la opcion que desea ejecutar: ");
            opcion=sc.nextInt();
            switch (opcion){
                case 1: Agregar();break;
                case 2: quitar();break;
                case 3: Frente();break;
                case 4: Fin();break;
                case 5: vacia();break;
                case 6: ConsultarTamaño();break;
                case 7: Mostrarcola();break;
                case 8: buscar();break;
                case 9: System.out.println("Gracias por ejecutarme");
            }
    }while(opcion!=9);

}
}
