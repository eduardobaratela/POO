import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class calculos {
	
	private String s;
	private BufferedImage image;
	private int maxX, maxY;
	private int ptoMin[] = new int[2];
	
	public void leImagem() throws IOException {	
		s = "oval.png";
		File inFile = new File(s);
		image = ImageIO.read(inFile);
	}
	
	public void printa() {
		for (int i = this.maxX-1;  i >= 0; i--) {
			for (int j = 0; j < this.maxY; j++) {
				System.out.print(image.getRGB(i, j));
			}
			System.out.println("\n");
		}
	}
	
	public int getmaxY() {
		
		maxY =  image.getData().getHeight();
		System.out.println(maxY);
		return maxY;
	}
	
	public int getmaxX() {
		
		this.maxX = image.getData().getWidth();
		System.out.println(maxX);
		return maxX;
		
	}
	
	public int[] getPtoMin(){
		this.maxX = getmaxX();
		this.maxY = getmaxY();
		for (int i = this.maxX-1;  i >= 0; i--) {
			for (int j = 0; j < this.maxY; j++) {
				if(image.getRGB(i, j) != -1) {
					this.ptoMin[0] = i;
					this.ptoMin[1] = j;
					break;
				}
			}
		}
		
		return ptoMin;
	}
	
	public int getAltura() {
		int height = 0, cont = 0;
		this.maxX = getmaxX();
		this.maxY = getmaxY();
		for (int i = ptoMin[0]; i < this.maxX; i++) {
			for (int j = 0; j < this.maxY; j++) {
				if(image.getRGB(i, j) != -1)
					cont++;
			}
			if(cont > height)
				height = cont;
			cont = 0;
		}
		return height;
	}
	
	public int getLargura() {
		int width = 0, cont = 0;
		
		for (int i = 0; i < this.maxY; i++) {
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
	
	
}
