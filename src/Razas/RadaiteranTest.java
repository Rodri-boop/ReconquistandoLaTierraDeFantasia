package Razas;
import org.junit.Test;

import Razas.Raza.Status;

import org.junit.Assert;


public class RadaiteranTest {

	/**
	 * El primer test es para comprobar que el objeto no este vacio
	 */
	@Test
	public void Test001() {
		Radaiteran radaiterran = new Radaiteran();
		
		Assert.assertNotNull(radaiterran);
	}
	
	/**
	 * Testeamos que la estadistica de la salud sea la adecuada
	 */
	@Test
	public void Test002() {
		Radaiteran radaiteran = new Radaiteran();
		
		Assert.assertEquals(36, radaiteran.salud,0.1);
	}
	
	/**
	 * Testeamos que el ataque base sea el previsto y su ataque sea como es
	 * en la consigna de la raza
	 */
	@Test
	public void Test003() {
		Radaiteran radaiteran = new Radaiteran();
		Humanos humano = new Humanos();
		
		radaiteran.atacar(humano);
		Assert.assertEquals(941, humano.salud,0.1);
	}
	
	/**
	 * Un Radaiteran al cada vez que realice un ataque lo hace
	 * con mas fuerza(3* la cantidad de ataques realizados).
	 */
	@Test
	public void Test004() {
		Radaiteran radaiteran = new Radaiteran();
		Humanos humano = new Humanos();
		
		radaiteran.atacar(humano);
		radaiteran.atacar(humano);
		
		Assert.assertEquals(879, humano.salud,0.1);
	}
	
	
	/**
	 * Los radaiteran al recibir daño lo hacen normalmente .
	 */
	@Test
	public void Test005() {
		Radaiteran radaiteran = new Radaiteran();
		Humanos humano = new Humanos();
		
		humano.atacar(radaiteran);
		
		Assert.assertEquals(Status.HERIDO, radaiteran.getStatus());
	}
	
	/**
	 * Todas las razas sin ser atacadas su estado inicial es SANO
	 */
	@Test
	public void Test006() {
		Radaiteran radaiteran = new Radaiteran();
		
		
		Assert.assertEquals(Status.SANO, radaiteran.getStatus());
	}
	
	/**
	 * Un radaiteran al descansar no le sucede nada.
	 */
	@Test
	public void Test007() {
		Radaiteran radaiteran = new Radaiteran();
		
		radaiteran.descansar();
		
		Assert.assertEquals(36, radaiteran.salud,0.1);
		Assert.assertEquals(56, radaiteran.danio_Basico);
	}
	
	/**
	 * Cuando la aventura comienza a cada raza se le asigna un bando.
	 */
	@Test
	public void test008() {
		Radaiteran radaiteran = new Radaiteran();
		radaiteran.setBando(Bando.ALIADO);;
		Assert.assertEquals(Bando.ALIADO, radaiteran.bando);
	}
	
}
