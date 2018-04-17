package aula8;

/** Subclasse da classe Pessoa. Ela apenas adiciona alguns campos particulares das pessoas juridicas.
 * 
 * @author eduar
 *
 */
public class PessoaJuridica extends Pessoa{
	private String CNPJ;
	private String Insc_Estadual;
	private String RazaoSocial;
	
	/**
	 * Construtor da classe. Cria um contato de pessoa juridica.
	 * @param nome - String que contem o nome do contato.
	 * @param endereco - String que contem o endereco do contato.
	 * @param email - String que contem o email do contato.
	 * @param cnpj - String que contem o CNPJ do contato.
	 * @param inscricao - String que contem a inscricao estadual do contato.
	 * @param razao - String que contem a razao social do contato.
	 */
	public PessoaJuridica(String nome, String endereco, String email, String cnpj, String inscricao, String razao) {
		super(nome, endereco, email);
		this.CNPJ = cnpj;
		this.Insc_Estadual = inscricao;
		this.RazaoSocial = razao;
	}
	
	/**
	 * Apenas retorna o atributo privado CNPJ.
	 * @return o CNPJ.
	 */
	public String getCNPJ() {
		return CNPJ;
	}
	
	/**
	 * Apenas retorna o atributo privado Insc_Estadual.
	 * @return a Inscricao Estadual.
	 */
	public String getInsc_Estadual() {
		return Insc_Estadual;
	}
	
	/**
	 * Apenas retorna o atributo privado RazaoSocial
	 * @return a Razao Social.
	 */
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	
	/**
	 * Funcao que retorna uma string que contem a ficha inteira do contato.
	 */
	@Override
	public String toString() {
		return "Nome : " + this.getNome() + "\nEndereco : " + this.getEndereco() + "\nEmail : " + this.getEmail() + "\nCNPJ : " + this.getCNPJ() + 
				"\nInscricao estadual : " + this.getInsc_Estadual() + "\nRazao social : " + this.getRazaoSocial();
	}
}
