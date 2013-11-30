public class Fous extends Piece {
	
	public Fous(String couleur) {
		super("Fous", couleur);
		}

	public boolean estValide(Deplacement deplacement) {
		return (deplacement.getDeplacementX() == deplacement.getDeplacementY());
	}

}