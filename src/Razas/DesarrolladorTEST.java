package Razas;
import org.junit.Test;


//import org.junit.Assert;

public class DesarrolladorTEST {

	/**
	 * En este test se testea el camino de la consigna del tp para ser resuelto.
	 */
	@Test
	public void test001() {
		Desarrollador d = new Desarrollador("/C://Users//rolin/OneDrive/Escritorio/Camino.txt");
		d.prediccion();
	}
	
	/**
	 * Este tes es un camino igual al de la consigna solo que se agregaron mas unidades enemigas
	 * para que se presente una derrota.
	 * 
	 * 4
	 * 1 100 Wrives propios
	 * 2 30 Reralopes aliado
	 * 3 70 Nortaichian enemigo
	 * 4 60 Nortaichian enemigo
	 * 1 -> 4
	 * 1 2 10
	 * 1 3 20
	 * 2 3 5
	 * 3 4 7
	 */
	@Test
	public void test002() {
		Desarrollador d = new Desarrollador("/C://Users//rolin/OneDrive/Escritorio/Camino2.txt");
		d.prediccion();
	}
	
	/**
	 * Este tes es un camino igual al de la consigna solo que se agregaron mas unidades y la raza R adaiteran
	 * 
	 * 4
	 * 1 100 Wrives propios
	 * 2 30 Reralopes aliado
	 * 3 70 Radaiteran enemigo
	 * 4 60 Nortaichian enemigo
	 * 1 -> 4
	 * 1 2 10
	 * 1 3 20
	 * 2 3 5
	 * 3 4 7
	 */
	@Test
	public void test003() {
		Desarrollador d = new Desarrollador("/C://Users//rolin/OneDrive/Escritorio/Camino3.txt");
		d.prediccion();
	}
}
