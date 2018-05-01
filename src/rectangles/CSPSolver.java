package rectangles;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSPSolver extends AbstractSolver {

	// private Label[][] cells;
	//
	// public Label[][] getCells() {
	// return cells;
	// }
	//
	// public void setCells(Label[][] cells) {
	// this.cells = cells;
	// }

	public CSPSolver() {
		// shikaku = new Shikaku();
		// numberIndex = 0;

	}

	// private Shikaku shikaku;

	// public Shikaku getShikaku() {
	// return shikaku;
	// }
	//
	// public void setShikaku(Shikaku shikaku) {
	// this.shikaku = shikaku;
	// }
	// public int getNumberIndex() {
	// return numberIndex;
	// }
	//
	// public void setNumberIndex(int numberIndex) {
	// this.numberIndex = numberIndex;
	// }
	// private int numberIndex;

	private Shikaku shikaku = new Shikaku();

	private int count;

	// public static void main(String[] args) {
	//
	// int problemNumber = 3;
	// CSPSolver cspSolver = new CSPSolver();
	// System.out.println(cspSolver.solve(1, problemNumber));
	// }

	public static void main(String[] args) {
		CSPSolver cspSolver = new CSPSolver();
		System.out.println(cspSolver.solve(args[0]));
	}

	public Result solve(String fileName) {
		Cell[][] grid = getShikaku().generateData(readFromFile(fileName));
		return this.treeActionDFS(grid, 0, new Result(false, 0));
	}

	public Result solve(int complexity, int problemNumber) {
		Cell[][] grid = getShikaku().generateData(
				readFromFile(complexity, problemNumber));
		// dfsSolver.numberIndex = 0;

		return this.treeActionDFS(grid, 0, new Result(false, 0));
	}

	public Result treeActionDFS(Cell[][] grid, int numberIndex, Result result) {
		// get first number
		Number number = getShikaku().getNumberCells().get(numberIndex);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + count);
		count++;
		System.out.println("we are currently dealing with no. " + number);
		// find factors of that number
		Integer[] factors = getShikaku().generateFactors(number.getNumber());

		boolean levelSuccessful = false;

		// int numberOfNodesExpanded = 0;
		// for all possibilities see whether we can construct rectangle
		for (int i = 0; i < factors.length; i++) {

			int rowSize = factors[i];
			int columnSize = number.getNumber() / factors[i];
			System.out.println("considering factors " + rowSize + " & "
					+ columnSize);

			// consider space left to this cell
			int leftSpaces = getShikaku().getLeftEmptySpace(number.getRow(),
					number.getColumn(), rowSize, false, grid);
			System.out.println("left possible spaces = " + leftSpaces);

			// if leftspace is greater than the factor then make it factor
			// because we can't make rectangles whose column space is greater
			// than factor
			if (leftSpaces >= columnSize) {
				leftSpaces = columnSize - 1;
			}
			for (int columnSpace = 0; columnSpace <= leftSpaces; columnSpace++) {

				// calculate top space
				// consider spaces to the top
				int topSpaces = getShikaku().getTopEmptySpace(number.getRow(),
						number.getColumn(), columnSize, false, columnSpace,
						grid);
				System.out.println("top possible spaces = " + topSpaces
						+ " for left space " + columnSpace);
				// if leftspace is greater than the factor then make it factor
				// because we can't make rectangles whose row space is greater
				// than factor
				if (topSpaces >= rowSize) {
					topSpaces = rowSize - 1;
				}

				for (int rowSpace = 0; rowSpace <= topSpaces; rowSpace++) {

					if (getShikaku().checkCovered(number.getRow(),
							number.getColumn(), false, rowSize, columnSize,
							columnSpace, rowSpace, grid)) {

						result.incrementNumberOfNodesExpaned();

						System.out.println("we can make rectangle of size "
								+ rowSize + " * " + columnSize + "  at "
								+ number.getRow() + "," + number.getColumn()
								+ " for number " + number.getNumber()
								+ " with left space " + columnSpace
								+ " and top space " + rowSpace);

						levelSuccessful = false;

						// then consider this possibility
						Cell[][] newGrid = getShikaku().markCells(
								number.getRow(), number.getColumn(), true,
								rowSize, columnSize, columnSpace, rowSpace,
								numberIndex, grid);

						// shikaku.printData(grid);
						// try {
						// System.out.println("##########################################");
						// Thread.sleep(8000);
						// } catch (InterruptedException ex) {
						// Logger.getLogger(DFSSolver.class.getName()).log(Level.SEVERE,
						// null, ex);
						// }
						if (numberIndex == getShikaku().getNumberCells().size() - 1) {
							result.setFound(true);
							return result;
						} else if (!levelSuccessful
								&& numberIndex < getShikaku().getNumberCells()
										.size() - 1) {
							// numberIndex++;
							System.out.println("got next number "
									+ getShikaku().getNumberCells().get(
											numberIndex + 1));
							result = treeActionDFS(newGrid, numberIndex + 1,
									result);
							boolean found = result.isFound();

							System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");

							if (found) {

								levelSuccessful = true;
								return result;

							} else {

								// undo move
								levelSuccessful = false;
								// shikaku.markCells(number.getRow(),
								// number.getColumn(), false, rowSize,
								// columnSize, columnSpace, rowSpace, cells,
								// numberIndex - 1);
							}
							// if reached end and final success value is true
							// then return
						}

					} else {
						System.out.println("can't make rectangle");
					}
				}
			}
		}

		// no need to consider spaces to the right

		return result;
	}

	public void setShikaku(Shikaku shikaku) {
		this.shikaku = shikaku;
	}

	public Shikaku getShikaku() {
		return shikaku;
	}
}
