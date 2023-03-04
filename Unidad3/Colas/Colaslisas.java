package Estructura_De_Datos.Unidad3.Colas;
import java.util.*;

/*
Insertar
Eliminar un elemento de posicion x para esto se necesita crear una lista de respaldo para eliminar un dato y recuperar las demás
Buscar un elemento X
Frente
Preguntar si está Colavacia
Preguntar tamaño
Imprimir los datos de la cola
*/
public class Colaslisas {
Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Colaslisas col=new Colaslisas();
        col.Menu();
    }

    //=====================
    private nodocola inicio;
    int tamaño;
    String frente;
    String fin;
    nodocola no=new nodocola();

    public void Colaslisas(){
    inicio=null;
    tamaño=0;
    }

    //Vamos a comenzar de nuevo
    public boolean ColaVacia(){//Pregunte si la cola está Colavacia
        if (no.getApuntador()==null){
            return true;
        }else {
            return false;
        }
    }
    public void Agregar(int dato){
        if (ColaVacia()){//Si la cola está Colavacia el dato irá directo al inicio
            no.setValor(dato);//Ingreso el dato en el nodo de tipo valor
            inicio=no;//Lo manda al inicio
            System.out.println("El dato "+dato+" se ha añadido correctamente");

        }else {//En el caso de que la cola no esté Colavacia, y contenga datos
            no.setValor(dato);
            no.setApuntador(no);
            System.out.println("El dato "+dato+" se ha añadido correctamente");

        }
    }

    public void Eliminar(){

    }
    public void MostrarCola(){
        nodocola recorrido=inicio;
        System.out.println("El contenido de la cola es: ");
        while (recorrido!=null){

            System.out.println(recorrido.getValor()+"<-");
            recorrido=recorrido.getApuntador();
        }

    }
    public void Menu(){
        {
            int opcion=0,dato=0;
            do {
                System.out.println("\nLas opciones disponibles son: " +
                        "\n1.- Agregar Datos" +
                        "\n2.- Eliminar el ultimo dato" +
                        "\n3.- Buscar un elemento" +
                        "\n4.- Mostrar frente" +
                        "\n5.- Pregunte si está Colavacia" +
                        "\n6.- Consulte el tamaño de la pila" +
                        "\n7.- Imprimir valores" +
                        "\n8.- Salir");

                System.out.print("Ingrese la opcion que desea ejecutar: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.print("Ingrese el dato: ");Agregar(dato=sc.nextInt());break;
                    case 2: /*Funcion eliminar*/ break;
                    case 3: //funcion buscar elemento;
                        break;
                    case 4: //Funcion mostrar el frente
                        break;
                    case 5: /*Preguntar si está Colavacia*/break;
                    case 6: /*Consultar el tamaño de la pila*/;break;
                    case 7: /*Impirimir los valores de la cola*/;
                    case 8: System.out.println("Gracias por ejecutarme");
                }
            }while(opcion!=8);

        }

}
class nodocola {
    int valor;
    nodocola apuntador;

    public void nodocola(){
        this.valor=0;
        this.apuntador =null;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public nodocola getApuntador() {
        return apuntador;
    }

    public void setApuntador(nodocola apuntador) {
        this.apuntador = apuntador;
    }
}
}
/*
*     public boolean estaVacia(){
        if (no.getApuntador()==null){
            return true;
        }else{
            return false;
        }
    }
    public void agregar(int dato){
        nodocola nuevonodo=new nodocola();
        nuevonodo.setValor(dato);
        if (estaVacia()){
            inicio=nuevonodo;

            //this.frente=Integer.toString(inicio.getValor());
            //this.fin=Integer.toString(inicio.getValor());
        }else {
            nuevonodo.setApuntador(inicio);//se pone como inicio el apuntador valor
            inicio=nuevonodo;//el inicio será igual al nuevo valor establecido

            this.frente=Integer.toString(inicio.getValor());//el nuevo valor establecido será el inicio
            this.fin=Integer.toString(nuevonodo.getValor());
        }
        tamaño++;
    }
    public void quitar(){
    if (!estaVacia()){
        System.out.println(" se ha eliminado el dato "+inicio+" correctamente");
        inicio=inicio.getApuntador();

        //this.frente=Integer.toString(inicio.getValor());
        //this.fin=Integer.toString(inicio.getValor());

        tamaño--;//me faltaría eliminar los datos y volverlos a dejar como inicio
    }else{
        System.out.println("no se puede eliminar");
    }
    }
    public void MostrarFrente(){
    if (!estaVacia()){
        System.out.println(frente);//esto lo hice como pilas
    }else {
        System.out.println("no hay datos que mostrar");
    }
    }
    public void MostrarFin(){//intentar una variable temporal para solucionar esto y mostrarla

        if (!estaVacia()){
            nodocola nodo=new nodocola();
                System.out.println("El valor del final es "+nodo.getValor());
            }else {
            System.out.println("no hay datos que mostrar");
        }
    }*/