package Estructura_De_Datos.Unidad3.Pilas;
import java.util.*;
public class PilasArreglo {
    public static PilaArray Pila;

    public static void main(String[] ARGUMENTOS)
    {
        int MAX;
            Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la pila: ");
        MAX = sc.nextInt();
        Pila = new PilaArray(MAX);

        MenuPila();
    }

    public static void MenuPila()
    {
        Scanner sc=new Scanner(System.in);
        int Opcion;
        do{
            System.out.println("1.- Ingrese un valor");
            System.out.println("2.- Elimine un dato");
            System.out.println("3.- Muestre los datos de la pila");
            System.out.println("4.- Vacie la pila");
            System.out.println("5.- Salir");
            System.out.print("Ingrese su opcion: ");
            Opcion=sc.nextInt();
            switch(Opcion)
            {
                case 1: Pila.InsertarPila();break;
                case 2: Pila.EliminarPila();break;
                case 3: Pila.MostrarPila();break;
                case 4: Pila.VaciarPila();break;
                case 5: System.exit(0);break;
                default:System.out.println("INGRESE UNA OPCION VALIDA");break;
            }
        }
        while(Opcion!=5); //-- SEGUIRA HASTA QUE OPCION SEA IGUAL A 5
    }
}
class PilaArray {
    Scanner entrada=new Scanner(System.in);
    int[] PILA;
    int TOPE;
    int MAX;

    //-- CUANDO NO SE LE ASIGNA EL TAMAÑO MAXIMO
    public PilaArray()
    {
        this.TOPE = 0;
        this.MAX = 100;
        this.PILA = new int[this.MAX+1];
    }

    //-- CUANDO SE LE ASIGNA EL TAMAÑO MAXIMO
    public PilaArray(int MAX)
    {
        this.TOPE = 0;
        this.MAX = MAX;
        this.PILA = new int[this.MAX+1];
    }

    public int GetTOPE()
    {
        return TOPE;
    }

    public void VaciarPila()
    {
        this.TOPE = 0;
    }

    public boolean IsPilaLlena()
    {
        if(this.MAX == this.TOPE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean IsPilaVacia()
    {
        if(this.TOPE == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void InsertarPila()
    {
        if(this.IsPilaLlena())
        {
            System.out.println("LA PILA ESTA LLENA");
        }
        else
        {
            int ITEM;
            System.out.println("Ingrese el valor que desea agregar");
            ITEM = entrada.nextInt();

            this.TOPE++;
            this.PILA[this.TOPE] = ITEM;

            System.out.println("EL ITEM " + ITEM + " SE INSERTO A LA PILA");
        }
    }

    public void EliminarPila()
    {
        if(this.IsPilaVacia())
        {
            System.out.println("LA PILA ESTA VACIA");
        }
        else
        {
            int ITEM = this.PILA[this.TOPE];
            this.TOPE--;

            System.out.println("EL ITEM " + ITEM + " SE ELIMINO DE LA PILA");
        }
    }

    public void MostrarPila()
    {
        if(this.IsPilaVacia())
        {
            System.out.println("No hay datos que mostrar");
        }
        else
        {
            int i;
            String MOSTRAR = "";

            for(i=1;i<=this.TOPE;i++)
            {
                MOSTRAR = MOSTRAR + this.PILA[i]+"\n";
            }
            System.out.println("TOTAL ES : "+this.TOPE+"\n"+"LOS DATOS DE LA PILA SON : \n"+MOSTRAR);
        }
    }
}
