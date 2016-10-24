package test;

import org.junit.Assert;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import main.Prueba;
import main.Singleton;

public class SingletonTests extends AbstractPersistenceTest implements WithGlobalEntityManager{
	
	@Test
	public void elSingletonNoEsNull(){
		Assert.assertNotEquals(Singleton.getInstance(), null);
	}
	
	@Test
	public void laInstanciaDelSingletonEsUnica(){
		Assert.assertEquals(Singleton.getInstance(), Singleton.getInstance());
	}
	
	@Test
	public void siPersistoUnaPruebaSuIDes1(){
		Prueba prueba = new Prueba();	
		Singleton.getInstance().persistirPrueba(prueba);
		
		Long id = prueba.getId();
		Assert.assertSame(id, (long) 1); 
	}
	
	@Test
	public void persistoUnaPruebaYLaRecupero(){
		Prueba prueba = new Prueba();	
		Singleton.getInstance().persistirPrueba(prueba);
		
		Singleton.getInstance();
		Prueba pruebaEncontrada = Singleton.buscarPrueba(prueba.getId());
		
		Assert.assertEquals(prueba, pruebaEncontrada);
	}
}
