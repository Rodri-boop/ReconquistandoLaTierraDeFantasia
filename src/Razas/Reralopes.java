package Razas;

public class Reralopes extends Raza{

	private int golpesDados;
	private int potenciados;
	
	public Reralopes() {
		this.danio_Basico = 27;
		this.salud = 53;
	}

	@Override
	protected int recibirDanio(int i) {
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
				enemigo.salud -= enemigo.recibirDanio(danio_Basico*2);
			}else {
			enemigo.salud -=  enemigo.recibirDanio(danio_Basico);
			}
		}
		golpesDados++;
		
	}


}
