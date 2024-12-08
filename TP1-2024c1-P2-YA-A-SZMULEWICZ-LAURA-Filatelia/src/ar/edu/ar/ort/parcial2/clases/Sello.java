package ar.edu.ar.ort.parcial2.clases;

public abstract class Sello implements Visualizable{
	private static final String MSJ_ERR_VALOR = "Valor facial fuera del rango aceptable";
	private final static float MIN_VALOR_FACIAL = 0.5f;
	private final static float MAX_VALOR_FACIAL = 0.9f;
	private String pais;
	private String pieDeImprenta;
	private float valorFacial;
	private Formato tipoFormato;
	private Impresion tipoImpresion;
	protected float valorComercial;
	
	public Sello(String pais, String pieDeImprenta, float valorFacial, Formato formato, Impresion impresion) {
		this.pais = pais;
		this.setValorFacial(valorFacial);
		this.setPieDeImprenta(pieDeImprenta);
		this.tipoFormato = formato;
		this.tipoImpresion = impresion;
	}
	
	public float getValorFacial() {
		return this.valorFacial;
	}
	
	public Formato getTipoFormato() {
		return this.tipoFormato;
	}
	
	public Impresion getTipoImpresion() {
		return this.tipoImpresion;
	}
	
	public String getPie() {
		return this.pieDeImprenta;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public void setPieDeImprenta(String pie) {
		if(pie == null || pie.isEmpty()) {
			throw new IllegalArgumentException(Visualizable.ERROR_PIE_NULO);
		}
		this.pieDeImprenta = pie;
	}
	
	public void setValorFacial(float valor) {
		RangoNumeros rango = new RangoNumeros(MIN_VALOR_FACIAL, MAX_VALOR_FACIAL);
		if(!rango.incluye(valor)) {
			throw new IllegalArgumentException(MSJ_ERR_VALOR);
		}
		this.valorFacial = valor;
	}
	
	public abstract float setValorComercial();
	public float getValorComercial() {
		return this.valorComercial;
	}

	@Override
	public String toString() {
		return "Sello [pais=" + pais + ", pieDeImprenta=" + pieDeImprenta + ", valorFacial=" + valorFacial
				+ ", tipoFormato=" + tipoFormato + ", tipoImpresion=" + tipoImpresion + ", valorComercial="
				+ valorComercial + "]";
	}



	
}
