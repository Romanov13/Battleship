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
