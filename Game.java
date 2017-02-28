import java.util.*;
import java.io.*;

public class Game {
	
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
	String[] heading = {" A", " B", " C", " D", " E", " F", " G", " H", " I", " J"};
	String[][] field = new String[10][10];
	ArrayList<Ship> ships = new ArrayList<Ship>();
	ArrayList<Cell> occupied = new ArrayList<Cell>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	public Display d;
	
	
	
	public void createField(){
		for(int i=0; i<field.length; i++){
			
			for(int j=0; j<field[i].length; j++){
				Cell c = new Cell("Empty");
				field [i][j] = c.getShape();
			}
			
		}
	}
	
	public void printField(String[][] field){
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
		
		for(int j=0; j<SHIPS; j++){
			for(int i=0; i<ONEDECK_SHIPS; i++){
		Ship s = new Ship(ONE_DECK, new Random().nextInt(field.length), new Random().nextInt(field[1].length));
		Cell c = new Cell("Deck");
		field[s.decksList.get(0).getX()][s.decksList.get(0).getY()] = c.getShape();
			ships.add(s);
		}
			for(int i=0; i<TWODECK_SHIPS; i++){
		Ship s = new Ship(TWO_DECK, new Random().nextInt(field.length), new Random().nextInt(field[1].length));
		Cell c = new Cell("Deck");
		field[s.decksList.get(0).getX()][s.decksList.get(0).getY()] = c.getShape();
			ships.add(s);
		}
			
			for(int i=0; i<THREEDECK_SHIPS; i++){
		Ship s = new Ship(THREE_DECK, new Random().nextInt(field.length), new Random().nextInt(field[1].length));
		Cell c = new Cell("Deck");
		field[s.decksList.get(0).getX()][s.decksList.get(0).getY()] = c.getShape();
			ships.add(s);
		}
			
			for(int i=0; i<FOURDECK_SHIPS; i++){
		Ship s = new Ship(FOUR_DECK, new Random().nextInt(field.length), new Random().nextInt(field[1].length));
		Cell c = new Cell("Deck");
		field[s.decksList.get(0).getX()][s.decksList.get(0).getY()] = c.getShape();
			ships.add(s);
		}
			
		d.shipsAreReady();
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
		Cell c = new Cell("Miss");
		System.out.println(shot);
	  field[(Character.getNumericValue(shot.charAt(1))+1)][Character.getNumericValue(shot.charAt(0))] = c.getShape();
		
	}
		
		public void endGame(){
			d.weHaveWinner(players.get(0).getName());
		}
	
	// Start
	public static void main(String[] args){
		Game g = new Game();
		d = new Display();
		d.salute();
		Player playerOne = new Player();
		playerOne.setName(d.getPlayerName());
		g.createField();
		g.printField(g.field);
		g.fillField();
		g.printField(g.field);
		g.shot();
		g.printField(g.field);
	}
}


public class Cell{
	
	
	String shape;
	
	Cell(String type){
		changeTo(type);
	}
	
	public String getShape(){
		return shape;
	}
	
	public void changeTo(String type){
		if(type.equals("Deck")){
			shape = "|p";
		}
		if(type.equals("Hit")){
			shape = "|x";
		}
		if(type.equals("Empty")){
			shape = "| ";
		}
		if(type.equals("Miss")){
			shape = "|*";
		}
	}
	
}

public class Deck{
	private int x;
	private int y;
	boolean isHit = false;
	
	Deck(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void hit(){
		isHit = true;
	}
} 
import java.util.*;

public class Ship{
	
	private char direction;
private int decks;
ArrayList<Deck> decksList = new ArrayList<Deck>();

Ship(int decks, int x, int y){
	this.decks = decks;
	decksList.add(new Deck(x, y));
	if (decks>1){
//if (direction.equals('v')){
	for(int i=1; i<decks; i++){
		decksList.add(new Deck(x, y+i));
	}
//}
	}
}
public int getDecks(){
	return decks;
}

}


public class Player{
	String name;
	int killCount = 0;
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void killedShip(){
	killCount+=1;
	}
}
