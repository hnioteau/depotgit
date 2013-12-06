package echec;

public class HtmlPageGenerator extends ChessBoardToHtml{
	
	private static String[][] casesToModify = null;
	private static int ligne = 0;
	private static int colonne = 0;
	private static String[][] cloneCasesToModify = null;
	
	public HtmlPageGenerator(){
		super();
		setCasesToModify(new String[Echequier.sizeBoard][Echequier.sizeBoard]);
		setCloneCasesToModify(new String[Echequier.sizeBoard][Echequier.sizeBoard]);
	}
	
	public static void initialiseArray(int ligne, int colonne, String content){
		getCasesToModify()[ligne][colonne] = content;
		getCloneCasesToModify()[ligne][colonne] = content;
		setColonne(1);
		if(colonne == Echequier.sizeBoard - 1){
			setLigne(1);
			setColonneTo(0);
			
		}
		if(ligne == Echequier.sizeBoard - 1 && colonne == Echequier.sizeBoard - 1){
			setLineTo(0);
		}
	}
	
	public static void refreshCasesToModify(){
		for(int i = 0; i < Echequier.sizeBoard; ++i){
			for(int j = 0; j < Echequier.sizeBoard; j++ ){
				getCasesToModify()[i][j] = getCloneCasesToModify()[i][j];
			}
		}
	}
	public static void showElements(){
		for(int i = 0; i < Echequier.sizeBoard; ++i){
			for(int j = 0; j < Echequier.sizeBoard; j++ ){
				System.out.println(getCasesToModify()[i][j]);
			}
		}
	}
	
	public static void showTheCases(Position current, Piece p){
		if(p.getType().equals("Pion") && p.getCouleur().equals("noir")){
			System.out.println(current.getColonne());
			System.out.println(current.getLigne());
			Position a1 = createFinishPosition(current.getColonne(),current.getLigne() - 1);
			
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a1);
			}
			priseEnDiagonale(current,p,-1,1);
			priseEnDiagonale(current,p,-1,-1);
			
		}if(p.getType().equals("Pion") && p.getCouleur().equals("blanc")){
			Position a1 = createFinishPosition(current.getColonne(),current.getLigne() + 1);
			
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a1);
			}
			// Busy Case
			System.out.println("Busy Case");
			priseEnDiagonale(current,p,1,-1);
			priseEnDiagonale(current,p,1,1);
			
		}if((p.getType().equals("Roi") && p.getCouleur().equals("noir")) || (p.getType().equals("Roi") && p.getCouleur().equals("blanc")) ){
			Position a1 = createFinishPosition(current.getColonne(), current.getLigne() - 1); // avancer
			Position a2 = createFinishPosition(current.getColonne() - 1, current.getLigne());
			Position a3 = createFinishPosition(current.getColonne(), current.getLigne() + 1); // reculer
			Position a4 = createFinishPosition(current.getColonne() + 1, current.getLigne());
			Position a5 = createFinishPosition(current.getColonne() + 1, current.getLigne() - 1);
			Position a6 = createFinishPosition(current.getColonne() - 1, current.getLigne() - 1);
			Position a7 = createFinishPosition(current.getColonne() + 1, current.getLigne() + 1);
			Position a8 = createFinishPosition(current.getColonne() - 1, current.getLigne() + 1);
		
			if(((a1.getLigne() < Echequier.sizeBoard) && (a1.getLigne() > -1))  && ((a1.getColonne() < Echequier.sizeBoard) && (a1.getColonne() > -1))){
				if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a1);
				}
			}
			if(((a2.getLigne() < Echequier.sizeBoard) && (a2.getLigne() > -1))  && ((a2.getColonne() < Echequier.sizeBoard) && (a2.getColonne() > -1))){
				if(getCasesToModify()[a2.getLigne()][a2.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a2);
				}
			}
			if(((a3.getLigne() < Echequier.sizeBoard) && (a3.getLigne() > -1))  && ((a3.getColonne() < Echequier.sizeBoard) && (a3.getColonne() > -1))){
				if(getCasesToModify()[a3.getLigne()][a3.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a3);
				}
			}
			if(((a4.getLigne() < Echequier.sizeBoard) && (a4.getLigne() > -1))  && ((a4.getColonne() < Echequier.sizeBoard) && (a4.getColonne() > -1))){
				if(getCasesToModify()[a4.getLigne()][a4.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a4);
				}
			}
			if(((a5.getLigne() < Echequier.sizeBoard) && (a5.getLigne() > -1))  && ((a5.getColonne() < Echequier.sizeBoard) && (a5.getColonne() > -1))){
				if(getCasesToModify()[a5.getLigne()][a5.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a5);
				}
			}
			if(((a6.getLigne() < Echequier.sizeBoard) && (a6.getLigne() > -1))  && ((a6.getColonne() < Echequier.sizeBoard) && (a6.getColonne() > -1))){
				if(getCasesToModify()[a6.getLigne()][a6.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a6);
				}
			}if(((a7.getLigne() < Echequier.sizeBoard) && (a7.getLigne() > -1))  && ((a7.getColonne() < Echequier.sizeBoard) && (a7.getColonne() > -1))){
				if(getCasesToModify()[a7.getLigne()][a7.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a7);
				}
			}
			if(((a8.getLigne() < Echequier.sizeBoard) && (a8.getLigne() > -1))  && ((a1.getColonne() < Echequier.sizeBoard) && (a8.getColonne() > -1))){
				if(getCasesToModify()[a8.getLigne()][a8.getColonne()].contains("img")){
					System.out.println("Case Inocuuppe");
					modifyContent(current,a8);
				}
			}
		}if((p.getType().equals("Tour") && p.getCouleur().equals("noir")) || (p.getType().equals("Tour") && p.getCouleur().equals("blanc"))){
			moveTourHorizontally(p,current,+1);
			moveTourVertically(p,current,+1);
			moveTourHorizontally(p,current,-1);
			moveTourVertically(p,current,-1);
			
		}if((p.getType().equals("Dame") && p.getCouleur().equals("noir")) || (p.getType().equals("Dame") && p.getCouleur().equals("blanc"))){
			moveTourHorizontally(p,current,+1);
			moveTourVertically(p,current,+1);
			moveTourHorizontally(p,current,-1);
			moveTourVertically(p,current,-1);
			moveFouDiagonally(p,current,1,1);
			moveFouDiagonally(p,current,-1,-1);
			moveFouDiagonally(p,current,1,-1);
			moveFouDiagonally(p,current,-1,1);
		}if((p.getType().equals("Fous") && p.getCouleur().equals("noir")) || (p.getType().equals("Fous") && p.getCouleur().equals("blanc"))){
			moveFouDiagonally(p,current,1,1);
			moveFouDiagonally(p,current,-1,-1);
			moveFouDiagonally(p,current,1,-1);
			moveFouDiagonally(p,current,-1,1);
		}if((p.getType().equals("Cavalier") && p.getCouleur().equals("noir")) || (p.getType().equals("Cavalier") && p.getCouleur().equals("blanc"))){
			moveCavalierHorizontally(p,current,2);
			moveCavalierHorizontally(p,current,-2);
			moveCavalierVertically(p,current,2);
			moveCavalierVertically(p,current,-2);
		}
	}
	
	private static void moveCavalierVertically(Piece p, Position current, int inc){
		Position a = createFinishPosition(current.getColonne(), current.getLigne() + inc);
		Position a1 = createFinishPosition(current.getColonne(), current.getLigne() + inc);
		a.setColonne(a.getColonne() - 1);
		a1.setColonne(a1.getColonne() + 1);
		if((-1 < a.getColonne() && a.getColonne() < Echequier.sizeBoard) && ((a.getLigne() < Echequier.sizeBoard) && (a.getLigne() > -1))){
			if(getCasesToModify()[a.getLigne()][a.getColonne()].contains("img"))
				modifyContent(current,a);
			else{
				priseEnDeplacement(getCasesToModify()[a.getLigne()][a.getColonne()],current,new Position(a.getColonne(),a.getLigne()),p);
			}
			
		}if((-1 < a1.getColonne() && a1.getColonne() < Echequier.sizeBoard) && ((a1.getLigne() < Echequier.sizeBoard) && (a1.getLigne() > -1))){
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img"))
				modifyContent(current,a1);
			else{
				priseEnDeplacement(getCasesToModify()[a1.getLigne()][a1.getColonne()],current,new Position(a1.getColonne(),a1.getLigne()),p);
			}
		}
	}
	private static void moveCavalierHorizontally(Piece p, Position current, int inc){
		Position a = createFinishPosition(current.getColonne() + inc, current.getLigne());
		Position a1 = createFinishPosition(current.getColonne() + inc, current.getLigne());
		a.setLigne(a.getLigne() - 1);
		a1.setLigne(a1.getLigne() + 1);
		if((-1 < a.getColonne() && a.getColonne() < Echequier.sizeBoard) && ((a.getLigne() < Echequier.sizeBoard) && (a.getLigne() > -1))){
			if(getCasesToModify()[a.getLigne()][a.getColonne()].contains("img"))
				modifyContent(current,a);
			else{
				priseEnDeplacement(getCasesToModify()[a.getLigne()][a.getColonne()],current,new Position(a.getColonne(),a.getLigne()),p);
			}
		}if((-1 < a1.getColonne() && a1.getColonne() < Echequier.sizeBoard) && ((a1.getLigne() < Echequier.sizeBoard) && (a1.getLigne() > -1))){
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img"))
				modifyContent(current,a1);
			else{
				priseEnDeplacement(getCasesToModify()[a1.getLigne()][a1.getColonne()],current,new Position(a1.getColonne(),a1.getLigne()),p);
			}
		}
	}
	private static void moveTourVertically(Piece p,Position current, int inc){
		int result = 0;
		for(int i = current.getLigne() + inc; (-1 < i && i < Echequier.sizeBoard) ; i+=inc ){
			if(!getCasesToModify()[i][current.getColonne()].contains("img")){
				System.out.println("Occupe");
				priseEnDeplacement(getCasesToModify()[i][current.getColonne()],current,new Position(current.getColonne(),i),p);
				break;
			}
			if(getCasesToModify()[i][current.getColonne()].contains("img")){
				System.out.println("Pas");
				result++;
			}
		}
		if(inc == -1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() ,current.getLigne() - i);
				modifyContent(current,a);
			}
		}else{
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() ,current.getLigne() + i);
				modifyContent(current,a);
			}
		}
	}
	
	private static void moveFouDiagonally(Piece p,Position current, int incLigne, int incColonne){
		int result = 0;
		for(int i = current.getColonne() + incColonne, j = current.getLigne() + incLigne; (-1 < i && i < Echequier.sizeBoard) && (-1 < j && j < Echequier.sizeBoard); i+=incColonne , j+=incLigne){
			if(!getCasesToModify()[j][i].contains("img")){
				System.out.println("Occupe");
				priseEnDeplacement(getCasesToModify()[j][i],current,new Position(i,j),p);
				break;
			}
			if(getCasesToModify()[j][i].contains("img")){
				System.out.println("Pas");
				result++;
			}
		}if(incLigne == -1 && incColonne == -1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() - i,current.getLigne() - i);
				modifyContent(current,a);
			}
		}if(incLigne == -1 && incColonne == 1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() + i,current.getLigne() - i);
				modifyContent(current,a);
			}
		}if(incLigne == 1 && incColonne == 1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() + i,current.getLigne() + i);
				modifyContent(current,a);
			}
		}if(incLigne == 1 && incColonne == -1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() - i,current.getLigne() + i);
				modifyContent(current,a);
			}
		}
	}
	
	private static void priseEnDeplacement(String whatPiece,Position current, Position arrivee, Piece p){
		// Other case
		if(p.getCouleur().equals("blanc")){
			if(whatPiece.contains("black")){
				System.out.println("Miam Miam");
				modifyContentAuxi(current,arrivee);
			}
		}else{
			if(whatPiece.contains("white")){
				System.out.println("Miam Miam");
				modifyContentAuxi(current,arrivee);
			}
		}
		
	}
	private static void moveTourHorizontally(Piece p,Position current, int inc){
		int result = 0;
		for(int i = current.getColonne() + inc; (-1 < i && i < Echequier.sizeBoard) ; i+=inc ){
			if(!getCasesToModify()[current.getLigne()][i].contains("img")){
				System.out.println("Occupe");
				priseEnDeplacement(getCasesToModify()[current.getLigne()][i],current,new Position(i,current.getLigne()),p);
				break;
			}
			if(getCasesToModify()[current.getLigne()][i].contains("img")){
				System.out.println("Pas");
				result++;
			}
		}
		if(inc == -1){
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() - i,current.getLigne());
				modifyContent(current,a);
			}
		}else{
			for(int i = 1; i <= result; ++i){
				Position a = createFinishPosition(current.getColonne() + i,current.getLigne());
				modifyContent(current,a);
			}
		}
	}
	
	private static void priseEnDiagonale(Position current, Piece p, int incLine, int incColumn){
		Position a = createFinishPosition(current.getColonne()+incColumn,current.getLigne()+incLine);
		System.out.println("Pion ="+Echequier.createName(a.getLigne(), a.getColonne()));
		if((-1 < a.getColonne() && a.getColonne() < Echequier.sizeBoard)){
			if(p.getCouleur().equals("blanc")){
				if(!getCasesToModify()[a.getLigne()][a.getColonne()].contains("img")){
					System.out.println("Es ce un pion adverse ou pas");
					if(getCasesToModify()[a.getLigne()][a.getColonne()].contains("black")){
						System.out.println("Miam Miam");
						modifyContentAuxi(current,a);
					}
				}
			}else{
				if(!getCasesToModify()[a.getLigne()][a.getColonne()].contains("img")){
					System.out.println("Es ce un pion adverse ou pas");
					if(getCasesToModify()[a.getLigne()][a.getColonne()].contains("white")){
						System.out.println("Miam Miam");
						modifyContentAuxi(current,a);
					}
				}
			}
		}
		
	}
	
	
	
	private static void showTheCasesForTheFirstTimeAuxi(Position current,Piece p){ // les cases où la piece a le droit de se deplacer
		
		if(p.getType().equals("Pion") && p.getCouleur().equals("noir")){
			System.out.println(current.getColonne());
			System.out.println(current.getLigne());
			Position a1 = createFinishPosition(current.getColonne(),current.getLigne() - 1);
			Position a2 =  createFinishPosition(current.getColonne(),current.getLigne() - 2);
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a1);
			}
			if(getCasesToModify()[a2.getLigne()][a2.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a2);
			}
			
		}if(p.getType().equals("Pion") && p.getCouleur().equals("blanc")){
			Position a1 = createFinishPosition(current.getColonne(),current.getLigne() + 1);
			Position a2 =  createFinishPosition(current.getColonne(),current.getLigne() + 2);
			if(getCasesToModify()[a1.getLigne()][a1.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a1);
			}
			if(getCasesToModify()[a2.getLigne()][a2.getColonne()].contains("img")){
				System.out.println("Case Inocuuppe");
				modifyContent(current,a2);
			}
		}
	
	}
	private static Position createFinishPosition(int colonne, int ligne){	
		echec.Position a = (new echec.Position(colonne, ligne)); 
		return a;
	}
	
	private static void modifyContent(Position current, Position arrivee){
		String htmlCase = getCasesToModify()[arrivee.getLigne()][arrivee.getColonne()];
		int depart = htmlCase.indexOf("<img");
		int fin = htmlCase.indexOf("</td>");
		String contentToChange = htmlCase.substring(depart, fin);
		ChessBoardToHtml ch = new ChessBoardToHtml();
		ch.drawHtmlInput("\"pieces/blank.svg\"", Echequier.typeOfPiece, Echequier.createName(current.getLigne(), current.getColonne())+"TO"+Echequier.createName(arrivee.getLigne(), arrivee.getColonne()), " ", Echequier.sizBoardCell);
		String contentModify = htmlCase.replaceFirst(contentToChange, ch.getCm().getContent());
		getCasesToModify()[arrivee.getLigne()][arrivee.getColonne()] =  contentModify.replaceFirst("\">", "Select\">");	
	}
	
	private static void modifyContentAuxi(Position current, Position arrivee){
		String eating =  Echequier.createName(arrivee.getLigne(), arrivee.getColonne()).replaceAll("\"","");
		String eater = Echequier.createName(current.getLigne(), current.getColonne()).replaceAll("\"", "");
		String nameValue = "name=" + eater + "KILL" + eating;
		String htmlCaseVictim = getCasesToModify()[arrivee.getLigne()][arrivee.getColonne()].replaceFirst(getNameAttribute(arrivee), nameValue);
		System.out.println(htmlCaseVictim);
		String htmlCaseKiller = getCasesToModify()[current.getLigne()][current.getColonne()].replaceFirst(getNameAttribute(current), nameValue);
		getCasesToModify()[arrivee.getLigne()][arrivee.getColonne()] =  htmlCaseVictim.replaceFirst("\">", "SelectPiece\">");	
		getCasesToModify()[current.getLigne()][current.getColonne()] = htmlCaseKiller;
	}
	
	private static String getNameAttribute(Position p){
		String result = getCasesToModify()[p.getLigne()][p.getColonne()];
		int depart = result.indexOf("name");
		String sub = result.substring(depart);
		int fin = sub.indexOf(" ");
		String nameAttribut = sub.substring(0, fin);
		return nameAttribut;
	}
	public static void showTheCasesForTheFirstTime(Position current,Piece piece){
		showTheCasesForTheFirstTimeAuxi(current,piece);
	}

	public static String[][] getCasesToModify() {
		return casesToModify;
	}

	public static void setCasesToModify(String[][] c) {
		casesToModify = c;
	}
	
	public String getPageGenerate(){
		return null;
	}

	public static int getLigne() {
		return ligne;
	}

	public static void setLigne(int ligne) {
		HtmlPageGenerator.ligne += ligne;
	}

	public static int getColonne() {
		return colonne;
	}

	public static void setColonne(int colonne) {
		HtmlPageGenerator.colonne += colonne;
	}
	
	public static void setColonneTo(int colonne){
		HtmlPageGenerator.colonne = colonne;
	}
	
	public static void setLineTo(int ligne){
		HtmlPageGenerator.ligne = ligne;
	}

	public static String[][] getCloneCasesToModify() {
		return cloneCasesToModify;
	}

	public static void setCloneCasesToModify(String[][] cloneCasesToModify) {
		HtmlPageGenerator.cloneCasesToModify = cloneCasesToModify;
	}
}
