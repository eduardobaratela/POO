package exercicioFuncionario;

import java.io.IOException;

public class Teste {

	private Funcionarios f[] = new Funcionarios[100];
	private static int nFunc = 0;

	public static void main(String[] args) throws IOException {
		
		Teste t = new Teste();
		
		System.out.println("Digite o salario base: ");
		double salario = EntradaTeclado.leDouble();
		
		while(true) {
			System.out.println("Para adicionar um gerente digite 1.\nPara adicionar um Vendedor digite 2.\nPara adicionar um assistente digite 3. Para sair digite 4.\n");
			int op = EntradaTeclado.leInt();
			System.out.println("Digite o nome: ");
			String n = EntradaTeclado.leString();
			System.out.println("Digite o CPF: ");
			String cpf  = EntradaTeclado.leString();
			if(op == 1) {
				Gerente g = new Gerente(n, cpf, salario);
				t.add(g);
			}
			else if(op == 2) {
				System.out.println("Digite a comissao.");
				double comissao = EntradaTeclado.leDouble();
				Vendedor v = new Vendedor(n, cpf, salario, comissao);
				t.add(v);
			}
			else if(op == 3) {
				Assistente a = new Assistente(n, cpf, salario);
				t.add(a);
			}
			else if(op == 4) break;
			else System.out.println("Opcao invalida");
		}
		
		double total = t.folhaSalarial();
		System.out.println("Total = " + total);
	}
	
	private double folhaSalarial() {
		double total = 0;
		
		for (int j = 0; j < nFunc; j++) {
			System.out.println(this.f[j].getNome() + " = " + this.f[j].calculaSalario());
			total += this.f[j].calculaSalario();
		}
		
		return total;
	}

	private void add(Funcionarios fun) {
		f[nFunc++] = fun;		
	}
}
