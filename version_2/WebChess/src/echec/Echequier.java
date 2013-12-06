package echec;


public class Echequier extends ChessBoardToHtml implements EchequierInterface,Runnable{
	private Case[][] emplacement;
	final int sizeBoard = 8;
	final int sizBoardCell = 32;
	final String typeOfPiece = "image";
	private String pageHtml = null;
	
	public Echequier() {
		super();
		emplacement = new Case[sizeBoard][sizeBoard];
		for (int i = 0; i < emplacement.length; i++)
			for (int j = 0; j < emplacement.length; j++)
				emplacement[i][j] = (new Case());
	}
	
	public Case getCase(int colonne, int ligne) {
		return emplacement[colonne][ligne];
	}
	
	private void instanciateAuxi(String c, int i,int j){
		switch(j){
			case 0:
				emplacement[i][j].setPiece(new Tour(c));
				break;
			case 1:
				emplacement[i][j].setPiece(new Cavalier(c));
				break;
			case 2:
				emplacement[i][j].setPiece(new Fous(c));
				break;
			case 3:
				emplacement[i][j].setPiece(new Dame(c));
				break;
			case 4:
				emplacement[i][j].setPiece(new Roi(c));
				break;
			case 5:
				emplacement[i][j].setPiece(new Fous(c));
				break;
			case 6:
				emplacement[i][j].setPiece(new Cavalier(c));
				break;
			case 7:
				emplacement[i][j].setPiece(new Tour(c));
				break;
		}
	}
	private void instanciateCase(int i , int j){
		String couleur = null;
	
		if((i == this.sizeBoard - 1) || (i == this.sizeBoard - 2))
			couleur ="noir";
		
		if(i == 0){
				couleur = "blanc";
					/* 	first line 
						color is white
						Instantiate first line in chessboard*/
				instanciateAuxi(couleur,i,j);
				
		}
		
		if(i == 1){	/* 	Second line 
						color is white
						Instantiate second line in chessboard*/
			couleur = "blanc";
			emplacement[i][j].setPiece(new Pion(couleur));
			System.out.println(couleur);
		}
		
		if(i == this.sizeBoard-1){
			instanciateAuxi(couleur,i,j);
			System.out.println(couleur);
		}
		
		if(i == this.sizeBoard-2){
			emplacement[i][j].setPiece(new Pion(couleur));
		}	
	}
	
	public void start() {
		for (int i = 0;  i < this.sizeBoard ; ++i){
			for(int j = 0; j < this.sizeBoard ; ++j){	
				instanciateCase(i,j);
				}
		}
		
		
	}
	
	public void showChequierBoard(){
		for (int i = 0;  i < this.sizeBoard ; ++i){
			for(int j = 0; j < this.sizeBoard ; ++j){
				if(this.getCase(i, j).estOccupe()){
					System.out.println(this.getCase(i, j).getPiece().getType());
					System.out.println(this.getCase(i, j).getPiece().getCouleur());
				}
			}
		}
	}
	
	private void drawFirstTableHtmlLine(){	
		this.drawEmptyCase();
		for (int i = 0; i < this.sizeBoard; ++i){
			this.drawBorderCase(new ConvertIndexToLetter(i).getLetterConverted()+"");
		}
		this.drawEmptyCase();
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear(); // Clear All
		this.encapsulateLine(this.getLine());		
	}
	
	private void drawtSecondToNinthTableHtmlLine(int ligne, int colonne, String classe){
		
		if(colonne == 0){
			this.drawBorderCase((ligne+1)+"");
		}
		
		if(!(this.getCase(ligne, colonne).estOccupe())){ // empty case	
				this.drawCaseWithoutPiece("\"pieces/blank.svg\"", " ",this.sizBoardCell, classe);
		}else{// Not empty case
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Pion")){
				this.caseWithWhitePawnToHtmlFormat(ligne, colonne,classe);
				this.caseWithBlackPawnToHtmlFormat(ligne, colonne,classe);
			}
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Roi")){
				this.caseWithWhiteKingToHtmlFormat(ligne, colonne,classe);
				this.caseWithBlackKingToHtmlFormat(ligne, colonne,classe);
			}
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Tour")){
				this.caseWithBlackRookToHtmlFormat(ligne, colonne,classe);
				this.caseWithWhiteRookToHtmlFormat(ligne, colonne,classe);
			}
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Dame") ){	
				this.caseWithWhiteQueenToHtmlFormat(ligne, colonne,classe);
				this.caseWithBlackQueenToHtmlFormat(ligne, colonne,classe);
			}
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Fous")){
				this.caseWithBlackBishopToHtmlFormat(ligne, colonne,classe);
				this.caseWithWhiteBishopToHtmlFormat(ligne, colonne,classe);
			}
			if(this.getCase(ligne, colonne).getPiece().getType().equals("Cavalier")){
				this.caseWithBlackKnightToHtmlFormat(ligne, colonne,classe);
				this.caseWithWhiteKnightToHtmlFormat(ligne, colonne,classe);
			}
		}
		
		if(colonne == (this.sizeBoard - 1)){
			this.drawBorderCase((ligne + 1)+"");
			this.setLine(this.ArrayListToString(this.getStreamHtml()));
			this.getStreamHtml().clear(); // clear All
			this.encapsulateLine(this.getLine());
		}
	}
	
	private void encapsulateTable(String c){
		this.drawTable(c);
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear();
	}
	
	private void encapsulateLine(String c){
		this.drawLine(c);
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear(); // clear All
	}
	
	private void encapsulateForm(String c){
		this.drawForm(c);
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear();
	}
	
	private String addMetaDataContent(){
		String contentHead = "";
		this.drawMeta("content-type", "text/html;charset=utf8");
		this.setLine(this.ArrayListToString(getStreamHtml()));
		contentHead += this.getLine();
		this.getStreamHtml().clear();
		this.drawLink("stylesheet", "stylesheet.css", "text/css");
		this.setLine(this.ArrayListToString(getStreamHtml()));
		contentHead += this.getLine();
		this.getStreamHtml().clear();
		this.drawTitle(PageHtml.getDocTitle());
		this.setLine(this.ArrayListToString(getStreamHtml()));
		contentHead += this.getLine();
		this.getStreamHtml().clear();
		return contentHead;
	}
	
	
	public String showWebchessBoardInHtmlFormat() { // Add necessary Attributes
		String body = createBodyContent();
		String head = createHeadContent();
		PageHtml e = new PageHtml(head, body);
		return e.getPageHtml();
		
	}
	
	private String createBodyContent(){
		String contentTable = "";
		drawFirstTableHtmlLine(); 
		contentTable += this.getLine();
		String classe = null;
		String value = null;
		for(int i = 0; i < this.sizeBoard; ++i){
			if( (i+1) % 2 == 0){
				classe = "even";
			}else{
				classe = "odd";
			}
			for(int j = 0; j < this.sizeBoard; ++j){
				this.drawtSecondToNinthTableHtmlLine(i, j,classe);
				if(classe == "even")
					value = "odd";
				if(classe == "odd")
					value = "even";
				classe = value;
			}
			contentTable += this.getLine();
		}
		drawFirstTableHtmlLine(); // last and the first is the same
		contentTable += this.getLine();
		this.encapsulateTable(contentTable);
		this.encapsulateForm(this.getLine());
		// Content of Body 
		return this.getLine();
	}
	
	private String createHeadContent(){
		return this.addMetaDataContent();
	}
	

	private void caseWithWhiteBishopToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteBishop.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"F\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithBlackBishopToHtmlFormat(int ligne,int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackBishop.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"f\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithBlackRookToHtmlFormat(int ligne,int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackRook.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"t\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithWhiteRookToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteRook.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"T\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithWhiteKnightToHtmlFormat(int ligne, int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteKnight.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"C\"",this.sizBoardCell, classe);
		}
	}
	
	private void caseWithBlackKnightToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackKnight.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"c\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithBlackKingToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/whiteKing.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"r\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithWhiteKingToHtmlFormat(int ligne, int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteKing.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"R\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithBlackQueenToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackQueen.svg\"", this.typeOfPiece,createName(ligne,colonne),"\"d\"",this.sizBoardCell, classe);
		}
	}
	private void caseWithWhiteQueenToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteQueen.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"D\"",this.sizBoardCell, classe);
		}
	}
	
	private void caseWithWhitePawnToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whitePawn.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"P\"",this.sizBoardCell, classe);
		}
	}
	
	private void caseWithBlackPawnToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackPawn.svg\"", this.typeOfPiece,createName(ligne,colonne), "\"p\"",this.sizBoardCell, classe);
		}
	}
	
	private String createName(int ligne, int colonne){
		ConvertIndexToLetter c = new ConvertIndexToLetter(colonne);
		return ("\""+ c.getLetterConverted()+(ligne+1)+"\"");
	}
	

	public String getElement() {
		return null;
	}

	public void run() {
		// Writing
		this.setPageHtml(this.showWebchessBoardInHtmlFormat());
	}

	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public boolean deplacementPossible(Deplacement deplacement) {
		Piece pieceDepart = emplacement[(int)deplacement.getDepart().getColonne()][(int)deplacement.getDepart().getLigne()].getPiece();
		
		//on vérifie si la case d'arrivée est libre ou si elle est occupé par une piece de l'adversaire
		if (!emplacement[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()].estOccupe(pieceDepart.getCouleur().equals("blanc") ? "blanc" : "noir")
				| deplacement.isNul()){
			if (!(pieceDepart.getType() == "Cavalier")){
				if(!(pieceDepart.getType() == "Pion")){
					if(!(Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) <= 1
							&& Math.abs(deplacement.getDeplacementX()) + Math.abs(deplacement.getDeplacementY()) <= 1)){

						//depColonne et depLigne vont servir pour vérifier chaque case lors du déplacement
						int depColonne = deplacement.getDeplacementX() == 0 ? 0 : (int)(deplacement.getArrivee().getColonne() - deplacement.getDepart().getColonne())
								/Math.abs((int)(deplacement.getArrivee().getColonne() - deplacement.getDepart().getColonne()));
				
						int depLigne = deplacement.getDeplacementY() == 0 ? 0 : (int)(deplacement.getArrivee().getLigne() - deplacement.getDepart().getLigne())
								/Math.abs((int)(deplacement.getArrivee().getLigne() - deplacement.getDepart().getLigne()));

						//On vérifie chaque case lors du déplacement
						for (int i = (int)deplacement.getDepart().getColonne() + depColonne, j = (int)deplacement.getDepart().getLigne() + depLigne;
							i != (int)deplacement.getArrivee().getColonne() | j != (int)deplacement.getArrivee().getLigne();
							i += depColonne, j += depLigne){
							if (emplacement[i][j].estOccupe()){
								return false;
							}
						}
						return true;
					}
					else
						return true;
				}
				else
					//Si c'est un pion, je vérifie si la case est libre
					return !emplacement[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()].estOccupe();
					
			}
			else
				//je renvoie true car un cavalier peut sauter par dessus les autres pièces.
				return true;
		}
		else
			//Le mouvement n'est pas possible si la case d'arrivé contient une pièce de meme couleur
			return false;

		
	}

	
	public boolean captureParUnPionPossible(Deplacement deplacement) {
		if(emplacement[deplacement.getDepart().getColonne()][deplacement.getDepart().getLigne()].getPiece().getType() == "Pion")
		{
			Case Arrive = emplacement[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()];
			String couleurDepart = emplacement[(int)deplacement.getDepart().getColonne()][(int)deplacement.getDepart().getLigne()].getPiece().getCouleur();
			
			if(Arrive.estOccupe(couleurDepart.equals("blanc") ? "noir" : "blanc"))
				return (deplacement.getDeplacementY() * Math.abs(deplacement.getDeplacementX()) == (couleurDepart.equals("noir") ? 1 : -1));
		}
		return false;
	}
}