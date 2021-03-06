import java.io.IOException;

/**
 * Essa � a classe inicial do programa Boz�. Possui apenas o m�todo main, que cuida da execu��o do jogo.
 *
 */
public class Bozo {
	/**
	 * M�todo inicial do programa. Ele cuida da execu��o do jogo e possui um la�o, no qual cada itera��o representa uma rodada do jogo.
	 * Em cada rodada, o jogador joga os dados at� 3 vezes e depois escolhe a posi��o do placar que deseja preencher. No final das rodadas
	 *  a pontua��o total � exibida.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i =0;
		RolaDados rd = new RolaDados();
		Placar p = new Placar();
		int[] result = new int[5];
		while(i<10){
			p.toString();
			
			System.out.println("****** Rodada "+ (i+1));
			System.out.println("Pressione ENTER para lan�ar  os dados");
			String comeco = EntradaTeclado.leString();
			if ( comeco.length() == 0){
					result = rd.rolar();
					System.out.println(rd.toString());
				
				//Caso queira tentar pela segunda vez
				System.out.println("Digite os n�meros dos dados que quiser TROCAR. Separados por espa�os.");
				String tentativa = EntradaTeclado.leString();
				if (tentativa.length() != 0) {
					result = rd.rolar(tentativa);
					System.out.println(rd.toString());
				}
					
				//Caso queira tentar pela terceira vez
				System.out.println("Digite os n�meros dos dados que quiser TROCAR. Separados por espa�os.");
				String tentativa1 = EntradaTeclado.leString();
				if (tentativa1.length() != 0) {
					result = rd.rolar(tentativa1);
					System.out.println(rd.toString());
				}
				
				System.out.print("Escolha a posi��o que quer ocupar com essa jogada ===> ");
				int jogada = EntradaTeclado.leInt();
				try {
					p.add(jogada, result);
				}
				catch(java.lang.IllegalArgumentException e) {
					System.out.println("Tente novamente");
					i--;
				}
			}	
			i++;
		}
		p.toString();
		int score = p.getScore();
		System.out.println("Pontu�ao Final: "+score);
	}

}