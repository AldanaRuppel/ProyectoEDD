package Exceptions;

/**
 * Clase EmptyQueueException.
 * Modela una excepcion para cola vacia.
 * @author Comision número 38. Ruppel Aldana / Pires Valentin
 */
public class EmptyQueueException extends Exception{
	
	/**
	 * Crea una clase EmptyQueueException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public EmptyQueueException(String msj) {
		super(msj);
	}
}