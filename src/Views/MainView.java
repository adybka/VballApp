package Views;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controllers.BaseController;
//import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class MainView extends JFrame{ 
	
	private BaseController baseController;
	
	private JScrollPane historyPanel;
	private JPanel menuPanel;
	private JPanel inputPanel;
	
	private JButton[] receiveTypeButtons;
	private JButton[] ReceivingPlayer;
	
	public MainView(BaseController base) {
		super("Stat Track");
		this.baseController = base;
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1250,1000));
		
		setUpFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setUpButtons();
		ReceiveTypeButtons();
		setVisible(true);
	}
	
	private void ReceiveTypeButtons() {
		for(JButton b: receiveTypeButtons) {
			b.setVisible(true);
		}
	}
	

	
	private void setUpFrame() {
		historyPanel = new JScrollPane();
		menuPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new FlowLayout());
		
		historyPanel.setPreferredSize(new Dimension(1210, 500));
		menuPanel.setPreferredSize(new Dimension(230, 490));
		inputPanel.setPreferredSize(new Dimension(980, 490));	
		
		historyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		historyPanel.setBackground(Color.white);	
		menuPanel.setBackground(Color.white);	
		inputPanel.setBackground(Color.white);			
		
		historyPanel.add(new JLabel("HISTORY PANEL"));
		menuPanel.add(new JLabel("Menu Panel"));
		
		
		this.add(historyPanel);
		this.add(menuPanel);
		this.add(inputPanel);
		
	}
	
	
	private void setUpButtons() {
		Dimension d = new Dimension(150, 75);
		//RecieveType
		receiveTypeButtons = new JButton[10];
		receiveTypeButtons[0] = new JButton("S");
		receiveTypeButtons[1] = new JButton("F");
		receiveTypeButtons[2] = new JButton("O");
		receiveTypeButtons[3] = new JButton("L");
		receiveTypeButtons[4] = new JButton("M");
		receiveTypeButtons[5] = new JButton("R");
		receiveTypeButtons[6] = new JButton("D");
		receiveTypeButtons[7] = new JButton("A");
		receiveTypeButtons[8] = new JButton("P");
		receiveTypeButtons[9] = new JButton("C");
		
		for(JButton b: receiveTypeButtons) {
			b.setPreferredSize(d);
			b.setFont(new Font("Arial", Font.PLAIN, 40));
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					baseController.addToPossessionChar("ReceiveType", b.getText().charAt(0));
				}
			});
			inputPanel.add(b);
			b.setVisible(true);
		}
		
		//
		

	}
	
	
}
