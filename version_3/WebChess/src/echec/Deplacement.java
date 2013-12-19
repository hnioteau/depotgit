package echec;

public class Deplacement  {
	
	
	private int deplacementX;
	
	private int deplacementY;
	
	private Position arrivee;
	
	private Position depart;
	
	public Deplacement(Position depart, Position arrivee)
	{
		this.arrivee = arrivee;
		this.depart = depart;
		this.deplacementX = arrivee.getColonne() - depart.getColonne(); // le déplacement est noté de façon relative
		this.deplacementY = arrivee.getLigne() - depart.getLigne(); // De combien de case la piece s'est déplacé
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
	
	public void setDeplacement(Case[][] em, Piece p){
		System.out.println("LIIIII");
		System.out.println(Echequier.createName(depart.getLigne(), depart.getColonne()));
		em[depart.getLigne()][depart.getColonne()].setPiece(null);
		em[arrivee.getLigne()][arrivee.getColonne()].setPiece(p);
		
	}
	
	public void setDeplacementKiller(Case[][]em, Piece p){
		em[depart.getLigne()][depart.getColonne()].setPiece(null);
		em[arrivee.getLigne()][arrivee.getColonne()].setPiece(p);
		
	}
	public Position[] deplacementPossible(Piece piece, Position positiond){ 
		Position tab[] = new Position[64]; //creer un tableau qui contiendra l'ensemble des positions possible de la piece
		Deplacement dep = new Deplacement(positiond,positiond);
		dep.depart.setColonne(positiond.getColonne());
		dep.depart.setLigne(positiond.getLigne());
		int h = 0;
		for(int i=1; i <= 8; ++i){
			for(int j=1; i<=8; j++){
				dep.arrivee.setLigne(i);
				dep.arrivee.setColonne(j);
				if((dep.depart.getColonne() == dep.arrivee.getColonne()) && (dep.depart.getLigne() == dep.arrivee.getLigne()))
					break;
				if(piece.estValide(dep))
					tab[h] = dep.getArrivee();
			}
		}
		return tab;		
}
	
	/*public Boolean roiEnEchec(Piece piece, Position positiond){
		Position dp[] = deplacementPossible(piece, positiond);
		for(int i = 0; i < dp.length ; i++){
			if(emplacement[dp[i].getColonne()][dp[i].getLigne()].estOccupe()) //vérifie si la case est occupée
				if(piece.getCouleur() != emplacement[dp[i].getColonne()][dp[i].getLigne()].getPiece().getCouleur()) //vérifie si la case est occupé par une piece adverse
					if(emplacement[dp[i].getColonne()][dp[i].getLigne()].getPiece().getType().equals("Roi")) //vérifie si la piece adverse est le roi
						return true;
		}
		return false;
					
	}*/
	
	public Boolean Echec(Deplacement deplacement){
		return true;
	}
}
