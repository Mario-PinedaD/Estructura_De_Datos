package Estructura_De_Datos.Unidad3;

import java.util.Scanner;

//http://codigolibre.weebly.com/blog/listas-simples-en-java#:~:text=Las%20listas%20son%20estructuras%20de,mediante%20la%20referencia%20a%20objetos.
public class ListasSimples {
    public static void main(String[] args) {

        ListasSimples nuevalista = new ListasSimples();

        nuevalista.menu();
    }

    nodolista inicio;
    int tamaño;

    public boolean estaVacia() {
        return inicio == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void agregarfinal(int valor) {
        nodolista nuevo = new nodolista();
        nuevo.setValor(valor);
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            nodolista apoyo = new nodolista();
            while (apoyo.getSiguiente() != null) {
                apoyo = apoyo.getSiguiente();
            }
            apoyo.setSiguiente(nuevo);
        }
        tamaño++;
    }

    public void aregarInicio(int valor) {
        nodolista nuevo = new nodolista();
        nuevo.setValor(valor);
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        tamaño++;
    }

    public void insertarPorReferencia(int referencia, int valor) {
        nodolista nuevo = new nodolista();
        nuevo.setValor(valor);
        if (!estaVacia()) {
            if (buscar(referencia)) {
                nodolista auxiliar = inicio;
                while (auxiliar.getValor() != referencia) {
                    auxiliar = auxiliar.getSiguiente();
                }
                nodolista siguiente = auxiliar.getSiguiente();
                auxiliar.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                tamaño++;
            }
        }
    }

    public void insertarPorPosicion(int posicion, int valor) {
        if (posicion >= 0 && posicion <= tamaño) {
            nodolista nuevo = new nodolista();
            nuevo.setValor(valor);
            if (posicion == 0) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else {
                if (posicion == tamaño) {
                    nodolista auxiliar = inicio;
                    while (auxiliar.getSiguiente() != null) {
                        auxiliar = auxiliar.getSiguiente();
                    }
                    auxiliar.setSiguiente(nuevo);
                } else {
                    nodolista auxiliar = inicio;
                    for (int i = 0; i < (posicion - 1); i++) {
                        auxiliar = auxiliar.getSiguiente();
                    }
                    nodolista siguiente = auxiliar.getSiguiente();
                    auxiliar.setSiguiente(nuevo);
                }
            }
            tamaño++;
        }
    }

    public int getValor(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            if (posicion == 0) {
                return inicio.getValor();
            } else {
                nodolista auxiliar = new nodolista();
                for (int i = 0; i < posicion; i++) {
                    auxiliar = auxiliar.getSiguiente();
                }
                return auxiliar.getValor();
            }
        } else {
            return 0;
        }
    }

    public boolean buscar(int referencia) {
        nodolista auxiliar = inicio;
        boolean encontrao = false;
        while (auxiliar != null && encontrao != true) {
            if (referencia == auxiliar.getValor()) {
                encontrao = true;
            } else {
                auxiliar = auxiliar.getSiguiente();
            }
        }
        return encontrao;
    }

    public int getPosicion(int referencia) {
        if (buscar(referencia)) {
            nodolista auxiliar = inicio;
            int cont = 0;
            while (referencia != auxiliar.getValor()) {
                cont++;
                auxiliar = auxiliar.getSiguiente();
            }
            return cont;
        } else {
            return 0;
        }
    }

    public void editarPorReferencia(int referencia, int valor) {
        if (buscar(referencia)) {
            nodolista auxiliar = inicio;
            while (auxiliar.getValor() != referencia) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setValor(valor);
        }
    }

    public void editarPorPosicion(int posicion, int valor) {
        if (posicion >= 0 && posicion < tamaño) {
            if (posicion == 0) {
                inicio.setValor(valor);
            } else {
                nodolista auxiliar = inicio;
                for (int i = 0; i < posicion; i++) {
                    auxiliar = auxiliar.getSiguiente();
                }
                auxiliar.setValor(valor);
            }
        }
    }

    public void eliminarPorReferencia(int referencia) {
        if (buscar(referencia)) {
            if (inicio.getValor() == referencia) {
                inicio = inicio.getSiguiente();
            } else {
                nodolista auxiliar = inicio;
                while (auxiliar.getSiguiente().getValor() != referencia) {
                    auxiliar = auxiliar.getSiguiente();
                }
                nodolista siguiente = auxiliar.getSiguiente().getSiguiente();
                auxiliar.setSiguiente(siguiente);
            }
            tamaño--;
        }
    }

    public void removerPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            if (posicion == 0) {
                inicio = inicio.getSiguiente();
            } else {
                nodolista auxiliar = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    auxiliar = auxiliar.getSiguiente();
                }
                nodolista siguiente = auxiliar.getSiguiente();
                auxiliar.setSiguiente(siguiente.getSiguiente());
            }
            tamaño--;
        }
    }

    public void eliminarlista() {
        inicio = null;
        tamaño = 0;
    }

    public void mostrarlista() {
        if (!estaVacia()) {
            nodolista auxiliar = inicio;
            int i = 0;
            while (auxiliar != null) {
                System.out.print(i + "[" + auxiliar.getValor() + "]   ->");
                auxiliar = auxiliar.getSiguiente();
                i++;
            }
        }
    }

    public void menu() {
        int opcion = 0, dato = 0, referencia = 0, posicion = 0;
        Scanner sc = new Scanner(System.in);
        ListasSimples nuevo = new ListasSimples();
        do {
            System.out.println("\n\nLas opciones disponibles son:" +
                    "\n1.-  Agregar al final de la lista" +
                    "\n2.-  Agregar al inicio de la lista" +
                    "\n3.-  Agregar Por referencia: Inserte un valor x despues de x valor" +
                    "\n4.-  Agregar en una posicion" +
                    "\n5.-  Obtener un valor de la lista: el de posicion x" +
                    "\n6.-  Obtener el tamaño de la lista" +
                    "\n7.-  Editar valores por posicion" +
                    "\n8.-  Eliminar un nodo buscando el valor" +
                    "\n9.-  Buscar un valor dentro de la lisa" +
                    "\n10.- Consulte si esta vacia" +
                    "\n11.- Mostrar lista" +
                    "\n12.- Salir" +
                    "\nIntroduzca la opcion que desea ejecutar: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el valor que desea agregar: ");
                    agregarfinal(dato = sc.nextInt());
                    break;
                case 2:
                    System.out.println("Introduzca el valor que desea agregar: ");
                    aregarInicio(dato = sc.nextInt());
                    break;
                case 3:
                    System.out.println("Introduzca el numero de referencia y despues el numero que desea agregar: ");
                    insertarPorReferencia(referencia = sc.nextInt(), dato = sc.nextInt());
                    break;
                case 4:
                    System.out.println("Introduzca el la posicion y despues el numero que desea agregar: ");
                    insertarPorPosicion(posicion = sc.nextInt(), dato = sc.nextInt());
                    break;
                case 5:
                    System.out.println("Introduzca la posicion que desea conocer: ");
                    posicion = sc.nextInt();
                    System.out.println("El valor en la posicion " + posicion + " es: " + getPosicion(posicion));
                    break;
                case 6:
                    System.out.println("El tamaño de la lista es: " + nuevo.getTamaño());
                    break;
                case 7:
                    System.out.println("Introduzca la posicion, este debe ser menor a " + getTamaño() + ":");
                    posicion = sc.nextInt();
                    System.out.println("Introduzca el valor: ");
                    dato = sc.nextInt();
                    editarPorPosicion(posicion, dato);
                    break;
                case 8:
                    System.out.println("Ingrese el valor que desea eliminar si es que existe: ");
                    referencia = sc.nextInt();
                    eliminarPorReferencia(referencia);
                    break;
                case 9:
                    System.out.println("Ingrese el valor que desea buscar: ");
                    buscar(referencia = sc.nextInt());
                    break;
                case 10:
                    System.out.println(nuevo.estaVacia());
                    break;
                case 11:
                    mostrarlista();
                    break;
                case 12:
                    System.out.println("Finalizando... ");

            }
        } while (opcion != 12);
    }
}

class nodolista {
    private int valor;
    private nodolista siguiente;

    public void nodolista() {
        this.valor = 0;
        this.siguiente = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public nodolista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodolista siguiente) {
        this.siguiente = siguiente;
    }
}