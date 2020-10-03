import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class SudokuBox extends JTextField {

	int row;
	int column;
	int group;
	int number;
	
	ArrayList<Integer> rowNumbers;
	ArrayList<Integer> columnNumbers;
	ArrayList<Integer> groupNumbers;
	
	private Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
	
	public SudokuBox(int row, int column) {
		this.row = row;
		this.column = column;
		this.group = groupHelper();
		rowNumbers = new ArrayList<Integer>();
		columnNumbers = new ArrayList<Integer>();
		groupNumbers = new ArrayList<Integer>();
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
	
	public ArrayList<Integer> getRowNumbers() {
		return rowNumbers;
	}
	
	public ArrayList<Integer> getColumnNumbers() {
		return columnNumbers;
	}
	
	public ArrayList<Integer> getGroupNumbers(){
		return groupNumbers;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int groupHelper() {
		return column/3 + ((row/3)*3);
	}

	public void setSpecs(int i, int j) {
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Character.isDigit(getText().charAt(0)) && getText().length() == 1) {
					
					actionCalls();
				}
			}
		});
		setBounds(i*50, j*50, 45, 45);
		setFont(font);
		setHorizontalAlignment(JTextField.CENTER);
	}
	
	public void actionCalls() {
		
		setNumber(Integer.parseInt(getText()));
		System.out.println(getText());
		System.out.println(row + " " + column + " " + group);
		System.out.println(Game.isValid(Integer.parseInt(getText())));
		Game.setArrays(this);
	}
}
