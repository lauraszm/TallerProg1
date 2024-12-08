package ar.edu.ort.tp1.examen.clases;

public class EnvioNormal extends Envio {
	public static final String NOMBRE = "Envio normal";
	
	public EnvioNormal() {
		super(NOMBRE);
	}
	@Override
	public float getPrecioEnvio(float peso, float distancia) {
		// TODO Auto-generated method stub
		return getPrecioBaseKm() * distancia;
	}
	
	
}
