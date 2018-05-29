
public class IA {
	
	private int[] dados;
	private int[] valores;
	private char[] escolha;

	public IA() {
		this.escolha = new char[5];
		this.dados = new int[5];
		this.valores = new int[6];
		
	}
	
	public void zeraTudo() {
		for (int i = 0; i < valores.length; i++) 
			this.valores[i] = 0;
		for (int i = 0; i < escolha.length; i++)
			this.escolha[i] = '0';
	}
	
	public void getDados(String s) {
		String[] aux = s.split(" ");
		
		for (int i = 0; i < aux.length; i++) {
			this.dados[i] = Integer.parseInt(aux[i]);
		}
		
	}
	
	public void getValores() {
		
		for (int i = 0; i < dados.length; i++) {
			valores[this.dados[i]-1]++;
		}
		
	}
	
	public String trocaDados(String s) {
		String troca = "";
		
		zeraTudo();	
		getDados(s);
		getValores();
		
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] == 1) {
				for (int j = 0; j < dados.length; j++) {
					if(dados[j] == i+1) {
						escolha[j] = '1';
					}
				}
			}
		}
		
		for (int i = 0; i < dados.length; i++) {
			troca += " " + escolha[i];
		}
		
		return troca;
	}
	
	public int escolhePlacar(String s, boolean[] ocupado) {
		int best = 8;
		int max = 0;
		
		zeraTudo();	
		getDados(s);
		getValores();
		
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] >= valores[max]) max = i;
		}
		
		if(valores[max] == 5 && ocupado[max] == false) best = 10;     //quina
		else if(valores[max] == 4 && ocupado[max] == false) best = 9; //quadra
		else if(valores[max] == 3) {	//full house
			boolean flag = false;
			if(max+1 == 6 && ocupado[max] == false) best = 6;
			else {			
				for (int i = valores.length-1; i >= 0; i--) {
					if(valores[i] == 2) {
						best = 7;
						flag = true;
						break;
					}
				}
			}
			if(ocupado[max] == false && flag == false) best = max+1;	//tripla
		}
		else if(valores[max] == 2 && ocupado[max] == false) best = max+1;	//dupla
				
		return best;
	}


}
