public class Tour extends Piece {
	
	public Tour(String couleur) {
		super("Tour", couleur);
		}

	public boolean estValide(Deplacement deplacement) {
		return (deplacement.getDeplacementX() == 0 || deplacement.getDeplacementY() == 0);
	}

}