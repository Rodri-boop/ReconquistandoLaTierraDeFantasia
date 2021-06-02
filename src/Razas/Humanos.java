package Razas;

public class Humanos extends Raza{

	public Humanos() {
		super.salud=1000;
		super.danio_Basico=10;
		super.rangoDe_Ataque=10;
	}

	

	@Override
	protected int recibirDanio(int danioRecibido) {
		int danio = danioRecibido;
		this.salud -= danio; 
		
		return danioRecibido;
	}

	@Override
	protected void descansar() {
		this.salud += 10;		
	}

	@Override
	protected void atacar(Unidad enemigo) {
		// TODO Auto-generated method stub
		
	}

}
