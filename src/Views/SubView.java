package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.BaseController;

public class SubView extends JFrame{
	
	private JButton playerOffButton;
	private JButton playerOnButton;
	private JButton cancelButton;
	private JButton confirmButton;
	private static final int[] players = { 1, 4, 8, 9, 11, 13, 15, 16, 18, 19, 21};
	private ArrayList<JButton> playerButtons;
	private BaseController controller;
	private JPanel topPane;
	private JPanel middlePane;
	private JPanel bottomPane;
	private Handler handler;
	private int selected;
	private int pOff;
	private int pOn;
	
	public SubView(BaseController controller){
		super("Substitution");
		this.controller = controller;
		this.handler = new Handler();
		selected=-1;
		
		this.setPreferredSize(new Dimension(750,800));
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPane = new JPanel(new GridLayout(3, 4, 20, 20));
		middlePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		topPane.setPreferredSize(new Dimension(700, 330));
		middlePane.setPreferredSize(new Dimension(500, 330));
		bottomPane.setPreferredSize(new Dimension(500, 100));
		setupButtons();
		this.add(topPane);
		this.add(middlePane);
		this.add(bottomPane);
		this.pack();
		setVisible(true);
		
		
		this.setSize(750, 800);
		
	}
	
	private void setupButtons() {
		playerButtons = new ArrayList<JButton>(11);
		
		for(int i=0; i<11; i++) {
			playerButtons.add(new JButton(""+players[i]));
			playerButtons.get(i).setPreferredSize(new Dimension(80, 60));
			playerButtons.get(i).setEnabled(false);
			playerButtons.get(i).setBackground(Color.LIGHT_GRAY);
			middlePane.add(playerButtons.get(i));
			playerButtons.get(i).addActionListener(handler);
		}
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(handler);
		cancelButton.setEnabled(false);
		cancelButton.setPreferredSize(new Dimension(80, 60));
		middlePane.add(cancelButton);
		
		playerOffButton = new JButton();
		playerOnButton = new JButton();
		playerOffButton.addActionListener(handler);
		playerOnButton.addActionListener(handler);
		playerOffButton.setPreferredSize(new Dimension(150, 100));
		playerOnButton.setPreferredSize(new Dimension(150, 100));
		playerOffButton.setFont(new Font("Arial", Font.PLAIN, 40));
		playerOnButton.setFont(new Font("Arial", Font.PLAIN, 40));
		topPane.add(new JLabel("PLAYER OFF: "));
		topPane.add(playerOffButton);
		topPane.add(new JLabel("PLAYER ON: "));
		topPane.add(playerOnButton);
		
		
		confirmButton = new JButton("confirm");
		bottomPane.add(confirmButton);
		confirmButton.setEnabled(false);
		confirmButton.addActionListener(handler);
		confirmButton.setFont(new Font("Areial", Font.PLAIN, 25));
		confirmButton.setPreferredSize(new Dimension(125, 60));
		
		

	}
	
	
	class Handler implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==playerOffButton) {
				playerOffButton.setEnabled(false);
				playerOnButton.setEnabled(false);
				selected = 1;//playeroff
				for(JButton b : playerButtons) {
					if(Integer.parseInt(b.getText())!=pOn || Integer.parseInt(b.getText())!=pOff) {
						b.setEnabled(true);
						b.setBackground(null);
					}
				}
				cancelButton.setEnabled(true);
				
			}
			else if(e.getSource()==playerOnButton) {
				playerOffButton.setEnabled(false);
				playerOnButton.setEnabled(false);
				selected = 2;//PLayerOn
				for(JButton b : playerButtons) {
					if(Integer.parseInt(b.getText())!=pOn || Integer.parseInt(b.getText())!=pOff) {
						b.setEnabled(true);
						b.setBackground(null);
					}
				}
				cancelButton.setEnabled(true);
			}
			else if(playerButtons.contains(e.getSource())) {
				playerOffButton.setEnabled(true);
				playerOnButton.setEnabled(true);
				for(JButton b : playerButtons) {
					b.setEnabled(false);
					b.setBackground(Color.LIGHT_GRAY);
				}
				cancelButton.setEnabled(false);
				if(selected == 1) {
					pOff=Integer.parseInt(((AbstractButton) e.getSource()).getText());
					playerOffButton.setText(pOff+"");
				}
				else if(selected==2) {
					pOn=Integer.parseInt(((AbstractButton) e.getSource()).getText());
					playerOnButton.setText(pOn+"");
				}
				selected=-1;
				if(pOn!=-1&&pOff!=-1) {
					confirmButton.setEnabled(true);
				}
			}
			else if(e.getSource()==cancelButton) {
				playerOffButton.setEnabled(true);
				playerOnButton.setEnabled(true);
				for(JButton b : playerButtons) {
					b.setEnabled(false);
					b.setBackground(Color.LIGHT_GRAY);
				}
				
				cancelButton.setEnabled(false);
			}
			else if(e.getSource()==confirmButton) {
				controller.saveSub(pOff, pOn);
				setVisible(false);
			}
		}
		
	}
}
