import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class SudokuBox extends JTextField {

	private int row;
	private int column;
	
	private Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
	
	public SudokuBox(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setSpecs(int i, int j) {
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Character.isDigit(getText().charAt(0)) && getText().length() == 1)
						System.out.println(getText());
				System.out.println(row + " " + column);
			}
		});
		setBounds(i*50, j*50, 45, 45);
		setFont(font);
		setHorizontalAlignment(JTextField.CENTER);
	}
}
