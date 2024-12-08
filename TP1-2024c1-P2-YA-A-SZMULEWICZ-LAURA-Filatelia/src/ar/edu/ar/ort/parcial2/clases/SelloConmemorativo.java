package ar.edu.ar.ort.parcial2.clases;

public class SelloConmemorativo extends Sello {
	
	private Tematica tematica;
	
	public SelloConmemorativo(String pais, String pieDeImprenta, float valorFacial, Formato formato, Impresion impresion, Tematica tematica) {
		super(pais, pieDeImprenta, valorFacial, formato, impresion);
		this.tematica = tematica;
		this.valorComercial = this.setValorComercial();
	}

	@Override
	public float setValorComercial() {
		float valor = 0;
		if( this.getTipoFormato() == Formato.REDONDO && this.tematica == Tematica.CEREMONIAL) {
			valor = this.getValorFacial() + this.getTipoFormato().obtenerValor();
		} else {
			valor = this.getValorFacial();
		}
		
		return valor;
	}

	@Override
	public void verDatos() {
		////INFO_SELLO = "%s %s - Valor COMERCIAL:%.2f\n";
		
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName() + "--" + String.format(Visualizable.INFO_SELLO, this.getPais(), this.getPie(), this.getValorComercial()));
	}
}
