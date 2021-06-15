package Razas;

import java.util.Map;
import java.util.Stack;

public class Desarrollador {
	
	private LectorDeArchivo lector;
	private Ejercito myArmy;
	private String origen;
	private String destino;
	private Stack<String> pila;
	
	public Desarrollador(String archivo) {
		lector = new LectorDeArchivo();
		lector.leerArchivo(archivo);
		Mapa.getInstancia().setMapa(lector.getCantidadHabitantes(), lector.getBandoMapa(), lector.getRazaMapa(), lector.getDestino());
		Mapa.getInstancia().calcularCaminoMinimo(lector.getRuta(), lector.getOrigen()); //Mmmmm 
		myArmy = Mapa.getInstancia().getNuestroEjercito();
		origen = lector.getOrigen();
		destino = lector.getDestino();
		pila = new Stack<String>();
	}
	
	public void prediccion() {
		deRegresoACasa();
		pila.pop();		
		do {
			Integer puebloAVisitar = Integer.parseInt(pila.pop());
			Poblado pobladoAux = Mapa.getInstancia().getMapa().get(puebloAVisitar);
			if(Mapa.getInstancia().getMapa().get(puebloAVisitar).getBando()==Bando.ALIADO) {
				myArmy.descansar();
				myArmy.aniadirUnidad(pobladoAux.getEjercito());
			}else {
				ControladorDeBatalla.getControlador().batallar(myArmy,pobladoAux.getEjercito());
			}
		} while(!pila.isEmpty()&& myArmy.getSalud()>0);
			
		if(myArmy.getSalud()>0) {
			System.out.println("Ganaste chinchulin");
		}else {
			System.out.println("Perdiste chinchulin (u.u)");
		}
		
	}


	private void deRegresoACasa() {
		String ultimoPueblo = destino;
		pila.push(ultimoPueblo);
		
		while (!ultimoPueblo.equals(origen)) { //Recorremos el camino minimo desde el destino hacia el origen.
			pila.push(Mapa.getInstancia().getCaminoMinimo().get(ultimoPueblo));
			ultimoPueblo = Mapa.getInstancia().getCaminoMinimo().get(ultimoPueblo);
		}
	}
	
	
	public static void main(String[] args) {
		Desarrollador d = new Desarrollador("/C://Users//rolin/OneDrive/Escritorio/Camino.txt");
		System.out.println(Mapa.getInstancia().getCaminoMinimo());
		//d.deRegresoACasa(); este no va por que los haces que se reinicie y empieza mal sin este sale ganador.
		System.out.println(d.pila);
		d.prediccion();
	}
	
	//TODO: iniciar prediccion, pensar nuestro ejercito

}
