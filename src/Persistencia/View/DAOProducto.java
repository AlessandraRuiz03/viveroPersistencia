package Persistencia.View;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Persistencia.Conexion;


public class DAOProducto {
	
	private static SessionFactory factory;
	
	public static List<Producto> listProducto(){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null; 
	      List results = null;
	      try{ 
	         tx = session.beginTransaction();
	         Criteria crit =
	        		 session.createCriteria(Producto.class);
	         results = crit.list();  
	         tx.commit();
	         return  results; 
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return  results; 
	         
	      }
	   }
	
	
	 public Integer addProducto(String nombre,Date date, String condicion, TipoProducto tipo){
		 factory = Conexion.getConexion(); 
		 Session session = factory.openSession();
	      Transaction tx = null;
	      Integer daoID = null;
	      try{
	         tx = session.beginTransaction();
	         Producto product = new Producto(nombre, tipo,date,condicion);
	         System.out.println("Entrooo");
	         daoID = (Integer) session.save(product); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	      return daoID;
	   }
	 
	 public void updateProducto(Integer id, String nombre, TipoProducto tipoP, String condicion, Date fecha ){
		 factory = Conexion.getConexion(); 
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Producto product = 
	                    (Producto)session.get(Producto.class, id); 
	         product.setNombre( nombre );
	         product.setTipoP( tipoP );
	         product.setCondicion( condicion );
	         product.setFechaIngreso( fecha );
			 session.update(product); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	 
	 
	 public void deleteProducto(Integer id){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Producto product = 
	                   (Producto)session.get(Producto.class, id); 
	         session.delete(product); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	 
	 





	 
	 
}
