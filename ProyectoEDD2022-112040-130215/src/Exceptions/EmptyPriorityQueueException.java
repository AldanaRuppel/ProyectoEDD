package Exceptions;

/**
 * Clase EmptyStackException.
 * Modela una excepcion para pila vacia.
 * @author Comision número 36. Ruppel Aldana / Agustina Guastavino 
 */

public class EmptyPriorityQueueException  extends Exception{
	

	/**
	 * Crea una EmptyStackException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public EmptyPriorityQueueException (String msj) {
		super(msj);
	}
}


