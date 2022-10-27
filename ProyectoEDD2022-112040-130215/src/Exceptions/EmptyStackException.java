package Exceptions;

/**
 * Clase EmptyStackException.
 * Modela una excepcion para pila vacia.
 * @author Comision n�mero 38. Ruppel Aldana / Pires Valentin
 */
public class EmptyStackException extends Exception{
	
	/**
	 * Crea una EmptyStackException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public EmptyStackException(String msj) {
		super(msj);
	}
}