package rectangles;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 * 
 */
public class LineChartDemo extends ApplicationFrame {

	/**
	 * Creates a new demo.
	 * 
	 * @param title
	 *            the frame title.
	 */
	public LineChartDemo(final String title, int[] dataPoints1,
			int[] dataPoints2, String xLabel, String yLabel) {

		super(title);
		final XYDataset dataset = createDataset(dataPoints1, dataPoints2);
		final JFreeChart chart = createChart(dataset, xLabel, yLabel, title);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	}

	public LineChartDemo(final String title, int[] dataPoints1,
			int[] dataPoints2, int[] dataPoints3, int[] dataPoints4,
			int[] dataPoints5, int[] dataPoints6, String xLabel, String yLabel) {

		super(title);
		final XYDataset dataset = createDataset(dataPoints1, dataPoints2,
				dataPoints3, dataPoints4, dataPoints5, dataPoints6);
		final JFreeChart chart = createChart(dataset, xLabel, yLabel, title);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	}

	public LineChartDemo(final String title, int[] dataPoints1,
			int[] dataPoints2, int[] dataPoints3, int[] dataPoints4,
			int[] dataPoints5, int[] dataPoints6, int[] numbers1,
			int[] numbers2, int[] numbers3, String xLabel, String yLabel) {

		super(title);
		final XYDataset dataset = createDataset(dataPoints1, dataPoints2,
				dataPoints3, dataPoints4, dataPoints5, dataPoints6, numbers1,
				numbers2, numbers3);
		final JFreeChart chart = createChart(dataset, xLabel, yLabel, title);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private XYDataset createDataset(int[] dataPoints1, int[] dataPoints2) {

		final XYSeries series1 = new XYSeries("CSP");
		for (int i = 0; i < dataPoints1.length; i++)
			series1.add(i + 1, dataPoints1[i]);

		final XYSeries series2 = new XYSeries("Minimum Value heuristic CSP");
		for (int i = 0; i < dataPoints2.length; i++)
			series2.add(i + 1, dataPoints2[i]);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		return dataset;

	}

	private XYDataset createDataset(int[] dataPoints1, int[] dataPoints2,
			int[] dataPoints3, int[] dataPoints4, int[] dataPoints5,
			int[] dataPoints6) {

		final XYSeries series1 = new XYSeries("CSP - 1");
		for (int i = 0; i < dataPoints1.length; i++)
			series1.add(i + 1, dataPoints1[i]);

		final XYSeries series2 = new XYSeries("Minimum Value heuristic CSP - 1");
		for (int i = 0; i < dataPoints2.length; i++)
			series2.add(i + 1, dataPoints2[i]);

		final XYSeries series3 = new XYSeries("CSP - 2");
		for (int i = 0; i < dataPoints3.length; i++)
			series3.add(i + 1, dataPoints3[i]);
		final XYSeries series4 = new XYSeries("Minimum Value heuristic CSP - 2");
		for (int i = 0; i < dataPoints4.length; i++)
			series4.add(i + 1, dataPoints4[i]);
		final XYSeries series5 = new XYSeries("CSP - 3");
		for (int i = 0; i < dataPoints5.length; i++)
			series5.add(i + 1, dataPoints5[i]);
		final XYSeries series6 = new XYSeries("Minimum Value heuristic CSP - 3");
		for (int i = 0; i < dataPoints6.length; i++)
			series6.add(i + 1, dataPoints6[i]);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);
		dataset.addSeries(series5);
		dataset.addSeries(series6);

		return dataset;

	}

	private XYDataset createDataset(int[] dataPoints1, int[] dataPoints2,
			int[] dataPoints3, int[] dataPoints4, int[] dataPoints5,
			int[] dataPoints6, int[] numbers1, int[] numbers2, int[] numbers3) {

		final XYSeries series1 = new XYSeries("CSP - 1");
		for (int i = 0; i < dataPoints1.length; i++)
			series1.add(numbers1[i], dataPoints1[i]);

		final XYSeries series2 = new XYSeries("Minimum Value heuristic CSP - 1");
		for (int i = 0; i < dataPoints2.length; i++)
			series2.add(numbers1[i], dataPoints2[i]);

		final XYSeries series3 = new XYSeries("CSP - 2");
		for (int i = 0; i < dataPoints3.length; i++)
			series3.add(numbers2[i], dataPoints3[i]);
		final XYSeries series4 = new XYSeries("Minimum Value heuristic CSP - 2");
		for (int i = 0; i < dataPoints4.length; i++)
			series4.add(numbers2[i], dataPoints4[i]);
		final XYSeries series5 = new XYSeries("CSP - 3");
		for (int i = 0; i < dataPoints5.length; i++)
			series5.add(numbers3[i], dataPoints5[i]);
		final XYSeries series6 = new XYSeries("Minimum Value heuristic CSP - 3");
		for (int i = 0; i < dataPoints6.length; i++)
			series6.add(numbers3[i], dataPoints6[i]);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);
		dataset.addSeries(series5);
		dataset.addSeries(series6);

		return dataset;

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final XYDataset dataset, String xLabel,
			String yLabel, String title) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createXYLineChart(title, // chart
																		// title
				xLabel, // x axis label
				yLabel, // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.white);

		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		// legend.setDisplaySeriesShapes(true);

		// get a reference to the plot for further customisation...
		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, false);
		renderer.setSeriesShapesVisible(1, false);
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

	}

	/**
	 * Starting point for the demonstration application.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(final String[] args) {

		final LineChartDemo demo = new LineChartDemo("Line Chart Demo 6",
				new int[] { 1, 2, 3 }, new int[] { 6, 5, 4 }, "x", "y");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}