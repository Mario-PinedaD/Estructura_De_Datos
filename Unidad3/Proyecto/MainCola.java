package Estructura_De_Datos.Unidad3.Proyecto;

import java.util.Scanner;

public class MainCola {
    public static void main(String[] args) {
        Colacircular cola = new Colacircular();
        cola.menu();
    }
}

//Aqui inicia el código de colas doble
/*Instancia del problema:
 * En una pastelería se requiere llevar el control de los precios, el pedido, quien lo pidió y que cuando se termine el primer pedido
 * este se elimine*/

class Colacircular {

    nodoCircular Frente;
    nodoCircular Final;
    Scanner introducir = new Scanner(System.in);
    String nombre = "", contenido = "";
    int precio = 0;

    Colacircular() {
        Frente = null;
        Final = null;
    }

    boolean Vacia() {
        return Frente == null;
    }

    void añadirPedido() {
        introducir.useDelimiter("\n");
        System.out.println("Nombre del cliente: ");
        nombre = introducir.next();
        System.out.println("Requerimientos del pedido: ");
        contenido = introducir.next();
        System.out.println("Precio final: ");
        precio = introducir.nextInt();
        cliente nuevocliente = new cliente(nombre, contenido, precio);

        ingresar(nuevocliente.datoscliente());
    }

    public void ingresar(String cosas) {
        nodoCircular nodo;
        nodo = new nodoCircular(cosas);
        nodo.siguiente = nodo;
        if (Vacia()) {
            Frente = nodo;
            Final = nodo;
        } else {
            Final.siguiente = nodo;
            nodo.siguiente = Frente;
            Final = nodo;
        }
    }

    public void eliminar() {
        String dato;
        if (!Vacia()) {
            dato = Frente.contenido;
            System.out.println("Se ha eliminado el primer pedido: " + dato);
            if (Frente == Final) {
                Frente = null;
                Final = null;
            } else {
                Frente = Frente.siguiente;
                Final.siguiente = Frente;
            }
        } else {
            System.out.println("No hay datos que eliminar");
        }
    }

    void mostrar() {
        String cadena = "";
        nodoCircular aux;
        aux = Frente;

        if (!Vacia()) {
            do {
                cadena += aux.contenido + "-";
                aux = aux.siguiente;
            } while (aux != Frente);

            String caden[] = cadena.split("-");
            for (int i = 0; i < caden.length; i++) {
                System.out.println((i + 1) + " - " + caden[i]);
            }
        } else {
            System.out.println("la cola esta vacia");
        }
    }


    void menu() {
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Bienvenido a la pastelería teo, que desea realizar?" +
                    "\n1.- Agregar un pedido" +
                    "\n2.- Eliminar un pedido" +
                    "\n3.- Mostrar los pedidos pendientes" +
                    "\n4.- Salir");
            System.out.print("Teclee la accion correspondiente: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    añadirPedido();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    mostrar();
                    break;
                case 4:
                    System.out.print("Finalizando...");
                    break;
            }
            System.out.println("\n\n");
        } while (opcion != 4);
    }
}
//*==========================================================*//

class nodoCircular {
    nodoCircular siguiente;
    String contenido;

    nodoCircular() {
        this.siguiente = null;
        this.contenido = "";
    }

    nodoCircular(String contenido) {
        this.contenido = contenido;
    }

    public void setSiguiente(nodoCircular siguiente) {
        this.siguiente = siguiente;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public nodoCircular getSiguiente() {
        return siguiente;
    }

    public String getContenido() {
        return contenido;
    }
}

//*==========================================================*//

class cliente {
    String nombre, contenido;
    int precio;

    cliente(String nombre, String contenido, int precio) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.precio = precio;

    }

    public String datoscliente() {
        String cadena = nombre + "," + contenido + "," + precio;
        return cadena;
    }
}


