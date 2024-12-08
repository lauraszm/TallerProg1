package ar.edu.ort.tp1.pacial1.clases;

public class Rectangular extends Pizza {

	private static final String MSG_RECTANGULAR = "%-12s - %-15s - Precio de Venta: $%8.2f - %d porciones - %s\n";
	private static final float PRECIO_POR_PORCION = 45f;
	//TODO A completar
	private static final String TIPO = "Rectangular";
	private long largo;
	private long ancho;
	private AdicionalQueso adicionalQueso;

	//TODO A completar
	public Rectangular(String nombre, float costoBase, float porcentajeGanancia, long largo, long ancho, AdicionalQueso adicionalQueso) {
		super(nombre, costoBase,porcentajeGanancia);
		this.largo = largo;
		this.ancho = ancho;
		this.adicionalQueso = adicionalQueso;
	}

	
	private long getCantidadDePorciones() {
		return ancho * largo;
	}
	@Override
	public void mostrar() {
		System.out.println(String.format(MSG_RECTANGULAR, TIPO, getNombre(), getPrecioDeVenta(), getCantidadDePorciones(), adicionalQueso.getDescripcion()));
		// TODO Auto-generated method stub
		
	}


	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		//float costoProd = getCostoBase() + getCantidadDePorciones() * PRECIO_POR_PORCION;
		//float adicQueso = adicionalQueso.getMultiplicadorQueso();
		return (getCostoBase() + (getCantidadDePorciones() * PRECIO_POR_PORCION)) * adicionalQueso.getMultiplicadorQueso();
	}
	
	@Override
	public String getTipo() {
		return TIPO;
	}

	//TODO A completar
	// Costo de produccion + Precio de las porciones (ancho y largo) y todo eso 
	//	se multiplica por el adicional del queso.
	//
}
