package ar.edu.ort.tp1.recu2.clases;

public class Moto extends Vehiculo {
	private TipoMoto tipo;

	public Moto(String patente, String marca, String modelo, TipoMoto tipo) {
		super(patente, marca, modelo);
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mostrar() {
			System.out.println(this.toString());
			System.out.println("su índice de costo por hora es: " + calcularIndiceCostoHora());

	}

	@Override
	public double calcularIndiceCostoHora() {
		// TODO Auto-generated method stub
		return tipo.getIndice();
	}

	@Override
	public String getDescripcionTipoVehiculo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.MOTO.getDescripcion();
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.MOTO;
	}
	
	

}
