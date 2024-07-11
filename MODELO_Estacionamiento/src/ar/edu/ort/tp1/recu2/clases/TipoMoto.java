package ar.edu.ort.tp1.recu2.clases;

public enum TipoMoto {
	CICLOMOTOR(1.2), SCOOTER(1.25), MOTOCROSS(3), CRUISER(2.4);
	
	private double indice;
	private TipoMoto(double indice) {
		this.indice = indice;
	}
	
	public double getIndice() {
		return indice;
	}
}
