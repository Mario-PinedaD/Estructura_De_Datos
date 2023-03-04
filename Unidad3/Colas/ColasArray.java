package Estructura_De_Datos.Unidad3.Colas;
import java.util.*;

public class ColasArray {
    int max;
    int[] cola;
    int frente;
    int Final;
    Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        ColasArray c1=new ColasArray();
        c1.Menu();
    }

    public ColasArray(){
        this.max=5;
        this.frente=0;
        this.Final=0;
        this.cola=new int[this.max+1];
    }

    public ColasArray(int max){
        this.max=max;
        this.frente=0;
        this.Final=0;
        this.cola=new int[this.max+1];
    }

    public boolean Colallena(){
        if (this.Final==this.max){
            return true;
        }else {
            return false;
        }
    }

    public boolean Colavacia(){
        if (this.frente==this.Final){
            return true;
        }else {
            return false;
        }
    }

    public void insertar(){
        if (this.Colallena()){
            System.out.println("La cola está llena");
        }else {
            System.out.print("Ingrese el dato que desea agregar: ");
            int dato=sc.nextInt();
            this.Final++;
            this.cola[Final]=dato;
        }
    }

    public void eliminar(){
        if (this.frente==this.Final){
            System.out.println("La cola esta Colavacia");
        }else{
            for (int i=frente; i<Final-1;i++){
                cola[i]=cola[i+1];
            }
            Final--;
        }
    }

    public void MostrarCola(){
        if(this.Colavacia()){
            System.out.println("la cola esta Colavacia");
        }else{
            String mostar="";
            for (int i = frente+1;i<=Final;i++){
                mostar=mostar+cola[i]+"<-";
            }
            System.out.println("el total es: "+this.Final+"\nLos datos de la cola son: "+ mostar);
        }
    }

    public void VaciarCola(){
        frente=0;
        Final=0;
        System.out.println("la cola se ha vaciado correctamente");
    }

    public void Menu(){
        int opcion=0;
        do {
            System.out.println("\nLas opciones disponibles son: " +
                    "\n1.- Agregar Datos" +
                    "\n2.- Eliminar ultimo dato" +
                    "\n3.- Mostrar Cola" +
                    "\n4.- Vaciar cola" +
                    "\n5.-Salir");

        System.out.print("Ingrese la opcion que desea ejecutar: ");
        opcion=sc.nextInt();
        switch (opcion){
            case 1: insertar();break;
            case 2: eliminar();break;
            case 3: MostrarCola();break;
            case 4: VaciarCola();break;
            case 5: System.out.println("Gracias por ejecutarme");
        }

    }while (opcion!=5);
}}
