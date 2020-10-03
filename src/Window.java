import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	JFrame window;
	JPanel mainPane;
	
	ArrayList<SudokuBox> sudokuArray;
	
	public Window() {
		
		mainPane = new JPanel();
		sudokuArray = new ArrayList<SudokuBox>();
		createView();
	}
	
	public void createView() {
		
		setTitle("Sudoku");
		setSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		add(mainPane);
		boxes();
	}
	
	public void boxes() {
		
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				SudokuBox temp = new SudokuBox(j, i);
				mainPane.add(temp);
				temp.setSpecs(i, j);
				sudokuArray.add(temp);
			}
		}
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
}
