public class Cell{


	String shape;
	Deck d;
	int x;
	int y;

	Cell(int x, int y, String type){
		d = null;
		this x=x;
		this y=y;
		 shape = type;
	}
	
	Cell(int x, int y){
		d = null;
		this x=x;
		this y=y;
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
		
	public void setX(int x){
	this x=x;
	}
		
		public void setY(int y){
			this y=y;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
		return y;
		}
	
	public void shotAt(){
	
	if(d==null){
	shape = "Miss";	
	} else {
	shape = d.hit();
	}
	}

}
