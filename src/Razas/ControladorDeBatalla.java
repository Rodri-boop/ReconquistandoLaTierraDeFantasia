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

	public void batallar(Ejercito propio, Ejercito enemigo) {
		Unidad aliadoActual;
		Unidad enemigoActual=enemigo.army.poll();
		if(propio.army.peek().bando==Bando.ALIADO&&propio.army.peek().getSalud()>0) {
			aliadoActual=propio.army.peek().quitarDesmayados();
		}else {
			aliadoActual=propio.army.poll();
		}
		
		
		while(enemigo.getSalud() > 0 && propio.getSalud() > 0) {
			while(aliadoActual.validarVida()&&enemigoActual.validarVida()) {
				aliadoActual.atacar(enemigoActual);
				if(enemigoActual.validarVida()) {
					enemigoActual.atacar(aliadoActual);
				}
			}
			if(!aliadoActual.validarVida()&&!propio.army.isEmpty()) {
				if(propio.army.peek().getSalud()==0) {
					propio.army.poll();
				}
				if(propio.army.peek().bando==Bando.ALIADO&&propio.army.peek().getSalud()>0) {
					aliadoActual=propio.army.peek().quitarDesmayados();
				}else {
					aliadoActual=propio.army.poll();
				}
			}
			if(!enemigoActual.validarVida()&&!enemigo.army.isEmpty()) {
				enemigoActual= enemigo.army.poll();
			}
//			if(!propio.validarVida()) {
//				if(propio.army.peek().bando==Bando.ALIADO) {
//					propio.army.peek().quitarDesmayados();					
//				}else {
//					propio.quitarDesmayados();
//				}
//			}
			
		}
		if(!aliadoActual.validarVida()) {
			enemigo.army.add(enemigoActual);
		}else {
			propio.army.add(aliadoActual);
		}
	}
	
	
}