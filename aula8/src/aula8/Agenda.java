package aula8;

import java.io.IOException;

import exercicioFuncionario.EntradaTeclado;

/**
 * Essa é a classe inicial do programa. Possui apenas o método main que admnistra a agenda.
 * @author eduar
 *
 */
public class Agenda {
	
	/**
	 * 	Método inicial do programa. Ele fornece 5 opcoes de operacoes, que até que se decida sair do programa fica em um loop, podendo fazer operações de adicao, remocao,
	 * pesquisa ou visualizacao de todos os contatos. Para a vizualizacao se separa as pessoas fisicas e juridicas, e elas sao ordenadas de acordo com CPF/CNPJ.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	    Pessoa Contato[] = new Pessoa[100];
	    int op, tipo, i = 0;
	    
	    do {
		    System.out.println("\nEscolha uma operacao:\n1 - Adicionar contato\n2 - Remover contato\n3 - Pesquisar contato\n4 - Visualizar contatos\n5 - Sair.");
		    op = EntradaTeclado.leInt();
		    if(op == 1) {	//Adiciona contato
		    	System.out.println("Para pessoa fisica digite 1. Para juridica digite 2.");
		    	tipo = EntradaTeclado.leInt();
		    	if(tipo == 1) {
		    		String nome, endereco, email, cpf, data, civil;
		    		System.out.println("Digite o nome");
		    		nome = EntradaTeclado.leString();
		    		System.out.println("Digite o endereco");
		    		endereco = EntradaTeclado.leString();
		    		System.out.println("Digite o email");
		    		email = EntradaTeclado.leString();
		    		System.out.println("Digite o CPF");
		    		cpf = EntradaTeclado.leString();
		    		System.out.println("Digite a data de nascimento");
		    		data = EntradaTeclado.leString();
		    		System.out.println("Digite o Estado civil");
		    		civil = EntradaTeclado.leString();
		    		
		    		Contato[i] = new PessoaFisica(nome, endereco, email, cpf, data, civil);
		    		i++;
		    	}
		    	else if(tipo == 2){
		    		String nome, endereco, email, cnpj, inscricao, razao;
		    		System.out.println("Digite o nome");
		    		nome = EntradaTeclado.leString();
		    		System.out.println("Digite o endereco");
		    		endereco = EntradaTeclado.leString();
		    		System.out.println("Digite o email");
		    		email = EntradaTeclado.leString();
		    		System.out.println("Digite o CNPJ");
		    		cnpj = EntradaTeclado.leString();
		    		System.out.println("Digite a inscricao estadual");
		    		inscricao = EntradaTeclado.leString();
		    		System.out.println("Digite a razao social");
		    		razao = EntradaTeclado.leString();
		    		
		    		Contato[i] = new PessoaJuridica(nome, endereco, email, cnpj, inscricao, razao);
		    		i++;
		    	}
		    	else System.out.println("---Opcao invalida.---");
		    }
		    else if(op == 2) { //Remove o contato
		    	System.out.println("Para remover por nome digite 1. Para remover por CPF/CNPJ digite 2.");
		    	tipo = EntradaTeclado.leInt();
		    	if(tipo == 1) {
		    		System.out.println("Digite o nome.");
		    		String nome = EntradaTeclado.leString();
		    		int flag  = 0;
		    		for (int j = 0; j < i; j++) {
						if(Contato[j].getNome().equals(nome)) {
							if(j == i) {
								i--;
								flag = 1;
							}
							else{
								for (; j < i; j++) {
									Contato[j] = Contato[j+1];
								}
								i--;
								flag = 1;
								break;
							}
						}
					}
		    		if(flag == 0) System.out.println("---Pessoa nao encontrada.---");
		    	}
		    	else if(tipo == 2) {
		    		System.out.println("Digite o CPF/CNPJ.");
		    		String num = EntradaTeclado.leString();
		    		int flag  = 0;
		    		for (int j = 0; j <= i; j++) {
						if(Contato[j] instanceof PessoaFisica) {
							PessoaFisica p = (PessoaFisica) Contato[j];
							if(p.getCPF().equals(num)) {
								if(j == i) {
									i--;
									flag = 1;
								}
								else{
									for (; j < i; j++) {
										Contato[j] = Contato[j+1];
									}
									flag = 1;
									break;
								}
							}
						}
						else if(Contato[j] instanceof PessoaJuridica) {
							PessoaJuridica p = (PessoaJuridica) Contato[j];
							if(p.getCNPJ().equals(num)) {
								if(j == i) {
									i--;
									flag = 1;
								}
								else{
									for (; j < i; j++) {
										Contato[j] = Contato[j+1];
									}
									flag = 1;
									break;
								}
							}
						}
					}
		    		if(flag == 0) System.out.println("---Pessoa nao encontrada.---");
		    	}
		    	else System.out.println("---Opcao invalida.---");
		    }
		    else if(op == 3) { //Pesquisa o contato
		    	System.out.println("Para pesquisar por nome digite 1. Para pesquisar por CPF/CNPJ digite 2.");
		    	tipo = EntradaTeclado.leInt();
		    	if(tipo == 1) {
		    		System.out.println("Digite o nome.");
		    		String nome = EntradaTeclado.leString();
		    		int flag  = 0;
		    		for (int j = 0; j < i; j++) {
						if(Contato[j].getNome().equals(nome)) {
							System.out.println(Contato[j]);
							flag = 1;
						}
		    		}
		    		if(flag == 0) System.out.println("---Pessoa nao encontrada.---");
		    	}
		    	else if(tipo == 2) {
		    		System.out.println("Digite o CPF/CNPJ.");
		    		String num = EntradaTeclado.leString();
		    		int flag  = 0;
		    		for (int j = 0; j < i; j++) {
						if(Contato[j] instanceof PessoaFisica) {
							PessoaFisica p = (PessoaFisica) Contato[j];
							if(p.getCPF().equals(num)) {
								System.out.println(Contato[j]);
								flag = 1;
							}
						}
						else if(Contato[j] instanceof PessoaJuridica) {
							PessoaJuridica p = (PessoaJuridica) Contato[j];
							if(p.getCNPJ().equals(num)) {
								System.out.println(Contato[j]);
								flag = 1;
							}
						}
		    		}
		    		if(flag == 0) System.out.println("---Pessoa nao encontrada.---");
		    	}
		    	else System.out.println("---Opcao invalida.---");
		    }
		    else if(op == 4) {  //Visualiza todos os contatos ordenadamente
		        Pessoa temp;  
		        for(int j = 0; j < i; j++){  //Separa fisico de juridico
		        	for(int k = 0; k < i - 1; k++){  
		        		if(Contato[k] instanceof PessoaJuridica && Contato[k+1] instanceof PessoaFisica){  
		        			temp = Contato[k];  
		        			Contato[k] = Contato[k+1];  
		        			Contato[k+1] = temp;  
		        		}
		           }  
		        }
		        for (int j = 0; j < i; j++) {	//Ordena de acordo com CPF/CNPJ
					for (int k = 0; k < i-1; k++) {
						if(Contato[k] instanceof PessoaFisica && Contato[k+1] instanceof PessoaFisica) {
		        			PessoaFisica p1 = (PessoaFisica) Contato[k];
		        			PessoaFisica p2 = (PessoaFisica) Contato[k+1];
		        			if(p1.getCPF().compareTo(p2.getCPF()) == 1) {
		        				temp = Contato[k];  
			        			Contato[k] = Contato[k+1];  
			        			Contato[k+1] = temp;  
		        			}
		        		}
		        		else if(Contato[k] instanceof PessoaJuridica && Contato[k+1] instanceof PessoaJuridica) {
		        			PessoaJuridica p1 = (PessoaJuridica) Contato[k];
		        			PessoaJuridica p2 = (PessoaJuridica) Contato[k+1];
		        			if(p1.getCNPJ().compareTo(p2.getCNPJ()) == 1) {
		        				temp = Contato[k];  
			        			Contato[k] = Contato[k+1];  
			        			Contato[k+1] = temp;  
		        			}
		        		}
					}
				}
		        
		        if(i == 0) System.out.println("---Lista vazia.---");
		        for (int j = 0; j < i; j++) {
					System.out.println(Contato[j] + "\n");
				}
		    }
		    else if(op == 5) break;
		    else {
		    	System.out.println("---Opcao invalida.---");
		    }
		}while(true);
	}

}
