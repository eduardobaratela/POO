package Chain;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe que possui todas as funcoes de calculos de medida
 * @author eduardo alves baratela
 *
 */
public class calculos {
	
	private BufferedImage image;
	private int maxX, maxY;
	private int[] ptoMin = new int[2];
	private int[] ptoMax = new int[2];
	private int[][] visitado;
	private double perimetro;
	private int[] ultimo = new int[2];
	
	/**
	 * Funcao que inicializa o programa lendo o arquivo de imagem
	 * @param s eh a string que contem o nome do arquivo de imagem
	 * @throws IOException
	 */
	public void leImagem(String s) throws IOException {	
		File inFile = new File(s);
		image = ImageIO.read(inFile);
		this.perimetro = 0;
		
	}
	
	/**
	 * Funcao que zera o vetor auxiliar de pixels visitados
	 */
	public void zeraVisitado() {
		
		this.visitado = new int[this.maxY][this.maxX];
		
		for (int i = 0; i < this.maxY; i++) {
			for (int j = 0; j < this.maxX; j++) {
				this.visitado[i][j] = 0;
			}
		}
	}
	
	/*/**
	 * Funcao auxiliar que printa a imagem em RGB
	 */
	/*public void printa() {
		for (int i = 0;  i < getmaxY(); i++) {
			for (int j = 0; j < getmaxX(); j++) {
				System.out.print(image.getRGB(j, i));
			}
			System.out.println("\n");
		}
	}*/
	
	/**
	 * Funcao que da o tamanho da altura do aquivo de imagem
	 * @return retorna uma variavel que possui a altura do aquivo de imagem
	 */
	public int getmaxY() {
		
		maxY =  image.getHeight();
		
		return maxY;
	}
	
	/**
	 * Funcao que da o tamanho da largura do aquivo de imagem
	 * @return retorna uma variavel que possui a largura do arquivo de imagem
	 */
	public int getmaxX() {
		
		this.maxX = image.getWidth();
		
		return maxX;
		
	}
	
	/**
	 * Da o primeiro ponto da imagem
	 * @return um vetor com as cordenadas do ponto
	 */
	public int[] getPtoMin(){
		boolean flag = false;
		this.maxX = getmaxX();
		this.maxY = getmaxY();
		for (int i = 0;  i <this.maxY; i++) {
			for (int j = 0; j < this.maxX; j++) {
				if(image.getRGB(j, i) != -1 && !(flag)) {
					this.ptoMin[0] = i;
					this.ptoMin[1] = j;
					flag = true;
				}
			}
		}
		
		return ptoMin;
	}
	
	/**
	 * Da o ultimo ponto da imagem
	 * @return um vetor com as cordenadas do ponto
	 */
	public int[] getPtoMax(){
		boolean flag = false;
		this.maxX = getmaxX();
		this.maxY = getmaxY();
		for (int i = this.maxY-1;  i >= 0; i--) {
			for (int j = this.maxX-1;  j >= 0; j--) {
				if(image.getRGB(j, i) != -1 && !(flag)) {
					this.ptoMax[0] = i;
					this.ptoMax[1] = j;
					flag = true;
				}
			}
		}
		return ptoMax;
	}
	
	/**
	 * Funcao que da a altura da imagem, do ponto mais alto até o ponto mais baixo
	 * @return uma variavel com esse valor
	 */
	public int getAltura() {
		int height = this.ptoMax[0] - this.ptoMin[0] + 1;
		return height;
	}
	
	/**
	 * Funcao que da a largura da imagem, do ponto mais a esquerda até o ponto mais a direita
	 * @return uma variavel com esse valor
	 */
	public int getLargura() {
		int width = 0, cont = 0;
		
		for (int i = this.ptoMin[0]; i < this.ptoMax[0]; i++) {
			for (int j = 0; j < this.maxX; j++) {
				if(image.getRGB(j, i) != -1)
					cont++;
			}
			if(cont > width)
				width = cont;
			cont = 0;
		}
		return width;
	}
	
	/**
	 * Funcao que checa se o pixel eh preto e contem vizinhos brancos, ou seja, se ele pertence a borda
	 * @param i coordenada y
	 * @param j coordenada x
	 * @return se pertence ou nao a borda
	 */
	public boolean checaBorda(int i, int j) {
		
		if (image.getRGB(j, i) == -1) return false;
		
		if(image.getRGB(j-1, i) == -1)  //esquerda
			return true;
		if(image.getRGB(j+1, i) == -1)  //direita
			return true;
		if(image.getRGB(j, i-1) == -1)  //cima
			return true;
		if(image.getRGB(j, i+1) == -1)  //baixo
			return true;
		
		return false;
	}
	
	/**
	 * Funcao que retorna a quantidade de pixels que a borda da imagem possui
	 * @return a variavel com o valor de pixels na borda
	 */
	public int borda() {
		int edge = 0;
		
		for (int i = this.ptoMin[0]; i <= this.ptoMax[0]; i++) {
			for (int j = 0; j < this.maxX; j++) {
				if(image.getRGB(j, i) != -1)
					if(checaBorda(i, j)) edge++;
			}
		}
		
		return edge;
	}
	
	/**
	 * Acha, a partir de um pixel da borda, seu vizinho tambem pertencente a borda
	 * @param i coordenada do pixel em y
	 * @param j coordenada do pixel em x
	 * @return um vetor com as coordenadas do vizinho
	 */
	public int[] achaVizinho(int i, int j) {
		int aux[] = new int[2];	//aux[0] = i   / aux[1] = j
		
		//norte
		if(checaBorda(i-1, j) && visitado[i-1][j] == 0) {
			i--;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += 1;
    		return aux;
		}
		//nordeste
		if(checaBorda(i-1, j+1) && visitado[i-1][j+1] == 0) {
			i--;
			j++;
			aux[0] = i;
		    aux[1] = j;
		    this.perimetro += Math.sqrt(2);
		    return aux;
		}
		//leste
		if(checaBorda(i, j+1) && visitado[i][j+1] == 0) {
			j++;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += 1;
    		return aux;
		}
		//sudeste
		if(checaBorda(i+1, j+1) && visitado[i+1][j+1] == 0) {
			i++;
			j++;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += Math.sqrt(2);
    		return aux;
		}
		//sul
		if(checaBorda(i+1, j) && visitado[i+1][j] == 0) {
			i++;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += 1;
    		return aux;
		}
		//sudoeste
		if(checaBorda(i+1, j-1) && visitado[i+1][j-1] == 0) {
			i++;
			j--;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += Math.sqrt(2);
    		return aux;
		}
		//oeste
		if(checaBorda(i, j-1) && visitado[i][j-1] == 0) {
			j--;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += 1;
    		return aux;
		}
		//noroeste
		if(checaBorda(i-1, j-1) && visitado[i-1][j-1] == 0) {
			i--;
			j--;
			aux[0] = i;
    		aux[1] = j;
    		this.perimetro += Math.sqrt(2);
    		return aux;
		}
	
		this.ultimo [0] = i;
		this.ultimo[1] = j;
		aux[0] = i;
		aux[1] = j;
    	return aux;
	}
	
	/**
	 * Calcula recursivamente o perimetro da imagem através da distancia entre os pontos vizinhos da borda
	 * @param i coordenadas em y
	 * @param j coordenadas em x
	 * @return o valor do perimetro da imagem
	 */
	public double calculaPerimetro(int i, int j) {
		int[] vizinho = new int[2];
		
		vizinho = achaVizinho(i, j);
		this.visitado[i][j] = 1;
		
		if (this.visitado[vizinho[0]][vizinho[1]] == 0)
			calculaPerimetro(vizinho[0], vizinho[1]);		
		
		if(i == ptoMin[0] && j == ptoMin[1]) {		//soma a distancia do ultimo ponto com o primeiro ponto da borda
			if(i == this.ultimo[0] || j == this.ultimo[1])
				this.perimetro++;
			else this.perimetro += Math.sqrt(2);
		}
		
		return perimetro;
	}
	
	
}
