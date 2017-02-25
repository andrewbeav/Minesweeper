import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperFrame extends JFrame {
	private MinesweeperPanel panel;
	private GameBoard board;

	private JLabel counterLabel;

	public MinesweeperFrame() {
		setTitle("Minesweeper");
		setSize(450, 450);
		
		int numOfBombs;
		while (true) {
			numOfBombs = Integer.parseInt(JOptionPane.showInputDialog("Number of Mines to Put On Board (# from 1 to 99, 10-20 recommended)"));
			if (numOfBombs >= 1 && numOfBombs < 100) break;
		}
		board = new GameBoard(numOfBombs);

		setLayout(new BorderLayout());

		panel = new MinesweeperPanel(this, board);
		add(panel, BorderLayout.CENTER);

		counterLabel = new JLabel("Bombs Remaining: " + numOfBombs);
		add(counterLabel, BorderLayout.PAGE_START);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void updateRemainingBombs(int bombsLeft) {
		this.counterLabel.setText("Bombs Remaining: " + bombsLeft);
	}
}
