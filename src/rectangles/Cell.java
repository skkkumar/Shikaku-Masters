package rectangles;

public class Cell {
	@Override
	public String toString() {
		return "State [isNumber=" + isNumber + ", number=" + number + ", rows="
				+ rows + ", columns=" + columns + ", isCovered=" + isCovered
				+ "]";
	}

	private boolean isNumber;
	private Number number;
	private int rows;
	private int columns;
	private boolean isCovered;

	public boolean isNumber() {
		return isNumber;
	}

	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}

	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public boolean isCovered() {
		return isCovered;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

}
