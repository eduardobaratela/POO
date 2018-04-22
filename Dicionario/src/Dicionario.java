
public class Dicionario <k,v>{

	k chave[];
	v valor[];
	int i;
	
	public Dicionario() {
		valor = (v[]) new Object[100];
		chave = (k[]) new Object[100];
		i = 0;
	}
	
	public void add(k key, v value) {
		chave[i] = key;
		valor[(int) key] = value;
		i++;
	}
	
	public v getValor(k key) {
		
		return valor[(int) key];
	}
	
	public boolean containsValue(v value) {
		for (int j = 0; j < i; j++) {
			if(valor[(int) value].equals(value))
				return true;
		}
		
		return false;
	}
	
	public boolean containsKey(k key) {
		
		if(valor[(int) key] != null) 
			return true;
		
		return false;
	}

}
