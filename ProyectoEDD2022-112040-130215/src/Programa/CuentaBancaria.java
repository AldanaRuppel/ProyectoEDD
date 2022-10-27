package Programa;

import TDALista.DoubleLinkedList;
import TDALista.PositionList;

public class CuentaBancaria {
	
//Atributos de instancia 
protected String nombre;
protected String apellido;
protected int Dni;
protected int monto;
protected PositionList<Transaccion> lista;

public CuentaBancaria (String nom, String apellido,int dni, int monto , PositionList<Transaccion>transacciones) {
	
nombre=nom;
this.apellido=apellido;
Dni=dni;
this.monto=monto;
PositionList<Transaccion> lista= new DoubleLinkedList<Transaccion>();	
}
//Metodos setters y getters
public String getNombre() {
	return nombre;
}
public String getApellido () {
	return apellido;
}
public int getDNI() {
	return Dni;
}
public int getMonto() {
	return monto;
}
}
