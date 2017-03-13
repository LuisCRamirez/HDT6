//Algoritmos y Estructura de Datos
//Luis Carlo Ramirez - 15019
//HDT6

import java.util.Set;


public class Hash<E> {
    Factory fabrica = new Factory();
    /* Conjuntos que se utilizaran */
    private Set<E> conjuntoPrincipal;
    private Set<E> conjuntoResultado;
    
    /* Constructor */
    public Hash(int value){
	conjuntoPrincipal = fabrica.setInterfaz(value);
        conjuntoResultado = fabrica.setInterfaz(value);
    }
    public void add(E name){
        conjuntoPrincipal.add(name);
    }
    public Set<E> getConjunto(){
        return conjuntoPrincipal;
    }
    
    public Set<E> interseccionTresConjuntos(Set<E> conjuntoB, Set<E> conjuntoC){
        
        conjuntoResultado.clear();
        conjuntoResultado.addAll(conjuntoPrincipal);
        conjuntoResultado.retainAll(conjuntoB);
        conjuntoResultado.retainAll(conjuntoC);
        return conjuntoResultado;
    }
    
    public Set<E> interseccionDosConjuntos(Set<E> conjuntoB){
        
        conjuntoResultado.clear();
        conjuntoResultado.addAll(conjuntoPrincipal);
        conjuntoResultado.retainAll(conjuntoB);
        return conjuntoResultado;
    }
    
    public Set<E> unionDosConjuntos(Set<E> conjuntoB){
        
        conjuntoResultado.clear();
        conjuntoResultado.addAll(conjuntoPrincipal);
        conjuntoResultado.addAll(conjuntoB);
        return conjuntoResultado;
    }
    
    public Set<E> restaDosConjuntos(Set<E> conjuntoB){
    
        conjuntoResultado.clear();
        conjuntoResultado.addAll(conjuntoPrincipal);
        conjuntoResultado.removeAll(conjuntoB);
        return conjuntoResultado;
    
    }
    
    public int cantElementos(){
        
        int a = conjuntoPrincipal.size();
        return a;
    }
    
    public Object[] elementos(){
        
        Object[] elementos;
        elementos = conjuntoPrincipal.toArray();
        
        return elementos;
        
    }
    
    public Set<E> CopiarResultado(){
    
        return conjuntoResultado;
    }
    
    public void CopiarResultado(Set<E> conjuntoB){
    
        conjuntoPrincipal = conjuntoB;
    }
    
    public boolean subConjunto(Set<E> conjuntoB){
	conjuntoResultado.clear();
	conjuntoResultado.addAll(conjuntoB);
	conjuntoResultado.retainAll(conjuntoPrincipal);
	if (conjuntoResultado.size()==conjuntoPrincipal.size()){
		return true;
	}
	else{
		return false;
	}
    }
    
    @Override
    public String toString(){
	String desarrollador = conjuntoPrincipal.toString();
        desarrollador = desarrollador.replace("]", "");
        desarrollador = desarrollador.replace("[", " ");
        desarrollador = desarrollador.replace(",", "\n");
        return desarrollador;
    }
    
}
