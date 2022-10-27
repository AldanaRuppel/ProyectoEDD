package Programa;


import java.sql.Time;
import java.util.Date;

public class Transaccion {
	//Atributos de instancia
	protected Date fecha;
	protected Time hora;
	protected int monto;
	protected int dni;
	protected String apellido;
	protected String nombre;
	
public Transaccion (String nom, String apellido ,int dni, int monto ,Date fecha , Time hora) {
	nombre=nom;
	this.apellido=apellido;
	this.dni=dni;
	this.monto=monto;
	this.fecha=fecha;
	this.hora=hora;
}
//Metodos Setters y getters
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public String toString () {
		return " Nombre " +nombre+ "Apellido "+apellido+ "DNI : "+dni+ "Monto : 0"+monto+"Fecha : "+fecha+ "Hora :"+hora; 
	}
	
}

