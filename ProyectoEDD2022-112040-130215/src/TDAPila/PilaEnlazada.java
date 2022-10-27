package TDAPila;
import Exceptions.EmptyStackException;

/**
 * Clase PilaEnlazada
 * Implementa la interfaz Stack con nodos simplemente enlazados.
 * @author Comision número 38. Ruppel Aldana / Pires Valentin
 * @param <E> tipo de dato de los elementos
 */

public class PilaEnlazada<E> implements Stack<E>{ 
	protected Nodo<E> head;
	protected int tamanio;
	
	/**
	 * Crea una Pila enlazada
	 */
	
	public PilaEnlazada() { 
		head = null;
		tamanio = 0;
	}
	
	
	public int size() {
		return tamanio;
	}
	
	public boolean isEmpty() {
		return (tamanio==0);
	}
	
	public E top() throws EmptyStackException{
		if (isEmpty()) {
			throw new EmptyStackException("La pila esta vacia");
		}
		return head.getElemento(); 
	}

	public void push(E element) { 
		Nodo<E> aux = new Nodo<E>(element,head); 
		head = aux;
		tamanio++;
	}
	
	public E pop() throws EmptyStackException{ 
		if (isEmpty()) {
			throw new EmptyStackException("La pila esta vacia");
		}
	E aux = head.getElemento();
	head = head.getSiguiente(); 
	tamanio--;
	return aux;
	}
} 