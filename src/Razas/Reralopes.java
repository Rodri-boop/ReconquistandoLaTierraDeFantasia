package Razas;

public class Reralopes extends Raza{
	private final static int SALUD_BASE=53;
	private int golpesDados;
	private int potenciados;
	
	public Reralopes() {
		this.danio_Basico = SALUD_BASE;
		this.salud = 53;
	}

	@Override
	protected int recibirDanio(int i) {
		int danio = i;
		this.salud-= danio;
		potenciados = 0;
		return i;
	}

	@Override
	protected void descansar() {
		potenciados = 2;
		
	}

	@Override
	protected void atacar(Raza enemigo) {
		
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
