package Exceptions;

/**
 * Clase BoundaryViolationException.
 * Modela una excepcion para violacion de rangos.
 * @author Comision número 38. Ruppel Aldana/ Pires Valentin
 */
public class BoundaryViolationException extends Exception{
	
	/**
	 * Crea una BoundaryViolationException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public BoundaryViolationException(String msj) {
		super(msj);
	}
}