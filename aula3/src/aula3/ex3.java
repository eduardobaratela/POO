package aula3;

public class ex3 {

	public static void main(String[] args) {
		int a = 0, aux = 0;
		while(aux == 0) {
			try {
				a = teste.leInt();
				if(a >= 0) aux = 1;
			} catch(Exception e) {
				System.out.println("O valor que vc digitou em 'a' não é um número inteiro");
			}
		}
		
		int resp = 1;
		while(a > 0) {
			resp *= a;
			a--;
		}
		System.out.printf("%d", resp);

	}

}
