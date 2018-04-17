
package aula7;

public class Contas {

	private ContaBancaria contas[] = new ContaBancaria[100];
	private int nContas = 0;
	
	public static void main(String[] args) throws Exception {
		int op = 0;
		Contas ct = new Contas();
		
		while (op != 7) {
			op = Contas.leOpcao();
			switch (op)
			{
			case 1:
				System.out.println("Digite 1 para Poupanca Simples ou 2 para Poupanca Ouro.");
				int poup = EntradaTeclado.leInt();
				System.out.println("Nome do correntista: ");
				String s = EntradaTeclado.leString();
				System.out.println("Dia de vencimento: ");
				int dia = EntradaTeclado.leInt();
				if(poup == 1) {
					PoupancaSimples ps = new PoupancaSimples(s, dia);
					ct.add(ps);
				}
				else if(poup == 2) {
					PoupancaOuro po = new PoupancaOuro(s, dia);
					ct.add(po);
				}
				else System.out.println("Opcao invalida.");
				
				if(poup == 1 || poup == 2)System.out.println("************ Conta criada.**************");
				break;
				
			case 2: 
				System.out.println("Nome do correntista: ");
				s = EntradaTeclado.leString();
				System.out.println("Limite de saque: ");
				double limite = EntradaTeclado.leDouble();
				ContaEspecial ce = new ContaEspecial(s, limite);
				ct.add(ce);
				System.out.println("************ Conta criada.**************");
				break;
			case 3:
				System.out.println("Numero da conta: ");
				int conta = EntradaTeclado.leInt();
				System.out.println("Valor a sacar: ");
				double valor = EntradaTeclado.leDouble();
				ContaBancaria cb = ct.procura(conta);
				if ( cb == null )
				{
					System.out.println("************* Conta nao existe **************");
					break;
				}
				try {
					cb.saca(valor);
					System.out.println("****************** Saque realizado ***********");
				}
				catch (Exception e)
				{
					System.out.println("****************** Saque não realizado ***********");
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Numero da conta: ");
				conta = EntradaTeclado.leInt();
				System.out.println("Valor a depositar: ");
				valor = EntradaTeclado.leDouble();
				cb = ct.procura(conta);
				if ( cb == null )
				{
					System.out.println("************* Conta nao existe **************");
					break;
				}
				cb.deposita(valor);
				System.out.println("****************** Deposito realizado ***********");
				break;
			case 6: 
				ct.printSaldos();
				break;
			case 5:
				System.out.println("Qual o valor da taxa? ");
				double tx = EntradaTeclado.leDouble();
				ct.atualizaPoupanca(tx);
				System.out.println("Saldos atualizados");
				break;
			case 7:
				System.out.println("Terminando o programa....");
				return;
			}
			System.out.println("Digite ENTER para continuar");
			EntradaTeclado.leString();
			System.out.println("\n\n");
		}

	}

	private static int leOpcao() {
        System.out.println("1) Criar poupanca\n2) Criar conta especial\n3) Realizar saque\n4) Realizar deposito\n"
        		+ "5) Atualizar poupancas\n6) Mostrar saldos\n7) Sair");
        int k = -1;
        while (true)
        {
        	System.out.println("Digite a opcao desejada ===> ");
        	try {
        		k = EntradaTeclado.leInt();
        		if ( k > 0 && k < 8 )
        			return k;
        	}
        	catch (Exception e) {
        		;
        	}
        }
	}

	private void add(ContaBancaria cb) {
		contas[nContas++] = cb;		
	}
	
	private void printSaldos() {
		for (ContaBancaria ctb : contas)
		{
			if ( ctb == null ) break;
			System.out.println("Numero da conta:" + ctb.getNumConta());
			System.out.println("Titular: " + ctb.getNomeCliente());
			System.out.println("Saldo: " + ctb.getSaldo());
			System.out.println();
		}

	}

	private void atualizaPoupanca(double tx) {
		for (ContaBancaria ctb : contas)
		{
			if ( ctb == null ) break;

			if ( ctb instanceof ContaPoupanca )
			{
				ContaPoupanca cp = (ContaPoupanca) ctb;
				cp.atualiza(tx);
			}
		}
	}

	private ContaBancaria procura(int conta) {
		for (ContaBancaria ctb: contas )
		{
			if ( ctb == null ) break;

			if (conta == ctb.getNumConta())
				return ctb;
		}
		return null;
	}

}
