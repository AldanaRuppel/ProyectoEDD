package TDAColaCP;



import Auxiliares.Comparator;
import Exceptions.EmptyPriorityQueueException;
import Exceptions.InvalidKeyException;
import TDADiccionario.Entrada;
import TDADiccionario.Entry;

public class ColaCPconHeap<K extends Comparable<K>,V> implements PriorityQueue<K,V> {

	protected Entrada<K,V> arreglo[];
	protected int size;
	protected Comparator<K> comparador;
	
	/**
	 * Inicializa una cola con prioridad vacia
	 */
	
	@SuppressWarnings("unchecked")
	public ColaCPconHeap() {
		arreglo = (Entrada<K,V>[]) new Entrada[20];
		size = 0;
		comparador = new Comparator<K>();
	}
	 
	@SuppressWarnings("unchecked")
	public ColaCPconHeap(Comparator<K> comp) {
		arreglo = (Entrada<K,V>[]) new Entrada[20];
		size = 0;
		comparador = comp;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		if(size == 0)
			throw new EmptyPriorityQueueException("Error cola vacia");
		return arreglo[1];
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		// TODO Auto-generated method stub
		Entrada<K,V> entrada;
		int cont;
		boolean seguir;
		Entrada<K,V> elemActual;
		Entrada<K,V> elemPadre;
		Entrada<K,V> aux;
		if(key == null)
			throw new InvalidKeyException("La clave parametrizada es invalida");
		entrada = new Entrada<K,V>(key,value);
		size++;
		if(size+1 == arreglo.length)
			aumentarArreglo();
		cont = size;
		arreglo[cont] = entrada;
		seguir = true;
		while(cont > 1 && seguir) {
			elemActual = arreglo[cont];
			elemPadre = arreglo[cont/2];
			if(comparador.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				aux = arreglo[cont];
				arreglo[cont] = arreglo[cont/2];
				arreglo[cont/2] = aux;
				cont /= 2;
			}else
				seguir = false;
		}
		return entrada;
	}

	private void aumentarArreglo() {
		Entrada<K,V> arregloAnterior[];
		arregloAnterior = arreglo;
		arreglo = (Entrada<K,V>[]) new Entrada[arregloAnterior.length*2];
		for(int i = 1 ; i <= size ; i++) {
			arreglo[i] = arregloAnterior[i];
		}
	}
	
	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		int cont;
		Entrada<K,V> aux;
		int posHijoi;
		int posHijod;
		int posMin = 0;
		boolean seguir = true;
		boolean tieneHijoIzq;
		boolean tieneHijoDer;
		if(size == 0)
			throw new EmptyPriorityQueueException("La cola se encuentra vacia");
		Entry<K,V> entrada = min();
		if(size == 1) {
			arreglo[1] = null; 
			size--;
		}else {
			arreglo[1] = arreglo[size];//El ultimo elemento del arreglo 
			arreglo[size] = null;
			size--;
			cont = 1;
			while(seguir) {
				posHijoi = cont*2;
				posHijod = cont*2+1;
				tieneHijoIzq = posHijoi <= size;
				tieneHijoDer = posHijod <= size;
				if(!tieneHijoIzq)//Indica que llego a una hoja
					seguir = false;
				else {
					if(tieneHijoDer) {//Debo calcular cual es el menor de los hijos
						if(comparador.compare(arreglo[posHijoi].getKey(), arreglo[posHijod].getKey()) < 0)
							posMin = posHijoi;
						else
							posMin = posHijod;
					}else //no tiene hijo derecho la posmin es del hijo izq
						posMin = posHijoi;
				}
				//Ver si hay que intercambiar el actual con el menor de sus hijos
				if(seguir && comparador.compare(arreglo[cont].getKey(),arreglo[posMin].getKey()) > 0){
					aux = arreglo[cont];//intercambio
					arreglo[cont] = arreglo[posMin];
					arreglo[posMin] = aux;
					cont = posMin;
				}else
					seguir = false;
			}
		}
		return entrada;
	}
}