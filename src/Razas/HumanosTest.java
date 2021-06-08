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
		Assert.assertEquals(1010.0, humano.salud, 0.1);
	}
	
	@Test
	public void testHumano003() {
		Humanos humano = new Humanos();
		Humanos humano2 = new Humanos();
		
		humano.atacar(humano2);
		humano.atacar(humano2);
		humano.atacar(humano2);
		
	}

}
