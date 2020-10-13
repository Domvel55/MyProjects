import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	JFrame window;
	static JPanel mainPane;
	JButton solveButton;
	
	ArrayList<SudokuBox> sudokuArray;
	
	public Window() {
		
		mainPane = new JPanel();
		sudokuArray = new ArrayList<SudokuBox>();
		new Thread(new Updater()).start();
		createView();
	}
	
	public void createView() {
		
		setTitle("Sudoku");
		setSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		add(mainPane);
		buttons();
		boxes();
	}
	
	private void buttons() {
		
		solveButton = new JButton("Solve");
		solveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Game.createAnswers();
				displayAnswers();
			}
		});
		solveButton.setBounds(475, 100, 100, 25);
		solveButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		mainPane.add(solveButton);
	}
	
	private void boxes() {
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				SudokuBox temp = new SudokuBox(i, j);
				mainPane.add(temp);
				sudokuArray.add(temp);
				temp.setSpecs();
			}
		}
		nextAndPrevHelper();
	}
	
	private void nextAndPrevHelper(){
		
		SudokuBox temp = null;
		temp = finder(0, 0);
		temp.setFirst(true);
		for(int i = 1; i <= 81 ; i++) {
			if(!(temp.getRow() == 0 && temp.getColumn() == 0)) {
				if(temp.getColumn() == 0)
					temp.setPrev(finder(temp.getRow()-1, 8));
				else
					temp.setPrev(finder(temp.getRow(), temp.getColumn()-1));
			}
			if(!(temp.getRow() == 8 && temp.getColumn() == 8)) {
				if(temp.getColumn() == 8)
					temp.setNext(finder(temp.getRow()+1, 0));
				else
					temp.setNext(finder(temp.getRow(), temp.getColumn()+1));
			}
			temp = temp.getNext();
		}
	}
	
	private SudokuBox finder(int row, int column) {
		
		for(SudokuBox sb: sudokuArray)
			if(sb.getRow() == row && sb.getColumn() == column)
				return sb;
		return null;
	}
	
	private void displayAnswers() {
		
		for(SudokuBox sb: sudokuArray)
			sb.displayAnswer();
	}

	private void update() {
		
		repaint();
		for(SudokuBox sb: sudokuArray)
			sb.update();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		Line2D line = new Line2D.Float(156, 0, 156, 480);
		g2d.draw(line);
		line = new Line2D.Float(306, 0, 306, 480);
		g2d.draw(line);
		line = new Line2D.Float(0, 185, 450, 185);
		g2d.draw(line);
		line = new Line2D.Float(0, 335, 450, 335);
		g2d.draw(line);
	}
	
	class Updater implements Runnable{

		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					update();
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
