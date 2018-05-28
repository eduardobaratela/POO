import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
	
		Socket client = new Socket("127.0.0.1",9669);
		PrintStream saida = new  PrintStream(client.getOutputStream());
		Scanner server = new  Scanner(client.getInputStream());
		
		saida.println("I 10295270");
		System.out.println(server.nextLine());
		
		for (int i = 1; i <= 10; i++) {
			saida.println("R"+i);
			System.out.println("Rodada " + i);
			System.out.println(server.nextLine());
			
			saida.println("T 1 0 1 0 0");
			System.out.println(server.nextLine());
			
			saida.println("T 1 0 1 0 0");
			System.out.println(server.nextLine());
			
			saida.println("P"+i+" "+i);
			System.out.println(server.nextLine());
		}
		
		saida.println("F");
		System.out.println(server.nextLine());
		saida.close();
		server.close();
		client.close();
	}
}
