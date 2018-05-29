import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
	
		int pos;
		Socket client = new Socket("127.0.0.1", 9669);
		PrintStream saida = new  PrintStream(client.getOutputStream());
		Scanner server = new  Scanner(client.getInputStream());
		String respServer;
		IA ia = new IA();
		boolean[] ocupado = new boolean[11];
		
		for (int i = 0; i < 11; i++)
			ocupado[i] = false;
		
		saida.println("I 10295270");
		System.out.println(server.nextLine());
		
		for (int i = 1; i <= 10; i++) {
			saida.println("R"+i);
			System.out.println("Rodada " + i);			
			respServer = server.nextLine();
			System.out.println(respServer);
			
			saida.println("T" + ia.trocaDados(respServer));
			respServer = server.nextLine();
			System.out.println(respServer);
			
			saida.println("T" + ia.trocaDados(respServer));
			respServer = server.nextLine();
			System.out.println(respServer);
			
			pos = ia.escolhePlacar(respServer, ocupado);
			ocupado[pos-1] = true;
			saida.println("P"+i+" "+ pos);
			System.out.println(server.nextLine());
		}
		
		saida.println("F");
		System.out.println(server.nextLine());
		saida.close();
		server.close();
		client.close();
	}
}
