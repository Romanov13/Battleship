public class Game{
	
	private final int ONEDECK = 4;
	private final int TWODECK = 3;
	private final int THREEDECK = 2;
	private final int FOURDECK = 1;
	private final int SHIPS = 10;
	private final int NUM_OF_PLAYERS = 2;
	String[] heading = {" A", " B", " C", " D", " E", " F", " G", " H", " I", " J"};
	String[][] field = new String[10][11];
	
	public void createField(){
		for(int i=0; i<field.length; i++){
			field[i][0] = "|";
			for(int j=1; j<field[i].length; j++){
				Cell c = new Cell("Empty");
				field [i][j] = c.getShape();
			}
		}
	}
	
	public void printField(){
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
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Game g = new Game();
		g.createField();
		g.printField();
	}
}


public class Cell{
	
	
	String shape;
	
	Cell(String type){
		if(type.equals("Deck")){
			shape = "p|";
		}
		if(type.equals("Hit")){
			shape = "x|";
		}
		if(type.equals("Empty")){
			shape = " |";
		}
		if(type.equals("Miss")){
			shape = "*|";
		}
	}
	
	public String getShape(){
		return shape;
	}
	
	
}

public class Deck{
	
	boolean isHit = false;
} 

public class Ship{
	
private int decks;

Ship(String type){
	if(type = "ONEDECK"){
		decks = 1;
	}
	if(type = "TWODECK"){
		decks = 2;
	}
	if(type = "THREEDECK"){
		decks = 3;
	}
	if(type = "FOURDECK"){
		decks = 4;
	}
	
}
}

public class Player{
	
	String name;
	
	Player(String name){
		this.name = name;
	}
	
}