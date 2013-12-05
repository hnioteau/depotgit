package echec;
public class Cavalier extends Piece {
	
	public Cavalier(String couleur) {
		super("Cavalier", couleur);
		}

	public boolean estValide(Deplacement deplacement) {
		return ((deplacement.getDeplacementX() == 1 && deplacement.getDeplacementY() == 2)
		|| (deplacement.getDeplacementX() == -1 && deplacement.getDeplacementY() == 2)
		|| (deplacement.getDeplacementX() == 1 && deplacement.getDeplacementY() == -2)
		|| (deplacement.getDeplacementX() == -1 && deplacement.getDeplacementY() == -2)
		|| (deplacement.getDeplacementX() == 2 && deplacement.getDeplacementY() == 1)
		|| (deplacement.getDeplacementX() == 2 && deplacement.getDeplacementY() == -1)
		|| (deplacement.getDeplacementX() == -2 && deplacement.getDeplacementY() == 1)
		|| (deplacement.getDeplacementX() == -2 && deplacement.getDeplacementY() == -1));
	}

}