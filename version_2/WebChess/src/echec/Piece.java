package echec;

public abstract class Piece implements Cloneable{
	
	private String type;
	
	private String couleur;
	
	
	
	public Piece(String nom, String couleur) {
		setNom(nom);
		setCouleur(couleur);
	}
	
	public String getType() {
		return type;
	}
	
	public void setNom(String nom) {
		this.type = nom;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		if ((couleur == "noir") || (couleur == "blanc"))
			this.couleur = couleur;
	}
	
	public Object clone(){
		Piece p = null;
		try {
			p = (Piece) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return p;
		
	}
	public String toString(){
		StringBuilder s = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		s.append("[" + this.getClass().getName() + "]" + NEW_LINE);
		s.append("Type : " + this.getType() + NEW_LINE);
		s.append("Couleur : " + this.getCouleur() + NEW_LINE);
		
		return s.toString();
		
	}
	public abstract boolean estValide(Deplacement deplacement);  //Verifie si le mouvement de la piece est valide
	

	
}
