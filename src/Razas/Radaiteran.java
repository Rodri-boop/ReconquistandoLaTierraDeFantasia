package Razas;

public class Radaiteran extends Raza{
	private final static int SALUD_BASE=56;
	
	
	public Radaiteran() {
		this.danio_Basico=36;
		this.salud=SALUD_BASE;
	}
	
	@Override
	protected void atacar(Raza enemigo) {
		enemigo.recibirDanio(this.danio_Basico);
		
		this.danio_Basico += 3;
	}
	
	@Override
	protected int recibirDanio(int i) {
		int danio=i;
		this.salud-=i;
		return danio;
	}

	@Override
	protected void descansar() {
		//la consigna dice no hace nada asi que no ahce nada(?
		
	}


}
