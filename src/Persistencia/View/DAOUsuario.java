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
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Persistencia.Conexion;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class DAOUsuario {
	
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	
	
	 public Integer addUsuario(String correo, String password){
		 factory = Conexion.getConexion();
	      Session session = factory.openSession();
	      
	      Transaction tx = null;
	      Integer daoID = null;
	      try{
	         tx = session.beginTransaction();
	         Usuario usuari = new Usuario(correo, password);
	         daoID = (Integer) session.save(usuari); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return daoID;
	   }
	 
		  public boolean verificarUsuarios(String correo, String password) {
			  factory = Conexion.getConexion();
				Session session = factory.openSession();
				 Criteria crit =
		        		 session.createCriteria(Usuario.class);
				 crit.add(Restrictions.like("Correo", correo));
				 crit.add(Restrictions.like("Password", password));
		         List results = crit.list();
				if(crit.uniqueResult()!= null) {
					return true;
				}
				System.out.println("USUARIO O CONTRASEÑA INCORRECTA");
				return false;
				
			
		
		}
	 
	 
}
