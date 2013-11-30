package echec;

public abstract class Convert {
	private int indice = 0;
	private char letter;
	
	public Convert(int i){
		this.setIndice(i);
	}
	public Convert(char c){
		this.setLetter(c);
	}
	public Convert(){
		
	}
	abstract void convert(Object o);
	abstract void setIntegerOrLetter(Object o);
	
	public char getLetterConverted() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
}
