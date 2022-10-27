package TDADiccionario;

/**
 * Clase Entrada
 * implementa la interfaz Entry 
 * @author Comision número 38. Ruppel Aldana /Pires Valentin
 * @param <K> Tipo de dato para la clave
 * @param <V> Tipo de dato para el valor
 */
public class Entrada<K,V> implements Entry<K,V> {
	private K clave;
	private V valor;
	
	/**
	 * Constructor de la clase Entrada
	 * @param clave Clave de la entrada
	 * @param valor Valor de la entrada
	 */
	public Entrada(K clave, V valor) { 
		this.clave = clave;
		this.valor = valor;
	}
	
	/**
	 * Consulta la clave de la entrada
	 * @return Clave de la entrada
	 */
	
	public K getKey() {
		return clave;
	} 
	
	/**
	 * Consulta el valor de la entrada
	 * @return Valor de la entrada
	 */
	
	public V getValue() {
		return valor;
	}
	
	/**
	 * Establece la clave de la entrada 
	 * @param clave Clave a establecer
	 */
	
	public void setKey( K clave ) {
		this.clave = clave;
	}
	
	/**
	 * Establece el valor de la entrada 
	 * @param valor Valor a establecer
	 */
	
	public void setValue(V valor) {
		this.valor = valor; 
	}
	
	/**
	 * Consulta el contenido de la entrada
	 * @return Clave y valor de la entrada
	 */
	
	public String toString( ) { 
		return "(" + getKey() + "," + getValue() +")";
	}
}