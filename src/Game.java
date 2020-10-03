import java.util.ArrayList;

public class Game {

	static Window window;
	
	ArrayList<Integer> actualAnswer;
	
	public static void main(String[] args) {
		
		window = new Window();
	}
	
	public static boolean isValid(int num) {
		
		for(SudokuBox sb: window.sudokuArray) {
			if(sb.getRowNumbers().contains(num))
				return false;
			if(sb.getColumnNumbers().contains(num))
				return false;
			if(sb.getGroupNumbers().contains(num))
				return false;
		}
		return true;
	}
	
	public static void setArrays(SudokuBox sb) {
		
		for(SudokuBox other: window.sudokuArray) {
			if(sb.getColumn() == other.getColumn() 
					&& !(sb.getColumnNumbers().contains(other.getNumber())))
				sb.getColumnNumbers().add(other.getNumber());
			if(sb.getRow() == other.getRow() 
					&& !(sb.getRowNumbers().contains(other.getNumber())))
				sb.getRowNumbers().add(other.getNumber());
			if(sb.getGroup() == other.getGroup() 
					&& !(sb.getGroupNumbers().contains(other.getNumber())))
				sb.getGroupNumbers().add(other.getGroup());
		}
	}
}
