package echec;

public class Deplacement {
	
	private Case [][] emplacement;
	
	private int deplacementX;
	
	private int deplacementY;
	
	private Position arrivee;
	
	private Position depart;
	
	public Deplacement(Position depart, Position arrivee)
	{
		this.arrivee = arrivee;
		this.depart = depart;
		this.deplacementX = arrivee.getColonne() - depart.getColonne();
		this.deplacementY = arrivee.getLigne() - depart.getLigne();
	}


	public int getDeplacementX() {
		return deplacementX;
	}

	public int getDeplacementY() {
		return deplacementY;
	}
	
	public Position getArrivee() {
		return arrivee;
	}

	public Position getDepart() {
		return depart;
	}
	
	public void setDeplacement(Deplacement deplacement, Piece piece){
		emplacement[deplacement.depart.getColonne()][deplacement.depart.getLigne()].setPiece(null);
		emplacement[deplacement.arrivee.getColonne()][deplacement.arrivee.getLigne()].setPiece(piece);
	}
	
	
	
	public Boolean Echec(Deplacement deplacement){
		return true;
	}
}
