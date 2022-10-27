package TDALista;

import java.util.Iterator;


import Auxiliares.Position;
import Exceptions.*;


/**
 * Clase DoubleLinkedList
 * Implementa la interfaz PositionList con una lista doblemente enlazada
 * @author Comision número 38. Ruppel Aldana / Pires Valentin
 * @param <E> tipo de dato de los elementos
 */

public class DoubleLinkedList<E> implements PositionList<E>{
	private DNode<E> cabeza;
	private DNode<E> rabo;
	private int size;
	
	/**
	 * Crea una Lista doblemente enlazada vacia.
	 */
	
	public DoubleLinkedList(){ 
		cabeza = new DNode<E> (null, null, null);
		rabo = new DNode<E>(null, null, cabeza);
		cabeza.setSiguiente(rabo);
		size = 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public Position<E> first() throws EmptyListException{
		if (size == 0) { 
			throw new EmptyListException("La lista esta vacia");
		}
		return cabeza.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		if (size==0) {
			throw new EmptyListException("La lista esta vacia");
		}
		return rabo.getAnterior();
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		if (n == rabo.getAnterior()) {
			throw new BoundaryViolationException("No se le puede pedir el siguiente al ultimo elemento");
		}
		DNode<E> aux = n.getSiguiente();
		return aux;
	}
	
		public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		if (n == cabeza.getSiguiente()) {
			throw new BoundaryViolationException("No se le puede pedir el previo al primero");
		}
		DNode<E> aux = n.getAnterior();
		return aux;
	}
	
	public void addFirst(E element) {
		DNode<E> aux = new DNode<E>(element);
		aux.setSiguiente(cabeza.getSiguiente());
		cabeza.getSiguiente().setAnterior(aux);
		cabeza.setSiguiente(aux);
		aux.setAnterior(cabeza);
		size++;
	}
	
	public void addLast(E element) {
		DNode<E> aux = new DNode<E>(element);
		aux.setAnterior(rabo.getAnterior());
		rabo.getAnterior().setSiguiente(aux);
		rabo.setAnterior(aux);
		aux.setSiguiente(rabo);
		size++;
	}
	
	/**
	 * Verifica que la posicion dada sea valida 
	 * @param v Posicion a verificar
	 * @return El nodo correspondiente a la posicion dada 
	 * @throws InvalidPositionException si p no pertenece a la lista
	 */
	 private DNode <E> checkPosition(Position<E> p) throws InvalidPositionException{
		DNode <E> retornar = null;
		if (p == null || size == 0 || p.element()==null)
			throw new InvalidPositionException("No es una posicion de la lista o es una lista vacia");
		try {
			retornar = (DNode <E>)p;
		}catch(ClassCastException e) {
			e.getMessage();
		}
		return retornar;
	}
	
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		nuevo.setSiguiente(n.getSiguiente());
		nuevo.setAnterior(n);
		nuevo.getSiguiente().setAnterior(nuevo);
		n.setSiguiente(nuevo);
		size++;
	}

	public void addBefore(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		nuevo.setAnterior(n.getAnterior());
		nuevo.setSiguiente(n);
		nuevo.getAnterior().setSiguiente(nuevo);
		n.setAnterior(nuevo);
		size++;
	}

	public E remove(Position<E> p) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		E aux = n.element();
		n.getAnterior().setSiguiente(n.getSiguiente());
		n.getSiguiente().setAnterior(n.getAnterior());
		n.setAnterior(null);
		n.setSiguiente(null);
		n.setElemento(null);
		size--;
		return aux;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		E aux = n.element();
		n.setElemento(element);
		return aux;
	}
	
	public Iterator<E> iterator() {
		Iterator<E> it = new ElementIterator<E>(this); 
		return it;
	}
	
	public Iterable<Position<E>> positions(){
		DNode<E> pos;
		PositionList<Position<E>> list = new DoubleLinkedList<Position<E>>(); 
		if (size!=0) {
			pos = cabeza.getSiguiente();
			while (pos!=rabo) {
				list.addLast(pos);
				pos = pos.getSiguiente();
			}
		}
		return list;
	}
}