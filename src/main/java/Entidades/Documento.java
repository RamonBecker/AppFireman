package Entidades;

import Alert.MessageAlert;

public class Documento {
	
	private String numDocumento;

	public Documento(String numDoc, ValidadorDocumento validaDoc) throws Exception {

		if (numDoc.isEmpty() || numDoc == null) {
			throw new IllegalArgumentException("O número do documento não pode ser vazio");
		}

		if (numDoc.trim().length() == 11 && validaDoc == ValidadorDocumento.CPF) {
			if (validaDoc.validarCPF(numDoc)) {
				MessageAlert.cadastroRealizadoSucesso(Strings.mensagemCPF);
				this.numDocumento = numDoc;
			} else {
				throw new Exception("CPF Invalido");
			}
		}
		
		if(numDoc.trim().length() == 11 && validaDoc == ValidadorDocumento.CNPJ) {
			if(validaDoc.validarCNPJ(numDoc)) {
				MessageAlert.cadastroRealizadoSucesso(Strings.mensagemCNPJ);
				this.numDocumento = numDoc;
			}else {
				throw new Exception("CNPJ Inválido");
			}
		}
	}

	public String getNumDocumento() {
		return numDocumento;
	}
}
