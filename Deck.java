public class Deck{
	private int x;
	private int y;
	boolean isHit;

	Deck(int x, int y){
		this.x = x;
		this.y = y;
		isHit = false;
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
