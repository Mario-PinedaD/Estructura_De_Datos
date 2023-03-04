/*
 * El tecnologico de Veracruz solicito un programa para anotar a los alumnos que asistan a las conferencias
 * por lo cual se realizara una lista enlazada.
 */
package Estructura_De_Datos.Unidad3.Proyecto;
import java.util.LinkedList;
import java.util.Scanner;

public class ListaProyectoa {
  public static void main(String[] args) {
    
    LinkedList <Integer> numControl = new LinkedList<Integer>();
    LinkedList <String> nombre = new LinkedList<String>();
    LinkedList <Integer> semestre = new LinkedList<Integer>();
    Scanner sc = new Scanner(System.in);
    
    int op = 0;
    
    do{
      System.out.println("\n------------ Operacion a Realizar ------------");
      System.out.println("1. Ingresar Datos");
      System.out.println("2. Visualizar los datos en la lista");
      System.out.println("3. Eliminar la lista");
      System.out.println("4. Agregar datos al inicio de la lista");
      System.out.println("5. Agregar datos al final de la lista");
      System.out.println("6. Agregar datos en cualquier posición de la lista");
      System.out.println("7. Eliminar datos al inicio de la lista");
      System.out.println("8. Eliminar datos al final de la lista");
      System.out.println("9. Eliminar datos en cualquier posición de la lista");
      System.out.println("10. Cambiar datos de cualquier posicion");
      System.out.println("11. Comprobar si el dato existe en la Lista");
      System.out.println("12. Salir");
      System.out.println("----------------------------------------------");
      System.out.print("Operación elegida: ");
      op = sc.nextInt();
      switch(op){
        case 1:
          System.out.println("------------ Ingresar Datos ------------");
          System.out.println("¿Cuantos datos quieres ingresar?");
          int datosMax = sc.nextInt();
          for(int i=0; i<datosMax; i++){
            System.out.println("\n\tAlumno #" + i);
            System.out.print("Ingresa el nombre: ");
            String nombreA = sc.nextLine();
            nombre.add(sc.nextLine());
            System.out.print("Ingresa el semestre: ");
            int semestreA = sc.nextInt();
            semestre.add(semestreA);
            System.out.print("Ingresa tu Numero de Control: ");
            int numControlA = sc.nextInt();
            numControl.add(numControlA);
          }
          break;
        case 2:
          System.out.println("----------------- Visualizar Lista ----------------");
          if(nombre.size() > 0){
            System.out.println("\n\t Nombres \t");
            for(int i=0; i<nombre.size(); i++){
              System.out.println("-------------------------------------");
              System.out.println("\t" + nombre.get(i)  + "\t\tPosición: " + i);
              System.out.println("-------------------------------------");
              }
            System.out.println("\n\t Semestre \t");
            for(int j = 0; j<semestre.size(); j++){
              System.out.println("-----------------");
              System.out.println("|\t" + semestre.get(j) + "\t|" + "\t\tPosición: " + j);
              System.out.println("-----------------");
              }
            System.out.println("\n\t Numero de Control \t");
            for(int k = 0; k<numControl.size(); k++){
              System.out.println("-------------------------");
              System.out.println("|\t" + numControl.get(k) + "\t|" + "\t\tPosición: " + k);
              System.out.println("-------------------------");
              }
            }else{
              System.out.println("*La lista esta vacia*");
            }
          break;
        case 3:
          System.out.println("------------ Elimina todos los elementos de la Lista ------------");
          nombre.clear();
          semestre.clear();
          numControl.clear();
          System.out.println("*Lista eliminado con exito*");
          break;
        case 4:
          System.out.println("------------ Añade los datos en la primera posicion ------------");
          System.out.print("Ingresa el nombre: ");
          String nombreB = sc.nextLine();
          nombre.addFirst(sc.nextLine());
          System.out.print("Ingresa el semestre: ");
          int semestreB = sc.nextInt();
          semestre.addFirst(semestreB);
          System.out.print("Ingresa tu Numero de Control: ");
          int numControlB = sc.nextInt();
          numControl.addFirst(numControlB);
          break;
        case 5:
          System.out.println("------------ Añade los datos en la ultima posicion ------------");
          System.out.print("Ingresa el nombre: ");
          String nombreC = sc.nextLine();
          nombre.addLast(sc.nextLine());
          System.out.print("Ingresa el semestre: ");
          int semestreC = sc.nextInt();
          semestre.addLast(semestreC);
          System.out.print("Ingresa tu Numero de Control: ");
          int numControlC = sc.nextInt();
          numControl.addLast(numControlC);
          break;
        case 6:
          System.out.println("------------ Añade los datos en cualquier posicion ------------");
          System.out.print("Ingresa en que posicion quieres agregar el elemento: ");
          int posicion = sc.nextInt();
          System.out.print("Ingresa el nombre: ");
          String nombreD = sc.nextLine();
          nombre.add(posicion,sc.nextLine());
          System.out.print("Ingresa el semestre: ");
          int semestreD = sc.nextInt();
          semestre.add(posicion,semestreD);
          System.out.print("Ingresa tu Numero de Control: ");
          int numControlD = sc.nextInt();
          numControl.add(posicion,numControlD);
          break;
        case 7:
          System.out.println("------------ Elimina los datos de la primera posicion ------------");
          nombre.removeFirst();
          semestre.removeFirst();
          numControl.removeFirst();
          System.out.println("*Datos eliminados con exito*");
          break;
        case 8:
          System.out.println("------------ Elimina los datos de la ultima posicion ------------");
          nombre.removeLast();
          semestre.removeLast();
          numControl.removeLast();
          System.out.println("*Datos eliminados con exito*");
          break;
        case 9:
          System.out.println("------------ Elimina los datos en cualquier posicion ------------");
          System.out.print("\nIngresa en que posicion estan los datos que quieres eliminar: ");
          int elemPosicion = sc.nextInt();
          nombre.remove(elemPosicion);
          semestre.remove(elemPosicion);
          numControl.remove(elemPosicion);
          System.out.println("*Datos eliminados con exito*");
          break;
        case 10:
          System.out.println("------------ Cambia el dato en cualquier posicion ------------");
          System.out.println("¿Que quieres cambiar?\n1. Nombre\n2. Semestre\n3. Numero de Control");
          System.out.print("Operación elegida: ");
          int opcionA = sc.nextInt();
            switch(opcionA){
              case 1:
                System.out.print("Ingresa en que posicion esta el dato que quieres cambiar: ");
                int nomPosicion = sc.nextInt();
                System.out.print("Ingresa el nombre: ");
                String nombreE = sc.nextLine();
                nombre.set(nomPosicion,sc.nextLine());
                break;
              case 2:
                System.out.print("Ingresa en que posicion esta el dato que quieres cambiar: ");
                int semPosicion = sc.nextInt();
                System.out.print("Ingresa el semestre: ");
                int semestreE = sc.nextInt();
                semestre.set(semPosicion,semestreE);
                break;
              case 3:
                System.out.print("Ingresa en que posicion esta el dato que quieres cambiar: ");
                int contPosicion = sc.nextInt();
                System.out.print("Ingresa tu Numero de Control: ");
                int numControlE = sc.nextInt();
                numControl.set(contPosicion,numControlE);
                break;
            }
          break;
        case 11:
          System.out.println("------------ Comprueba si el elemento existe en la Lista ------------");
          System.out.println("¿Que quieres comprobarr?\n1. Nombre\n2. Semestre\n3. Numero de Control");
          System.out.print("Operación elegida: ");
          int opcionB = sc.nextInt();
          switch(opcionB){
            case 1:
              System.out.print("Ingresa el nombre que quieres comprobar: ");
              String compNombre = sc.nextLine();
              boolean comprobacionA = nombre.contains(sc.nextLine());
              if(comprobacionA == true){
                System.out.println("El nombre SI existe en la Lista");
              }else{
                System.out.println("El nombre NO existe en la Lista");
              }
              break;
            case 2:
              System.out.print("Ingresa el semestre que quieres comprobar: ");
              int compSemestre = sc.nextInt();
              boolean comprobacionB = semestre.contains(compSemestre);
              if(comprobacionB == true){
                System.out.println("El semestre -" + compSemestre + "- SI existe en la Lista");
              }else{
                System.out.println("El semestre -" + compSemestre + "- NO existe en la Lista");
              }
              break;
            case 3:
              System.out.print("Ingresa el Numero de Control que quieres comprobar: ");
              int compNumControl = sc.nextInt();
              boolean comprobacionC = numControl.contains(compNumControl);
              if(comprobacionC == true){
                System.out.println("El Numero de Control -" + compNumControl + "- SI existe en la Lista");
              }else{
                System.out.println("El Numero de Control -" + compNumControl + "- NO existe en la Lista");
              }
              break;
          }
          break; 
        case 12:
          op = 12;
          break;
        default:
          System.out.println("Operacion invalida");
          break;
      }
    }while(op != 12);
    sc.close();
    }
}