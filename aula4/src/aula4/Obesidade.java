package aula4;

public class Obesidade {
	
	private double Peso = 0;
	private double Altura = 0;
	
	public void setPeso(double k){
		k = Peso;
	}
	
	public void setAltura(double x){
		x = Altura;
	}
	
	public double getPeso(){
		return Peso;
	}
	
	public double getAltura(){
		return Altura;
	}
	
	public double calculaIMC() {
		double IMC = Peso / (Altura * Altura);
		return IMC;
	}
}
