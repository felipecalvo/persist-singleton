package main;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public final class Singleton implements WithGlobalEntityManager{
	
	static EntityManager em;
	
	private static Singleton instance = null;
	
	private Singleton(){
		em = PerThreadEntityManagers.getEntityManager();
	}
	
    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    
	public void persistirPrueba(Prueba prueba){
		em.persist(prueba);
	}
	
	public static Prueba buscarPrueba(Long id){
		return em.find(Prueba.class, id);
	}
}
