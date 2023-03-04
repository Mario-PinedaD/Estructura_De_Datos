package Estructura_De_Datos.Unidad3.Clase;
import java.util.Scanner;
//Pineda Domìnguez Mario Alfredo
public class PilasConSetYGet {
    public static void main(String[] args) throws Exception {
        int opcion=0,dato=0;
        Scanner sc=new Scanner(System.in);

        PilasConSetYGet P1=new PilasConSetYGet();

        do {
            P1.Menu();
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Ingrese el valor que desea añadir: ");
                    P1.apilar(dato=sc.nextInt());
                    break;
                case 2:
                    P1.desapilar();
                    break;
                case 3:
                    System.out.println("La pila contiene un total de "+P1.getTamaño()+" datos");
                    break;
                case 4:
                    System.out.println("El ultimo valor de la pila es: "+P1.valorCima());;
                    break;
                case 5:
                    System.out.print("Ingrese el valor que desea buscar: ");
                    dato=sc.nextInt();
                    System.out.println(P1.buscar(dato));
                    break;
                case 6:
                    System.out.println(P1.esVacia());
                    break;
                case 7:
                    System.out.println("Introduzca el valor que desea eliminar: ");
                    dato=sc.nextInt();
                    P1.quitar(dato);
                    break;
                case 8:
                    System.out.println("Finalizando");
            }
        }while (opcion!=8);
    }

    //=========================================
    //Puntero, inicio o  tope pila
    private nodo inicio;
    private int tamaño,dato=0,tamax=0;

    public void Pilas(){
        inicio=null;
        tamaño=0;
    }
    public boolean esVacia(){
        return inicio==null;
    }

    public int getTamaño(){
        return tamaño;
    }

    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }
    //Añadir un nodo a la pila
    public void apilar(int dato){
        nodo nuevo =new nodo();
        nuevo.setValor(dato);
        if ( esVacia() ){
            inicio=nuevo;
        }else{
            nuevo.setSiguiente(inicio);
            inicio=nuevo;
        }
        tamaño++;
    }

    public void desapilar(){
        if (!esVacia()){
            inicio=inicio.getSiguiente();
            System.out.println("Se ha desapilado correctamente");
            tamaño--;
        }else{
            System.out.println("No se puede desapilar");
        }
    }

    public String valorCima(){
        String error="No se puede mostrar nada, primero añada un valor";
        if (!esVacia()){
            return Integer.toString(inicio.getValor());
        }else{
            return error;
        }


    }
    public boolean buscar(int referencia){//Buscar un numero en la pila
        nodo aux=inicio;

        boolean existe=false;

        //Checar porque se hace esto
        while (existe!=true && aux!=null){
            if (referencia== aux.getValor()){
                existe=true;
            }else{
                aux=aux.getSiguiente();
            }
        }
        return existe;
    }

    //Esto es quitar, va a quitar solamente un elemento de la pila (el que digitemos)
    public void quitar(int referencia){
        if (buscar(referencia)){
            nodo PilaAux=null;

            while (referencia!=inicio.getValor()){
                nodo temp = new nodo();

                temp.setValor(inicio.getValor());

                if (PilaAux==null){
                    PilaAux=temp;
                }else{
                    temp.setSiguiente(PilaAux);
                    PilaAux=temp;
                }
                desapilar();
            }
            desapilar();

            while (PilaAux!=null){
                apilar(PilaAux.getValor());
                PilaAux=PilaAux.getSiguiente();
            }
            PilaAux=null;
        }
    }

    public void Menu(){
        System.out.println("Acontinuacion se muestran las opciones disponibleS:" +
                "\n1.- Ingresar Valor a la pila" +
                "\n2.- Elimine el ultimo valor añadido" +
                "\n3.- Muestre el tamaño de la pila" +
                "\n4.- Muestre el valor de la cima (el ultimo valor apilado)" +
                "\n5.- Busque un numero en la pila" +
                "\n6.- Verifique si la pila está vacia"+
                "\n7.- Eliminar un elemento(introduzca cual)" +
                "\n8.- Salir" +
                "\nIngrese una opcion: ");
    }
}


class nodo{
    int valor; //
    nodo siguiente;

    public void nodo(){
        this.valor = 0;
        this.siguiente= null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor){
        this.valor=valor;
    }

    public nodo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(nodo siguiente){
        this.siguiente=siguiente;
    }

}