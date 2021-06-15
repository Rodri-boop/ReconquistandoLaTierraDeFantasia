package Razas;
import org.junit.Test;

import Razas.Raza.Status;

import org.junit.Assert;


public class ReralopesTest {

	/**
	 * El primer test es para comprobar que el objeto no este vacio
	 */
	@Test
	public void test001() {
		Reralopes reralope = new Reralopes();
		
		Assert.assertNotNull(reralope);
	}
	
	/**
	 * Testeamos que la estadistica de la salud sea la adecuada
	 */
	@Test
	public void test002() {
		Reralopes reralope = new Reralopes();
		
		Assert.assertEquals(53, reralope.salud,0.1);
	}
	
	/**
	 * Testeamos que el ataque base sea el previsto y su ataque sea como es
	 * en la consigna de la raza
	 */
	@Test
	public void test003() {
		Reralopes reralope = new Reralopes();
		Humanos humano = new Humanos();
		
		reralope.atacar(humano);
		Assert.assertEquals(973, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(973, humano.salud,0.1);
	}
	
	/**
	 * Un Reralope de cada 4 golpes acierta 2.
	 */
	@Test
	public void test004() {
		Reralopes reralope = new Reralopes();
		Humanos humano = new Humanos();
		
		reralope.atacar(humano);
		Assert.assertEquals(973, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(973, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(919, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(919, humano.salud,0.1);
	}
	
	/**
	 * Un Reralope al descansar multiplica su ataque por 2 durante 3 turnos.
	 */
	@Test
	public void test005() {
		Reralopes reralope = new Reralopes();
		Humanos humano = new Humanos();
		
		reralope.descansar();
		reralope.atacar(humano);
		Assert.assertEquals(946, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(946, humano.salud,0.1);
		reralope.descansar();
		reralope.atacar(humano);
		Assert.assertEquals(892, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(892, humano.salud,0.1);
	}
	
	/**
	 * Cuando un Reralope recibi danio se desconcentra y su danio vuelve 
	 * al valor inicial.
	 */
	@Test
	public void test006() {
		Reralopes reralope = new Reralopes();
		Humanos humano = new Humanos();
		
		reralope.descansar();
		reralope.atacar(humano);
		Assert.assertEquals(946, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(946, humano.salud,0.1);
		humano.atacar(reralope);
		reralope.atacar(humano);
		Assert.assertEquals(919, humano.salud,0.1);
		reralope.atacar(humano);
		Assert.assertEquals(919, humano.salud,0.1);
	}
	
	
	/**
	 * Cuando una unidad recibe danio pasa a estar herido.
	 */
	@Test
	public void test007() {
		Reralopes reralope = new Reralopes();
		Humanos humano = new Humanos();
		
		humano.atacar(reralope);
		Assert.assertEquals(Status.HERIDO, reralope.getStatus());
	}
	
	/**
	 * Todas las razas sin ser atacadas su estado inicial es SANO
	 */
	@Test
	public void test008() {
		Reralopes reralope = new Reralopes();
		
		Assert.assertEquals(Status.SANO, reralope.getStatus());
	}
	
	/**
	 * Cuando la aventura comienza a cada raza se le asigna un bando.
	 */
	@Test
	public void test009() {
		Reralopes reralope = new Reralopes();
		reralope.setBando(Bando.ALIADO);;
		Assert.assertEquals(Bando.ALIADO, reralope.bando);
	}

	
	
}
