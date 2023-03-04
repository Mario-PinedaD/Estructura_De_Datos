package Estructura_De_Datos.Unidad3.Proyecto;

import java.util.LinkedList;
import java.util.Scanner;

/*
 *
 * */
public class MainPila {
    public static void main(String[] args) {

        PilaSimple pi = new PilaSimple();//Creo una pila

        pi.menu();//Ejecuto el menu de la pila

    }

}

/*
Instancia del programa: Suponiendo que una empresa de paquetería necesita guardar distintos elementos/productos/Objetos
en cajas y tiene que mover y eliminar las cajas que decida el organizador
* */
class PilaSimple {
    Scanner intro = new Scanner(System.in);//Para introducir valores
    int maximo = 0;

    LinkedList<String> pilaSimple = new LinkedList();

    PilaSimple() {
    }

    void ingresartamaño() {
        intro.useDelimiter("\n");
        if (pilaSimple.size() < maximo) {
            System.out.print("Nombre de la caja: ");
            String nombre = intro.next();
            System.out.print("Contenido de la caja: ");
            String contenido = intro.next();
            System.out.print("Responsable del empaque de la caja: ");
            String encargado = intro.next();
            caja cajanueva = new caja(nombre, contenido, encargado);
            pilaSimple.add(cajanueva.datos());
        } else {
            System.out.println("La pila está llena");
        }
    }

    void ingresar() {
        System.out.print("Nombre de la caja: ");
        String nombre = intro.next();
        System.out.print("Contenido de la caja: ");
        String contenido = intro.next();
        System.out.print("Responsable del empaque de la caja: ");
        String encargado = intro.next();
        caja cajanueva = new caja(nombre, contenido, encargado);
        pilaSimple.add(cajanueva.datos());
    }

    void eliminar() {
        System.out.print("Para retirar la ultima caja presione 1, para eliminar una en especifico presione 2: ");
        int opcion = intro.nextInt();
        if (opcion == 1) {
            pilaSimple.removeLast();
        } else {
            ePosicion();
        }
    }

    void ePosicion() {
        int posicion = 0;
        do {
            System.out.print("Introduzca una posicion del 1 al " + (pilaSimple.size()) + ": ");
            posicion = intro.nextInt();
            if (posicion <= pilaSimple.size()) {
                pilaSimple.remove(posicion - 1);
                posicion = 0;
            } else {
                System.out.println("Intentelo de nuevo");
            }

        } while (posicion > pilaSimple.size());
    }

    void vaciar() {
        pilaSimple.clear();
        System.out.println("Se han enviado las cajas");
        System.out.println("De nuevo volvemos a tener " + pilaSimple.size() + " cajas");
    }

    void mostrar() {

        if (pilaSimple.size() == 0) {
            System.out.println("No hay cajas que mostrar");
        } else {//Como tal se muestra desde el 0 hasta el valor maximo por eso se ve "alrevez" de como se debería ver, pero funciona
            System.out.println("Las cajas se muestran por: nombre, contenido, encargado");
            for (int i = 0; i < pilaSimple.size(); i++) {
                System.out.println((i + 1) + " - " + pilaSimple.get(i));
            }
        }
    }

    void menu() {
        int opcion = 0, desicion = 0;
        intro.useDelimiter("\n");
        System.out.print("Desea establecer un numero maximo de cajas? 1=si, otro numero=no: ");
        desicion = intro.nextInt();
        if (desicion == 1) {
            System.out.print("Introduzca un valor maximo: ");
            this.maximo = intro.nextInt();
            do {
                System.out.println("Bienvenido" +
                        "\n1 .- Añadir" +
                        "\n2 .- Eliminar" +
                        "\n3 .- Enviar las cajas al repartidor" +
                        "\n4 .- Mostrar las cajas" +
                        "\n5 .- Salir");
                System.out.print("Ingrese la opcion que desea ejecutar: ");
                opcion = intro.nextInt();

                switch (opcion) {
                    case 1:
                        ingresartamaño();
                        break;
                    case 2:
                        eliminar();
                        break;
                    case 3:
                        vaciar();
                        break;
                    case 4:
                        mostrar();
                        break;
                    case 5:
                        break;
                }
                System.out.println("\n\n");
            } while (opcion != 5);

        } else {
            do {
                System.out.println("Bienvenido" +
                        "\n1 .- Añadir" +
                        "\n2 .- Eliminar" +
                        "\n3 .- Enviar las cajas al repartidor" +
                        "\n4 .- Mostrar las cajas" +
                        "\n5 .- Salir");
                System.out.print("Ingrese la opcion que desea ejecutar: ");
                opcion = intro.nextInt();

                switch (opcion) {
                    case 1:
                        ingresar();
                        break;
                    case 2:
                        eliminar();
                        break;
                    case 3:
                        vaciar();
                        break;
                    case 4:
                        mostrar();
                        break;
                    case 5:
                        break;
                }
                System.out.println("\n\n");
            } while (opcion != 5);
        }
    }
}

class caja {
    String nombre = "", contenido = "", encargado = "";

    caja(String nombre, String contenido, String encargado) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.encargado = encargado;
    }

    String datos() {
        String cadena = nombre + "," + contenido + "," + encargado;
        return cadena;
    }
}