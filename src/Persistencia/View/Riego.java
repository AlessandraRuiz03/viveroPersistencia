package Persistencia.View;

import java.util.Date;

public class Riego {
	int id;
	Date fecha;
	Producto idProducto;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	
	public Producto getIdProducto() {
		return idProducto;
	}
	
	public Riego() {
		
	}
	
	public Riego( Date fecha, Producto idProducto) {
		this.fecha = fecha;
		this.idProducto = idProducto;
	}

}
