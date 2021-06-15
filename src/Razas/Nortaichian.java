package Razas;

public class Nortaichian extends Raza {
	private final static Double SALUD_BASE = 66.0;
	private int potenciador;
	private int turnosDePiedra;
	
	public Nortaichian() {
		this.salud = SALUD_BASE;
		this.danio_Basico = 18;
	}
	
	@Override
	protected void recibirDanio(int danioRecibido) {
		int danio=danioRecibido;
		if(turnosDePiedra != 0) {
			this.salud -= danio/2;
			super.setStatus(SALUD_BASE);
			
		}else {
		this.salud-=danio;
		super.setStatus(SALUD_BASE);
		potenciador = 2;
		}
	}

	@Override
	protected void descansar() {
		this.salud = 66.0;
		this.turnosDePiedra = 2;
		
	}

	@Override
	protected void atacar(Unidad enemigo) {
		if(turnosDePiedra == 0) {
			if(potenciador != 0) {
				enemigo.recibirDanio(danio_Basico*2);
				roboDeVida();
				potenciador--;
			}else {
				enemigo.recibirDanio(danio_Basico);
				roboDeVida();
			}
		}else{
			turnosDePiedra--;//es un contador que va a crecer constantemente hasta que descanse y se hardcodee en 2.
		}
	}
	
	private void roboDeVida() {
		if(this.salud!= SALUD_BASE) {
			this.salud += this.salud*0.04;
		}
		else if(this.salud==SALUD_BASE){
//			this.salud+=0;	
		}
	}
	
	public void setBando(Bando bando) {
		super.bando = bando;
	}

}
