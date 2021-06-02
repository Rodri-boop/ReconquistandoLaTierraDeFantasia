package Razas;

import java.util.ArrayDeque;
import java.util.Queue;

public class Poblado {
	private String tipoRaza;
	private Bando bando;
	private Queue<Raza> ejercito= new  ArrayDeque<Raza>(); 
	
	//ejercito no cola
	public Poblado(String raza, int cantidad, String bando){
	 this.tipoRaza=raza;
	 if(bando == "Aliado") {
		this.bando = Bando.ALIADO;
	 }else{
			this.bando = Bando.ENEMIGO;
	 }
	 Raza soldado;
		if(raza == "Nortaichian") {
			
			for(int i =0;i<cantidad;i++) {
			   soldado= new Nortaichian();
				ejercito.add(soldado);
			}
			
		}if(raza== "Radaiteran") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Radaiteran();
				ejercito.add(soldado);
			}
			
		}if(raza== "Reralopes") {
			
			for(int i =0;i<cantidad;i++) {
				soldado= new Reralopes();
				ejercito.add(soldado);
			}
		}if(raza== "Wrives") {
		
			for(int i =0;i<cantidad;i++) {
				soldado= new Wrives();
				ejercito.add(soldado);
			}
			
		}
	}
	
	public Queue<Raza> getPoblado(){
		return this.ejercito;
	}
	public Bando getBando() {
		return this.bando;
	}
}
	
