package Razas;

import org.junit.Test;

import org.junit.Assert;

public class HumanosTest {
	
	@Test
	public void testHumano001() {
		Humanos humano = new Humanos();
		
		Assert.assertNotNull(humano);
	}
	
	@Test
	public void testHumano002() {
		Humanos humano = new Humanos();
		
		humano.descansar();
		Assert.assertNotNull(humano);
		Assert.assertEquals(110,humano.salud);
	}
	
	@Test
	public void testHumano003() {
		Humanos humano = new Humanos();
		Humanos humano2 = new Humanos();
		
		humano.atacar(humano2);
		
		
		System.out.println("vida:..."+humano2.salud+"\n"+"vida:..."+humano.salud);
		humano.atacar(humano2);
		System.out.println("vida:..."+humano2.salud+"\n"+"vida:..."+humano.salud);
		humano.atacar(humano2);
		System.out.println("vida:..."+humano2.salud+"\n"+"vida:..."+humano.salud);
		
	}

}
