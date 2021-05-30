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
	
	/**
	 * Test sobre el status de la unidad si su salud es menor o igual a 0 
	 * la unidad es retirada del ejercito
	 */
	@Test
	public void testWrives004() {
		Wrives wrive = new Wrives();
		Wrives wrive2 = new Wrives();
		
		wrive.atacar(wrive2);
		wrive.atacar(wrive2);
		Assert.assertEquals(Status.DESMAYADO, wrive2.getStatus());
			
	}
	
	/**
	 * Test sobre el status de la unidad si su salud es diferente a su salud inicial
	 * esta unidad esta herida y su estado es de HERIDO
	 */
	@Test
	public void testWrives005() {
		Humanos humano = new Humanos();
		Wrives wrive2 = new Wrives();
		
		humano.atacar(wrive2);
		humano.atacar(wrive2);
		Assert.assertEquals(Status.HERIDO, wrive2.getStatus());
			
	}
	
	/**
	 * Si un wrive descansa no puede atacar hasta ser atacado
	 * entonces la vida del humano seria la salud inicial
	 */
	@Test
	public void testWrives006() {
		Humanos humano = new Humanos();
		Wrives wrive = new Wrives();
		
		wrive.descansar();
		wrive.atacar(humano);
		Assert.assertEquals(1000, humano.salud);
			
	}
	
	/**
	 * Si un wrive descansa no puede atacar hasta que es atacado nuevamente 
	 * entonces no se ejecuta el primer ataca pero el segundo luego de ser 
	 * el wrives recurre a la violencia.
	 */
	@Test
	public void testWrives007() {
		Humanos humano = new Humanos();
		Wrives wrive = new Wrives();
		
		wrive.descansar();
		wrive.atacar(humano);
		humano.atacar(wrive);
		wrive.atacar(humano);
		Assert.assertEquals(887, humano.salud);
			
	}

}
