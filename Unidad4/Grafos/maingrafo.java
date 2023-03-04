package Estructura_De_Datos.Unidad4.Grafos;

/*
 * Agregar vertice
 * Agregar Arista
 * Eliminar Vertice
 * Eliminar Arista
 * Matriz de Adyacensia
 * Lista de adyacensia
 * Lista de incidencia
*/

import java.util.*;

public class maingrafo {
    public static void main(String[] args) {
        maingrafo mgrafo = new maingrafo();
        mgrafo.menuestatico();
    }

    void menuestatico() {
        //Funcion menú donde se realizan las operaciones correspondientes
        Scanner sc = new Scanner(System.in);
        int opcion = 0, lim = 0;
        System.out.print("Introduzca el limite: ");
        lim = sc.nextInt();

        Grafo nuevo = new Grafo(lim);

        do {
            System.out.print("\n*********************" +
                    "\n1.- Agregar vertice" +
                    "\n2.- Eliminar vertice" +
                    "\n3.- Agregar Arista" +
                    "\n4.- Eliminar Arista" +
                    "\n5.- Mostrar todos los vertices" +
                    "\n6.- Mostrar Matriz de adyacencia" +
                    "\n7.- Mostrar Lista de adyacencia" +
                    "\n8.- Mostrar Lista de incidencia" +
                    "\n9.- Salir" +
                    "\nIngrese su opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    nuevo.agragarvertice();
                    break;
                case 2:
                    nuevo.eliminaVertice();
                    break;
                case 3:
                    nuevo.añadirArista();
                    break;
                case 4:
                    nuevo.eliminarArista();
                    break;
                case 5:
                    nuevo.todos();
                    break;
                case 6:
                    nuevo.mMatriz();
                    break;
                case 7:
                    nuevo.listaady();
                    break;
                case 8:
                    nuevo.listasincidencia();
                    break;
                case 9:
            }
        } while (opcion != 9);
    }
}

class Grafo<G> {
    private HashMap<G, Set<G>> listaadya;
    Scanner en = new Scanner(System.in);
    int dato = 0, des = 0, tam = 0;
    int tmax = 0;

    Grafo(int tmax) {
        this.listaadya = new HashMap<>();
        this.tmax = tmax;
    }

    void agragarvertice() {
        if (tam == tmax) {
            System.out.println("No se puede");
        } else {
            System.out.print("Valor que desea agregar: ");
            dato = en.nextInt();
            vertice verti = new vertice(dato);
            agVertice((G) Integer.toString(verti.dev()));
        }
    }

    void agVertice(G ver) {
        if (this.listaadya.containsKey(ver)) {//si ya lo contiene
            System.out.println("El vertice ya existe");
        } else {
            // Id 5 , ...
            this.listaadya.put(ver, new HashSet<G>());
            System.out.println("Valor añadido correctamente :D");
            this.tam++;
        }
    }

    void eliminaVertice() {
        if(tam == 0){
            System.out.print("Grafo vacio");
        }else {
            System.out.print("Dato que desea eliminar: ");
            dato = en.nextInt();
            //Nuevo vertice con un dato
            vertice ver = new vertice(dato); //int
            eVertice((G) Integer.toString(ver.dev()));
        }
    }

    void eVertice(G ver) {
        if (!this.listaadya.containsKey(ver)) {
            System.out.print("No existe el vertice");
        } else {
            //Remueve el vertice
            this.listaadya.remove(ver);
            for (G u : this.todosVertices()) {
                //Se obtiene el valor de todos los vertices y se remueve el vertice
                this.listaadya.get(u).remove(ver);
            }
            System.out.println("Vertice eliminado correctamente.");
            this.tam--;
        }
    }

    void añadirArista() {
        System.out.print("Vertice origen: ");
        dato = en.nextInt();
        System.out.print("Destino: ");
        des = en.nextInt();

        vertice vorigen = new vertice(dato);
        vertice vdestino = new vertice(des);
        aArista((G) Integer.toString(vorigen.dev()) , (G) Integer.toString(vdestino.dev()));
    }

    void aArista(G ver, G over) {
        //Si alguno de los dos vertices no existen, pues no se puede
        // && "Y" || "o"
        if (!this.listaadya.containsKey(ver) || !this.listaadya.containsKey(over)) {
            System.out.println("Un nodo no existe");
        } else {
            //Si ya existe una arista pues ya no se ingresa nada
            if ( esAdyacente(ver, over) ) {
                System.out.println("Ya existe una coneccion");
            } else {
                //si no existe ninguna, se crean las conecciones de uno al otro y viceversa
                this.listaadya.get(ver).add(over);
                this.listaadya.get(over).add(ver);
                System.out.println("Se ha generado la coneccion entre " + ver + " y " + over + " correctamente");
            }
        }
    }

    void eliminarArista() {
        System.out.print("Origen: ");
        dato = en.nextInt();
        System.out.print("Destino: ");
        des = en.nextInt();
        vertice Vorigen = new vertice(dato);
        vertice Vdes = new vertice(des);
        eArista((G) Integer.toString(Vorigen.dev()), (G) Integer.toString(Vdes.dev()));
    }

    void eArista(G ver, G over) {
        //Si alguno de los 2 valores no existen no se puede
        if (!this.listaadya.containsKey(ver) || !this.listaadya.containsKey(over)) {
            System.out.println("Uno de los valores no existe");
        } else {
            //Si no existe una arista no se puede eliminar
            if (!esAdyacente(ver, over)) {
                System.out.println("No existe coneccion entre ellos");
            } else {
                //Al igual que en el añadir se eliminan ambas conecciones.
                this.listaadya.get(ver).remove(over);
                this.listaadya.get(over).remove(ver);
                System.out.println("Arista eliminara correctamente.");
            }
        }
    }

    void mMatriz() {
        System.out.println("Los vertices dentro de la matriz son: " + todosVertices());
        System.out.print("---");
        for (G ver : listaadya.keySet()) {System.out.print(" " + ver + " ");}
        System.out.println();
        for (G v1 : listaadya.keySet()) {System.out.print(v1 + " ");
            for (G v2 : listaadya.keySet()) {
                if (esAdyacente(v1, v2)) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    void listasincidencia() {
        for (G ver1 : listaadya.keySet()) { //1
            System.out.print(ver1 + " -> ");
            for (G ver2 : listaadya.keySet()) {//2
                if (esAdyacente(ver1, ver2)) {
                    System.out.print("(" + ver1 + "," + ver2 + ")");
                }
            }
            System.out.println();
        }
    }

    void listaady() {
        for (G mapa : listaadya.keySet()) {
            System.out.print("[" + mapa + "]");
            for (G mapa2 : listaadya.keySet()) {
                if (esAdyacente(mapa, mapa2)) {
                    System.out.print(" -> [" + mapa2 + "]");
                }
            }
            System.out.println();
        }
    }
    boolean esAdyacente(G ver, G over) {
        return this.listaadya.get(ver).contains(over);
    }

    Iterable<G> todosVertices() {
        //Regresa todos los vertices
        return this.listaadya.keySet();
    }

    void todos() {
        System.out.print(todosVertices());
    }
}
/*============================*/

class vertice {
    public int dato;
    public vertice(int dato) {
        this.dato = dato;
    }
    public int dev() {
        return dato;
    }
}
