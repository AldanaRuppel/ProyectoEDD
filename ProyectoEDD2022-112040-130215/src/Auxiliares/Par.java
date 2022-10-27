package Auxiliares;
/**
 * Clase Par.
 * @author Comision número 38. Ruppel Aldana / Pires Valentin
 *
 */

public class Par <K,V>{

	private K componente1; 
	private V componente2;
	
	/**
	 * Constructor de la clase Par
	 * @param k	primera componente
	 * @param v	segunda componenete
	 */
	
	public Par(K componente1, V componente2) {
		this.componente1 = componente1;
		this.componente2 = componente2;
	}
	
	/**
	 * Establece la primera componente al par
	 * @param k componente1 a establecer
	 */
	
	public void setComponente1(K componente1) {
		this.componente1 = componente1;
	}
	
	/**
	 * Establece la segunda componente a un par
	 * @param v componente2 a establecer
	 */
	
	public void setComponente2(V componente2) {
		this.componente2 = componente2;
	}
	

	/**
	 * Retorna la primera componente del par
	 * @return componente1
	 */
	public K getComponente1() {
		return componente1;
	}

	/**
	 * Retorna la segunda componente del grado
	 * @return componente2
	 */
	public V getComponente2() {
		return componente2;
	}
	

	/**
	 * Retorna el par 
	 * @return un string con el formato (componente1-componente2)
	 */
	public String goToString () {return "(" + componente1 + "-" + componente2 + ")";}

}