package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class DataViz extends JPanel {

	private JPanel graphicalView, textView;
	private JLabel title;
	private BufferedImage worldBackground;
	private String query;
	private JButton queryButton;
	private JTabbedPane tabbedViews;

	// public static void main(String[] args) {
	// DataViz testData = new DataViz("cocaine");
	// // testData.setVisible(true);
	// }

	public DataViz(String searchQ) {
		query = searchQ;
		layoutGUI();
		registerListeners();
	}

	private void layoutGUI() {
		tabbedViews = new JTabbedPane();
		graphicalView = new JPanel();
		textView = new JPanel();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screensize.getWidth() * 0.8;
		double screenHeight = screensize.getHeight() * 0.7;
		this.setSize((int) screenWidth, (int) screenHeight);
		this.setLocation(getInt(screenWidth), getInt(screenHeight));
		this.setLayout(new GridBagLayout());

		Color lightBlue = new Color(0, 0, 182, 55);

		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.anchor = GridBagConstraints.NORTH;
		titleConstraints.gridx = 1;
		titleConstraints.gridy = 1;
		titleConstraints.gridheight = 1;
		titleConstraints.gridwidth = 1;
		titleConstraints.weightx = 1;

		// Create the document GUI
		title = new JLabel("Global Twitter Data Visualizaton for Query: " + query);
		title.setFont(new Font("default", Font.BOLD, 18));
		this.add(title, titleConstraints);

		// Create and add a panel to the document GUI
		worldBackground = null;
		try {
			worldBackground = ImageIO.read(new File("./src/view/World_Background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image background = worldBackground.getScaledInstance((int) screenWidth, (int) screenHeight, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(background);
		GridBagConstraints imageConstraints = new GridBagConstraints();
		imageConstraints.anchor = GridBagConstraints.CENTER;
		imageConstraints.gridx = 1;
		imageConstraints.gridy = 1;
		imageConstraints.gridheight = 1;
		imageConstraints.gridwidth = 1;
		imageConstraints.weighty = 0;
		graphicalView.add(new JLabel(imageIcon), imageConstraints);
		graphicalView.setBackground(lightBlue.darker()); // 195 - 25 - 90


		tabbedViews.add("Graphical Map", graphicalView);
		tabbedViews.add("Text Map", textView);
		this.add(tabbedViews, imageConstraints);

		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.anchor = GridBagConstraints.SOUTHEAST;
		buttonConstraints.gridx = 1;
		buttonConstraints.gridy = 1;
		buttonConstraints.gridheight = 1;
		buttonConstraints.gridwidth = 1;
		buttonConstraints.weighty = 1;
		queryButton = new JButton("New Search");

		this.add(queryButton, buttonConstraints);
		this.setVisible(true);
		repaint();

	}

	private int getInt(double number) {
		return (int) (number / 8);
	}

	private void registerListeners() {
		queryButton.addActionListener(new SearchQueryListener());
	}

	private class SearchQueryListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String newQuery = JOptionPane.showInputDialog("Please enter a new query to search for:");
			if (newQuery == null || newQuery.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter a query.");
				return;
			} else {
				title.setText("Global Twitter Data Visualizaton for Query: " + newQuery);
				repaint();
			}
		}

	}

}
