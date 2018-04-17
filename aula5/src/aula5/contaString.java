package aula5;

import java.io.IOException;

public class contaString {
	
	public static void main(String[] args) throws IOException {
	
		System.out.println("Digite uma palavra:");
		String word1 = Entrada.leString();
		
		int countA = 0;
		int countE = 0;
		int countI = 0;
		int countO = 0;
		int countU = 0;
		
		int size = word1.length();
		
		for(int i=0; i<size; i++) {
			if(word1.charAt(i) == 'a' || word1.charAt(i) == 'A') countA++;
			else if(word1.charAt(i) == 'e' || word1.charAt(i) == 'E') countE++;
			else if(word1.charAt(i) == 'i' || word1.charAt(i) == 'I') countI++;
			else if(word1.charAt(i) == 'o' || word1.charAt(i) == 'O') countO++;
			else if(word1.charAt(i) == 'u' || word1.charAt(i) == 'U') countU++;
		}
		
		System.out.printf("A : %d\nE : %d\nI : %d\nO : %d\nU : %d\n ", countA, countE, countI, countO, countU);
		
		//----------------------------------------------------------------------------------------------------------
		
		String word2 = word1.toUpperCase();
		System.out.printf("Palavra em maiuscula : %s\n", word2);
		
		//-----------------------------------------------------------------------------------------------------------
		
	}
	
}
