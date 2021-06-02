package Razas;

public class Reralopes extends Raza{
	private final static Double SALUD_BASE = 53.0;
	private int golpesDados;
	private int potenciados;
	
	public Reralopes() {
		this.danio_Basico = 27;
		this.salud = SALUD_BASE;
	}

	@Override
	protected int recibirDanio(int i) {
		int danio = i;
		this.salud-= danio;
		potenciados = 0;
		super.setDesmayado();
		return i;
	}

	@Override
	protected void descansar() {
		potenciados = 2;
		
	}

	@Override
	protected void atacar(Unidad enemigo) {
		
		if(golpesDados % 2 == 0) {
			if(potenciados != 0) {
				enemigo.recibirDanio(danio_Basico*2);
			}else {
			enemigo.recibirDanio(danio_Basico);
			}
		}
		golpesDados++;
		
	}


}
