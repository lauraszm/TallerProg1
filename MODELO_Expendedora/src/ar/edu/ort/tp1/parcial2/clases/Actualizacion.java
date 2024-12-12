package ar.edu.ort.tp1.parcial2.clases;

/**
 * Define una regla de actualizacion de precio para uno o mas productos.
 * Para cada uno requiere el precio actual del producto, lo devuelve
 * actualizado.
 * 
 **/
public abstract class Actualizacion {
	private double valor;

	public Actualizacion(double valor) {
		this.setValor(valor);
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor invalido");
		}
		this.valor = valor;
	}
	
	public String getTipo() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String toString() {
		return getTipo() + " [valor=" + valor + "]";
	}

}