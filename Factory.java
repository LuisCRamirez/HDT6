//Algoritmos y Estructura de Datos
//Luis Carlo Ramirez - 15019
//HDT6

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Factory<E> {
    public Set<E> setInterfaz(int x){
        Set<E> lista = null;
        if (x == 1)
            lista = new HashSet<>();
        if (x == 2)
            lista = new TreeSet<>();
        if (x == 3)
            lista = new LinkedHashSet<>();
        return lista;
    }
}