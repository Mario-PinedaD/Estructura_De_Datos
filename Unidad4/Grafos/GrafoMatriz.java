package Estructura_De_Datos.Unidad4.Grafos;
import javax.print.attribute.standard.Finishings;
import java.util.*;
//https://www.softwaretestinghelp.com/java-graph-tutorial/


public class GrafoMatriz {
    public static void main(String[] args) {

        List<direccion> direccions= Arrays.asList(new direccion(0, 2),
                new direccion(1, 3),
                new direccion(1, 5),
                new direccion(3,7));

        GrafoMatriz grafoMatriz=new GrafoMatriz(direccions);

        grafoMatriz.mostrar(grafoMatriz);
    }

    List<List<nodogra>> lista = new ArrayList<>();

    public GrafoMatriz(List<direccion> direccions) {
        for (int i = 0; i < direccions.size(); i++) {
            lista.add(i, new ArrayList<>());
        }
        for (direccion d : direccions) {
            lista.get(d.inicio).add(new nodogra(d.inicio));
        }
    }

    static void mostrar(GrafoMatriz grafoMatriz) {
        int vertices = 0;
        int tamaño = grafoMatriz.lista.size();
        System.out.println("El grafo contiene: ");
        while (vertices < tamaño) {
            for (nodogra direccion : grafoMatriz.lista.get(vertices)) {
                System.out.println("Vertice: " + vertices + " -> " + direccion.valor);
            }
            System.out.println();
            vertices++;
        }

    }
}

    class direccion {
        int inicio, destino;

        direccion(int inicio, int destino) {
            this.inicio = inicio;
            this.destino = destino;
        }
    }

    class nodogra {
        int valor;
        nodogra(int valor) {
            this.valor = valor;
        }
    }

