package rectangles;

/**
 * 
 * @author Sriram
 */
public class DFSState {

	public DFSState(Cell[][] grid, int rowSize, int columnSise,
			int numberIndex, int leftSpace, int topSpace, String numberIndexPath) {
		super();
		this.grid = grid;
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.numberIndex = numberIndex;
		this.leftSpace = leftSpace;
		this.topSpace = topSpace;
		this.numberIndexPath = numberIndexPath;
	}

	private Cell[][] grid;

	private int rowSize;
	private int columnSize;

	private int numberIndex;
	private int leftSpace;
	private int topSpace;
	private String numberIndexPath;

	public int getLeftSpace() {
		return leftSpace;
	}

	public void setLeftSpace(int leftSpace) {
		this.leftSpace = leftSpace;
	}

	public int getTopSpace() {
		return topSpace;
	}

	public void setTopSpace(int topSpace) {
		this.topSpace = topSpace;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public int getNumberIndex() {
		return numberIndex;
	}

	public void setNumberIndex(int numberIndex) {
		this.numberIndex = numberIndex;
	}

	public void setNumberIndexPath(String numberIndexPath) {
		this.numberIndexPath = numberIndexPath;
	}

	public String getNumberIndexPath() {
		return numberIndexPath;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int getColumnSize() {
		return columnSize;
	}
}
