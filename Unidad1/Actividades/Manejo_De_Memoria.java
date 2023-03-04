package Estructura_De_Datos.Unidad1.Actividades;

public class Manejo_De_Memoria {
    private final int habitaciones=16;//Variable Final
    private static int inquilinos=76;//Método de memoria estático
    private double renta;//Método de Memoria dinámica

    public Manejo_De_Memoria(int cantida){//Método Memoria Automática
    renta=(cantida*habitaciones)/inquilinos;
    }

    public double getRenta() {//Método de Memoria dinámica
        return renta;
    }
/*
* En comentarios debemos de poner que tipo de memoria se usa, sea estática, dinámica o automatica
* */
    public static int getInquilinos(){//Método de memoria estático
        return inquilinos;
    }

    public static void main(String[] args) {
        System.out.println("Nº Inquilinos: "+inquilinos);
        System.out.println("Nº Inquilinos: "+getInquilinos());

        Manejo_De_Memoria unidad=new Manejo_De_Memoria(1400);//Método de memoria dinámica

        System.out.println("Nº de habitaciones: "+ unidad.habitaciones);
        System.out.println("Renta nominal "+ unidad.getRenta());
    }


}
