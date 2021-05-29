package Razas;
import org.junit.Test;

import Razas.Raza.Status;

import org.junit.Assert;

public class WrivesTest {
	
	
	/**
	 * primer tes para ver que el objeto no este vacio
	 */
	@Test
	public void testWrives001() {
		Wrives wrive = new Wrives();
		
		Assert.assertNotNull(wrive);
	}
	
	/**
	 * implementacion del primer wrive y comparacion de su salud base
	 */
	@Test
	public void testWrives002() {
		Wrives wrive = new Wrives();
		
		wrive.descansar();
		Assert.assertNotNull(wrive);
		Assert.assertEquals(158,wrive.salud);
	}
	
	
	/**
	 * testeo sobre el ataca base y efecto del wrive sobre un humano de 1000 puntos de salud
	 * se esperaba que ataque con el doble de su danio base(113) 
	 */
	@Test
	public void testWrives003() {
		Wrives wrive = new Wrives();
		Humanos humano2 = new Humanos();
		
		wrive.atacar(humano2);
		Assert.assertEquals(887, humano2.salud);
		wrive.atacar(humano2);	
	}
	
	
	@Test
	public void testWrives004() {
		Wrives wrive = new Wrives();
		Wrives wrive2 = new Wrives();
		
		wrive.atacar(wrive2);
		wrive.atacar(wrive2);
		Assert.assertEquals(Status.DESMAYADO, wrive2.getStatus());
			
	}
	

}
