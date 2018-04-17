package aula3;


import java.io.IOException;

public class ex1 {

	public static void main(String[] args) throws IOException {
		double a, b, c, delta;
		System.out.printf("Didgite o valor de a.\n");
		try {
		a = teste.leDouble();
		} catch(Exception e) {
			System.out.println("O valor que vc digitou em 'a' não é um número inteiro");
				return;
		}
		if(a == 0){
			System.out.println("Não é do segundo grau.");
			return;
		}
		System.out.printf("Didgite o valor de b.\n");
		try {
			b = teste.leDouble();
			} catch(Exception e) {
				System.out.println("O valor que vc digitou em 'b' não é um número inteiro");
					return;
		}
		System.out.printf("Didgite o valor de c.\n");
		try {
			c = teste.leDouble();
			} catch(Exception e) {
				System.out.println("O valor que vc digitou em 'c' não é um número inteiro");
					return;
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
