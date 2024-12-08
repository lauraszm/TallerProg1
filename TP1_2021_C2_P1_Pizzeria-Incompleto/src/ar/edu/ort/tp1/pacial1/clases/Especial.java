package ar.edu.ort.tp1.pacial1.clases;

public class Especial extends Pizza {
	private static final String MSG_ESPECIAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %d fainas - %s\n";
	private static final float PRECIO_UNITARIO_FAINA = 70f;
	//TODO A completar
	private static final String TIPO = "Especial";

	private int cantFainas;
	private TamanioDePizza tamanio;
	

	//TODO A completar
	public Especial(String nombre, float costoBase, float porcentajeGanancia, int cantidadFainas, TamanioDePizza tamanioDePizza) {
		super(nombre, costoBase, porcentajeGanancia);
		this.cantFainas = cantidadFainas;
		this.tamanio = tamanioDePizza;
	}


	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(String.format(MSG_ESPECIAL, TIPO, getNombre(), getPrecioDeVenta(), cantFainas, tamanio.getDescripcion()));
	}


	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		float costoProd = getCostoBase() * tamanio.getPorcentaje();
		float costoFaina = cantFainas * PRECIO_UNITARIO_FAINA;
		return costoProd + costoFaina;
	}

	@Override
	public String getTipo() {
		return TIPO;
	}
	//TODO A completar
	// Costo de produccion * el porcentaje del tama�o. 
	//	A todo eso se le suma las cantidades de Faina por el precio unitario de cada faina.
	//
	

}
