package aula8;

/**
 * Superclasse Pessoa, que é pai das classes PessoaFisica e Pessoajuridica. Ela apeas adiciona alguns campos comuns a todos os tipos de pessoa.
 * @author eduar
 *
 */
public abstract class Pessoa {
	private String nome;
	private String endereco;
	private String email;
	
	/**
	 * Construtor da classe. Cria um contato de uma pessoa qualquer.
	 * @param name - String que contem o nome do contato.
	 * @param adress - String que contem o endereco do contato.
	 * @param mail - String que contem o email do contato.
	 */
	public Pessoa(String name, String adress, String mail) {
		this.nome = name;
		this.endereco = adress;
		this.email = mail;
	}

	/**
	 * Apenas retorna o atributo privado nome.
	 * @return o nome.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Apenas retorna o atributo privado endereco.
	 * @return o endereco.
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Apenas retorna o atributo privado email.
	 * @return o email.
	 */
	public String getEmail() {
		return email;
	}
}
