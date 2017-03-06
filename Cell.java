public class Cell{


	String shape;
	Deck d;

	Cell(String type){
		d = null;
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
	
	public void shotAt(){
	
	if(d==null){
	changeTo("Miss");	
	} else {
	changeTo(d.hit());
	}
	}

}
