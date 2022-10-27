package TDADiccionario;

 /**
 * Clase Entry
 * @author Comision número 38. Ruppel Aldana/ Pires Valentin
 * @param <K> Tipo de dato de la clave
 * @param <V> Tipo de dato del valor
 */
public interface Entry<K,V> {
	
	/**
	 * Consulta la clave de la entry
	 * @return Clave de la entry
	 */
	
	public K getKey();
	
	/**
	 * Consulta el valor de la entry
	 * @return Valor de la entry
	 */
	
	public V getValue();
}