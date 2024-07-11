package ar.edu.ort.tp1.recu2.clases;

public interface EspacioInteligente<T, K> {

	public T retirar(K id);
	public void agregar(T elemento);
	public int lugarDisponible();
}
