package echec;
public class Roi extends Piece {
	
	public Roi(String couleur) {
		super("Roi", couleur);
		}

	public boolean estValide(Deplacement deplacement) {
		return ((deplacement.getDeplacementX() == 0 && (deplacement.getDeplacementY() == 1 || deplacement.getDeplacementY() == -1))  
				|| ((deplacement.getDeplacementX() == 1 || deplacement.getDeplacementX() == -1) && deplacement.getDeplacementY() == 0) 
				|| (deplacement.getDeplacementX() == 1 && deplacement.getDeplacementY() == 1)
				|| (deplacement.getDeplacementX() == -1 && deplacement.getDeplacementY() == -1) 
				|| (deplacement.getDeplacementX() == -1 && deplacement.getDeplacementY() == 1)
				|| (deplacement.getDeplacementX() == 1 && deplacement.getDeplacementY() == -1));
	}

}