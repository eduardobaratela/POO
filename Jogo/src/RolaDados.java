/**
 * Essa � uma classe auxiliar que permite gerencia um conjunto de v�rios dados simultaneamente. 
 * Opera��es como rolar alguns dos dados ou exibir o resultado de todos eles, s�o implementadas.
 */
public class RolaDados {
	
	private int[] result;
	private Dado[] dados;
	
	/**
	 * Construtor que cria e armazena v�rios objetos do tipo Dado. Usa para isso o construtor padr�o daquela classe, 
	 * ou seja, um dado de 6 lados e gerando sempre uma semente aleat�ria para o gerador de n�meros aleat�rios. 
	 * Os dados criados podem ser referenciados por n�meros, entre 1 e n.
	 */
	public RolaDados() {
		result = new int[5];
		dados = new Dado[5];
		
		for (int i = 0; i < dados.length; i++) {
			dados[i] = new Dado();
		} 
	}
	
	/**
	 * Rola todos os dados.
	 * @return Retorna o valor de cada um dos dados, inclusive os que n�o foram rolados. Nesse caso, o valor retornado 
	 * � o valor anterior que ele j� possuia.
	 */
	public int[] rolar() {
	
		for (int i = 0; i < result.length; i++) {
			result[i] = dados[i].rolar();
			//System.out.println(result[i]);
		}
		//System.out.println("");
		
		
		return result;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param quais - � um array de booleanos que indica quais dados devem ser rolados. Cada posi��o representa um dos dados. 
	 * Ou seja, a posi��o 0 do array indica se o dado 1 deve ser rolado ou n�o, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que n�o foram rolados. Nesse caso, o valor retornado � o valor
	 *  anterior que ele j� possuia.
	 */
	public int[] rolar(boolean[] quais){
		
		for (int i = 0; i < result.length; i++) {
			if(quais[i]) {
				result[i] = dados[i].rolar();
			}
		}
		
		return result;  
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param s - � um String que possui o n�mero dos dados a serem rolados. Por exemplo "1 4 5" indica que os dados 
	 * 1 4 e cinco devem ser rolados. Os n�meros devem ser separados por espa�os. Se o valor passado no string estiver 
	 * fora do intervalo v�lido, ele � ignorado simplesmente.
	 * @return Retorna o valor de cada um dos dados, inclusive os que n�o foram rolados. Nesse caso, o valor retornado
	 *  � o valor anterior que ele j� possuia.
	 */
	public int[] rolar(String s) {
				
		for (int i = 0; i < s.length(); i++) {
			int aux = Character.getNumericValue(s.charAt(i));
			if(aux == 1) result[i] = dados[i].rolar();
		}		
		
		return result;
	}
	
	public String toNumbers(){
		String array = new String();
		for(int i = 0; i < 5; i ++){
			array += result[i];
			array += " ";
		}
		return array;
	} 
	
	public int[] getResult() {
		for(int i = 0; i < 5; i++) {
			result[i] = dados[i].getLado();
		}
		return result;
	}
	
	/**
	 * Usa a representa��o em string do dados, para mostrar o valor de todos os dados do conjunto. 
	 * Exibe os dados horizontalmente, por exemplo:
		 1          2          3          4          5
		+-----+    +-----+    +-----+    +-----+    +-----+    
		|*   *|    |     |    |*    |    |*    |    |*   *|    
		|  *  |    |  *  |    |     |    |  *  |    |     |    
		|*   *|    |     |    |    *|    |    *|    |*   *|    
		+-----+    +-----+    +-----+    +-----+    +-----+    
	 */
	public java.lang.String toString(){
		
		String s = "";
		String[][] linhas = new String[5][5];
		
		for(int i = 0; i < dados.length; i++){
			s = dados[i].toString();
			linhas[i] = s.split("\n");
		}
		
		s =  "1          2          3          4          5\n";
		
		for(int i = 0; i < 5 ;i++) {
			for(int j = 0; j < 5 ;j++) {
				s += linhas[j][i];
			}
			s += '\n';
		}
		
		return s;
	}
}
