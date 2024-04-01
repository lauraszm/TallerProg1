package ejercicio2y3;


public class Podio {
	private int posicion;
	private Atleta atleta;
	
	public Podio(int posicion, Atleta atleta) {
		this.setAtleta(atleta);
		this.setPosicion(posicion);
	}

	public Atleta getAtleta() {
		return atleta;
	}

	private void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public int getPosicion() {
		return posicion;
	}

	private void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Podio [posicion=" + posicion + ", atleta=" + atleta + "]";
	}
	
	
	
	
}
