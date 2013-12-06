package echec;
public class Case implements Cloneable{
	
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
	
	public Object clone(){
		Case c = null;
		try {
			c = (Case) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean estOccupe(String couleur)
	{
		if (piece == null)
			return false;
		else
			return (piece.getCouleur() == couleur);
	}


}
