package rectangles;

import java.awt.Color;
import java.util.ArrayList;

public class Shikaku {

	// private State[][] grid;
	// private Number[] numberCells;

	public static Color[] colors = { Color.red, Color.blue, Color.gray,
			Color.green, Color.yellow, Color.orange, Color.pink, Color.cyan,
			Color.gray, Color.darkGray, Color.lightGray, Color.magenta };

	private ArrayList<Number> numberCells;

	private ButtonGrid buttonGrid;

	// public State[][] getGrid() {
	// return grid;
	// }
	//
	// public void setGrid(State[][] grid) {
	// this.grid = grid;
	// }

	// public Number[] getNumberCells() {
	// return numberCells;
	// }
	//
	// public void setNumberCells(Number[] numberCells) {
	// this.numberCells = numberCells;
	// }

	public ArrayList<Number> getNumberCells() {
		return numberCells;
	}

	public void setNumberCells(ArrayList<Number> numberCells) {
		this.numberCells = numberCells;
	}

	public int getLeftEmptySpace(int row, int column, int rows,
			boolean isCovered, Cell[][] grid) {
		int i = 0;
		try {
			for (i = 0;; i++) {
				// for (int j = 0; j < rows; j++) {

				// if (i + j != 0
				// && grid[row + j][column - i].isCovered() != isCovered) {
				// return i - 1;
				// }

				if (i != 0 && grid[row][column - i].isCovered() != isCovered)
					return i - 1;
				// }
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return i - 1;
		}
		// return i;

	}

	public int getTopEmptySpace(int row, int column, int columns,
			boolean isCovered, int leftSpace, Cell[][] grid) {
		int i = 0;
		try {
			for (i = 0;; i++) {
				for (int j = 0; j < columns; j++) {

					if ((i != 0 || j != leftSpace)
							&& grid[row - i][column + j - leftSpace]
									.isCovered() != isCovered) {
						return i - 1;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return i - 1;
		}
		// return i;

	}

	public boolean checkCovered(int row, int column, boolean isCovered,
			int rows, int columns, int leftSpace, int topspace, Cell[][] grid) {
		System.out.println("row " + row + ", column " + column + " ,rows "
				+ rows + " ,columns " + columns + " ,leftspace " + leftSpace);
		try {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if ((j != leftSpace || i != topspace)
							&& grid[row + i - topspace][column + j - leftSpace]
									.isCovered() != isCovered) {
						System.out.println("not matching for "
								+ (row + i - topspace) + " ,"
								+ (column + j - leftSpace) + " : " + i + " ,"
								+ j);
						return false;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println(e.getMessage());
			// e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cell[][] markCells(int row, int column, boolean mark, int rows,
			int columns, int leftSpace, int topSpace, /* Label[][] cells, */
			int numberIndex, Cell[][] grid) {
		Cell[][] newGrid = new Cell[grid.length][grid[0].length];

		// copy grid to new grid first

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				newGrid[i][j] = new Cell();
				newGrid[i][j].setColumns(grid[i][j].getColumns());
				newGrid[i][j].setRows(grid[i][j].getRows());
				newGrid[i][j].setNumber(grid[i][j].isNumber());
				newGrid[i][j].setNumber(grid[i][j].getNumber());
				newGrid[i][j].setCovered(grid[i][j].isCovered());
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				newGrid[row + i - topSpace][column + j - leftSpace]
						.setCovered(mark);
				// table.get
				// color the
				if (mark) {
					buttonGrid.grid[column + j - leftSpace][row + i - topSpace]
							.setBackground(colors[numberIndex]);
				} else {
					buttonGrid.grid[column + j - leftSpace][row + i - topSpace]
							.setBackground(Color.white);
				}
			}
		}
		return newGrid;
	}

	public Cell[][] generateData(int[][] cellEntries) {
		Cell[][] grid = new Cell[cellEntries.length][cellEntries[0].length];

		numberCells = new ArrayList<Number>();
		for (int i = 0; i < cellEntries.length; i++) {
			for (int j = 0; j < cellEntries[i].length; j++) {
				grid[i][j] = new Cell();
				if (cellEntries[i][j] != 0) {
					grid[i][j].setNumber(true);
					Number number = new Number(cellEntries[i][j], i, j);
					grid[i][j].setNumber(number);
					numberCells.add(number);
					grid[i][j].setCovered(true);
				} else {
					grid[i][j].setNumber(false);
					grid[i][j].setCovered(false);
				}
			}
		}
		// numberCells = new Number[numbersList.size()];
		// numberCells = numbersList.toArray(numberCells);

		System.out.println("-------------------------");
		printData(grid);
		// for (int i = 0; i < cellEntries.length; i++) {
		// System.out.println(numberCells[i]);
		// }

		// also instantiate colors list
		colors = new Color[numberCells.size()];

		for (int i = 0; i < numberCells.size(); i++)
			colors[i] = new Color((int) (Math.random() * 256),
					(int) (Math.random() * 256), (int) (Math.random() * 256));

		buttonGrid = new ButtonGrid(grid.length, grid[0].length, numberCells);

		return grid;
	}

	public void printData(Cell[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.println(grid[i][j]);
			}
		}
	}

	public Integer[] generateFactors(int number) {
		ArrayList<Integer> factorsList = new ArrayList<Integer>();
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				System.out.println("factors " + i);
				factorsList.add(i);
			}
		}
		Integer[] factors = new Integer[factorsList.size()];
		factors = factorsList.toArray(factors);
		return factors;
	}

	public void setButtonGrid(ButtonGrid buttonGrid) {
		this.buttonGrid = buttonGrid;
	}

	public ButtonGrid getButtonGrid() {
		return buttonGrid;
	}
}
