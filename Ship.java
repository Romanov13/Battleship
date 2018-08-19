import java.util.ArrayList;
import java.util.Scanner;

public class Ship{

    private char direction;
    private int decks;

    private boolean isHit;
    private boolean isSunk;

    int decksCoordinates [][];


    public ArrayList<Deck> getDecksList() {
        return decksList;
    }

    public ArrayList<int[]> getOutline() {
        return outline;
    }

    private ArrayList<int []> outline = new ArrayList<>();

    private ArrayList<Deck> decksList = new ArrayList<Deck>();

    Ship(int decks, int x, int y, boolean vertical) {
        boolean isHit = false;
        boolean isSunk = false;
        Deck d = new Deck(x,y);

        decksList.add(d);
        decksCoordinates = new int[decks][2];
        decksCoordinates [0][1] = x;
        decksCoordinates [0][0] = y;


        if (decks > 1) {
            if (vertical) {
                for (int i = 1; i < decks; i++) {
                    Deck dk = new Deck(x, y+i);
                    decksList.add(dk);
                    decksCoordinates[i][1] = dk.getX();
                    decksCoordinates [i][0] = dk.getY();

                }
            } else {
                for (int i = 1; i < decks; i++) {
                    Deck dk = new Deck(x+i, y);
                    decksList.add(dk);
                    decksCoordinates[i][1] = x;
                    decksCoordinates [i][0] = y;

                }
            }
        }
        outline();

    }

    public int getDecks(){
        return decks;
    }

    public void isHit(){
        boolean sunk = true;
        for (Deck d: getDecksList()){
            if(!d.isHit){
                sunk = false;
                break;
            }
        }
        if(sunk){
            isSunk = true;
        }
    }

    public boolean isSunk(){
        return isSunk;
    }

    public void outline(){
        for(Deck d: getDecksList()){
            int [][] deckOutline = d.getOutline();
            for(int i=0; i<deckOutline.length; i++){
                if((deckOutline[i][0]!= -1)&(!shipOverOutline(deckOutline[i]))){
                    outline.add(deckOutline[i]);
                }
            }

        }


    }

    private boolean shipOverOutline(int [] outlineToCheck) { // checks if outline cell is in place of the deck of the same ship
        boolean shipOver = false;
        for(Deck d: getDecksList()){
            if((d.getY()==outlineToCheck[0])&&(d.getX() == outlineToCheck[1])){
                shipOver = true;
                break;
            }
        }
        return shipOver;
    }


}
