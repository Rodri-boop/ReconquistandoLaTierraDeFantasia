package Razas;

import java.util.Stack;

public class Ejercito extends Unidad {

	
	private Stack<Unidad> army;
	
	public Ejercito(int cantidad,String racita) {
		army = new Stack<Unidad>();
		agregarAliados(cantidad,racita);
	}
	
	
	private void agregarAliados(int cantidad, String racita) {
		if(racita=="Wrives") {
			for(int i = 0; i < cantidad; i++) {
				Unidad unidad = new Wrives();
				army.add(unidad);
			}
		}
		
	}
	
	
	
	@Override
	protected void atacar(Raza enemigos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void descansar() {
		//Si es aliado descansa y suma tropas
		
		// TODO Auto-generated method stub
		
	}

}
