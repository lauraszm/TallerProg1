package ar.edu.ort.tp1.recu2.clases;

public class Auto extends Vehiculo {
	private int cantPuertas;
	private double cilindrada;
	
	public Auto(String patente, String marca, String modelo, int cantPuertas, double cilindrada) {
		super(patente, marca, modelo);
		this.cantPuertas = cantPuertas;
		this.cilindrada = cilindrada;
		// TODO Auto-generated constructor stub
	}
	
	public int getCantPuertas() {
		return this.cantPuertas;
	}
	
	@Override
	public void mostrar() {
		System.out.println(this.toString());
		System.out.println("su índice de costo por hora es: " + calcularIndiceCostoHora());

	}
	
	
	
	@Override
	public double calcularIndiceCostoHora() {
		// TODO Auto-generated method stub
		return (double) this.cantPuertas + this.cilindrada;
	}

	@Override
	public String getDescripcionTipoVehiculo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.AUTO.getDescripcion();
	}
	
	public TipoVehiculo getTipo() {
		return TipoVehiculo.AUTO;
	}

}
