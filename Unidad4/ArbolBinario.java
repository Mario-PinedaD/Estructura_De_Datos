package Estructura_De_Datos.Unidad4;

/*
Mostrar los datos:
    Por nivel
    Por los 3 tipos: Preorden, inorden, Posorden
    Mostrar la altura del arbol
    Mostrar las hojas del arbol
    Mostrar los padres
    Mostrar la raiz

* */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;//Ps pa introducir datos

public class ArbolBinario {
    public static void main(String[] args) {

        ArbolBinario arbol=new ArbolBinario();//Objeto tipo arbol

        arbol.Menu();//Ejecuta el menú
    }

    NodoBinario raiz;
    int dato;
    Scanner intro=new Scanner(System.in);


    void agregar(){//Funcion bonita de agregar
        System.out.println("Valor que desea agregar: ");dato= intro.nextInt();
        raiz = Ingresar(raiz,dato);//La reaz se vuelve el primer dato
        System.out.println("El valor se ha agregado correctamente");
        dato=0;
    }

    NodoBinario Ingresar(NodoBinario posicion,int valor){//Se ingresa la posicion y el dato
        if (posicion==null){//En caso de que la posicion sea null ps no se añade nada
            return new NodoBinario(valor);

        }else if (valor<posicion.dato){//si el valor es menor al ingresado va pa la izquierda
            posicion.nodoizquiero=Ingresar(posicion.nodoizquiero,valor);

        } else if (valor> posicion.dato) {//Si es mayor pa la derecha
            posicion.nododerecho=Ingresar(posicion.nododerecho,valor);

        }else {
            return posicion;
        }
        return posicion;
    }


    public void eliminar(){
        if (!vacio()){//Si no está vacio
            System.out.print("Introduzca el dato que desea eliminar: ");dato=intro.nextInt();
            if (buscar(dato)){//Busca el dato en caso de que exista

                //Llamar a la funcion eliminar recursiva
                raiz=borrar(raiz,dato);//Se elimina el dato seleccionado y todo lo que esté debajo
                System.out.println("El dato se ha borrado exitosamente");

            }else {
                System.out.println("el dato "+dato+" no existe");
            }
        }else {
            System.out.println("El arbol está vacio");
        }
    }

    private NodoBinario borrar(NodoBinario posicion, int dato){
        if (posicion==null){//Si la posicion es null ps no se borra nada
            return null;
        }if (dato== posicion.dato){//Si el adto es igual a la posicion
            if (posicion.nodoizquiero == null && posicion.nododerecho== null) {//En caso de que sea el ultimo valor, osea que no tenga ni izquierdo o derecho
                return null;                                                    //Se elimina

            }if (posicion.nododerecho==null){//Si solo tiene el derecho nulo se borra todo lo de la derecha
                return posicion.nododerecho;

            }if (posicion.nodoizquiero==null){
                return posicion.nodoizquiero;//Este igual pero todo lo de la izquierda

            }
            /*int valor_menor = valorinferior(posicion.nododerecho);
            posicion.dato = valor_menor;
            posicion.nododerecho = borrar(posicion.nododerecho, valor_menor);
            return posicion;*/

        }if (dato < posicion.dato){//Si es menor se va pa la posicion izquierda

            posicion.nodoizquiero = borrar(posicion.nodoizquiero,dato);//Con recursividad sigue buscando el valor
            return posicion;

        }
        posicion.nododerecho = borrar(posicion.nododerecho,dato);//Si no es menor ps se va a la derecha e igual se utiliza reciursividad

        return posicion;
    }

    /*int valorinferior(NodoBinario raiz){
        return raiz.nodoizquiero==null ? raiz.dato : valorinferior(raiz.nodoizquiero);
    }*/

    public boolean buscar(int valor){//Devuelve si el valor existe solo se introduce el valor
        return buscaraux(raiz,valor);
    }

    private boolean buscaraux(NodoBinario nodo, int dato){
        if (nodo == null){//Si el nodo no existe F
            return false;
        }
        if (dato == nodo.dato){//Si el valor es igual que el el valor del nodo nice
            return true;
        }
        return dato < nodo.dato ? buscaraux(nodo.nodoizquiero,dato) : buscaraux(nodo.nododerecho,dato);//esto es para que vaya brincando de izquierda a derecha
        //buscando el valor hasta que se vuelva fals eo true.
    }

    void Raiz(){
        if (!vacio()){//Si no esta vacio
            System.out.println(raiz.dato);//Muestra el valor de la raiz;
        }else{
            System.out.println("El arbol esta vacio");
        }
    }

    boolean eshoja(NodoBinario nodo){//Pregunta si el nodo es hoja
        return nodo.nodoizquiero==null && nodo.nododerecho==null;//Si a la izquierda y derecha no tiene nada es que es hoja
    }

    public int alutra(NodoBinario posicion){
        if (posicion==null){//si la posicion es null ps no da nada osea no hay altura
            return 0;
        }
        //Recorrer el sub arbol izquierdo y el derecho para considerar la profundiadad maxima+1
        //ojo la profundidad no es la misma que la altura, la altura es el conjunto de todo raiz-padre-hijos-hojas
        //Minetras que la profundidad solo abarca desde los padres pa abajo
        return 1+Math.max(alutra(posicion.nodoizquiero),alutra(posicion.nododerecho));
    }

    void altura(){//Muestra la altura de forma bonita :D
        int valor = alutra(raiz);
        System.out.println(valor);
    }

    public int mosPadres(NodoBinario posicion){

        if (posicion!=null){//Si la posicion es diferente de null continua
            mosPadres(posicion.nodoizquiero);//recorre la izquierda
            if (!eshoja(posicion)){//si no es una hoja, osea tiene un izquierdo o derecho
                System.out.println(posicion.dato+" - ");//Lo muestra
            }
            mosPadres(posicion.nododerecho);//una vez terminado regresa al nodo derecho
        }
        return 0;
    }

    public int mosHojas(NodoBinario posicion){//Igual que los padres, pero solo muestra las hojas
        if (posicion!=null){
            mosHojas(posicion.nodoizquiero);
            if (eshoja(posicion)){//si es hoja la muestra y listo
                System.out.println(posicion.dato+" - ");
            }
            mosHojas(posicion.nododerecho);
        }
        return 0;
    }

    void mosNiveles(){
        NodoBinario aux=raiz;
        if (aux!=null){
            Queue cola =new LinkedList();//Declara los metodos como cola, el primero que entra el primero que sale
            cola.add(aux);//Ingresa a la cola la posicion del nodo auxiliar

            int nivel1=devolvernivel(aux.dato);//El nivel 1 es la raiz basicamente
            while (!cola.isEmpty()){ //Mientras no esté vacio

                NodoBinario na=(NodoBinario) cola.element();//Crea un nuevo nodo del arbol que tendrá los elementos/elemento(raiz) antes hecho
                cola.remove();//elimina la cola creada al inicio
                int nivel2=devolvernivel(na.dato);//el valor del nivel 2 será el mismo que el de la posicion

                if (nivel1 != nivel2){//Si el nivel 1 es diferente al 2
                    System.out.print("\n");
                    nivel1 = nivel2;//Se igualan los niveles
                }
                System.out.print(na.dato+" ");//Primero imprime los datos del nivel 1

                if (na.nodoizquiero!=null){//si el tiene valor al lado izquierdo
                    cola.add(na.nodoizquiero);//a la cola se le añade el nodo izquierdo y entra en el while de nuevo
                }
                if (na.nododerecho!=null){//si el tiene valor al lado derecho
                    cola.add(na.nododerecho);//a la cola se le añade el nodo derecho y entra en el while de nuevo
                }
            }
        }
    }

    private int devolvernivel(int dato) {
        int nivel=0;//se inicializa con 0

        NodoBinario nodo=raiz;//un nodo de apoyo

        while (dato!=nodo.dato){//Mientras el dato sea diferente al ingresado
            if (dato>nodo.dato){//si es mayor recorre al derecho
                nodo=nodo.nododerecho;
            }else {//en otro caso se va al izquierdo y comienza el while denuevo
                nodo=nodo.nodoizquiero;
            }nivel +=1;//aumenta el nivel
        }return nivel;
    }

    void preorden(){
        preordenaux(raiz);
    }
    void preordenaux(NodoBinario nodo){
        if (!vacio()){//si no esta vacio
            if (nodo==null)//si es nulo vuelve
                return;
            System.out.print(nodo.dato+", ");//muestra el valor central
            preordenaux(nodo.nodoizquiero);//se va al izquierd
            preordenaux(nodo.nododerecho);//se va al derecho
        }else {
            System.out.println("El arbol está vacio");
        }
    }

    void inorden(){
    inordenaux(raiz);
    }
    void inordenaux(NodoBinario nodo){
        if (nodo==null)
            return;
        inordenaux(nodo.nodoizquiero);//inicia con los izquierdos
        System.out.print(nodo.dato+", ");//muetra el valor desde lo mas izquierdo
        inordenaux(nodo.nododerecho);//continua con los derechos
    }

    void posorden(){
        posordenaux(raiz);
    }
    void posordenaux(NodoBinario nodo){
        if (nodo==null)
            return;
        posordenaux(nodo.nodoizquiero);//inicia con el izquierdo
        posordenaux(nodo.nododerecho);//sigue con el derecho
        System.out.print(nodo.dato+", ");//muestra el izquierdo despues el derecho y despues el centro
    }

    boolean vacio(){
        return raiz==null;//Si la raiz es nula ps está vacio
    }

    void Menu(){
        int opcion=0;
        Scanner entrada=new Scanner(System.in);
        do {
            System.out.print("Opciones disponibles:" +
                    "\n1.-- Agregar datos" +
                    "\n2.-- Eliminar un dato" +
                    "\n3.-- Mostrar la altura del arbol" +
                    "\n4.-- Mostrar los padres del arbol" +
                    "\n5.-- Mostrar las hojas" +
                    "\n6.-- Mostrar nodos por el nivel" +
                    "\n---- Mostrar el contenido " +
                    "\n7.-- Preorden" +
                    "\n8.-- Inorden" +
                    "\n9.-- Posorden" +
                    "\n10.- Mostrar la raiz" +
                    "\n11.- Salir" +
                    "\nIngrese la opcion: ");opcion=entrada.nextInt();
            switch (opcion){
                case 1: agregar();break;
                case 2: eliminar();break;
                case 3: altura();break;
                case 4: mosPadres(raiz); break;
                case 5: mosHojas(raiz);break;
                case 6: mosNiveles();break;
                case 7: preorden();break;
                case 8: inorden();break;
                case 9: posorden();
                case 10: Raiz();break;
                case 11: System.out.println("Finalizando...");
            }
            System.out.println("\n\n");
        }while (opcion!=11);
        }

}


class NodoBinario{
    NodoBinario nodoizquiero;
    NodoBinario nododerecho;
    int dato;

    public NodoBinario(int datosnodo){
        dato=datosnodo;
        nododerecho=nodoizquiero=null;
    }
    public void InsertarNodo(int informacion){
        if (informacion<dato){
            if (nodoizquiero==null) {
                nodoizquiero = new NodoBinario(informacion);
            }else {
                nodoizquiero.InsertarNodo(informacion);
            }
        }else if (informacion>dato){
            if (nododerecho==null){
                nododerecho=new NodoBinario(informacion);

            }else {
                nododerecho.InsertarNodo(informacion);
            }
        }
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public NodoBinario getNodoizquiero() {
        return nodoizquiero;
    }

    public NodoBinario getNododerecho() {
        return nododerecho;
    }
}
