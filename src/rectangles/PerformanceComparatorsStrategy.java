package rectangles;

import org.jfree.ui.RefineryUtilities;

public class PerformanceComparatorsStrategy {

	public static void main(String[] args) {

		int problemSize = 8;
		int[] dataPoints1 = new int[problemSize];
		int[] dataPoints2 = new int[problemSize];

		int problemNumber = 0;
		int complexityNumber = 0;

		for (problemNumber = 1; problemNumber <= problemSize; problemNumber++) {
			CSPSolver cspSolver = new CSPSolver();
			Result result = cspSolver.solve(complexityNumber, problemNumber);
			if (result.isFound())
				dataPoints1[problemNumber - 1] = result.getNodesExpanded();
			else
				dataPoints1[problemNumber - 1] = -1;
		}

		for (problemNumber = 1; problemNumber <= problemSize; problemNumber++) {
			try {
				MinValCSPSolver minSolver = new MinValCSPSolver();
				Result result = minSolver
						.solve(complexityNumber, problemNumber);
				if (result.isFound())
					dataPoints2[problemNumber - 1] = result.getNodesExpanded();
				else
					dataPoints2[problemNumber - 1] = -1;
			} catch (Exception e) {
				System.out.println("problem in number  " + problemNumber + " "
						+ complexityNumber);
				System.exit(0);
			}

		}
		// final LineChartDemo demo = new LineChartDemo("Nodes expanded",
		// dataPoints1, dataPoints2);

		final LineChartDemo demo = new LineChartDemo("Nodes expanded for different sample",
				dataPoints1, dataPoints2, "sample no.", "no. of nodes expanded");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
