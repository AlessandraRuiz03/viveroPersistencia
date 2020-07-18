package Persistencia.View;

import java.io.Serializable;
import java.util.List;

import Persistencia.View.Producto;

public class TipoProducto implements Serializable {
	
	private int id;
	private String tipoProducto;
	private List<Producto> Productos;
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id; 
	}
	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	
	public TipoProducto() {
		
	}
	
	public TipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public void setProductos(List<Producto> productos) {
		Productos = productos;
	}
	
	public List<Producto> getProductos() {
		return Productos;
	}

}
