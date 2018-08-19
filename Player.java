import java.util.ArrayList;
import java.util.Random;

public class Player{
	public boolean manual = false;
	private String name;
	private int killCount = 0;

	private ArrayList<Ship> shps = new ArrayList<>();
	private Cell[][] field;
	private Display d = new Display();

	void setName(String name){
		this.name = name;
	}

	String getName(){
		return name;
	}

	public void killedShip(){
		killCount+=1;
	}

	void setPlayerField(Cell[][] field){
		this.field = field;
	}

	Cell[][] getField() {
		return field;
	}

	void fillField(){
		if(manual){
			makeShipsManually();
		}else {
			fillFieldAutomatically();
		}
	}

	private void fillFieldAutomatically(){

		int ONE_DECK = 1;// GameLogic constants
		int ONEDECK_SHIPS = 4;

		int TWO_DECK = 2;
		int TWODECK_SHIPS = 3;

		int THREE_DECK = 3;
		int THREEDECK_SHIPS = 2;

		int FOUR_DECK = 4;
		int FOURDECK_SHIPS = 1;

		makeClassOfShips(FOURDECK_SHIPS, FOUR_DECK);
		makeClassOfShips(THREEDECK_SHIPS, THREE_DECK);
		makeClassOfShips(TWODECK_SHIPS, TWO_DECK);
		makeClassOfShips(ONEDECK_SHIPS, ONE_DECK);


	}

	private void makeClassOfShips(int classOfShip, int decks){
		for(int i=0; i<classOfShip; i++){
			Ship s = makeShipInBorder(decks);
			while (checkForOverlay(s)){
				s = makeShipInBorder(decks);
			}


			shps.add(s);
		}
	}


	// move to Players class?
	 void renderShip(Ship s) {
		for(Deck d: s.getDecksList()){
			field[d.getY()][d.getX()] = Cell.DECK;
		}
		for(int[] i: s.getOutline()){
			field[i[0]][i[1]]= Cell.OUTLINE;
		}
	}

	 void renderAllShips() {
		for(Ship s: shps) {
			renderShip(s);
		}
	}


	private boolean checkForOverlay(Ship s) {
		boolean check = false;

		for(Deck d: s.getDecksList()){
			if(isOverlayed(d)){
				check = true;
				break;
			}

		}


		return check;
	}

	private boolean isOverlayed(Deck d) {// checks each neighbour cell for having Deck in it and returns f
		boolean overlay = false;
		int [] deckCoordinates = {d.getY(), d.getX()};
		for(Ship s: shps){
			for(Deck dk: s.getDecksList()){
				if((deckCoordinates[0] == dk.getY())&&(deckCoordinates[1] == dk.getX())){
					overlay = true;
					break;
				}
			}
			for(int [] o: s.getOutline()){
				if((deckCoordinates[0] == o[0])&&(deckCoordinates[1] == o[1])){
					overlay = true;
					break;
				}
			}
		}
		return overlay;
	}

	private void makeShipsManually(){

	}

	private Ship makeShipInBorder(int decks){
		int xOfShip = generateRandom(field[0].length);
		int yOfShip = generateRandom(field.length);
		boolean vertical = new Random().nextBoolean();
		if(vertical){
			yOfShip = generateRandom(field.length - decks);
		} else {
			xOfShip = generateRandom((field[0].length - decks));
		}
		return new Ship(decks, xOfShip, yOfShip, vertical);
	}

	private int generateRandom(int b){
		return new Random().nextInt(b);
	}

	public void setPlayerField(Cell[][] field){
		this.field = field;
	}

	public Cell[][] getField() {
		return field;
	}

	public void fillField(){

		int ONE_DECK = 1;// GameLogic constants
		int ONEDECK_SHIPS = 4;
		;
		int TWO_DECK = 2;
		int TWODECK_SHIPS = 3;

		int THREE_DECK = 3;
		int THREEDECK_SHIPS = 2;

		int FOUR_DECK = 4;
		int FOURDECK_SHIPS = 1;

		makeClassOfShips(FOURDECK_SHIPS, FOUR_DECK);
		makeClassOfShips(THREEDECK_SHIPS, THREE_DECK);
		makeClassOfShips(TWODECK_SHIPS, TWO_DECK);
		makeClassOfShips(ONEDECK_SHIPS, ONE_DECK);

		d.shipsAreReady();
	}

	private void makeClassOfShips(int classOfShip, int decks){
		for(int i=0; i<classOfShip; i++){
			Ship s = makeShipInBorder(decks);
			while (checkForOverlay(s)){
				s = makeShipInBorder(decks);
			}
			mapTheShip(s); // adds to the player but does not renders them on map
			renderShip(s);

			shps.add(s);
		}
	}

	private void mapTheShip(Ship s) {
		for(Deck d:s.getDecksList()){

		}
	}

	// move to Players class?
	private void renderShip(Ship s) {
		for(Deck d: s.getDecksList()){
			field[d.getX()][d.getY()] = Cell.DECK;
		}
		for(int[] i: s.getOutline()){
			field[i[0]][i[1]]= Cell.OUTLINE;
		}
	}

	private void renderAllShips(ArrayList<Ship> ships) {
		for(Ship s: ships) {
			renderShip(s);
		}
	}


	private boolean checkForOverlay(Ship s) {
		boolean check = false;

		for(Deck d: s.getDecksList()){
			if(isOverlayed(d)){
				check = true;
			}
		}


		return check;
	}

	private boolean isOverlayed(Deck d) {// checks each neighbour cell for having Deck in it and returns f
		if(field[d.getX()][d.getY()] == Cell.OUTLINE){
			return true;
		} else {return false;}
	}

	public void makeShipsManually(){

	}

	private Ship makeShipInBorder(int decks){
		int xOfShip = generateRandom(field[0].length);
		int yOfShip = generateRandom(field.length);
		boolean vertical = new Random().nextBoolean();
		if(vertical){
			yOfShip = generateRandom(field.length - decks);
		} else {
			xOfShip = generateRandom((field[0].length - decks));
		}
		return new Ship(decks, xOfShip, yOfShip, vertical);
	}

	private int generateRandom(int b){
		return new Random().nextInt(b);
	}

	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}
}


// list of cells of dif types with coordinates for each user
