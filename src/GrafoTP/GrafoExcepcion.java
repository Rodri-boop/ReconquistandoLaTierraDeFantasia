package GrafoTP;

public class GrafoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public GrafoExcepcion(String mensaje) {
		
		super(mensaje);
	}
}
