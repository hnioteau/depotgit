import java.util.Stack;


public class GameOfChess {
	private echec.Deplacement currentGame = null;
	private Stack <echec.Deplacement> games = null;
	private int index = 0;
	
	public GameOfChess(echec.Deplacement partie){
		this.setGame(partie);
		init();
	}
	
	private void init(){
		this.games = new Stack<echec.Deplacement>();
		this.pushGame(getGame());
	}
	
	public echec.Deplacement getGame() {
		return currentGame;
	}
	
	public void pushGame(echec.Deplacement game){
		this.games.push(game); 
	}
	
	public echec.Deplacement newGame(){
		return games.firstElement(); // Last IN First OUT
	}

	public echec.Deplacement getCurrentGame(){
		return games.lastElement(); 
	
	}
	
	public echec.Deplacement getPreviousGame(){
		echec.Deplacement result = null;
		if(controlIndexValue(games.size() - (1 + this.getIndex()))){
			result = games.get(games.size() - (1 + this.getIndex()));
		}
		return result; // same like getFollowingGame()
	}
	
	public echec.Deplacement getFollowingGame(){
		echec.Deplacement result = null;
		if(controlIndexValue(games.size()+1)){
			result = games.get(games.size()+1);
		}
		return result; // Null or Value Expected	
	}
	
	private boolean controlIndexValue(int ind){
		return ( -1 < ind && ind < games.size() );
	}
	
	public void setGame(echec.Deplacement partie) {
		this.currentGame = partie;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void incIndex(int index) {
		this.index += index;
	}
}
