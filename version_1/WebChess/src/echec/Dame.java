package echec;
public class Dame extends Piece {
	
	public Dame(String couleur) {
		super("Dame", couleur);
		}

	public boolean estValide(Deplacement deplacement) {
		return (deplacement.getDeplacementX() == 0 || deplacement.getDeplacementY() == 0 || deplacement.getDeplacementX() == deplacement.getDeplacementY());
	}

}