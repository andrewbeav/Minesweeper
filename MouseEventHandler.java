import java.awt.event.*;

public class MouseEventHandler extends MouseAdapter {
	public static int RIGHT_CLICK_BUTTON = MouseEvent.BUTTON3;
	public static int LEFT_CLICK_BUTTON = MouseEvent.BUTTON1;

	private int squareRow, squareColumn;
	private GameBoard board;
	private boolean isGamePlaying = true;
	private int adjacentBombs;
	private SquareGui squareGui;

	public MouseEventHandler(SquareGui squareGui) {
		this.squareGui = squareGui;
		this.squareRow = squareGui.getRow();
		this.squareColumn = squareGui.getColumn();
		this.board = squareGui.getBoard();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int button = event.getButton();

		if (button == LEFT_CLICK_BUTTON) {
			board.clickOnSquare(squareRow, squareColumn);
			if (!board.isGamePlaying()) {
				squareGui.update(GameBoard.GAME_OVER);
			}
			else if (board.getSquare(squareRow, squareColumn).getAdjacentBombs() == 0) {
				squareGui.update(Square.CLICKED_ZERO);
			}
			else {
				squareGui.setAdjacentBombs(board.getSquare(squareRow, squareColumn).getAdjacentBombs());
			}

			squareGui.update(Square.CLICKED);
		}
		else if (button == RIGHT_CLICK_BUTTON) {
			if (board.getSquare(squareRow, squareColumn).getStatus() != Square.FLAGGED) {
				board.flagSquare(squareRow, squareColumn);
				squareGui.update(Square.FLAGGED);
			}
			else {
				board.unFlagSquare(squareRow, squareColumn);
				squareGui.update(Square.NOT_CLICKED);
			}
		}

		if (board.checkForWin()) {
			squareGui.update(GameBoard.GAME_WON);
		}
	}

	public void gameOver() {
		this.isGamePlaying = false;
	}

	public boolean isGamePlaying() {
		return this.isGamePlaying;
	}
}
