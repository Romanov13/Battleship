import java.util.ArrayList;

public class Ship{

    private char direction;
    private int decks;
    ArrayList<Deck> decksList = new ArrayList<Deck>();

    Ship(int decks, int x, int y){
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
