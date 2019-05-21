package Entidades;

public class PessoaFisica extends Pessoa{
	private String sobrenome;
	private String dataNascimento;
	
	public PessoaFisica(String nome, Endereco endereco, String sobrenome, String dataNascimento) {
		super(nome, endereco);
		
		if(sobrenome.isEmpty() || sobrenome == null) {
			throw new IllegalArgumentException("O sobrenome n�o pode ser vazio");
		}
		
		if(dataNascimento.isEmpty() || dataNascimento == null) {
			throw new IllegalArgumentException("A data de nascimento n�o pode ser vazio !");
		}
		
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		if(sobrenome.isEmpty() || sobrenome == null) {
			throw new IllegalArgumentException("O sobrenome n�o pode ser vazio");
		}
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		if(dataNascimento.isEmpty() || dataNascimento == null) {
			throw new IllegalArgumentException("A data de nascimento n�o pode ser vazio !");
		}
		this.dataNascimento = dataNascimento;
	}
}
