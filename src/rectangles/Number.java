package rectangles;

import java.util.Comparator;

public class Number extends Object implements Comparable {
	@Override
	public String toString() {
		return "Number [number=" + number + ", row=" + row + ", column="
				+ column + "]";
	}

	Number(int number, int row, int column) {
		this.number = number;
		this.row = row;
		this.column = column;
	}

	public Number() {
		// TODO Auto-generated constructor stub
	}

	private int number;
	private int row;
	private int column;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int compareTo(Object arg1) {
		Number number = (Number) arg1;
		if (this.number > number.number)
			return -1;
		else if (number.number > this.number)
			return 1;
		else
			return 0;

	}
	
	 public Number clone(){
	        Number number = new Number();
	        number.number = this.number;
	        number.column = this.column;
	        number.row = this.row;
	        
	        return number;
	    }
}
