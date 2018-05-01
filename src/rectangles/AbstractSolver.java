package rectangles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AbstractSolver {

	public static int[][] readFromFile(int complexity, int problemNo) {
		File file = new File("." + File.separator + "input" + File.separator
				+ "grid" + complexity + problemNo);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// get size of the problem

		int row = scanner.nextInt();
		int column = scanner.nextInt();
		System.out.println("row " + row + column);

		int[][] grid = new int[row][column];

		int lineNumber = 0;
		while (scanner.hasNextInt()) {
			int newNumber = scanner.nextInt();
			grid[lineNumber / column][lineNumber % column] = newNumber;
			lineNumber++;

		}

		// while (scanner.hasNextLine()) {
		// String line = scanner.nextLine();
		// String[] numbers = line.split("\\s+");
		// System.out.println("size " + numbers.length + " " + line);
		// for (int i = 0; i < numbers.length; i++) {
		// grid[lineNumber][i] = Integer.parseInt(numbers[i]);
		// }
		// lineNumber++;
		//
		// }
		return grid;
	}

	public static int[][] readFromFile(String fileName) {
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// get size of the problem

		int row = scanner.nextInt();
		int column = scanner.nextInt();
		System.out.println("row " + row + column);

		int[][] grid = new int[row][column];

		int lineNumber = 0;
		while (scanner.hasNextInt()) {
			int newNumber = scanner.nextInt();
			grid[lineNumber / column][lineNumber % column] = newNumber;
			lineNumber++;

		}

		// while (scanner.hasNextLine()) {
		// String line = scanner.nextLine();
		// String[] numbers = line.split("\\s+");
		// System.out.println("size " + numbers.length + " " + line);
		// for (int i = 0; i < numbers.length; i++) {
		// grid[lineNumber][i] = Integer.parseInt(numbers[i]);
		// }
		// lineNumber++;
		//
		// }
		return grid;
	}
	
	
}
