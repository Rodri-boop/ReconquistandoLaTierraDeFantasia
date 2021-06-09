package Razas;

public class Radaiteran extends Raza{
	private final static Double SALUD_BASE=36.0;
	private Integer golpesDados=0;
	
	public Radaiteran() {
		this.danio_Basico=56;
		this.salud=SALUD_BASE;
	}
	
	@Override
	protected void atacar(Unidad enemigo) {
		golpesDados++;
		enemigo.recibirDanio(this.danio_Basico+3*golpesDados);
		
	}
	
	@Override
	protected int recibirDanio(int danioRecibido) {
		int danio=danioRecibido;
		this.salud-=danio;
		super.setStatus(SALUD_BASE);
		return danio;
	}

	@Override
	protected void descansar() {
		//la consigna dice no hace nada asi que no ahce nada(?
		
	}
	
	public void setBando(Bando bando) {
		super.bando = bando;
	}
}