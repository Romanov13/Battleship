public class Cell{


	String shape;
	Deck d;
	

	Cell(String type){
		d = null;
		 shape = type;
	}
	
	Cell(){
		d = null;
		 shape = "Empty";
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
	
	if(d==null){
	shape = "Miss";	
	} else {
	shape = d.hit();
	}
	}

}
