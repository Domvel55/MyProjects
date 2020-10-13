import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AnswerLabel extends JLabel {

	int row;
	int column;
	int group;
	int number;
	
	private Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
	
	public AnswerLabel(int row, int column, int group, int number) {
		
		this.row = row;
		this.column = column;
		this.group = group;
		this.number = number;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getGroup() {
		return group;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setSpecs() {
		
		setBounds(column*50, row*50, 45, 45);
		setFont(font);
		setHorizontalAlignment(JTextField.CENTER);
		setText("" + number);
		Window.mainPane.add(this);
	}
}
