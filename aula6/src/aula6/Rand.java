package aula6;

public class Rand {
	
	public int getIntRand(int max){
		
		int i = getRand() * max;
		return i;
	}

	public int getIntRand(int min, int max) {
		return min + getIntRand(max - min);
	}

	public int getIntRand(){
		return getIntRand(Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		int x = getRand();
	}

}
