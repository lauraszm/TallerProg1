package ar.edu.ort.tp1.recu2.clases;

public class AutoElectrico extends Auto {
	

	private static final double CILINDRADA_ELECTRICO = 0;
	private static final int BONIFICACION_ELECTRICO = 1;

	public AutoElectrico(String patente, String marca, String modelo, int cantPuertas) {
		super(patente, marca, modelo, cantPuertas, CILINDRADA_ELECTRICO);
		// TODO Auto-generated constructor stub
	}
	
	public String getDescripcionTipoVehiculo() {
		return TipoVehiculo.AUTO_ELECTRICO.getDescripcion();
	}
	
	@Override
	public double calcularIndiceCostoHora() {
		// TODO Auto-generated method stub
		return this.getCantPuertas() - BONIFICACION_ELECTRICO;
	}
	 
	public TipoVehiculo getTipo() {
		return TipoVehiculo.AUTO_ELECTRICO;
	}
	
	@Override
	public void mostrar() {
		System.out.println(this.toString());
		System.out.println("su índice de costo por hora es: " + calcularIndiceCostoHora());

	}
}
