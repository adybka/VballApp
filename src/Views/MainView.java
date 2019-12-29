package Views;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Controllers.BaseController;
//import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class MainView extends JFrame{ 
	
	private BaseController baseController;
	
	private Handler handler;
	
	private JScrollPane historyPanel;
	private JPanel menuPanel;
	private JPanel inputPanel;
	
	private ArrayList<JButton> inputButtons;
	
	public MainView(BaseController base) {
		super("Stat Track");
		handler = new Handler();
		this.baseController = base;
		setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
		setPreferredSize(new Dimension(1400,950));
		
		setUpFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setUpButtons();
		ReceiveTypeButtons();
		setVisible(true);
	}
	
	private void ReceiveTypeButtons() {
		for(JButton b: inputButtons) {
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
		inputButtons = new ArrayList<JButton>();
		inputButtons.add(new JButton("S"));
		inputButtons.add(new JButton("F"));
		inputButtons.add(new JButton("O"));
		inputButtons.add(new JButton("L"));
		inputButtons.add(new JButton("M"));
		inputButtons.add(new JButton("R"));
		inputButtons.add(new JButton("D"));
		inputButtons.add(new JButton("A"));
		inputButtons.add(new JButton("P"));
		inputButtons.add(new JButton("C"));

		
		for(JButton b: inputButtons) {
			b.setPreferredSize(d);
			b.setFont(new Font("Arial", Font.PLAIN, 40));
			b.addActionListener(handler);
			inputPanel.add(b);
			b.setVisible(true);
		}

	}
	
	public void nextStep(int step) {
		
		//Step 3 = Receiving Player
		if(step==3) {
			int index=0;
			for(int i : baseController.getLineUp()) {
				inputButtons.get(index).setText(i+"");
				index++;
			}
			inputButtons.get(7).setText("-1");
			for(int i=8; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		//Step 4 = pass quality
		else if(step==4) {
			for(int i = 0; i<4; i++) {
				inputButtons.get(i).setText(""+(i));
				inputButtons.get(i).setVisible(true);
			}
			for(int i=4; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		//Step 5 = attacker
		else if(step==5) {
			int index=0;
			for(int i : baseController.getLineUp()) {
				inputButtons.get(index).setText(i+"");
				inputButtons.get(index).setVisible(true);
				index++;
			}
			inputButtons.get(7).setText("-1");
			inputButtons.get(7).setVisible(true);
			for(int i=8; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		//Step 6 = Attack Result
		else if(step==6) {
			inputButtons.get(0).setText("K");
			inputButtons.get(1).setText("D");
			inputButtons.get(2).setText("E");
			inputButtons.get(3).setText("B");
			inputButtons.get(4).setText("CB");
			inputButtons.get(5).setText("OBE");
			for(int i=6; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		//step 7 = Kill Type
		else if (step==7) {
			inputButtons.get(0).setText("S");
			inputButtons.get(1).setText("T");
			inputButtons.get(2).setText("R");
			inputButtons.get(3).setText("E");
			inputButtons.get(4).setText("BT");
			for(int i = 5; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);		
			}
		}
		//step 8 = killX/KillY
		else if(step==8 || step==9) {
			for(int i=0; i< inputButtons.size(); i++ ) {
				if(i<3) 
					inputButtons.get(i).setText(""+(i+1));
				else 
					inputButtons.get(i).setVisible(false);
			}
		}
		
		
	}
	
	class Handler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.print("BUtton PRess");
			if(baseController.getStep()==1 || baseController.getStep()==6 || baseController.getStep()==7 || baseController.getStep()==12) {
				baseController.addToPossessionChar(((AbstractButton) e.getSource()).getText().charAt(0)); 
				nextStep(baseController.getStep());
			}
			else {
				baseController.addToPossessionInt(Integer.parseInt(((AbstractButton) e.getSource()).getText()));
				nextStep(baseController.getStep());
			}
		}
		
	}
	
	
}
