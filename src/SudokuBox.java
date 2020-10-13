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
	int actual;
	
	boolean first;
	boolean solved;
	
	ArrayList<Integer> usedNums;
	
	SudokuBox prev;
	SudokuBox next;
	
	private Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
	
	public SudokuBox(int row, int column) {
		this.row = row;
		this.column = column;
		this.group = groupHelper();
		number = 0;
		actual = 0;
		usedNums = new ArrayList<Integer>();
		solved = false;
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
	
	public int getActual() {
		return actual;
	}
	
	public SudokuBox getPrev() {
		return prev;
	}
	
	public SudokuBox getNext() {
		return next;
	}
	
	public boolean getFirst() {
		return first;
	}
	
	public int getBoxNumber() {
		return row*9 + column;
	}
	
	public boolean solved() {
		return solved;
	}
	
	public ArrayList<Integer> getUsedNums(){
		return usedNums;
	}
	
	public void setPrev(SudokuBox prev) {
		this.prev = prev;
	}

	public void setNext(SudokuBox next) {
		this.next = next;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setActual(int actual) {
		this.actual = actual;
	}
	
	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public boolean hasPrev() {
		return prev != null ? true : false;
	}
	
	public boolean hasNext() {
		return next != null ? true : false;
	}
	
	public void clearUsedNums() {
		usedNums.clear();
	}
	
	public int groupHelper() {
		return column/3 + ((row/3)*3);
	}
	
	public void displayAnswer() {
		setText("" + actual);
	}
	
	private void correctAnswer() {
		
		solved = true;
		Window.mainPane.remove(this);
		AnswerLabel temp = new AnswerLabel(row, column, group, actual);
		temp.setSpecs();
	}
	
	public void update() {
		
		if(getText().length() == 1 && Character.isDigit(getText().charAt(0))) {
			int temp = Integer.parseInt(getText());
			if(actual == 0)
				actual = temp;
			else if(temp == actual)
				correctAnswer();
			else
				setText("");
			
		}
		if(getText().length() == 1 && Integer.parseInt(getText()) == 0) {
			number = 0;
			setText("");
		}
	}

	public void setSpecs() {
		setBounds(column*50, row*50, 45, 45);
		setFont(font);
		setHorizontalAlignment(JTextField.CENTER);
	}
}
