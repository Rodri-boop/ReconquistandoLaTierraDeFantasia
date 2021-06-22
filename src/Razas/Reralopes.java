package Razas;

public class Reralopes extends Raza{
	private final static Double SALUD_BASE=53.0;
	private int golpesDados;
	private int potenciados;
	
	public Reralopes() {
		this.danio_Basico = 27;
		this.salud = SALUD_BASE;
	}

	@Override
	protected void recibirDanio(int danioRecibido) {
		int danio = danioRecibido;
		this.salud-= danio;
		potenciados = 0;
		super.setStatus(SALUD_BASE);
		
	}

	@Override
	protected void descansar() {
		potenciados = 3;
		
	}

	@Override
	protected void atacar(Unidad enemigo) {
		if(golpesDados % 2 == 0) {
			if(potenciados != 0) {
				enemigo.recibirDanio(danio_Basico*2);
				potenciados--;
			}else {
			enemigo.recibirDanio(danio_Basico);
			}
		}
		potenciados--;
		golpesDados++;
		
	}
	
	public void setBando(Bando bando) {
		super.bando = bando;
	}
}