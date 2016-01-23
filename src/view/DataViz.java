package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DataViz extends JFrame {
	private JPanel thePanel;
	private BufferedImage worldBackground;
	private String query;

	public static void main(String[] args) {
		DataViz testData = new DataViz("cocaine");
	}

	public DataViz(String searchQ) {
		query = searchQ;
		layoutGUI();
		registerListeners();
	}

	private void layoutGUI() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screensize.getWidth() * 0.8;
		double screenHeight = screensize.getHeight() * 0.7;
		this.setSize((int) screenWidth, (int) screenHeight);
		// Create the document GUI
		this.setTitle("Global Twitter Data Visualizaton for Query: " + query);
		this.setLocation(getInt(screenWidth), getInt(screenHeight));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		// Create and add a panel to the document GUI
		thePanel = new JPanel();
		thePanel.setLayout(null);

		worldBackground = null;
		try {
			worldBackground = ImageIO.read(new File("./src/view/World_Background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image background = worldBackground.getScaledInstance((int) screenWidth, (int) screenHeight, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(background);
//		this.setContentPane(new JLabel(imageIcon));

		this.add(thePanel);
		this.setVisible(true);

	}

	private int getInt(double number) {
		return (int) (number / 8);
	}

	private void registerListeners() {

	}

}
