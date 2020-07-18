package Persistencia.View;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Producto implements Serializable {
	private int id;
	private String nombre;
	private TipoProducto tipoP;
	private String condicion;
	private Date fechaIngreso;
	
	List<Riego> Riegos;
	
	private TipoProducto tipoA;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public String getCondicion() {
		return condicion;
	}
	
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setTipoP(TipoProducto tipoP) {
		this.tipoP = tipoP;
	}
	
	public TipoProducto getTipoP() {
		return tipoP;
	}
	
	public void setRiegos(List<Riego> riegos) {
		Riegos = riegos;
	}
	
	public List<Riego> getRiegos() {
		return Riegos;
	}
	
	public Producto() {
		
	}
	
	public Producto(String nombre, TipoProducto tipoP, Date fechaIngreso, String condicion) {
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.tipoP = tipoP;
		this.condicion = condicion;
	}

}
