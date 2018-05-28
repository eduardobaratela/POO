import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	private RolaDados dados;
	private Placar placar;
	static ServerSocket sSocket;

	public Servidor() {
		this.dados = new RolaDados();
		this.placar = new Placar();
	}

    public String tratamento(String args) {
		String[] a = args.split(" ");
	
		if(a[0].equals("I")){
			return("Bem vindo usuario " + a[1]);
		}
		else if(a[0].equals("T")) {
			String trocas = "";
			for(int i = 0; i < 5; i ++)
				trocas += a[i+1];
			dados.rolar(trocas);
			System.out.print("T : ");
			return dados.toNumbers();	
		}
		else if(a[0].charAt(0) == 'P') {
            int posicao = Integer.parseInt(a[1]);
			placar.add(posicao-1, dados.getResult());
			System.out.print("P : ");
			return ""+placar.getScore();
		}
		else if(a[0].charAt(0) == 'R') {
			dados.rolar("11111");
			
			if(a[0].length() == 2) System.out.println("Rodada " + a[0].charAt(1));
			else System.out.println("Rodada " + a[0].charAt(1) + a[0].charAt(2));
			
			return dados.toNumbers();
		}
		else if(a[0].charAt(0) == 'F') {
			return "Pontuacao final : " + placar.getScore();
		}
		else {
			return "Comando invalido";
		}
    }
    
    private static void open(int porta) throws IOException {
    	sSocket = new ServerSocket(porta);
		System.out.println("Porta " + porta + " aberta");
    }
    
	public static void main(String[] args) throws Exception {
		open(9669);
		Socket cliente = sSocket.accept();
		Servidor server = new Servidor();
		
		String aux;
																	
		PrintStream out = new PrintStream(cliente.getOutputStream());
		Scanner s = new Scanner(cliente.getInputStream());
	
		while (s.hasNextLine()) {
			String r = s.nextLine();
			String temp[] = r.split(" ");
			
			aux = server.tratamento(r);
			if(!temp[0].equals("I"))System.out.println(aux);
			out.println(aux);
		}

		sSocket.close();
		out.close();
		cliente.close();
		s.close();
	}
}
