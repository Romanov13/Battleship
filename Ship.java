import java.util.ArrayList;

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
                    decksList.add(new Deck(x, y + i));
                    decksCoordinates[i][1] = x;
                    decksCoordinates [i][0] = y;
                }
            } else {
                for (int i = 1; i < decks; i++) {
                    decksList.add(new Deck(x + i, y));
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
        isHit = true;
}

public void isSunk(){
        isSunk = true;
    }

    public void outline(){
        for(Deck d: getDecksList()){
            int [][] deckOutline = d.getOutline();
            for(int i=0; i<deckOutline.length; i++){
                if(deckOutline[i][0]!= -1){
                    outline.add(deckOutline[i]);

                }
            }

        }
        for(int i = 0; i<decksCoordinates.length; i++){
            int [] coordinates = decksCoordinates[i];
            for(int j = 0; j<outline.size(); j++){
                if(outline.get(j).equals(coordinates)){
                    outline.remove(j);
                }
            }
        }

    }



}
