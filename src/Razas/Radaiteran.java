package Razas;

public class Radaiteran extends Raza{
	private final static Double SALUD_BASE = 56.0;
	
	
	public Radaiteran() {
		this.danio_Basico = 36;
		this.salud = SALUD_BASE;
	}
	
	@Override
	protected void atacar(Unidad enemigo) {
		enemigo.recibirDanio(this.danio_Basico);
		
		this.danio_Basico += 3;
	}
	
	@Override
	protected int recibirDanio(int i) {
		int danio=i;
		this.salud-=i;
		super.setDesmayado();
		return danio;
	}

	@Override
	protected void descansar() {
		//la consigna dice no hace nada asi que no hace nada(?
		
	}


}
