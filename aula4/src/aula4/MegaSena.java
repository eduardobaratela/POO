package aula4;

import java.io.IOException;

public class MegaSena {
	public static void main(String[] args) throws IOException {
		
		System.out.printf("Digite 2 valores:");
		int seed1 = Entrada.leInt();
		int seed2 = Entrada.leInt();
		Random r = new Random(seed1);
		Random s = new Random(seed2);
		//r.setSemente(seed);
		int i = 1;
		while(true){
			int k = r.getIntRand(500)+1;
			int l = s.getIntRand(500)+1;
			if(k == l) {
				System.out.printf("Os ficaram estão iguais na %d iteracao", i);
				return;
			}
			i++;
		}
	}
}
