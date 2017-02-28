import java.util.*;
import java.io.*;

public class Display{
String[] heading = {" A", " B", " C", " D", " E", " F", " G", " H", " I", " J"};
public void salute(){
System.out.println("Hello, sailor! What be yarrr name?");
}
 
 public String getPlayerName(){
  Scanner s = new Scanner(System.in);
  String playerName = s.nextLine();
  return playerName;
 }
 
 public void printField(String[][] field){
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
 
	 
	 public void shipsAreReady(){
		 System.out.println("Ships are ready!");
	 }
	 
	 public void weHaveWinner(String name){
		 System.out.println("The " + name + " is the last sailor swimming!");
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
	
	public hit(){
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
