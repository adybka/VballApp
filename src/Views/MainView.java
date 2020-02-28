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
	private MenuHandler menuHandler;
	
	private JScrollPane historyPanel;
	private JScrollPane hitStatsPane;
	private JPanel menuPanel;
	private JPanel inputPanel;
	
	public HistoryView history;
	public HittingStatsView hitStats;
	
	private JLabel stepLabel;
	private JLabel setterPosLabel;
	private JLabel menuLabel;
	
	private JButton rotateButton;
	private JButton StatOrTable;
	private ArrayList<JButton> inputButtons;
	private JButton  nextPosButton;
	private JButton substitutionButton;
	private JButton fullSaveButton;
	private JButton undoButton;
	
	public MainView(BaseController base, String title) {
		super(title);
		handler = new Handler();
		menuHandler = new MenuHandler();
		this.baseController = base;
		setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
		setPreferredSize(new Dimension(1400,950));
		
		setUpFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		//input Buttons
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
		//Setup Panels
		
		historyPanel = new JScrollPane(history = new HistoryView());
		
		hitStatsPane=new JScrollPane(hitStats = baseController.repoController.hitView);
		
		menuPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new FlowLayout());
		
		historyPanel.setPreferredSize(new Dimension(1360, 490));
		hitStatsPane.setPreferredSize(new Dimension(1360, 490));
		menuPanel.setPreferredSize(new Dimension(270, 490));
		inputPanel.setPreferredSize(new Dimension(1000, 490));	
		
		historyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		hitStatsPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		hitStatsPane.setVisible(false);
		
		//Menu Set up
		menuLabel = new JLabel("MENU", SwingConstants.CENTER);
		menuLabel.setPreferredSize(new Dimension(200, 25));
		menuPanel.add(menuLabel);
		
		rotateButton=new JButton("Rotate");
		rotateButton.setPreferredSize(new Dimension(200, 50));
		rotateButton.addActionListener(menuHandler);
		menuPanel.add(rotateButton);
		rotateButton.setVisible(true);
		
		undoButton = new JButton("Undo");
		undoButton.setPreferredSize(new Dimension(200, 50));
		undoButton.addActionListener(menuHandler);
		menuPanel.add(undoButton);
				
		substitutionButton = new JButton("Substitution");
		substitutionButton.setPreferredSize(new Dimension(200, 50));
		substitutionButton.addActionListener(menuHandler);
		menuPanel.add(substitutionButton);
		
		StatOrTable = new JButton("StatOrTable");
		StatOrTable.setPreferredSize(new Dimension(200, 50));
		StatOrTable.addActionListener(menuHandler);
		menuPanel.add(StatOrTable);
		
		fullSaveButton = new JButton("FULL SAVE");
		fullSaveButton.setPreferredSize(new Dimension(200, 50));
		fullSaveButton.addActionListener(menuHandler);
		menuPanel.add(fullSaveButton);
				
		
		
		
		//Input Panel Stuff
		setterPosLabel = new JLabel("Setter in: "+baseController.getCurrSetterPos(), (int) JLabel.CENTER_ALIGNMENT);
		setterPosLabel.setPreferredSize(new Dimension(100, 75));
		inputPanel.add(setterPosLabel);
		
		stepLabel = new JLabel("Recieve Type", (int) JLabel.LEFT_ALIGNMENT);
		stepLabel.setPreferredSize(new Dimension(650, 75));
		inputPanel.add(stepLabel);
		
		nextPosButton = new JButton("NEXT");
		nextPosButton.setPreferredSize(new Dimension(150, 60));
		nextPosButton.addActionListener(menuHandler);
		inputPanel.add(nextPosButton);
			
		this.add(historyPanel);
		this.add(hitStatsPane);
		
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
		
		//step 2 = BlockingNum
		if(step==1) {
			System.out.println("NEW");
			stepLabel.setText("Receive Type");
			inputButtons.get(0).setText("S");
			inputButtons.get(1).setText("F");
			inputButtons.get(2).setText("O");
			inputButtons.get(3).setText("L");
			inputButtons.get(4).setText("M");
			inputButtons.get(5).setText("R");
			inputButtons.get(6).setText("D");
			inputButtons.get(7).setText("A");
			inputButtons.get(8).setText("P");
			inputButtons.get(9).setText("C");
			for(int i=0; i<10; i++)
				inputButtons.get(i).setVisible(true);
		}
		else if(step==2) {
			stepLabel.setText("Blocking Number");
			inputButtons.get(0).setText("0");
			inputButtons.get(1).setText("1");
			inputButtons.get(2).setText("1.5");
			inputButtons.get(3).setText("2");
			inputButtons.get(4).setText("2.5");
			inputButtons.get(5).setText("3");
			for(int i=0; i<inputButtons.size(); i++) {
				if(i<6)
					inputButtons.get(i).setVisible(true);
				else
					inputButtons.get(i).setVisible(false);
			}
			
		}
		//Step 3 = Receiving Player
		else if(step==3) {
			stepLabel.setText("Receiving Player");
			int index=0;
			for(int i : baseController.getLineUp()) {
				inputButtons.get(index).setText(i+"");
				inputButtons.get(index).setVisible(true);
				index++;
			}
			inputButtons.get(7).setText("-1");
			inputButtons.get(7).setVisible(true);
			if(baseController.getCurrPos().getReceiveType()!='S') {
				inputButtons.get(8).setText("BR");
				inputButtons.get(8).setVisible(true);
			}
			else {
				inputButtons.get(8).setVisible(false);
			}
			for(int i=9; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
			
		}
		//Step 4 = pass quality
		else if(step==4) {
			stepLabel.setText("PassQuality");
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
			stepLabel.setText("Attacking Player");
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
			stepLabel.setText("Attack Result");
			inputButtons.get(0).setText("K");
			inputButtons.get(1).setText("D");
			inputButtons.get(2).setText("E");
			inputButtons.get(3).setText("B");
			inputButtons.get(4).setText("CB");
			inputButtons.get(5).setText("OBE");
			for(int i=0; i<inputButtons.size(); i++) {
				if(i>=6)
					inputButtons.get(i).setVisible(false);
				else 
					inputButtons.get(i).setVisible(true);
			}
		}
		//step 7 = Kill Type
		else if (step==7) {
			stepLabel.setText("Kill Type");
			inputButtons.get(0).setText("S");
			inputButtons.get(1).setText("T");
			inputButtons.get(2).setText("R");
			inputButtons.get(3).setText("E");
			inputButtons.get(4).setText("BT");
			for(int i=0; i<5; i++) {
				inputButtons.get(i).setVisible(true);
			}
			for(int i = 5; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);		
			}
		}
		//step 8/9 = killX/KillY
		else if(step==8 || step==9) {
			if(step==8) stepLabel.setText("KillX");
			else stepLabel.setText("KillY");
			for(int i=0; i< inputButtons.size(); i++ ) {
				if(i<3) 
					inputButtons.get(i).setText(""+(i+1));
				else 
					inputButtons.get(i).setVisible(false);
			}
		}
		//step 12 = block result
		else if(step==12) {
			stepLabel.setText("Block Result");
			inputButtons.get(0).setText("K");
			inputButtons.get(1).setText("D");
			inputButtons.get(2).setText("T");
			inputButtons.get(3).setText("E");
			for(int i =0; i<inputButtons.size(); i++) {
				if(i<4)
					inputButtons.get(i).setVisible(true);
				else
					inputButtons.get(i).setVisible(false);
			}
		}
		//step 13 == blocking player
		else if(step==13) {
			stepLabel.setText("Blocking Player");
			int index=0;
			for(int i : baseController.getLineUp()) {
				inputButtons.get(index).setText(i+"");
				inputButtons.get(index).setVisible(true);
				index++;
			}
			for(int i=7; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		else if(step==14) {
			stepLabel.setText("Blocking Assist");
			int index=0;
			for(int i : baseController.getLineUp()) {
				inputButtons.get(index).setText(i+"");
				inputButtons.get(index).setVisible(true);
				index++;
			}
			for(int i=7; i<inputButtons.size(); i++) {
				inputButtons.get(i).setVisible(false);
			}
		}
		else if(step==-1) {
			baseController.addPos();
		}
		
		
		
	}
	
	class Handler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.print(baseController.getStep()+" Button PRess");
			if(baseController.getStep()==1 || baseController.getStep()==6 || baseController.getStep()==7 || baseController.getStep()==12) {
				baseController.addToPossessionChar(((AbstractButton) e.getSource()).getText().charAt(0)); 
				nextStep(baseController.getStep());
			}
			else if(baseController.getStep()==3) {
				if(((AbstractButton) e.getSource()).getText().equals("BR")) 
					baseController.addToPossessionInt(-2);
				else
					baseController.addToPossessionInt(Integer.parseInt(((AbstractButton) e.getSource()).getText()));
				
				nextStep(baseController.getStep());
			}
			else if(baseController.getStep()==2) {
				baseController.addToPossessionBlockNum(Double.parseDouble(((AbstractButton) e.getSource()).getText())); 
				nextStep(baseController.getStep());
			}
			else {
				baseController.addToPossessionInt(Integer.parseInt(((AbstractButton) e.getSource()).getText()));
				nextStep(baseController.getStep());
			}
		}
		
	}

	class MenuHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==rotateButton) {
				baseController.rotate();
				setterPosLabel.setText("Setter in: "+baseController.getCurrSetterPos());
			}
			else if(e.getSource()==nextPosButton){
				baseController.addPos();
			}
			else if(e.getSource()==StatOrTable) {
				if(historyPanel.isVisible()) {
					historyPanel.setVisible(false);
					hitStatsPane.setVisible(true);
				}
				else {
					historyPanel.setVisible(true);
					hitStatsPane.setVisible(false);
				}
			}
			else if(e.getSource()==substitutionButton) {
				baseController.startSub();
			}
			else if(e.getSource()==fullSaveButton) {
				baseController.fullSave();
			}
			else if(e.getSource()==undoButton) {
				baseController.undo();
			}
			
		}
		
	}
	
}
