package Persistencia.View;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Persistencia.Conexion;


public class DAORiego {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	
	 public List<Riego> listRiego( ){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List listRiego = null;
	      try{
	         tx = session.beginTransaction();
	         Criteria crit =
	        		 session.createCriteria(Riego.class);
	        listRiego = crit.list();  
	         tx.commit();
	         return listRiego;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace();
	         return listRiego;
	      }
	   }
	
	
	 public Integer addRiego(Date fecha, Producto idProducto){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer daoID = null;
	      try{
	         tx = session.beginTransaction();
	         Riego riego = new Riego(fecha, idProducto);
	         daoID = (Integer) session.save(riego); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	      return daoID;
	   }
	 
	 public void updateRiego(Integer id,Date fechaRiego, Producto idProducto){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Riego riego = 
	                    (Riego)session.get(Riego.class, id); 
	         riego.setFecha( fechaRiego );
	         riego.setIdProducto( idProducto );
			 session.update(riego); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	 
	 
	 public void deleteRiego(Integer id){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Riego riego = 
	                   (Riego)session.get(Riego.class, id); 
	         session.delete(riego); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	 
	 
	 
}
