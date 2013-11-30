package echec;

public class ConvertIndexToLetter extends Convert {
	
	public ConvertIndexToLetter(int i){
		super(i);
		this.convertToLetter(i);;
	}
	public ConvertIndexToLetter(){
		super();
	}
	void convert(Object o) {
		convertToLetter((Integer)o);
	}
	
	private void convertToLetter(int c){
		switch(c){
		case 0:
			setIntegerOrLetter('A');
			break;
		case 1:
			setIntegerOrLetter('B');	
			break;
		case 2:
			setIntegerOrLetter('C');
			break;
		case 3:
			setIntegerOrLetter('D');
			break;
		case 4: 
			setIntegerOrLetter('E');
			break;
		case 5:
			setIntegerOrLetter('F');
			break;
		case 6:
			setIntegerOrLetter('G');
			break;
		case 7:
			setIntegerOrLetter('H');
			break;
		}
		
	}


	void setIntegerOrLetter(Object o) {
		this.setLetter((Character) o);
	}
	
	

}
