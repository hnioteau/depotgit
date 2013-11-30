public class Echequier{
	private Case[][] emplacement;


	public Echequier() {
		emplacement = new Case[8][8];
		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++)
				emplacement[i][j] = new Case();
	}
	
	public Case getCase(int colonne, int ligne) {
		return emplacement[colonne][ligne];
	}
	
	public void debuter() {
		int ligne = 7;
		for (String couleur = "noir" ; couleur != "blanc"; couleur = "blanc", ligne = 0){
			emplacement[0][ligne].setPiece(new Tour(couleur));
			emplacement[1][ligne].setPiece(new Cavalier(couleur));
			emplacement[2][ligne].setPiece(new Fous(couleur));
			emplacement[3][ligne].setPiece(new Dame(couleur));
			emplacement[4][ligne].setPiece(new Roi(couleur));
			emplacement[5][ligne].setPiece(new Fous(couleur));
			emplacement[6][ligne].setPiece(new Cavalier(couleur));
			emplacement[7][ligne].setPiece(new Tour(couleur));
			ligne += couleur.equals("noir") ? -1 : 1;
			for (int i = 0; i <= 7; i++)
				emplacement[i][ligne].setPiece(new Pion(couleur));
		}
	}
	
}