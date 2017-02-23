public class Square {
	// Type constants
	public static final char BOMB = '!';
	public static final char NOT_BOMB = '.';

	// Status constants
	public static final char NOT_CLICKED = '?';
	public static final char FLAGGED = 'F';
	public static final char CLICKED = 'C';
	public static final char CLICKED_ZERO = '0';

	// Object instance variables
	private char squareType; // Type of square (bomb/not bomb)
	private char squareStatus; // flagged/clicked/not clicked
	private int adjacentBombs; // # of adjacent bombs

	public Square() {
		this.squareType = NOT_BOMB;
		this.squareStatus = NOT_CLICKED;
	}

	public void click() {
		this.squareStatus = CLICKED;
	}

	public boolean isClicked() {
		return (this.getStatus() == CLICKED);
	}

	public void flag() {
		this.squareStatus = FLAGGED;
	}

	public void unFlag() {
		if (this.squareStatus == FLAGGED) this.squareStatus = NOT_CLICKED;
	}

	public boolean isFlagged() {
		return (this.squareStatus == FLAGGED);
	}

	public void makeBomb() {
		this.squareType = BOMB;
	}	

	public boolean isBomb() {
		return (this.squareType == BOMB);
	}

	// Accessor/Mutator methods
	public void setType(char type) {
		this.squareType = type;
	}

	public void setAdjacentBombs(int n) {
		this.adjacentBombs = n;
	}

	public void setStatus(char status) {
		this.squareStatus = status;
	}

	public char getType() {
		return squareType;
	}

	public int getAdjacentBombs() {
		return adjacentBombs;
	}

	public char getStatus() {
		return squareStatus;
	}
}
