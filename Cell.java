public class Cell{


	String shape;
	Deck d;
	boolean shotAt;
	

	Cell(String type){
		d = null;
		 shape = type;
		shotAt = false;
	}
	
	Cell(){
		d = null;
		 shape = "Empty";
		shotAt = false;
	}

	public String getShape(){
		return shape;
	}

	public void setShape(String type) {

			shape = type;
	}
		

	
	public void shotAt(){
	if(shotAt==false){
	if(d==null){
	shape = "Miss";	
	} else {
	shape = d.hit();
	}
		shotAt = true;
	} else {}
	}

	public void addDeck(Deck d){

		this.d = d;
		setShape("Deck");
	}

}
