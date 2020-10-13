import java.util.ArrayList;
import java.util.Random;

public class Game {

	static Window window;
	
	static ArrayList<Integer> actualAnswers;
	
	public static void main(String[] args) {
		
		window = new Window();
		actualAnswers = new ArrayList<Integer>();
	}
	
	
	
	public static boolean isValid(SudokuBox sb) {
		
		for(SudokuBox other: window.sudokuArray) {
			if(sb == other) {}
			else if(sb.getRow() == other.getRow()) {
				if(sb.getActual() == other.getActual() && other.getActual() != 0)
					return false;
			}
		    else if(sb.getColumn() == other.getColumn()) {
				if(sb.getActual() == other.getActual() && other.getActual() != 0)
					return false;
		    }
			else if(sb.getGroup() == other.getGroup()) {
				if(sb.getActual() == other.getActual() && other.getActual() != 0)
					return false;
			}
		}
		return true;
	}
	
	public static void createAnswers() {

		Random rand = new Random();
		int timesRan = 0;
		SudokuBox sb = null;
		SudokuBox sbMinus1 = null;
		boolean done = false;
		for(SudokuBox temp: window.sudokuArray)
			if(temp.getFirst())
				sb = temp;
		while(!done) {
			if(!sb.solved()) {	
				if(sb != null && sb.hasPrev())
					if(sb.getPrev().solved())
						sbMinus1 = sb.getPrev().getPrev();
					sbMinus1 = sb.getPrev();
				int randNum = rand.nextInt(9)+1;
				while(sb != null && sb.getUsedNums().contains(randNum)) {
					if(sb.getUsedNums().size() == 9) {
						sb.setActual(0);
						sb.clearUsedNums();
						if(sb.hasPrev()) {
							sbMinus1.setActual(0);
							sb = sbMinus1;
						}
					}
					else
						randNum = rand.nextInt(9)+1;
				}
				if(sb != null) {
					sb.setActual(randNum);
					timesRan++;
					if(timesRan%1000000 == 0)
						System.out.println(timesRan + " " + (sb.getRow()*3 + sb.getColumn()*3));
					if(isValid(sb)) {
						sb.getUsedNums().add(sb.getActual());
						if(sb.hasNext())
							sb = sb.getNext();
						else
							done = true;
					}
					else 
						sb.getUsedNums().add(sb.getActual());
				}
			}
			else
				sb = sb.getNext();
		}
		printAnswers();
	}
	
	public static void printAnswers() {
		
		for(SudokuBox sb: window.sudokuArray)
			actualAnswers.add(sb.getActual());
		for(int i = 0; i < 81; i++) {
			if(i%9 == 0)
				System.out.println();
			System.out.print(actualAnswers.get(i) + " ");
		}
	}
}
