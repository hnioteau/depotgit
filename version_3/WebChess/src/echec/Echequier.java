package echec;




public class Echequier extends ChessBoardToHtml implements EchequierInterface,Runnable{
	private Case[][] emplacement;
	final static int sizeBoard = 8;
	final static int sizBoardCell = 32;
	final static String typeOfPiece = "image";
	
	public Echequier() {
		super();
		emplacement = new Case[sizeBoard][sizeBoard]; //créé un tableau de 2 dimensions contenant des cases
		for (int i = 0; i < emplacement.length; i++)
			for (int j = 0; j < emplacement.length; j++)
				emplacement[i][j] = (new Case());
	}
	
	public void showWebchesssBoard(){
		for (int i = 0; i < emplacement.length; i++)
			for (int j = 0; j < emplacement.length; j++)
				System.out.println("i"+" j"+emplacement[i][j].estOccupe());	
	}
	
	public Case getCase(int colonne, int ligne) {
		return emplacement[colonne][ligne];
	}
	
	public Case[][] getEmplacement(){
		return emplacement;
	}
	private void instanciateAuxi(String c, int i,int j){ //place les pieces sur l'échequier pour débuter la partie
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
	
		if((i == sizeBoard - 1) || (i == sizeBoard - 2))
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
			//System.out.println(couleur);
		}
		
		if(i == sizeBoard-1){
			instanciateAuxi(couleur,i,j);
			//System.out.println(couleur);
		}
		
		if(i == sizeBoard-2){
			emplacement[i][j].setPiece(new Pion(couleur));
		}	
	}
	
	
	public void start() {
		for (int i = 0;  i < sizeBoard ; ++i){
			for(int j = 0; j < sizeBoard ; ++j){	
				instanciateCase(i,j);
				}
		}
		
		
	}
	
	public Object clone(){
		Echequier e = null;
		e = (Echequier) super.clone();
		for (int i = 0; i < emplacement.length; i++)
			for (int j = 0; j < emplacement.length; j++)
				e.emplacement[i][j] = (Case) emplacement[i][j].clone();
		return e;
	}
	
	private void drawFirstTableHtmlLine(){	
		this.drawEmptyCase();
		for (int i = 0; i < sizeBoard; ++i){
			this.drawBorderCase(new ConvertIndexToLetter(i).getLetterConverted()+"");
		}
		this.drawEmptyCase();
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear(); // Clear All
		this.encapsulateLine(this.getLine());		
	}
	
	private void drawtSecondToNinthTableHtmlLine(int ligne, int colonne){
		if(colonne == 0){
			this.drawBorderCase((ligne+1)+"");
		}
		this.getStreamHtml().add(HtmlPageGenerator.getCasesToModify()[ligne][colonne]+ContentManagement.NEW_LINE);
		if(colonne == (sizeBoard - 1)){
			System.out.println("ok");
			this.drawBorderCase((ligne + 1)+"");
			this.setLine(this.ArrayListToString(this.getStreamHtml()));
			this.getStreamHtml().clear(); // clear All
			this.encapsulateLine(this.getLine());
		}
	}
	private void drawtSecondToNinthTableHtmlLine(int ligne, int colonne, String classe){
		
		if(colonne == 0){
			this.drawBorderCase((ligne+1)+"");
		}
		
		if(!(this.getCase(ligne, colonne).estOccupe())){ // empty case	
				this.drawCaseWithoutPiece("\"pieces/blank.svg\"", " ",sizBoardCell, classe);
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
		
		if(colonne == (sizeBoard - 1)){
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
	
	private void drawBottomButtons(){
		this.drawBreakLine();
		this.drawButton("submit","New", "NewButton","button"); //créé une nouvelle partie
		this.drawButton("submit", "Undo","UndoButton","button"); //annule le coup
		this.drawButton("submit", "Redo","RedoButton","button"); //met le coup (ne fonctionne que si undo a déjà été utilisé)
		this.setLine(this.ArrayListToString(this.getStreamHtml()));
		this.getStreamHtml().clear(); // Clear
		
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
		this.drawLink("icon", "favicon.png", "image/png");
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
		new HtmlPageGenerator();
		String body = createBodyContent(false);
		String head = createHeadContent();
		PageHtml e = new PageHtml(head, body);
		System.out.println("show");
		return e.getPageHtml();
		
	}
	
	public String showWebchessBoardModifyInHtmlFormat(){
		String body = createBodyContent(true);
		String head = createHeadContent();
		PageHtml e = new PageHtml(head, body);
		System.out.println("show");
		return e.getPageHtml();
	}
	
	private String createBodyContent(boolean modify){
		String contentTable = "";
		drawFirstTableHtmlLine(); 
		contentTable += this.getLine();
		String classe = null;
		String value = null;
		
		for(int i = 0; i < sizeBoard; ++i){
			if( (i+1) % 2 == 0){
				classe = "even";
			}else{
				classe = "odd";
			}
			for(int j = 0; j < sizeBoard; ++j){
				if(modify)
					this.drawtSecondToNinthTableHtmlLine(i, j);
				if(!modify)
					this.drawtSecondToNinthTableHtmlLine(i, j,classe);
				if(classe == "even")
					value = "odd";
				if(classe == "odd")
					value = "even";
				classe = value;
			}
			contentTable += this.getLine();
			//System.out.println(this.getLine());
		}
		drawFirstTableHtmlLine(); // last and the first is the same
		contentTable += this.getLine();
		this.encapsulateTable(contentTable);
		contentTable = this.getLine();
		drawBottomButtons();
		contentTable += this.getLine();
		this.encapsulateForm(contentTable);
		// Content of Body 
		return this.getLine();
	}
	
	private String createHeadContent(){
		return this.addMetaDataContent();
	}
	

	private void caseWithWhiteBishopToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteBishop.svg\"", typeOfPiece,createName(ligne,colonne), "\"F\"",sizBoardCell, classe);
		}
	}
	private void caseWithBlackBishopToHtmlFormat(int ligne,int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackBishop.svg\"", typeOfPiece,createName(ligne,colonne), "\"f\"",sizBoardCell, classe);
		}
	}
	private void caseWithBlackRookToHtmlFormat(int ligne,int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackRook.svg\"", typeOfPiece,createName(ligne,colonne), "\"t\"",sizBoardCell, classe);
		}
	}
	private void caseWithWhiteRookToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteRook.svg\"", typeOfPiece,createName(ligne,colonne), "\"T\"",sizBoardCell, classe);
		}
	}
	private void caseWithWhiteKnightToHtmlFormat(int ligne, int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteKnight.svg\"", typeOfPiece,createName(ligne,colonne), "\"C\"",sizBoardCell, classe);
		}
	}
	
	private void caseWithBlackKnightToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackKnight.svg\"", typeOfPiece,createName(ligne,colonne), "\"c\"",sizBoardCell, classe);
		}
	}
	private void caseWithBlackKingToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackKing.svg\"", typeOfPiece,createName(ligne,colonne), "\"r\"",sizBoardCell, classe);
		}
	}
	private void caseWithWhiteKingToHtmlFormat(int ligne, int colonne,String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteKing.svg\"", typeOfPiece,createName(ligne,colonne), "\"R\"",sizBoardCell, classe);
		}
	}
	private void caseWithBlackQueenToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackQueen.svg\"", typeOfPiece,createName(ligne,colonne),"\"d\"",sizBoardCell, classe);
		}
	}
	private void caseWithWhiteQueenToHtmlFormat(int ligne,int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whiteQueen.svg\"", typeOfPiece,createName(ligne,colonne), "\"D\"",sizBoardCell, classe);
		}
	}
	
	private void caseWithWhitePawnToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("blanc")){
			this.drawCaseWithPiece("\"pieces/whitePawn.svg\"", typeOfPiece,createName(ligne,colonne), "\"P\"",sizBoardCell, classe);
		}
	}
	
	private void caseWithBlackPawnToHtmlFormat(int ligne, int colonne, String classe){
		if(this.getCase(ligne,colonne).getPiece().getCouleur().equals("noir")){
			this.drawCaseWithPiece("\"pieces/blackPawn.svg\"", typeOfPiece,createName(ligne,colonne), "\"p\"",sizBoardCell, classe);
		}
	}
	
	public static String createName(int ligne, int colonne){
		ConvertIndexToLetter c = new ConvertIndexToLetter(colonne);
		return ("\""+ c.getLetterConverted()+(ligne+1)+"\"");
	}
	
	public static int[] createIndices(char[] name){
		int[] tmp = new int[2];
		tmp[0] = (Integer.parseInt(name[1] + "") - 1); // Line
		tmp[1] = (new echec.ConvertLetterToIndex(name[0])).getIndiceConverted(); // Column
		return tmp;
	}


	public void run() {
		// Writing
		this.showWebchessBoardInHtmlFormat();
	}


	
	
}