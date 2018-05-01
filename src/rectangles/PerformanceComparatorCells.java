package rectangles;

import org.jfree.ui.RefineryUtilities;

public class PerformanceComparatorCells {

	public static void main(String[] args) {

		int problemSize = 9;
		int complexitySize = 3;
		int[][] dataPoints1 = new int[complexitySize][problemSize];
		int[][] dataPoints2 = new int[complexitySize][problemSize];
		int[][] numbers = new int[complexitySize][problemSize];

		int problemNumber = 0;
		int complexityNumber = 0;

		for (complexityNumber = 0; complexityNumber < complexitySize; complexityNumber++) {

			for (problemNumber = 1; problemNumber <= problemSize; problemNumber++) {
				CSPSolver cspSolver = new CSPSolver();
				Result result = cspSolver
						.solve(complexityNumber, problemNumber);
				if (result.isFound())
					dataPoints1[complexityNumber][problemNumber - 1] = result
							.getNodesExpanded();
				else
					dataPoints1[complexityNumber][problemNumber - 1] = -1;

				numbers[complexityNumber][problemNumber - 1] = cspSolver
						.getShikaku().getNumberCells().size();
			}

			for (problemNumber = 1; problemNumber <= problemSize; problemNumber++) {
				try {
					MinValCSPSolver minSolver = new MinValCSPSolver();
					Result result = minSolver.solve(complexityNumber,
							problemNumber);
					if (result.isFound())
						dataPoints2[complexityNumber][problemNumber - 1] = result
								.getNodesExpanded();
					else
						dataPoints2[complexityNumber][problemNumber - 1] = -1;
				} catch (Exception e) {
					System.out.println("problem in number  " + problemNumber
							+ " " + complexityNumber);
					System.exit(0);
				}
			}
		}
		// final LineChartDemo demo = new LineChartDemo("Nodes expanded",
		// dataPoints1, dataPoints2);

		final LineChartDemo demo = new LineChartDemo("Nodes expanded versus no. of numbers in grid",
				dataPoints1[0], dataPoints2[0], dataPoints1[1], dataPoints2[1],
				dataPoints1[2], dataPoints2[2], numbers[0], numbers[1],
				numbers[2], "no. of numbers in the grid",
				"no. of nodes expanded");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
