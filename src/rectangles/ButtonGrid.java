package rectangles;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonGrid {
	JFrame frame = new JFrame(); // creates frame
	JButton[][] grid; // names the grid of buttons

	public ButtonGrid(int width, int length, ArrayList<Number> numbers) { // constructor
		frame.setLayout(new GridLayout(width, length)); // set layout
		grid = new JButton[width][length]; // allocate the size of grid
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = new JButton("-"); // creates new button
				// change color
				// grid[x][y].setBackground(Color.blue);
				frame.add(grid[x][y]); // adds button to grid
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			grid[numbers.get(i).getColumn()][numbers.get(i).getRow()]
					.setText(numbers.get(i).getNumber() + "");
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // sets appropriate size for frame
		frame.setVisible(true); // makes frame visible

	}

	public static void main(String[] args) {
		// new ButtonGrid(3,3);//makes new ButtonGrid with 2 parameters
	}
}