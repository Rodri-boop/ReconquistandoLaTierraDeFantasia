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
		System.out.println(pila.pop());
		Integer cabeza = Integer.parseInt(pila.peek());
		System.out.println(pila.peek());
		Poblado pobladoAux ;

		while(!pila.isEmpty()&& myArmy.getSalud()>0) {
			if(Mapa.getInstancia().getMapa().get(cabeza).getBando() == Bando.ALIADO) {
				pobladoAux = Mapa.getInstancia().getMapa().get(Integer.parseInt(pila.pop()));
				myArmy.aniadirUnidad(pobladoAux.getEjercito());
				myArmy.descansar();

			}else{
				pobladoAux = Mapa.getInstancia().getMapa().get(Integer.parseInt(pila.pop()));
				ControladorDeBatalla.getControlador().batallar(myArmy,pobladoAux.getEjercito());
			}
		}
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
		Desarrollador d = new Desarrollador("/C://Users//Agustin/Desktop/Camino.txt");
		System.out.println(Mapa.getInstancia().getCaminoMinimo());
		d.deRegresoACasa();
		System.out.println(d.pila);
		d.prediccion();
	}
	
	//TODO: iniciar prediccion, pensar nuestro ejercito

}
