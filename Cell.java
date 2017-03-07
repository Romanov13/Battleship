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

	public void setShape(String type){
		if(type.equals("Deck")){
			shape = type;
		}
		if(type.equals("Hit")){
			shape = type;
		}
		if(type.equals("Empty")){
			shape = type;
		}
		if(type.equals("Miss")){
			shape = type;
		} else {shape = "Empty";
		
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

}
