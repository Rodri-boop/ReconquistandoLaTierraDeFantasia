package Razas;

public class Nortaichian extends Raza {
	private final static int SALUD_BASE=66;
	private int potenciador;
	private int turnosDePiedra;
	
	public Nortaichian() {
		this.salud = SALUD_BASE;
		this.danio_Basico = 18;
	}
	
	@Override
	protected int recibirDanio(int i) {
		
		int danio=i;
		this.salud-=danio;
		
		potenciador = 2;
		if(this.turnosDePiedra != 0 ) {
			return i/2;
		}
		return i;
	}

	@Override
	protected void descansar() {
		this.salud = 66;
		this.turnosDePiedra = 2;
		
	}

	@Override
	protected void atacar(Raza enemigo) {
		if(turnosDePiedra == 0) {
			if(potenciador != 0) {
				enemigo.recibirDanio(danio_Basico*2);
				this.salud += this.salud*0.04;
				potenciador--;
			}else {
				enemigo.recibirDanio(danio_Basico);
				this.salud += this.salud*0.04;
			}
		}else{
			turnosDePiedra--;//es un contador que va a crecer constantemente hasta que descanse y se hardcodee en 2.
		}
	}
	

}
