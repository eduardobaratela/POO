package aula8;

/**
 * Subclasse da classe Pessoa. Ela apenas adiciona alguns campos particulares das pessoas fisicas.
 * @author eduar
 *
 */
public class PessoaFisica extends Pessoa{
	private String CPF;
	private String data;
	private String estadocivil;
	
	/**
	 * Construtor da classe. Cria um contato de pessoa fisica.
	 * @param nome - String que contem o nome do contato.
	 * @param endereco - String que contem o endereco do contato.
	 * @param email - String que contem o email do contato.
	 * @param cpf - String que contem o CPF do contato.
	 * @param data - String que contem a idata de nascimento do contato;
	 * @param civil -  - String que contem o estado civil do contato;
	 */
	public PessoaFisica(String nome, String endereco, String email, String cpf, String data, String civil) {
		super(nome, endereco, email);
		this.CPF = cpf;
		this.data = data;
		this.estadocivil = civil;
	}

	/**
	 * Apenas retorna o atributo privado CPF.
	 * @return o CPF
	 */
	public String getCPF() {
		return CPF;
	}
	
	/**
	 * Apenas retorna o atributo privado data.
	 * @return a data de nascimento.
	 */
	public String getData() {
		return data;
	}
	
	/**
	 *  Apenas retorna o atributo privado estadocivil.
	 * @return o estado civil.
	 */
	public String getEstadocivil() {
		return estadocivil;
	}	
	
	/**
	 * Funcao que retorna uma string que contem a ficha inteira do contato.
	 */
	@Override
	public String toString() {
		return "Nome : " + this.getNome() + "\nEndereco : " + this.getEndereco() + "\nEmail : " + this.getEmail() + "\nCPF : " + this.getCPF() + 
				"\nData de nascimento : " + this.getData() + "\nEstado civil : " + this.getEstadocivil();
	}
}
