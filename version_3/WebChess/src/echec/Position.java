package echec;

public class Position {

	private int ligne; 

	private int colonne; 

	public Position(int colonne, int ligne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public boolean equals(Position position) {
		return (position.getColonne() == this.getColonne()) && (position.ligne == this.ligne);
	}

}