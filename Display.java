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
