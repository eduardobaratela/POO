/**
 * Esta classe representa o placar de um jogo de Boz�. Permite que combina��es de dados sejam alocadas �s posi��es e mant�m o escore de um jogador.
 */
public class Placar {
	int j;
	int[] resultado = new int [10];		
	
	public Placar(){
		for(j=0;j<10;j++){
			resultado[j] = -1;
		}
	}
	/**
	 * Adiciona uma sequencia de dados em uma determinada posi��o do placar. Ap�s a chamada, aquela posi��o torna-se ocupada e n�o pode ser 
	 * usada uma segunda vez.
	 * @param posicao - Posi��o a ser preenchida. As posi��es 1 a 6 correspondem �s quantidas de uns at� seis, ou seja, as lateraisdo placar. 
	 * As outas posi��es s�o: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados - um array de inteiros, de tamanho 5. Cada posi��o corresponde a um valor de um dado. Sup�es-se que cada dado pode ter valor 
	 * entre 1 e 6.
	 * @throws java.lang.IllegalArgumentException - Se a posi��o estiver ocupada ou se for passado um valor de posi��o inv�lido, essa exce��o 
	 * � lan�ada. N�o � feita nenhuma verifica��o quanto ao tamanho do array nem quanto ao seu conte�do.
	 */
	public void add(int posicao, int[] dados)throws java.lang.IllegalArgumentException{
		int cont=0;
		
			if(posicao >= 1 && posicao <= 6 && resultado[posicao - 1] == -1) {
				for (int i = 0; i < dados.length; i++) {
					if(dados[i] == posicao) cont += posicao;
				}
				resultado[posicao - 1] = cont;
			}
			else if(posicao == 7 && resultado[posicao - 1] == -1){
				int[] contFull = new int[6];
				for (int i = 0; i < contFull.length; i++) {
					contFull[i] = 0;
				}
				for(int i=0;i<5;i++){
					contFull[dados[i] - 1]++;
				}
				if(contFull[0] == 3 || contFull[1] == 3 || contFull[2] == 3 || contFull[3] == 3 || contFull[4] == 3 || contFull[5] == 3) {
					if(contFull[0] == 2 || contFull[1] == 2 || contFull[2] == 2 || contFull[3] == 2 || contFull[4] == 2 || contFull[5] == 2) {
						//System.out.println("ENTROU NO FULLHAND");
						resultado[6] = 15;
					}
					else {
						//System.out.println("Nao eh um full hand");
						resultado[6] =0;
					}
				}
				else {
					//System.out.println("Nao eh um full hand");
					resultado[6] = 0;
				}
			}
			else if(posicao == 8 && resultado[posicao - 1] == -1){//Sequencia
				if(dados[0]==1 || dados[1]==1 || dados[2]==1 || dados[3]==1 || dados[4]==1){
					if(dados[0]==2 || dados[1]==2 || dados[2]==2 || dados[3]==2 || dados[4]==2)
						if(dados[0]==3 || dados[1]==3 || dados[2]==3 || dados[3]==3 || dados[4]==3)
							if(dados[0]==4 || dados[1]==4 || dados[2]==4 || dados[3]==4 || dados[4]==4)
								if(dados[0]==5 || dados[1]==5 || dados[2]==5 || dados[3]==5 || dados[4]==5)
									resultado[7]=20;	
				}	
				else if(dados[0]==2 || dados[1]==2 || dados[2]==2 || dados[3]==2 || dados[4]==2) {
					if(dados[0]==3 || dados[1]==3 || dados[2]==3 || dados[3]==3 || dados[4]==3)
						if(dados[0]==4 || dados[1]==4 || dados[2]==4 || dados[3]==4 || dados[4]==4)
							if(dados[0]==5 || dados[1]==5 || dados[2]==5 || dados[3]==5 || dados[4]==5)
								if(dados[0]==6 || dados[1]==6 || dados[2]==6 || dados[3]==6 || dados[4]==6)	
									resultado[7]=20;
				}
				else {
					//System.out.println("Nao eh uma Sequencia");
					resultado[7] =0;
				}
			}
			else if(posicao == 9 && resultado[posicao - 1] == -1){//Quadra
				if(dados[0] == dados[1] && dados[0] == dados[2] && dados[0] == dados[3] && dados[0] != dados[4])
					resultado[8] = 30;
				else if(dados[1] == dados[2] && dados[1] == dados[3] && dados[1] == dados[4] && dados[1] != dados[0]) 
					resultado[8] = 30;
				else if(dados[2] == dados[3] && dados[2] == dados[4] && dados[2] == dados[0] && dados[2] != dados[1]) 
					resultado[8] = 30;
				else if(dados[3] == dados[4] && dados[3] == dados[0] && dados[3] == dados[1] && dados[3] != dados[2])
					resultado[8] = 30;
				else if(dados[4] == dados[0] && dados[4] == dados[1] && dados[4] == dados[2] && dados[4] != dados[3]) 
					resultado[8] = 30;
				else {
					//System.out.println("Nao eh uma quadra");
					resultado[8] =0;
				}
			}
			else if(posicao == 10 && resultado[posicao - 1] == -1){//Quina
				if(dados[0] == dados[1] && dados[0] == dados[2] && dados[0] == dados[3] && dados[0] == dados[4])
					resultado[9]= 40;
				else {
					//System.out.println("Nao eh uma quina");
					resultado[9] =0;
				}
			}
			else {
				//System.out.println("Posicao invalida");
				//throw new java.lang.IllegalArgumentException();
			}
		}
	
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posi��es que j� est�o ocupadas.
	 * @return - O valor da soma.
	 */
	public int getScore(){
		int soma=0;
		
		//Calculando o resultado final
		for (int i = 0; i < resultado.length; i++) {
			if(resultado[i]!= -1)soma += resultado[i];
		}
		
		return soma;
	}
	
	/**
	 * A representa��o na forma de string, mostra o placar completo, indicando quais s�o as posi��es livres (com seus respectivos n�meros) e o 
	 * valor obtido nas posi��es j� ocupadas. Por exemplo: 
 		(1)    |   (7)    |   (4) 
 		--------------------------
 		(2)    |   20     |   (5) 
 		--------------------------
 		(3)    |   30     |   (6) 
		--------------------------
        		|   (10)   |
        		+----------+ 

	mostra as posi��es 8 (sequencia) e 9 (quadra) ocupadas.
	 */
	public java.lang.String toString(){
		if(resultado[0] == -1) System.out.print("  (1)  |");
		else System.out.print("  " + resultado[0] + "  |");
		if(resultado[6] == -1) System.out.print("  (7)  |");
		else System.out.print("  " + resultado[6] + "  |");
		if(resultado[3] == -1) System.out.println("  (4)  |");
		else System.out.println("  " + resultado[3] + "  |");
		System.out.print("------------------------\n");
		if(resultado[1] == -1) System.out.print("  (2)  |");
		else System.out.print("  " + resultado[1] + "  |");
		if(resultado[7] == -1) System.out.print("  (8)  |");
		else System.out.print("  " + resultado[7] + "  |");
		if(resultado[4] == -1) System.out.println("  (5)  |");
		else System.out.println("  " + resultado[4] + "  |");
		System.out.print("------------------------\n");
		if(resultado[2] == -1) System.out.print("  (3)  |");
		else System.out.print("  " + resultado[2] + "  |");
		if(resultado[8] == -1) System.out.print("  (9)  |");
		else System.out.print("  " + resultado[8] + "  |");
		if(resultado[5] == -1) System.out.println("  (6)  |");
		else System.out.println("  " + resultado[5] + "  |");
		System.out.print("------------------------\n");
		if(resultado[9] == -1) System.out.println("       |  (10)  |       ");
		else System.out.println("       |"  + "  " + resultado[9] + "   " +  "|   ");
		System.out.print("       x-------x        \n");
		
		return null;
	}
}
