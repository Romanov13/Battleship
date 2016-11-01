public class Game{
	
	final int ONEDECK = 4;
	final int TWODECK = 3;
	final int THREEDECK = 2;
	final int FOURDECK = 1;
	final int SHIPS = 10;
	final int NUM_OF_PLAYERS = 2;
	String[] heading = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	String[][] field = new String[10][10];
	
	public void createField(){
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
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
		for(int i=0; i<10; i++){
			System.out.print(i+1 + "\t");
			for(int j=0; j<10; j++){
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
			shape = "|||";
		}
		if(type.equals("Hit")){
			shape = "|x|";
		}
		if(type.equals("Empty")){
			shape = "| |";
		}
		if(type.equals("Miss")){
			shape = "|*|";
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
	


Ship(String type){
	if(type = "ONEDECK"){
		
	}
	if(type = "TWODECK"){
		
	}
	if(type = "THREEDECK"){
		
	}
	if(type = "FOURDECK"){
		
	}
	
}
}

public class Player{
	
	String name;
	
	Player(String name){
		this.name = name;
	}
	
}