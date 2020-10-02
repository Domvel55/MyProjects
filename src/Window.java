import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window {

	JFrame window;
	JPanel mainPane;
	
	ArrayList<ArrayList<JTextField>> sudokuArray;
	
	public Window() {
		
		window = new JFrame("Sudoku");
		mainPane = new JPanel();
		sudokuArray = new ArrayList<ArrayList<JTextField>>(10);
		for(int i = 0; i < 10; i++)
			sudokuArray.add(new ArrayList<JTextField>());
		
		createView();
	}
	
	public void createView() {
		
		Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
		
		window.setSize(new Dimension(600,600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		
		window.add(mainPane);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				JTextField temp = new JTextField();
				temp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(temp.getText() != null)
							System.out.println(temp.getText());
					}
				});
				mainPane.add(temp);
				temp.setSize(new Dimension(50,50));
				temp.setLocation(i*50, j*50);
				temp.setFont(font);
				temp.setHorizontalAlignment(JTextField.CENTER);
				sudokuArray.get(i).add(temp);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Window main = new Window();
	}
}
