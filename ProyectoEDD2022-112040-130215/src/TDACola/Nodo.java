package TDACola;


/**
 * Clase Nodo
 * @author Comision número 38. Ruppel Aldana  / Pires Valentin
 * @param <E> tipo de dato del rotulo
 */

public class Nodo<E> {
	private E elemento; 
	private Nodo <E> siguiente;
	
	/**
	 *  Constructor de la clase Nodo.
	 * @param item valor a almacenar en el elemento del nodo
	 */
	public Nodo(E item) {
		this(item,null);
	}
	
	/**
	 * Constructor de la clase Nodo.
	 * @param item valor a almacenar en el elemento del nodo
	 * @param sig Nodo siguiente al actual.
	 */
	
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguiente = sig;
	}
	
	/**
	 * Asigna un valor al elemento
	 * @param elemento Elemento a asignar 
	 */
	
 	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
 	
 	/**
	 * Asigna el siguiente nodo al actual.
	 * @param siguiente nodo al actual.
	 */
 	
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente= siguiente;
	}
	
	/**
	 * Retorna el valor del elemento.
	 * @return valor del elemento.
	 */
	
	public E getElemento() {
		return elemento;
	}
	
	/**
	 * Retorna el siguiente nodo al nodo actual.
	 * @return Nodo siguente al actual.
	 */
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
}
