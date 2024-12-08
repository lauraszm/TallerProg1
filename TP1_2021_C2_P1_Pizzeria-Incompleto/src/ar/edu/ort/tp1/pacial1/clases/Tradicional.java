package ar.edu.ort.tp1.pacial1.clases;

public class Tradicional extends Pizza {
	private static final String MSG_TRADICIONAL = "%-12s - %-15s - Precio de Venta: $%8.2f - %s\n";
	//TODO A completar
	private static final String TIPO = "Tradicional";
	private TipoDeMasa tipoDeMasa;
	
	//TODO A completar
	public Tradicional(String nombre, float costoBase, float porcentajeGanancia, TipoDeMasa tipoDeMasa) {
		super(nombre, costoBase,porcentajeGanancia);
		this.tipoDeMasa = tipoDeMasa;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(String.format(MSG_TRADICIONAL, TIPO, getNombre(), getPrecioDeVenta(), tipoDeMasa.getDescripcion()));
	}

	@Override
	public float getPrecioDeCosto() {
		// TODO Auto-generated method stub
		return getCostoTrad();
	}
	
	@Override
	public String getTipo() {
		return TIPO;
	}

	//TODO A completar
	// Costo de produccion multiplicado por el porcentaje del tipo de masa.
	//
	private float getCostoTrad() {
		return getCostoBase() * tipoDeMasa.getPorcentaje();
	}
}
