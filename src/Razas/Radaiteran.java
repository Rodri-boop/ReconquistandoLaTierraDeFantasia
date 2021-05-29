package Razas;

public class Radaiteran extends Raza{

	
	
	public Radaiteran() {
		this.danio_Basico=36;
		this.salud=56;
	}
	
	@Override
	protected void atacar(Raza enemigo) {
		enemigo.salud -= enemigo.recibirDanio(this.danio_Basico);
		
		this.danio_Basico += 3;
	}
	
	@Override
	protected int recibirDanio(int i) {
		int danio=i;
		return danio;
	}

	@Override
	protected void descansar() {
		//la consigna dice no hace nada asi que no ahce nada(?
		
	}


}
