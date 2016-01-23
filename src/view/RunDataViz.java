package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RunDataViz extends JFrame {

	private DataViz dataViz;
	
	public RunDataViz(String string) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screensize.getWidth() * 0.8;
		double screenHeight = screensize.getHeight() * 0.85;
		this.setSize((int) screenWidth, (int) screenHeight);
		this.setLocation(getInt(screenWidth), getInt(screenHeight));
		dataViz = new DataViz(string);
		this.add(dataViz);
	}

	public static void main(String[] args) {
		RunDataViz testData = new RunDataViz("query");
		testData.setVisible(true);
	}

	private int getInt(double number) {
		return (int) (number / 8);
	}
}
