public class Deck{
	private int x;
	private int y;
	boolean isHit = false;

	Deck(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public String hit(){
		isHit = true;
		String status = "Hit";
		return status;
	}
}
