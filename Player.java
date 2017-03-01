public class Player{
	String name;
	int killCount = 0;
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void killedShip(){
	killCount+=1;
	}
}
