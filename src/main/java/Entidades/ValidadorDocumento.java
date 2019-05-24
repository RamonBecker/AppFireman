package Entidades;

import java.util.ArrayList;
// REVER

public enum ValidadorDocumento {

	CPF, CNPJ;

	public static boolean validarCPF(String cpf) {
		boolean valido = true;
		int primeiroDigito = 0, segundoDigito = 0, indiceAuxPriDigito = 10, indiceAuxSegDigito = 11;

		ArrayList<Integer> vetor = new ArrayList<Integer>();
		ArrayList<String> cpfInvalido = new ArrayList<String>() {
			{
				add("00000000000");
				add("11111111111");
				add("22222222222");
				add("33333333333");
				add("44444444444");
				add("55555555555");
				add("66666666666");
				add("77777777777");
				add("88888888888");
				add("99999999999");
			}

		};

		ArrayList<Character> caracterInvalido = new ArrayList<Character>() {
			{
				add('A');
				add('B');
				add('C');
				add('D');
				add('E');
				add('F');
				add('G');
				add('H');
				add('I');
				add('J');
				add('K');
				add('L');
				add('M');
				add('N');
				add('O');
				add('P');
				add('Q');
				add('R');
				add('S');
				add('T');
				add('U');
				add('V');
				add('W');
				add('X');
				add('Y');
				add('Z');
			}
		};

		for (int i = 0; i < cpf.length(); i++) {
			for (int j = 0; j < caracterInvalido.size(); j++) {
				if (cpf.toUpperCase().charAt(i) == caracterInvalido.get(j)) {
					valido = false;
				}
			}
		}

		for (int i = 0; i < cpfInvalido.size(); i++) {
			if (cpfInvalido.get(i).equals(cpf)) {
				valido = false;
			}
		}

		if (valido == true) {
			for (int i = 0; i < cpf.length(); i++) {
				vetor.add((int) cpf.charAt(i) - 48);
			}

			for (int i = 0; i < vetor.size() - 2; i++) {
				primeiroDigito += vetor.get(i) * indiceAuxPriDigito;
				indiceAuxPriDigito--;
			}

			primeiroDigito = primeiroDigito * 10 % 11;

			if (primeiroDigito == 10) {
				primeiroDigito = 0;
			}

			for (int i = 0; i < vetor.size() - 1; i++) {
				segundoDigito += vetor.get(i) * indiceAuxSegDigito;
				indiceAuxSegDigito--;
			}

			segundoDigito = segundoDigito * 10 % 11;

			if (segundoDigito == 10) {
				segundoDigito = 0;
			}

			if (vetor.get(9) == primeiroDigito) {
				if (vetor.get(10) == segundoDigito) {
					valido = true;
				}
			}
		}

		return valido;
	}

	public static boolean validarCNPJ(String cnpj) {

		int primeiroDigito = 0, segundoDigito = 0, indiceAuxiliar = 1;
		boolean valido = true;
		ArrayList<Integer> vetor = new ArrayList<Integer>();
		ArrayList<String> cnpjInvalido = new ArrayList<String>() {
			{
				add("00000000");
				add("11111111");
				add("22222222");
				add("33333333");
				add("44444444");
				add("55555555");
				add("66666666");
				add("77777777");
				add("88888888");
				add("99999999");
			}
		};

		ArrayList<Integer> pesoCNPJ = new ArrayList<Integer>() {
			{
				add(6);
				add(5);
				add(4);
				add(3);
				add(2);
				add(9);
				add(8);
				add(7);
				add(6);
				add(5);
				add(4);
				add(3);
				add(2);
			}
		};

		ArrayList<Character> caracterInvalido = new ArrayList<Character>() {
			{
				add('A');
				add('B');
				add('C');
				add('D');
				add('E');
				add('F');
				add('G');
				add('H');
				add('I');
				add('J');
				add('K');
				add('L');
				add('M');
				add('N');
				add('O');
				add('P');
				add('Q');
				add('R');
				add('S');
				add('T');
				add('U');
				add('V');
				add('W');
				add('X');
				add('Y');
				add('Z');
			}
		};

		for (int i = 0; i < cnpj.length(); i++) {
			for (int j = 0; j < caracterInvalido.size(); j++) {
				if (cnpj.toUpperCase().charAt(i) == caracterInvalido.get(j)) {
					valido = false;
				}
			}
		}

		for (int i = 0; i < cnpjInvalido.size(); i++) {
			if (cnpjInvalido.get(i).equals(cnpj.substring(0, 8))) {
				valido = false;
			}
		}

		if (valido == true) {

			for (int i = 0; i < cnpj.length(); i++) {
				vetor.add((int) cnpj.charAt(i) - 48);
			}

			for (int i = 0; i < vetor.size() - 2; i++) {
				primeiroDigito += vetor.get(i) * pesoCNPJ.get(indiceAuxiliar);
				indiceAuxiliar++;

			}

			primeiroDigito = primeiroDigito % 11;

			if (primeiroDigito < 2) {
				primeiroDigito = 0;
			} else {
				primeiroDigito = 11 - primeiroDigito;
			}

			for (int i = 0; i < vetor.size() - 1; i++) {
				segundoDigito += vetor.get(i) * pesoCNPJ.get(i);
			}

			segundoDigito = segundoDigito % 11;

			if (segundoDigito < 2) {
				segundoDigito = 0;
			} else {
				segundoDigito = 11 - segundoDigito;
			}

			if (vetor.get(12) == primeiroDigito) {
				if (vetor.get(13) == segundoDigito) {
					valido = true;
				}
			}
		}
		return valido;
	}
}
