package Exceptions;

/**
 * Clase InvalidPositionException.
 * Modela una excepcion para posicion invalida.
 * @author Comision número 38. Ruppel Aldana /Pires Valentin
 */
public class InvalidPositionException extends Exception{
	
	/**
	 * Crea una InvalidPositionException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public InvalidPositionException(String msj){
		super(msj);
	}
}