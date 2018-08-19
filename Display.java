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
			System.out.print("|" + "\t" + c + "\t");
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

	public void autoShoot(int x, int y) {
		System.out.println("Auto shoot" + x + ", " + y);
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

	public int [] shoot(String name){
		int [] coordinates = new int [2];
		System.out.println("Where to shoot, captain " + name + "?");
		int[] sh = convertCoordinates();
		while (!responseValid(sh)){
			System.out.println("That doesn't sound right. Try one more time.");
			sh = convertCoordinates();
		}
		System.out.println("Debug: " + sh[0] + ", " + sh[1]);
//	  field[(Character.getNumericValue(shot.charAt(1))-1)][Character.getNumericValue(shot.charAt(0))] = c.getShape();
		coordinates[0] = sh[1]- 1;
		coordinates[1] = sh[0];
		return coordinates;
	}

	private boolean responseValid(int[] sh) {
		boolean res = true;
		if(sh.length>2){
			res = false;
		}
		return res;
	}

	private int[] convertCoordinates(){
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
		char[] sh = shot.toCharArray();
		int[] shi = new int[2];
		shi [0] = Character.getNumericValue(sh[0]);
		shi [1] = Character.getNumericValue(sh[1]);
		if(sh.length==3){
			shi[1] = 10;
		}
		return shi;
	}
}
