public class Case {
	
	private Piece piece;
	
	public Case(){
		
	}
	
	public Case(Piece piece){
		this.piece = piece;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	
	public boolean estOccupe(){
		return (piece != null);	
	}
	
	
	public boolean estOccupe(String couleur)
	{
		if (piece == null)
			return false;
		else
			return (piece.getCouleur() == couleur);
	}
	
}
