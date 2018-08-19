import java.util.*;
import java.io.*;

public class Display{
	String[] heading = {" A", " B", " C", " D", " E", " F", " G", " H", " I", " J"};
	public void salute(){
		System.out.println("Hello, sailor!");
	}
	public Scanner s = new Scanner(System.in);

	public String getPlayerName(){
		System.out.println("What be yarrr name?");
		String playerName = s.nextLine();
		return playerName;
	}

	public void printField(Cell[][] field){
		System.out.print(" " + "\t");
		for(int h=0; h<heading.length; h++){
			System.out.print(heading[h]);
		}
		System.out.println();
		for(int i=0; i<field.length; i++){
			System.out.print(i+1 + "\t");
			for(int j=0; j<field[i].length; j++){
				printCell(field[i][j]);
			}
			System.out.println("|");
		}
	}

	public void printField(Cell[][] field1, Cell[][] field2){
		System.out.print(" " + "\t");
		for(int h=0; h<heading.length; h++){
			System.out.print(heading[h]);
		}
		System.out.print("\t");
		for(int h=0; h<heading.length; h++){
			System.out.print(heading[h]);
		}
		System.out.println();
		for(int i=0; i<field1.length; i++){
			int c = i+1;
			System.out.print(c + "\t");
			for(int j=0; j<field1[i].length; j++){
				printCell(field1[i][j]);
			}
			System.out.print("|" + "\t" + c);
			for(int j=0; j<field2[i].length; j++){
				printCell(field2[i][j]);
			}
			System.out.println("|");

		}
	}

	private void printCell(Cell cell) {
		switch (cell){
			case DECK:
				System.out.print("|p");
				break;
			case MISS:
				System.out.print("|*");
				break;
			case EMPTY:
				System.out.print("| ");
				break;
			case HIT:
				System.out.print("|x");
				break;
			case OUTLINE:
				System.out.print("|.");
				break;
		}
	}


	public void shipsAreReady(){
		System.out.println("Ships are ready!");
	}

	public void weHaveWinner(String name){
		System.out.println("The " + name + " is the last sailor swimming!");
	}

	public void autoShoot() {
		System.out.println("Auto shoot");
	}

	public String getYCoord(int y) {
		String yCoord = String.valueOf(y+1);
		return yCoord;
	}

	public String getXCoord(int x) {
		String xCoord = String.valueOf(x);
		xCoord = xCoord.replace("0", "a");
		xCoord = xCoord.replace("1", "b");
		xCoord = xCoord.replace("2", "c");
		xCoord = xCoord.replace("3", "d");
		xCoord = xCoord.replace("4", "e");
		xCoord = xCoord.replace("5", "f");
		xCoord = xCoord.replace("6", "g");
		xCoord = xCoord.replace("7", "h");
		xCoord = xCoord.replace("8", "i");
		xCoord = xCoord.replace("9", "j");
		return xCoord;
	}

	public boolean requestMode() {
		System.out.println("Are playing alone? (y/n)");
		boolean automode = true;
		String r = s.nextLine();
		if(r.equalsIgnoreCase("y")){
			automode = true;
		} else {automode = false;}
		return automode;
	}

	public String getAnotherPlayerName() {
		System.out.println("What be yarrr opponent's name?");
		String playerName = s.nextLine();
		return playerName;
	}
}
