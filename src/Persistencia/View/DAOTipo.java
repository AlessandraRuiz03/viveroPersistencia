package Persistencia.View;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Persistencia.Conexion;


public class DAOTipo {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	
	 public static List<TipoProducto> listTipo( ){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List listTipo = null;
	      try{
	         tx = session.beginTransaction();
	         Criteria crit =
	        		 session.createCriteria(TipoProducto.class);
	         listTipo = crit.list(); 
	         tx.commit();
	         return listTipo;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace();
	         return listTipo;
	      }
	   }
	
	
	 public static Integer addTipo(String tipoProducto){
		 System.out.println("Entro:"+tipoProducto);
		 factory = Conexion.getConexion();
		 Session session = factory.openSession();
	      System.out.println("1:"+tipoProducto);
	      Transaction tx = null;
	      Integer daoID = null;
	      try{
	         tx = session.beginTransaction();
	         System.out.println("2:"+tipoProducto);
	         TipoProducto tipo = new TipoProducto(tipoProducto);
	         System.out.println("3:"+tipoProducto);
	         daoID = (Integer)session.save(tipo); 
	         System.out.println("4:"+tipoProducto);
	         tx.commit();
	         System.out.println("5:"+tipoProducto);
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	      return daoID;
	   }
	 
	 public void updateTipo(Integer id,String tipoProducto){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         TipoProducto tipo = 
	                    (TipoProducto)session.get(TipoProducto.class, id); 
	         tipo.setTipoProducto( tipoProducto );
			 session.update(tipo); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	 
	 
	 public void deleteTipo(Integer id){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         TipoProducto tipoProducto = 
	                   (TipoProducto)session.get(TipoProducto.class, id); 
	         session.delete(tipoProducto); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	   }
	 
	 
	 
}
