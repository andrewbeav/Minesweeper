import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperFrame extends JFrame {
	private MinesweeperPanel panel;
	private GameBoard board;

	public MinesweeperFrame() {
		setTitle("Minesweeper");
		setSize(450, 450);
		
		int numOfBombs;
		while (true) {
			numOfBombs = Integer.parseInt(JOptionPane.showInputDialog("Number of Bombs (# from 1 to 99)"));
			if (numOfBombs >= 1 && numOfBombs < 100) break;
		}
		board = new GameBoard(numOfBombs);

		panel = new MinesweeperPanel(board);
		add(panel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
