package Razas;

public class ControladorDeBatalla {
	private static ControladorDeBatalla controlador;
	
	private ControladorDeBatalla() {
	}
	
	public static ControladorDeBatalla getControlador(){
		if(controlador == null) {
			controlador = new ControladorDeBatalla();
		}
		return controlador;
	}

	/**
	 * Se batalla dos unidades en 1vs1 hasta que uno de los dos es desmayado si es desmayado
	 * sigue la batalla con el enemigo siguiente en la cola.
	 * @param propio
	 * @param enemigo
	 */
	public void batallar(Ejercito propio, Ejercito enemigo) {
		Unidad aliadoActual;
		Unidad enemigoActual=enemigo.army.poll();
		if(propio.army.peek().bando==Bando.ALIADO) {
			aliadoActual=propio.army.peek().quitarSoldadosListos();
		}else {
			aliadoActual=propio.army.poll();
		}
		
		
		do {
			
			if(!aliadoActual.validarVida()&&!propio.army.isEmpty()) {
				if(propio.army.peek().getSalud()<=0&&propio.army.peek().bando==Bando.ALIADO) {//remover ejercito muerto
					propio.army.remove();
				}
				if(propio.army.peek().bando==Bando.ALIADO&&propio.army.peek().getSalud()>0) {
					aliadoActual=propio.army.peek().quitarSoldadosListos();
				}else if(propio.army.peek().getSalud()>0){
					aliadoActual=propio.army.poll();
				}
			}
			if(!enemigoActual.validarVida()&&!enemigo.army.isEmpty()) {
				enemigoActual= enemigo.army.poll();
			}
			while(aliadoActual.validarVida()&&enemigoActual.validarVida()) {
				aliadoActual.atacar(enemigoActual);
				if(enemigoActual.validarVida()) {
					enemigoActual.atacar(aliadoActual);
				}
			}	
		}while(( enemigoActual.validarVida()||enemigo.getSalud() > 0) && (aliadoActual.validarVida()||propio.getSalud() > 0));
		
		
		if(!aliadoActual.validarVida()) {
			enemigo.army.add(enemigoActual);
		}else {
			propio.army.add(aliadoActual);
		}
	}
	
}