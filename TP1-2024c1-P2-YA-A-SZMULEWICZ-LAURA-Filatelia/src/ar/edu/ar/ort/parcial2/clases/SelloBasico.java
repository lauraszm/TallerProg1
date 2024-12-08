package ar.edu.ar.ort.parcial2.clases;

public class SelloBasico extends Sello {
	
	private Disenio tipoDisenio;
		
	public SelloBasico(String pais, String pieDeImprenta, float valorFacial, Formato formato, Impresion impresion, Disenio disenio) {
		super(pais, pieDeImprenta, valorFacial, formato, impresion);
		this.tipoDisenio = disenio;
		this.valorComercial = this.setValorComercial();
		// TODO Auto-generated constructor stub
	}

	@Override
	public float setValorComercial() {
		// TODO Auto-generated method stub
		float valor = 0;
		if(this.tipoDisenio == Disenio.MONARCA) {
			valor = this.getValorFacial() + this.tipoDisenio.getValorDisenio();
		} else {
			valor = this.getValorFacial() + this.getTipoFormato().obtenerValor();
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
