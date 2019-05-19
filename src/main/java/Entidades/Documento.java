package Entidades;

public class Documento {
	private String numDocumento;

	public Documento(String numDoc) {

		if (numDocumento.isEmpty() || numDocumento == null) {
			throw new IllegalArgumentException("O número do documento não pode ser vazio");
		}
		this.numDocumento = numDoc;

	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		if (numDocumento.isEmpty() || numDocumento == null) {
			throw new IllegalArgumentException("O número do documento não pode ser vazio");
		}
		this.numDocumento = numDocumento;
	}

}
