package Persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Persistencia.View.ProductoController;


public class Conexion { 
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory getConexion(){
		
		 System.err.println("Iniciando");
       try {
           Configuration configuration = new Configuration();
           System.err.println("Leyendo configuracion.");
           configuration.configure();
           serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
           factory = configuration.buildSessionFactory(serviceRegistry);
           System.out.println("CONECTOOO");
           
       } catch (Throwable ex) {
     	  System.out.println("ERROR");
           System.err.println("No se puede crear la Sesion" + ex);
           throw new ExceptionInInitializerError(ex);
       }
	return factory;
	
}
	
	

}
