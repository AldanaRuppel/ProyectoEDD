package TDALista;

import Auxiliares.Position;

//falta javadoc
public class DNode<E> implements Position<E> { 
	//falta javadoc
	private E elemento;
	private DNode <E> siguiente; 
	private DNode <E> anterior; 
	
	//falta javadoc
	public DNode(E item) {
		this(item,null, null);
	}
	//falta javadoc
	public DNode(E item, DNode<E> sig, DNode<E> ant) {
		elemento = item;
		siguiente = sig;
		anterior = ant;
	}
	
	//falta javadoc
 	public void setElemento(E elemento) {
 	this.elemento = elemento;
	}
 	
 	//falta javadoc
	public void setSiguiente(DNode<E> siguiente) {
		this.siguiente= siguiente;
	}
	
	//falta javadoc
	public void setAnterior(DNode<E> anterior) {
		this.anterior= anterior;
	}
	
	//falta javadoc
	public DNode<E> getSiguiente(){
		return siguiente;
	}
	
	//falta javadoc
	public DNode<E> getAnterior(){
		return anterior;
	}
	
	//falta javadoc
	public E element() {
		return elemento;
	}
}
