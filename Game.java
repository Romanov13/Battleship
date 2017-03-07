import java.util.*;
import java.io.*;

public class Game {

	// Game constants
	private final int ONEDECK_SHIPS = 4;
	private final int TWODECK_SHIPS = 3;
	private final int THREEDECK_SHIPS = 2;
	private final int FOURDECK_SHIPS = 1;
	private final int ONE_DECK = 1;
	private final int TWO_DECK = 2;
	private final int THREE_DECK = 3;
	private final int FOUR_DECK = 4;
	private final int CLASSES = 4;
	private final int SHIPS = 10;
	private final int NUM_OF_PLAYERS = 2;
	

	Cell[][] field = new Cell[10][10];
	ArrayList<Ship> ships = new ArrayList<Ship>();
	
	ArrayList<Player> players = new ArrayList<Player>();
	
	public Display d = new Display();
	
	
	
	public void createField(){
		for(int i=0; i<field.length; i++){
			
			for(int j=0; j<field[i].length; j++){
				Cell c = new Cell();
				field [i][j] = c;
			}
			
		}
	}
	
	public void printField(Cell[][] field){
	    d.printField(field);
	}
	
	/*public void drawBoard(){
		System.out.print(" " + "\t");
		for(int h=0; h<heading.length; h++){
		System.out.print(heading[h]);
		}
		System.out.println();
		for(int i=0; i<field.length; i++){
			System.out.print(i+1 + "\t");
			for(int j=0; j<field[i].length; j++){
				System.out.print(field[i][j]);
			}
			System.out.println("|");
		}
	}
	*/
	
	public void fillField(){
		
		makeShips(ONEDECK_SHIPS, ONE_DECK);
		makeShips(TWODECK_SHIPS, TWO_DECK);
		makeShips(THREEDECK_SHIPS, THREE_DECK);
		makeShips(FOURDECK_SHIPS, FOUR_DECK);
		
		d.shipsAreReady();
	}
	
	public void makeShips(int shipClass, int decks){
		for(int i=0; i<shipClass; i++){
		Ship s = new Ship(decks, new Random().nextInt(field.length), new Random().nextInt(field[1].length));
		for(Deck d : s.decksList) {
			field[d.getX()][d.getY()].addDeck(d);
		}
			ships.add(s);
		}
	}
	
	
	public void shot(){
		System.out.println("Shoot!");
		Scanner s = new Scanner(System.in);
		String shot = s.nextLine();
		shot = shot.replaceAll("[Aa]", "0");
		shot = shot.replaceAll("[Bb]", "1");
		shot = shot.replaceAll("[Cc]", "2");
		shot = shot.replaceAll("[Dd]", "3");
		shot = shot.replaceAll("[Ee]", "4");
		shot = shot.replaceAll("[Ff]", "5");
		shot = shot.replaceAll("[Gg]", "6");
		shot = shot.replaceAll("[Hh]", "7");
		shot = shot.replaceAll("[Ii]", "8");
		shot = shot.replaceAll("[Jj]", "9");
		//char[] sh = shot.toCharArraY();
		//Cell c = new Cell("Miss");
		System.out.println(shot);
	  field[(Character.getNumericValue(shot.charAt(1))-1)][Character.getNumericValue(shot.charAt(0))].shotAt();
		
		
	}

	public void salute(){

		d.salute();
	}
		
		public void endGame(){
			d.weHaveWinner(players.get(0).getName());
		}
	
	// Start
	public static void main(String[] args){
		Game g = new Game();

		g.salute();
		Player playerOne = new Player();
		playerOne.setName(g.getPlayerName());
		g.createField();
		g.printField(g.field);
		g.fillField();
		g.printField(g.field);
		g.shot();
		g.printField(g.field);

	}

	private String getPlayerName() {
		return d.getPlayerName();
	}
}



