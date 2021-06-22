package Razas;

import java.util.Stack;

public class Desarrollador {
	
	private LectorDeArchivo lector;
	private Ejercito myArmy;
	private String origen;
	private String destino;
	private Stack<String> pila;
	
	/**
	 * Constructor de nuestro camino para la batalla.
	 * @param archivo
	 */
	public Desarrollador(String archivo) {
		lector = new LectorDeArchivo();
		lector.leerArchivo(archivo);
		Mapa.getInstancia().setMapa(lector.getCantidadHabitantes(), lector.getBandoMapa(), lector.getRazaMapa(), lector.getDestino());
		Mapa.getInstancia().calcularCaminoMinimo(lector.getRuta(), lector.getOrigen(),lector.getDestino()); //Mmmmm 
		myArmy = Mapa.getInstancia().getNuestroEjercito();
		origen = lector.getOrigen();
		destino = lector.getDestino();
		pila = new Stack<String>();
	}
	
	/**
	 * Este metodo se encarga de leer el archivo y declarar los resultados de los recorridos.
	 */
	public void prediccion() {
		Double dias = Mapa.getInstancia().getDias();
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
			dias++;
		} while(!pila.isEmpty()&& myArmy.getSalud()>0);
			
		if(myArmy.getSalud()>0) {
			System.out.println("\t"+"\t"+"!!Victoria para tu pueblo Chinchulin!! "+"\n"+"\n"+aliadosVivos()+"\n"
		+"\t"+"En "+dias+" dias lograste una hazaña.");
		}else {
			System.out.println("\t"+"\t"+"!!Derrota para tu pueblo Chinchulin!!");
		}
		
	}

	/**
	 * Devolvemos la cantidad de nuestros guerreros vivos.
	 * @return
	 */
	private String aliadosVivos() {
		int vivosAliados = 0 ;
		int vivosPropios = 0;
		for (Unidad ejercito : this.myArmy.army) {
			if(ejercito.bando==Bando.PROPIO) {
		    vivosPropios+= ejercito.contarCabezas();
		    }else {
		    	vivosAliados+= ejercito.contarCabezas();
		    }
		}
		return "\t"+"Tu ejercito sobrevivio a la reconquista de la tierra de fantasia con: "+"\n"+"\t"+vivosPropios+" Guerreros de tu ejercito"+"\n"
		+"\t"+vivosAliados+" Guerreros de poblados aliados.";
	}
	
	/**
	 * Recorremos el camino minimo desde el destino hacia el origen.
	 */
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
		
		d.prediccion();
	}
	

}
