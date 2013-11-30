public abstract class Piece {
	
	private String nom;
	
	private static String couleur;
	
	public Piece(String nom, String couleur) {
		setNom(nom);
		setCouleur(couleur);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		if ((couleur == "noir") || (couleur == "blanc"))
			Piece.couleur = couleur;
	}
	
	public abstract boolean estValide(Deplacement deplacement);  //Verifie si le mouvement de la piece est valide
}
