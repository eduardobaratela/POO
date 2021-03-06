/**
 * Simula um dado de n�mero de lados variados. Ao criar o objeto � poss�vel estabelecer o n�mero de lados. A rolagem do dado � feita por 
 * meio de um gerador de n�meros aleat�rios (Random).
 */
public class Dado {
	//private static int valor = 0;
	private int lados;
	private int ladoEscolhido;
	
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado() {
		lados = 6;
	}
	
	/**
	 * Cria objeto com um n�mero qualquer de lados
	 * @param n - n�mero de lados do dado
	 */
	public Dado(int n) {
		lados = n;
	}
	
	/**
	 * Recupera o �ltimo n�mero selecionado.
	 * @return o n�mero do �ltimo lado selecionado.
	 */
	public int getLado() {
		return ladoEscolhido;
	}
	
	/**
	 * Simula a rolagem do dado por meio de um gerador aleat�rio. O n�mero selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return o n�mero que foi sorteado
	 */
	public int rolar() {
		Random r = new Random();
		ladoEscolhido = (r.getIntRand(lados));
		
		return ladoEscolhido;
	}

	/**
	 * Transforma representa��o do dado em String. � mostrada uma representa��o do dado que est� para cima. Note que s� funciona corretamente para
	 *  dados de 6 lados. Exemplo:
		+-----+    
		|*   *|    
		|  *  |    
		|*   *|    
		+-----+    
	 */
@Override
	public java.lang.String toString(){
		
		String desenho = "";
		
		if(ladoEscolhido == 1) {
			desenho = "+-----+    \n" +    
					  "|     |    \n" +   
					  "|  *  |    \n" +  
					  "|     |    \n" +  
					  "+-----+    ";
		}
		else if(ladoEscolhido == 2) {
			desenho = "+-----+    \n" +    
					  "|*    |    \n" +   
					  "|     |    \n" +  
					  "|    *|    \n" +  
					  "+-----+    ";
		}
		else if(ladoEscolhido == 3) {
			desenho = "+-----+    \n" +    
					  "|*    |    \n" +   
					  "|  *  |    \n" +  
					  "|    *|    \n" +  
					  "+-----+    ";
		}
		else if(ladoEscolhido == 4) {
			desenho = "+-----+    \n" +    
					  "|*   *|    \n" +   
					  "|     |    \n" +  
					  "|*   *|    \n" +  
					  "+-----+    ";
		}
		else if(ladoEscolhido == 5) {
			desenho = "+-----+    \n" +    
					  "|*   *|    \n" +   
					  "|  *  |    \n" +  
					  "|*   *|    \n" +  
					  "+-----+    ";
		}
		else if(ladoEscolhido == 6) {
			desenho = "+-----+    \n" +    
					  "|* * *|    \n" +   
					  "|     |    \n" +  
					  "|* * *|    \n" +  
					  "+-----+    ";
		}
		
		return desenho;
	}
}
