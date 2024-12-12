package ar.edu.ort.tp1.parcial2.clases;

public class ActualizacionPorcentual extends ActualizacionExtendida {

	public ActualizacionPorcentual(double valorAAjustar) {
		super(valorAAjustar);
	}

	@Override
	public double obtenerValorCalculado(double precioBase) {
		double nuevoValor = precioBase * (100.0 + getValor()) / 100.0;
		if(nuevoValor <= 0) {
			throw new IllegalArgumentException("Valor invalido");
		}
		return nuevoValor;
	}

}
