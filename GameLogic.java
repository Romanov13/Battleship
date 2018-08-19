import java.util.*;import java.util.*;

public class GameLogic {

	private static boolean manual;
	private static boolean endGame = false;
	private final int CLASSES = 4;
	private final int SHIPS = 10;
	private final int NUM_OF_PLAYERS = 2;
	private final int FIELD_LENGTH = 10;
	static int turn = 0;


	private boolean automode;


	private ArrayList<Ship> getShips() {
		return ships;
	}

	private ArrayList<Ship> ships = new ArrayList<Ship>();

	private ArrayList<Player> players = new ArrayList<Player>();

	private Display d = new Display();



	private Cell[][] createField(){
		Cell[][] field = new Cell[FIELD_LENGTH][FIELD_LENGTH];

		for(int i=0; i<field.length; i++){

			for(int j=0; j<field[i].length; j++){
				field [i][j] = Cell.EMPTY;
			}

		}
		return field;
	}

	private void printField(Cell[][] field1, Cell[][] field2){
		d.printField(field1, field2);
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




	private void shot(){
		// move to Display
//		System.out.println("Shoot!");
//		Scanner s = new Scanner(System.in);
//		String shot = s.nextLine();
//		shot = shot.replaceAll("[Aa]", "0");
//		shot = shot.replaceAll("[Bb]", "1");
//		shot = shot.replaceAll("[Cc]", "2");
//		shot = shot.replaceAll("[Dd]", "3");
//		shot = shot.replaceAll("[Ee]", "4");
//		shot = shot.replaceAll("[Ff]", "5");
//		shot = shot.replaceAll("[Gg]", "6");
//		shot = shot.replaceAll("[Hh]", "7");
//		shot = shot.replaceAll("[Ii]", "8");
//		shot = shot.replaceAll("[Jj]", "9");
//		//char[] sh = shot.toCharArraY();
//		Cell c = new Cell("Miss");
//		System.out.println(shot);
//	  field[(Character.getNumericValue(shot.charAt(1))-1)][Character.getNumericValue(shot.charAt(0))] = c.getShape();
//
	}

	private int generateRandom(int b){
		return new Random().nextInt(b);
	}

	private  boolean shoot(){
		boolean shotAt = false;
		if(turn % 2 != 0){
			shotAt = players.get(1).shotAt(players.get(0).shoot());
		} else {
			if (automode) {
				shotAt = players.get(0).shotAt(players.get(1).autoShoot());
			} else {
				shotAt = players.get(0).shotAt(players.get(1).autoShoot());
			}
		}
		printField(players.get(0).getField(), players.get(1).getField());
		return shotAt;
	}

	private void salute(){

		d.salute();
	}

	public void endGame(){
		d.weHaveWinner(players.get(0).getName());
	}

	// Start
	public static void main(String[] args){
		GameLogic g = new GameLogic();

		g.salute();
		g.players.add(new Player());
		g.players.get(0).setName(g.getPlayerName());
		g.requestMode();
		g.players.add(new Player());
		if(!g.automode){
			g.players.get(1).setName(g.getPlayerName());}
		else {g.players.get(1).setName("Computer");}
		g.players.get(0).setPlayerField(g.createField());
		g.players.get(1).setPlayerField(g.createField());


		g.printField(g.players.get(0).getField(), g.players.get(1).getField());
		manual = false;
		g.players.get(0).fillField();
		g.players.get(1).fillField();
		g.shipsAreReady();
		g.players.get(0).renderAllShips();

		g.printField(g.players.get(0).getField(), g.players.get(1).getField());
		System.out.println(g.players.get(0).getName() + ", " + g.players.get(1).getName());
		turn = 1;
		while (!endGame){
			while (g.shoot()){

			}
			turn++;
		}

//		for (int i = 0; i<4;i++) {
//			g.autoShoot();
//			g.printField(g.field, g.players.get(1).getField());
//		}
//		g.printField(g.field, g.players.get(1).getField());
	}

	private void shipsAreReady() {
		d.shipsAreReady();
	}

	private void requestMode() {
		automode = d.requestMode();

	}

	private String getPlayerName() {

		if(players.size()>1){
			return d.getAnotherPlayerName();
		}
		return d.getPlayerName();
	}
}


