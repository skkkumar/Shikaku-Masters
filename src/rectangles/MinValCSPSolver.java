package rectangles;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinValCSPSolver extends AbstractSolver {

	// private Label[][] cells;
	//
	// public Label[][] getCells() {
	// return cells;
	// }
	//
	// public void setCells(Label[][] cells) {
	// this.cells = cells;
	// }

	public MinValCSPSolver() {
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

	public static void main(String[] args) {
		MinValCSPSolver minSolver = new MinValCSPSolver();
		System.out.println(minSolver.solve(args[0]));
	}

	// public static void main(String[] args) {
	//
	// int problemNumber = 3;
	// MinValCSPSolver minSolver = new MinValCSPSolver();
	//
	// // Cell[][] grid = dfsSolver.shikaku.generateData(new int[][] {
	// // { 2, 0, 0, 3, 0 }, { 0, 0, 0, 4, 0 }, { 3, 0, 0, 2, 0 },
	// // { 0, 0, 4, 4, 0 }, { 0, 0, 3, 0, 0 } });
	//
	// System.out.println(minSolver.solve(1, problemNumber));
	// }

	public Result solve(int complexity, int problemNumber) {
		Cell[][] grid = shikaku.generateData(readFromFile(complexity,
				problemNumber));
		// dfsSolver.numberIndex = 0;

		return this.treeActionDFS(grid, new Result(false, 0));
	}

	public Result solve(String fileName) {
		Cell[][] grid = shikaku.generateData(readFromFile(fileName));
		return this.treeActionDFS(grid, new Result(false, 0));
	}

	public Result treeActionDFS(Cell[][] grid, Result result) {

		int numberIndex = getNumberForMinPossibilities(grid);

		if (numberIndex == -1) {
			// means there is a problem
			System.out.println("size " + shikaku.getNumberCells().size());
			// need to back track
			return result;

		}
		// get number for whioch there are min possibilities
		Number number = shikaku.getNumberCells().get(numberIndex);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + count);
		count++;
		System.out.println("we are currently dealing with no. " + number);
		// find factors of that number
		Integer[] factors = shikaku.generateFactors(number.getNumber());

		boolean levelSuccessful = false;

		// int numberOfNodesExpanded = 0;
		// for all possibilities see whether we can construct rectangle
		for (int i = 0; i < factors.length; i++) {

			int rowSize = factors[i];
			int columnSize = number.getNumber() / factors[i];
			System.out.println("considering factors " + rowSize + " & "
					+ columnSize);

			// consider space left to this cell
			int leftSpaces = shikaku.getLeftEmptySpace(number.getRow(),
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
				int topSpaces = shikaku.getTopEmptySpace(number.getRow(),
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

					if (shikaku.checkCovered(number.getRow(),
							number.getColumn(), false, rowSize, columnSize,
							columnSpace, rowSpace, grid)) {

						// take number out
						shikaku.getNumberCells().remove(numberIndex);

						result.incrementNumberOfNodesExpaned();
						System.out
								.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

						System.out.println("we can make rectangle of size "
								+ rowSize + " * " + columnSize + "  at "
								+ number.getRow() + "," + number.getColumn()
								+ " for number " + number.getNumber()
								+ " with left space " + columnSpace
								+ " and top space " + rowSpace);

						levelSuccessful = false;

						// then consider this possibility
						Cell[][] newGrid = shikaku.markCells(number.getRow(),
								number.getColumn(), true, rowSize, columnSize,
								columnSpace, rowSpace, numberIndex, grid);

						// shikaku.printData(grid);
						// try {
						// System.out.println("##########################################");
						// Thread.sleep(8000);
						// } catch (InterruptedException ex) {
						// Logger.getLogger(DFSSolver.class.getName()).log(Level.SEVERE,
						// null, ex);
						// }
						if (shikaku.getNumberCells().size() == 0) {
							result.setFound(true);
							return result;
						} else if (!levelSuccessful
								&& shikaku.getNumberCells().size() != 0) {
							// numberIndex++;
							// System.out.println("got next number "
							// + shikaku.getNumberCells().get(
							// numberIndex + 1));
							result = treeActionDFS(newGrid, result);
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

								// add number again

								shikaku.getNumberCells().add(number);
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

	public int getNumberForMinPossibilities(Cell[][] grid) {

		int minNumberIndex = -1;
		int minNumberCount = 10000;

		for (int numberIndex = 0; numberIndex < shikaku.getNumberCells().size(); numberIndex++) {

			int count = 0;

			// get first number
			Number number = shikaku.getNumberCells().get(numberIndex);
			Integer[] factors = shikaku.generateFactors(number.getNumber());

			// for all possibilities see whether we can construct rectangle
			for (int i = 0; i < factors.length; i++) {

				int rowSize = factors[i];
				int columnSize = number.getNumber() / factors[i];
				// System.out.println("considering factors " + rowSize + " & "
				// + columnSize);

				// consider space left to this cell
				int leftSpaces = shikaku.getLeftEmptySpace(number.getRow(),
						number.getColumn(), rowSize, false, grid);
				// System.out.println("left possible spaces = " + leftSpaces);

				// if leftspace is greater than the factor then make it factor
				// because we can't make rectangles whose column space is
				// greater
				// than factor
				if (leftSpaces >= columnSize) {
					leftSpaces = columnSize - 1;
				}
				for (int columnSpace = 0; columnSpace <= leftSpaces; columnSpace++) {

					// calculate top space
					// consider spaces to the top
					int topSpaces = shikaku.getTopEmptySpace(number.getRow(),
							number.getColumn(), columnSize, false, columnSpace,
							grid);
					// System.out.println("top possible spaces = " + topSpaces
					// + " for left space " + columnSpace);
					// if leftspace is greater than the factor then make it
					// factor
					// because we can't make rectangles whose row space is
					// greater
					// than factor
					if (topSpaces >= rowSize) {
						topSpaces = rowSize - 1;
					}

					for (int rowSpace = 0; rowSpace <= topSpaces; rowSpace++) {

						if (shikaku.checkCovered(number.getRow(),
								number.getColumn(), false, rowSize, columnSize,
								columnSpace, rowSpace, grid)) {
							count++;
						} else {
							// System.out.println("can't make rectangle");
						}
					}
				}
			}
			System.out.println("possibilities for " + number.getNumber()
					+ " is " + count);

			// make sure count is not zero
			if (count != 0 && count < minNumberCount) {
				minNumberCount = count;
				minNumberIndex = numberIndex;
			}
		}
		return minNumberIndex;
	}
}
