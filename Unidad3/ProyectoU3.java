package Estructura_De_Datos.Unidad3;
import java.util.Stack;

public class ProyectoU3 {
    public static void main(String[] args) {

        Stack<Libro> pila = new Stack<Libro>();

        Libro l1 = new Libro("El principito", "Antoine de Saint-Exupéry");
        Libro l2 = new Libro("Moby-Dick", " Herman Melville");
        Libro l3 = new Libro("La isla del tesoro", "Robert Louis Stevenson");

        pila.push(l1); // adiciona un libro a la pila
        pila.push(l2);
        pila.push(l3);

        System.out.println(pila.peek().getTitulo()); // el último elemento adicionado

        while (!pila.isEmpty()) { // mostrar pila completa
            System.out.println(pila.pop().getTitulo()); // extrae un elemento de la pila
        }

    }
}
class Libro {

    private String titulo;
    private String autor;

    public Libro() {
        this.titulo = "";
        this.autor = "";
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}