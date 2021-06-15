package Razas;
import org.junit.Test;

import Razas.Raza.Status;

import org.junit.Assert;

public class WrivesTest {
	
	
	/**
	 * primer test para ver que el objeto no este vacio
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
		
		Assert.assertNotNull(wrive);
		Assert.assertEquals(108,wrive.salud,0.1);
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
		Assert.assertEquals(887, humano2.salud,0.1);
		wrive.atacar(humano2);	
	}
	

	/**
	 * Si un wrive descansa su salud base y su salud aumentan en 50 puntos
	 */
	@Test
	public void testWrives004() {
		Humanos humano = new Humanos();
		Wrives wrive = new Wrives();
		
		wrive.descansar();
		Assert.assertEquals(158,wrive.salud,0.1);
		humano.atacar(wrive);
		wrive.atacar(humano);
		Assert.assertEquals(138, wrive.salud,0.1);
	}
	
	/**
	 * Cuando una unidad recibe danio pasa a estar herido.
	 */
	@Test
	public void testWrives005() {
		Wrives wrive = new Wrives();
		Humanos humano = new Humanos();
		
		humano.atacar(wrive);
		Assert.assertEquals(Status.HERIDO, wrive.getStatus());
			
	}
	
	/**
	 * Todas las razas sin ser atacadas su estado inicial es SANO
	 */
	@Test
	public void testWrives006() {
		Wrives wrive = new Wrives();
		
		Assert.assertEquals(Status.SANO, wrive.getStatus());
			
	}
	
	/**
	 * Cuando la aventura comienza a cada raza se le asigna un bando.
	 */
	@Test
	public void test007() {
		Wrives wrive = new Wrives();
		wrive.setBando(Bando.ALIADO);;
		Assert.assertEquals(Bando.ALIADO, wrive.bando);
	}

}
