package Razas;

import org.junit.Test;
import Razas.Raza.Status;
import org.junit.Assert;

public class NortaichianTest {
	/**
	 * El primer test es para comprobar que el objeto no este vacio
	 */
	@Test
	public void test001() {
		Nortaichian nortaichian = new Nortaichian();

		Assert.assertNotNull(nortaichian);
	}

	/**
	 * Testeamos que la estadistica de la salud sea la adecuada
	 */
	@Test
	public void test002() {
		Nortaichian nortaichian = new Nortaichian();

		Assert.assertEquals(66.0, nortaichian.salud, 0.1);
	}

	/**
	 * Testeamos que el ataque base sea el previsto y su ataque sea como es en la
	 * consigna de la raza
	 */
	@Test
	public void test003() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		nortaichian.atacar(humano);

		Assert.assertEquals(982, humano.salud, 0.1);
	}

	/**
	 * Como un Nortaichian al ser herido se enfurece obtiene una bonificacion de
	 * danio doble por 2 turnos.
	 */
	@Test
	public void test004() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		nortaichian.atacar(humano);// danio por 2

		Assert.assertEquals(964.0, humano.salud, 0.1);
	}

	/**
	 * Un Nortaichian al descansar se vuelve de piedra y no puede atacar por 2
	 * turnos.
	 * 
	 */
	@Test
	public void test005() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		nortaichian.descansar();
		nortaichian.atacar(humano);// no ataca no ocasiona danio

		Assert.assertEquals(1000, humano.salud, 0.1);
	}

	/**
	 * Los Nortaichian se curan un 4% de su salud base en cada ataque.
	 * 
	 * el resultado tendria que ser 56 pero gracias a este efecto gano 2 puntos de
	 * salud.
	 */
	@Test
	public void test006() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		nortaichian.atacar(humano);

		Assert.assertEquals(58.24, nortaichian.salud, 0.1);
	}

	/**
	 * Un Nortaichian en estado de piedra recibe solo la mitad del daño.
	 * 
	 * en este caso que el humano tiene un daño base de 100 recibio 5 puntos de daño
	 */
	@Test
	public void test007() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		nortaichian.descansar();
		humano.atacar(nortaichian);

		Assert.assertEquals(61, nortaichian.salud, 0.1);
	}

	/**
	 * Cuando un nortaichian se debilita pasa al estado de desmayado.
	 */
	@Test
	public void test008() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		// Assert.assertEquals(Status.DESMAYADO,nortaichian.getStatus());
	}

	/**
	 * Cuando un Nortaichian recibe daño pasa al estado de herido.
	 */
	@Test
	public void test009() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		humano.atacar(nortaichian);

		Assert.assertEquals(Status.HERIDO, nortaichian.getStatus());
	}

	/**
	 * Los nortaichian si atacan y estan con su vida intacta no se cura.
	 */
	@Test
	public void test0010() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		nortaichian.atacar(humano);

		Assert.assertEquals(66, nortaichian.salud, 0.1);
	}

	/**
	 * Los Nortaichian al descansar recuperan toda su salud.
	 */
	@Test
	public void test011() {
		Nortaichian nortaichian = new Nortaichian();
		Humanos humano = new Humanos();

		humano.atacar(nortaichian);
		humano.atacar(nortaichian);
		Assert.assertEquals(46, nortaichian.salud, 0.1);
		nortaichian.descansar();
		Assert.assertEquals(66, nortaichian.salud, 0.1);
	}
	
	
}