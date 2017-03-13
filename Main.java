//Algoritmos y Estructura de Datos
//Luis Carlo Ramirez - 15019
//HDT6

import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        System.out.println("Bienvenido al programa");
        System.out.println();
        int x = 0;
        Scanner keyboard = new Scanner(System.in);
        //Hacer loop para progra defensiva
        while (x == 0){
            System.out.println("Elija el numero de implementacion SET a utilizar: ");
            System.out.println("1.HashSet");
            System.out.println("2.TreeSet");
            System.out.println("3.LinkedHashSet");
            try{
                x = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e){
		System.out.println();
                System.out.println("Error: dato invalido, intentelo de nuevo.");
		System.out.println();
                x = 0;
            }
            if (x < 1 || x > 3){
                x = 0;
                System.out.println();
                System.out.println("Error: opcion invalida, intentelo de nuevo.");
                System.out.println();
            }
        }
        //Crear interface SET a utilizar
        Hash conjuntoJava = new Hash(x);
		Hash conjuntoWeb = new Hash(x);
		Hash conjuntoMovil = new Hash(x);
        Hash conjuntoTemp = new Hash(x);
        
        
        
        x = 0;
        String nombre;
        int y;
        int cont = 1;
        int z;
        //Loop ingreso de desarrolladores
        while (x == 0){
            System.out.println("\nIngrese el nombre del desarrollador "+cont+": ");
            nombre = keyboard.nextLine();
            y = 0;
            int cont2 = 0;
            while (y == 0){
                System.out.println("\nIngrese el numero correspondiente al area del desarrollador:\n1. Java\n2. Web\n3. Moviles\n4. Terminar con este desarrollador");
                try{
                    y = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("\nError: dato invalido, intentelo de nuevo.");
                    y = 0;
                }
                if (y < 1 || y > 4){
                    y = 0;
                    System.out.println("\nError: opcion invalida, intentelo de nuevo.");
                }
                if (y == 1){
                    if (cont2 == 1 || cont2 == 4 || cont2 == 6){
                        System.out.println("\nEl desarrollador ya se encuentra en este conjunto");
                        y = 0;
                    } else{
                        System.out.println("\nSe añadio a los desarrolladores Java.");
                        conjuntoJava.add(nombre);
                        y = 0;
                        cont2 = cont2 + 1;
                    }
                }
                if (y == 2){
                    if (cont2 == 3 || cont2 == 4 || cont2 == 8){
                        System.out.println("\nEl desarrollador ya se encuentra en este conjunto");
                        y = 0;
                    } else{
                        System.out.println("\nSe añadio a los desarrolladores Web.");
                        conjuntoWeb.add(nombre);
                        y = 0;
                        cont2 = cont2 + 3;
                    }
                }
                if (y == 3){
                    if (cont2 == 5 || cont2 == 6 || cont2 == 8){
                        System.out.println("\nEl desarrollador ya se encuentra en este conjunto");
                        y = 0;
                    } else {
                        System.out.println("\nSe añadio a los desarrolladores Moviles.");
                        conjuntoMovil.add(nombre);
                        y = 0;
                        cont2 = cont2 + 5;
                    }
                }
                if (cont2 == 9) //Sale de este ciclo si esta en los 3 conjuntos
                    y = 1;
            }
            z = 0;
            while (z == 0){
                System.out.println("\nDesea continuar ingresando desarrolladores?\n1. Si\n2. No");
                 try{
                    z = Integer.parseInt(keyboard.nextLine());
                } catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("\nError: dato invalido, intentelo de nuevo.");
                    System.out.println();
                    z = 0;
                }
                if (z < 1 || z > 2){
                    z = 0;
                    System.out.println();
                    System.out.println("\nError: opcion invalida, intentelo de nuevo.");
                    System.out.println();
                }
            }
            x = z - 1;
            cont++;
        }
        
        
        Set<String> cJava = conjuntoJava.getConjunto();
        Set<String> cWeb = conjuntoWeb.getConjunto();
        Set<String> cMovil = conjuntoMovil.getConjunto();
        Set<String> cResultado = conjuntoTemp.getConjunto();
        
        System.out.println("\nA continuacion se mostraran las estadisticas requeridas: \n");
        System.out.println("¿Cuáles son los desarrolladores con experiencia en Java, web y celulares?\n");
        conjuntoJava.interseccionTresConjuntos(cWeb,cMovil);
        cResultado = conjuntoJava.CopiarResultado();
        conjuntoTemp.CopiarResultado(cResultado);
        System.out.println("Los desarrolladores con experiencia en Java, web y celulares son: "+conjuntoTemp.getConjunto()+"\n");
        conjuntoJava.restaDosConjuntos(cWeb);
        cResultado = conjuntoJava.CopiarResultado();
        conjuntoTemp.CopiarResultado(cResultado);
        System.out.println("Los desarrolladores con experiencia en Java que no tienen experiencia en web son: "+conjuntoTemp.getConjunto()+"\n");
        conjuntoWeb.interseccionDosConjuntos(cMovil);
        cResultado = conjuntoWeb.CopiarResultado();
        conjuntoTemp.CopiarResultado(cResultado);
        conjuntoTemp.restaDosConjuntos(cJava);
        System.out.println("Los desarrolladores con experiencia en Web y Celulares pero sin experiencia en java son: "+conjuntoTemp.CopiarResultado()+"\n");
        conjuntoWeb.unionDosConjuntos(cMovil);
        cResultado = conjuntoWeb.CopiarResultado();
        conjuntoTemp.CopiarResultado(cResultado);
        conjuntoTemp.interseccionDosConjuntos(cJava);
        System.out.println("Los desarrolladores con experiencia en Web o Celulares, pero que tienen experiencia en java son: "+conjuntoTemp.CopiarResultado()+"\n");
        if(conjuntoJava.subConjunto(cWeb)){
            System.out.println("El conjunto de desarrolladores Java es un subconjunto de Desarrolladores Web\n");
        }
        else{
            System.out.println("El conjunto de desarrolladores Java no es un subconjunto de Desarrolladores Web\n");
        }
        if(cJava.size()>cWeb.size()&& cJava.size()>cMovil.size()){
            System.out.println("El conjunto de desarrolladores Java es el mas grande, conformado por: \n");
            System.out.println(conjuntoJava.toString());
        }
        else if(cWeb.size()>cJava.size()&& cWeb.size()>cMovil.size()){
            System.out.println("El conjunto de desarrolladores Web es el mas grande, conformado por: \n");
            System.out.println(conjuntoWeb.toString());
        }
        else if(cMovil.size()>cJava.size()&& cMovil.size()>cWeb.size()){
            System.out.println("El conjunto de desarrolladores Movil es el mas grande, conformado por: \n");
            System.out.println(conjuntoMovil.toString());
        }
        else {
            System.out.println("No hay ningun conjunto mas grande");
        }
        
        
    }
}
