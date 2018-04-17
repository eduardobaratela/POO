package aula3;


import java.io.IOException;

public class ex2 {

	public static void main(String[] args) throws IOException {
		double a = 0, b = 0, c = 0, delta;
		int aux = 0;
		System.out.printf("Didgite o valor de a.\n");
		while(aux == 0){
			try {
				a = teste.leDouble();
				aux = 1;
			} catch(Exception e) {
				System.out.println("O valor que vc digitou em 'a' não é um número inteiro");
			}
			
		}
		if(a == 0){
			System.out.println("Não é do segundo grau.");
			return;
		}
		System.out.printf("Didgite o valor de b.\n");
		aux = 0;
		while(aux == 0) {
			try {
				b = teste.leDouble();
				aux = 1;
				} catch(Exception e) {
					System.out.println("O valor que vc digitou em 'b' não é um número inteiro");
			}
		}
		System.out.printf("Didgite o valor de c.\n");
		aux = 0;
		while(aux == 0) {
			try {
				c = teste.leDouble();
				aux = 1;
				} catch(Exception e) {
					System.out.println("O valor que vc digitou em 'c' não é um número inteiro");
			}
		}
		
		delta = (b * b) - 4*(a * c);
		if(delta >= 0){
			double x1, x2;
			x1 = (-b + Math.sqrt(delta))/(2*a);
			x2 = (-b - Math.sqrt(delta))/(2*a);
			System.out.println(x1 + " " + x2);
		}
		else{
			System.out.println("Não tem raiz.\n");
		}

	}

}
