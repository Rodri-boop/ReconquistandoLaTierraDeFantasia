package Razas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

import Razas.Poblado.Bando;
import Razas.Raza.Status;

public class Ejercito extends Unidad {

	private ArrayList [] army;
	private ArrayList <Unidad> aliados= new ArrayList<Unidad>();
	private ArrayList <Unidad> propios= new ArrayList<Unidad>();
	private ArrayList <Unidad> propiosHeridos= new ArrayList<Unidad>();
	private ArrayList <Unidad> aliadosHeridos= new ArrayList<Unidad>();
	public Ejercito(String raza ,int cantidad) {
		army= new ArrayList[4];
		army[0]= aliados;
		army[1]= propios;
		army[2]= propiosHeridos;
		army[3]= aliadosHeridos;
		aniadirPropios(raza,cantidad);
		
	}
	private void aniadirPropios(String raza ,int cantidad) {
		Raza soldado;
		if(raza== "Nortaichian") {
			
			for(int i =0;i<cantidad;i++) {
			   soldado= new Nortaichian();
				propios.add(soldado);
			}
			
		}if(raza== "Radaiteran") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Radaiteran();
				propios.add(soldado);
			}
			
		}if(raza== "Reralopes") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Reralopes();
				propios.add(soldado);
			}
		}if(raza== "Wrives") {
		
			for(int i =0;i<cantidad;i++) {
				soldado= new Wrives();
				propios.add(soldado);
			}
			
		}
	}
	private void aniadirAliados(String raza ,int cantidad) {
		Raza soldado;
		if(raza== "Nortaichian") {
			
			for(int i =0;i<cantidad;i++) {
			   soldado= new Nortaichian();
				aliados.add(soldado);
			}
			
		}if(raza== "Radaiteran") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Radaiteran();
				aliados.add(soldado);
			}
			
		}if(raza== "Reralopes") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Reralopes();
				aliados.add(soldado);
			}
		}if(raza== "Wrives") {
		
			for(int i =0;i<cantidad;i++) {
				soldado= new Wrives();
				aliados.add(soldado);
			}
			
		}
	}
	public void comprobarPoblado(Poblado pueblito) {
		//TODO: comprobar si al llegar a un pueblo los ejercitos son aliados o enemigos
		if(pueblito.getBando()== Bando.ENEMIGO) {
			batallar(pueblito);
		}
	}
	
	
	

	private void batallar(Poblado pueblito) {
		Queue <Raza> enemigos= pueblito.getPoblado();
		Iterator it = aliados.iterator();
		while(!enemigos.isEmpty() && it.hasNext()) {
			Raza enemigoActual= enemigos.poll();
			Raza aliadoActual =  (Raza) it.next();
			it.remove();
			
			//pelea individual fighting
			while(enemigoActual.getStatus()!= Status.DESMAYADO && aliadoActual.getStatus()!= Status.DESMAYADO){
				aliadoActual.atacar(enemigoActual);
				if(enemigoActual.getStatus()!= Status.DESMAYADO)
					enemigoActual.atacar(aliadoActual);
				
			}
		}
	}
	@Override
	protected void descansar() {
		// TODO Auto-generated method stub
		
	}

	
	/*
	 * private Stack<Unidad> army;
	 * public Ejercito(int cantidad,String racita) {
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

	 */
	
	
}
