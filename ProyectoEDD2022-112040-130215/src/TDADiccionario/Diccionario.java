package TDADiccionario;

import java.util.Iterator;

import Auxiliares.Position;
import Exceptions.BoundaryViolationException;
import Exceptions.EmptyListException;
import Exceptions.InvalidEntryException;
import Exceptions.InvalidKeyException;
import Exceptions.InvalidPositionException;
import TDALista.DoubleLinkedList;
import TDALista.PositionList;

/**
 * Clase Diccionario
 * Implementa la interfaz Dictionary con un diccionario con hash abierto
 * @author Comision número 38. Ruppel Aldana / Pires Valentin
 * @param <K> tipo de dato de la clave
 * @param <V> tipo de dato del valor
 */
public class Diccionario<K,V> implements Dictionary<K,V> {
	protected PositionList<Entrada<K,V>> [] arregloBucket;
	protected int n;
	protected int N;
	protected static final float factor = 0.9f;

	/**
	 * Crea un Diccionario
	 */
	
	public Diccionario() {
		N = 13;
		arregloBucket = new DoubleLinkedList[N]; 
		for (int i=0; i<N; i++)
			arregloBucket[i] = new DoubleLinkedList<Entrada<K,V>>();
		n = 0;
	}

	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	/**
	 * Calcula el valor del bucket donde se guardara la entrada con clave k
	 * @param k clave a la que se calcula el valor Hash
	 * @return El el valor Hash asociado a la clave k 
	 * @throws InvalidKeyException si k no es una clave valida
	 */
	private int HashThisKey(K k) throws InvalidKeyException{
		checkKey(k);
		return Math.abs(k.hashCode() % N);
	}
	
	/**
	 * Verifica que la clave dada sea valida 
	 * @param clave a verificar
	 * @return la clave dada 
	 * @throws InvalidKeyException si clave no pertenece al diccionario
	 */
	private K checkKey(K clave) throws InvalidKeyException{
		if (clave==null)
			throw new InvalidKeyException("");
		return clave;
	}
	
	/**
	 * Verifica que la entrada dada sea valida 
	 * @param e entrada a verificar
	 * @return la entrada dada 
	 * @throws InvalidEntryException si e no pertenece al diccionario
	 */
	private Entry<K,V> checkEntry(Entry<K,V> e) throws InvalidEntryException{
		Entry<K,V> retornar;
		try {
			if (e==null)
				throw new InvalidEntryException("");
			retornar = (Entry<K,V>) e;
		}
		catch(ClassCastException es) {
			throw new InvalidEntryException("");
		}
		return retornar;
	}
	
	/**
	 * Metodo auxiliar que redimensiona el arreglo Bucket
	 */
	private void ReHash() {
		Iterable<Entry<K,V>> entradas = entries();
		try {
			int aux = N;
			N=nextPrimo(N);
			PositionList<Entrada<K,V>> [] arreglo = new PositionList[N];
			for (int i=0; i<N; i++)
				arreglo[i] = new DoubleLinkedList<Entrada<K,V>>();
			for(int i = 0; i<aux; i++) {
				for(Entrada<K,V> e : arregloBucket[i])
					arreglo[HashThisKey(e.getKey())].addLast(e); 	
			}
			arregloBucket=arreglo;
		}
		catch(InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo auxiliar para calcular el siguiente numero primo 
	 * @param n la cantidad de entradas
	 * @return el siguiente primo de n
	 */
	private int nextPrimo(int n) {
		int retornar = 2*n;
		int div = 1;
		int cont = 0;
		while (cont!=2) {
			retornar++;
			cont = 0;
			div = 1;
			while (div<=retornar) {
				if (retornar%div==0)
					cont++;
				div++;
			}
		}
		return retornar;	
	}

	public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException{
		PositionList<Entry<K,V>> L = new DoubleLinkedList<Entry<K,V>>();
		K clave = checkKey(key);
		Iterator<Entrada<K, V>> it = arregloBucket[HashThisKey(clave)].iterator();
		Entrada<K,V> aux = null;
		while (it.hasNext()) {
			aux = it.next();
			if (aux.getKey().equals(clave))
				L.addLast(aux);
		}
		return L;
	}

	public Entry<K,V> find(K key) throws InvalidKeyException{
		Entry<K,V> retornar = null;
		K clave = checkKey(key);
		boolean encontre = false;
		Iterator<Entrada<K,V>> it = arregloBucket[HashThisKey(clave)].iterator();
		Entry<K,V> aux = null;
		while (it.hasNext() && !encontre) {
			aux = it.next();
			if (aux.getKey().equals(clave)) { 
				retornar = aux;
				encontre = true;
				}
			}
		return retornar;
	}

	public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
		K clave = checkKey(key);
		Entrada<K, V> nuevo = new Entrada<K,V>(clave, value); 
		arregloBucket[HashThisKey(key)].addLast(nuevo);
		n++;
		if (!(n/N < factor))
			ReHash();
		return nuevo;
	}
	
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException {
		Entry<K,V> aux = checkEntry(e);
		boolean encontre = false;
		try {
			PositionList<Entrada<K,V>>  l= arregloBucket[HashThisKey(aux.getKey())];
			Position<Entrada<K,V>> pos = null;
			if (!l.isEmpty()) {
				pos = l.first();
			}
			while (pos != null && !encontre) {
					
				if(pos.element().getKey().equals(aux.getKey()))
					{encontre = true;
					arregloBucket[HashThisKey(aux.getKey())].remove(pos);
					n--;}
				if(pos == l.last())
					pos = null;
				else
					pos = l.next(pos);
				
				}
		}catch(InvalidPositionException|InvalidKeyException|BoundaryViolationException|EmptyListException es) {
			System.out.println(es.getMessage());
		}
		if (!encontre) {
			throw new InvalidEntryException("Entrada no valida");
		}
		return aux;
	}

	public Iterable<Entry<K,V>> entries(){
		PositionList<Entry<K,V>> L = new DoubleLinkedList<Entry<K,V>>();
		Iterator<Entrada<K, V>> it;
		for (int i=0; i<N; i++) {
			it = arregloBucket[i].iterator();
			while(it.hasNext())
				L.addLast(it.next());
		}
		return L;
	}
}
