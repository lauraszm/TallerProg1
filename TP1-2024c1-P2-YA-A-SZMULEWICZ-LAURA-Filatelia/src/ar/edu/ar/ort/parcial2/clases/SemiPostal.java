package ar.edu.ar.ort.parcial2.clases;

public class SemiPostal extends Sello {
	
	private static final float COSTO_CONVENCION_POSTAL = 0.08f;

	public SemiPostal(String pais, String pieDeImprenta, float valorFacial, Formato formato, Impresion impresion) {
		super(pais, pieDeImprenta, valorFacial, formato, impresion);
		this.valorComercial = this.setValorComercial();
	}


	@Override
	public float setValorComercial() {
		return this.getValorFacial() + COSTO_CONVENCION_POSTAL + this.getTipoFormato().obtenerValor();
	}

	@Override
	public void verDatos() {
		
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName() + "--" + String.format(Visualizable.INFO_SELLO, this.getPais(), this.getPie(), this.getValorComercial()));
	}

	

}
