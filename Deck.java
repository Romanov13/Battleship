public class Deck {
	private int x;
	private int y;
	boolean isHit = false;
	int outlineCells = 0;
	boolean xLeft;
	boolean xRight;
	boolean yUp;
	boolean yDown;

	Deck(int x, int y) {
		this.x = x;
		this.y = y;
		if (x == 0) {
			xLeft = true;
		}
		if (x == 9) {
			xRight = true;
		}
		if (y == 0) {
			yUp = true;
		}
		if (y == 9) {
			yDown = true;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String hit() {
		isHit = true;
		String status = "Hit";
		return status;
	}

	public int[][] getOutline() {
		int[][] cellOutline = new int[8][2];
		int[] negative = new int[]{-1, -1};
		if (xLeft) {
			cellOutline[0] = negative;
			cellOutline[3] = negative;
			cellOutline[5] = negative;
		}
		if (xRight) {
			cellOutline[2] = negative;
			cellOutline[4] = negative;
			cellOutline[7] = negative;
		}
		if (yUp) {
			cellOutline[0] = negative;
			cellOutline[1] = negative;
			cellOutline[2] = negative;
		}
		if (yDown) {
			cellOutline[5] = negative;
			cellOutline[6] = negative;
			cellOutline[7] = negative;
		}
		for (int i = 0; i < cellOutline.length; i++) {
			if (cellOutline[i][0] != -1) {
				switch (i) {
					case 0:
						cellOutline[i][1] = x - 1;
						cellOutline[i][0] = y - 1;
						break;
					case 1:
						cellOutline[i][1] = x;
						cellOutline[i][0] = y - 1;
						break;
					case 2:
						cellOutline[i][1] = x + 1;
						cellOutline[i][0] = y - 1;
						break;
					case 3:
						cellOutline[i][1] = x - 1;
						cellOutline[i][0] = y;
						break;
					case 4:
						cellOutline[i][1] = x + 1;
						cellOutline[i][0] = y;
						break;
					case 5:
						cellOutline[i][1] = x - 1;
						cellOutline[i][0] = y + 1;
						break;
					case 6:
						cellOutline[i][1] = x;
						cellOutline[i][0] = y + 1;
						break;
					case 7:
						cellOutline[i][1] = x + 1;
						cellOutline[i][0] = y + 1;
						break;
				}
			}
		}
		return cellOutline;
	}
}
