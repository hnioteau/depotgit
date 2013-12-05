package echec;

public class ConvertLetterToIndex extends Convert{
	
	
	public ConvertLetterToIndex(char letter){
		super(letter);
		this.convertToIndex(letter);;
	}
	public ConvertLetterToIndex(){
		super();
	}
	private void convertToIndex(char c){
		switch(c){
		case 'A':
			setIntegerOrLetter(0);
			break;
		case 'B':
			setIntegerOrLetter(1);	
			break;
		case 'C':
			setIntegerOrLetter(2);
			break;
		case 'D':
			setIntegerOrLetter(3);
			break;
		case 'E': 
			setIntegerOrLetter(4);
			break;
		case 'F':
			setIntegerOrLetter(5);
			break;
		case 'G':
			setIntegerOrLetter(6);
			break;
		case 'H':
			setIntegerOrLetter(7);
			break;
		}
		
	}
	
	void convert(Object o) {
		convertToIndex((Character)o);	
	}

	
	void setIntegerOrLetter(Object o) {
		this.setIndice(((Integer)o));
		
	}
	
}
