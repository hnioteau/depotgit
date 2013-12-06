package echec;

public class Pion extends Piece {
	
	private int clicks;
	
	public Pion(String couleur) {
		super("Pion", couleur);
	}

	public boolean estValide(Deplacement deplacement) {
		if(this.getCouleur() == "blanc"){
			if(deplacement.getDepart().getLigne() == 2)
				return((deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == 1) || (deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == 2));
			return(deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == 1);
		}	
		
		else{
			if(deplacement.getDepart().getLigne() == 7)
				return((deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == -1) || (deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == -2));
			return(deplacement.getDeplacementX() == 0 && deplacement.getDeplacementY() == -1);
		}
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int c) {
		this.clicks = c;
	}
	
	
}