package Estructura_De_Datos.Unidad4;

import java.util.Scanner;


public class VeterinariaArbol {

    public static void main(String[] args) {
        VeterinariaArbol ve=new VeterinariaArbol();

        ve.menu();
    }
    Scanner sc=new Scanner(System.in);
    nodoVeterinaria Raiz;
    String nperro,dueño;


    VeterinariaArbol(){
        Raiz.informacion="El perro feliz";
    }

    void ingresarPerro(){
        sc.useDelimiter("\n");
        System.out.print("Introduzca el nombre del perro: ");
        nperro=sc.next();
        System.out.print("Introduzca el nombre del dueño: ");
        dueño=sc.next();
        nodoVeterinaria nodo=new nodoVeterinaria();

        mascota mas=new mascota(nperro);
        dueño du=new dueño(dueño);
        Raiz.siguiente.informacion=du.datos();

    }

    void menu(){
        System.out.println("Bienvenido a la veterinaria el Perro feliz." +
                "\nA continuacion se muestran las siguientes opciones: ");
        int opcion=0;
        do {
            System.out.print("1.- Ingresar un nuevo perro." +
                    "\n2.- Ingresar una vacuna para un perro." +
                    "\n3.- Mostrar las vacunas de un perro." +
                    "\n4.- Salir" +
                    "\nElija la opcion deseada:");
        }while (opcion!=8);

    }
}

class nodoVeterinaria{
    nodoVeterinaria izquierdo,derecho;
    nodoVeterinaria siguiente,anterior;
    String informacion;
    Scanner sc=new Scanner(System.in);

    nodoVeterinaria(){
        anterior=null;
        siguiente=null;
        informacion="";
    }
}

class dueño{
    private String nombre;

    dueño(String nombre){
        this.nombre=nombre;
    }
    public String datos(){
        return nombre;
    }
}

class mascota{
    String nombre;

    mascota(String nombre){
        this.nombre=nombre;
    }

    String datosmascota(){
        return nombre;
    }
}
class vacuna{
    String vacuna, fecha;

    vacuna(String vacuna, String fecha){
        this.vacuna=vacuna;
        this.fecha=fecha;
    }
    String datosvacuna(){
        return vacuna+","+fecha;
    }
}