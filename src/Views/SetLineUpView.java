package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import Controllers.LineUpController;
import Controllers.BaseController;
import java.util.ArrayList;

public class SetLineUpView extends JFrame {
	
	private static final int[] players = { 1, 4, 8, 9, 11, 13, 15, 16, 18, 19, 21};
	private static final String[] positions = { "1", "2", "3", "4", "5", "6" };
	
	private ArrayList<Integer> currentLineUp;
	
	private JPanel lineUpPane;
	private JPanel playerPane;
	private JPanel confirmPane;
	private ArrayList<JButton> lineUpButtons;
	private ArrayList<JButton> playerButtons;
	private JButton confirmButton;
	private JButton cancelButton;
	private JComboBox setterPosDropDown;
	private BaseController controller;
	private JTextField nameField;
	
	private Handler handler;
	
	public SetLineUpView(BaseController controller) {
		super("Set Line Up");
		this.controller = controller;
		this.handler = new Handler();
		
		currentLineUp = new ArrayList<Integer>(7);
		
		this.setPreferredSize(new Dimension(750,800));
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lineUpPane = new JPanel(new GridLayout(3, 4, 20, 20));
		playerPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		confirmPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		lineUpPane.setPreferredSize(new Dimension(700, 330));
		playerPane.setPreferredSize(new Dimension(500, 330));
		confirmPane.setPreferredSize(new Dimension(500, 100));
		setupButtons();
		this.add(lineUpPane);
		this.add(playerPane);
		this.add(confirmPane);
		this.pack();
		setVisible(true);
			
	}
	
	private void setupButtons() {
		playerButtons = new ArrayList<JButton>(11);
		lineUpButtons = new ArrayList<JButton>(7);
		
		//setup player list stuff
		for(int i=0; i<11; i++) {
			playerButtons.add(new JButton(""+players[i]));
			playerButtons.get(i).setPreferredSize(new Dimension(80, 60));
			playerButtons.get(i).setEnabled(false);
			playerButtons.get(i).setBackground(Color.LIGHT_GRAY);
			playerPane.add(playerButtons.get(i));
			playerButtons.get(i).addActionListener(handler);
		}
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(handler);
		cancelButton.setEnabled(false);
		cancelButton.setPreferredSize(new Dimension(80, 60));
		playerPane.add(cancelButton);
		
		//Setup Lineup stuff
		for(int i=0; i<7; i++) {
			lineUpButtons.add(new JButton());
			lineUpButtons.get(i).addActionListener(handler);
			currentLineUp.add(i, -1);
		}
				
		lineUpPane.add(lineUpButtons.get(3));
		lineUpPane.add(lineUpButtons.get(2));
		lineUpPane.add(lineUpButtons.get(1));
		lineUpPane.add(lineUpButtons.get(4));
		lineUpPane.add(lineUpButtons.get(5));
		lineUpPane.add(lineUpButtons.get(0));
		lineUpPane.add(new JLabel("Libero: ", SwingConstants.RIGHT));
		lineUpPane.add(lineUpButtons.get(6));
		
		
		for(JButton b : lineUpButtons) {
			
			b.addActionListener(null);
		}
		
		//Misc stuff in confirmPane
		confirmPane.add(new JLabel("Setter Starting Position:"));
		
		setterPosDropDown = new JComboBox(positions);
		confirmPane.add(setterPosDropDown);
		setterPosDropDown.setPreferredSize(new Dimension(125, 60));
		setterPosDropDown.setFont(new Font("Arial", Font.PLAIN, 40));
		
		
		
		confirmButton = new JButton("confirm");
		confirmPane.add(confirmButton);
		confirmButton.setEnabled(false);
		confirmButton.addActionListener(handler);
		confirmButton.setFont(new Font("Areial", Font.PLAIN, 25));
		confirmButton.setPreferredSize(new Dimension(125, 60));
		
		//nameField stuff
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(300, 50));
		nameField.setFont(new Font("Arial", Font.PLAIN, 30));
		playerPane.add(nameField);
		
		
	}
	
	
	class Handler implements ActionListener{
		
		private int selected=-1;
		public void actionPerformed(ActionEvent e) {
			
			if(lineUpButtons.contains(e.getSource())) {
				System.out.println("LineUP");
				lineUpButtonPress(e);
				selected = lineUpButtons.indexOf(e.getSource());
				System.out.println(selected);
			}
			else if(playerButtons.contains(e.getSource())) {
				System.out.println("Player");
				playerButtonPress(((AbstractButton) e.getSource()).getText());
			}
			else if(e.getSource()==confirmButton) {
				confirmLineUp();
			}
			else if(e.getSource()==cancelButton) {
				cancelButtonPress();
			}			
		}
		
		private void cancelButtonPress() {
			for(JButton b : lineUpButtons) {
				b.setEnabled(true);
				b.setBackground(null);
			}
			
			for(JButton b : playerButtons) {
				b.setEnabled(false);
				b.setBackground(Color.LIGHT_GRAY);
			}
			
			cancelButton.setEnabled(false);
		
		}
		
		private void lineUpButtonPress(ActionEvent e) {
			for(JButton b:lineUpButtons) {
				b.setEnabled(false);
				if(e.getSource()!=b)
					b.setBackground(Color.gray);
				else
					b.setBackground(Color.white);
			}
			
			for(JButton b : playerButtons) {
				if(!currentLineUp.contains(Integer.parseInt(b.getText()))) {
					b.setEnabled(true);
					b.setBackground(null);
				}
			}
			
			cancelButton.setEnabled(true);
		}
		
		private void playerButtonPress(String buttonText) {
			for(JButton b:lineUpButtons) {
				b.setEnabled(true);
				b.setBackground(null);
				if(lineUpButtons.indexOf(b)==selected) {
					b.setText(buttonText);
					b.setFont(new Font("Arial", Font.PLAIN, 30));
				}
			}
			currentLineUp.set(selected, Integer.parseInt(buttonText));
			for(JButton b: playerButtons) {
				b.setEnabled(false);
				b.setBackground(Color.LIGHT_GRAY);
			}
			if(!currentLineUp.contains(-1) && !nameField.getText().equals(""))
				confirmButton.setEnabled(true);
			cancelButton.setEnabled(false);
		}
		
		private void confirmLineUp() {
			controller.addLineUp(currentLineUp, Integer.parseInt((String) setterPosDropDown.getSelectedItem()), nameField.getText());
			setVisible(false);
		}
		
	}//end of handler class
	
}
