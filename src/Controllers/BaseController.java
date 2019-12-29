package Controllers;

import Views.MainView;
import Views.SetLineUpView;
import Models.Possession;
import Models.Set;

import java.util.ArrayList;

import Models.LineUp;

public class BaseController {
	
	private SetLineUpView sView;
	private MainView mView;
	private Possession currPos;
	private ArrayList<Integer> lineUp;
	private int step;
	
	public BaseController() {
		currPos = new Possession();
		step = 1;
		//for TESTING
		lineUp = new ArrayList<Integer>();
		lineUp.add(4);
		lineUp.add(16);
		lineUp.add(1);
		lineUp.add(9);
		lineUp.add(21);
		lineUp.add(13);
		lineUp.add(11);
		go();
	}
	
	
	public void addToPossessionInt(int value) {
		System.out.println("add int: " + value);
		switch(step) {
		case 3:
			currPos.setReceivingPlayer(value);
			if(value==0 && currPos.getReceiveType()!='S' && currPos.getReceiveType()!='F' && currPos.getReceiveType()!='O') {
				currPos.setKillTeam(0);
			}
			step++;
			break;
		case 4:
			currPos.setPassQuality(value);
			step++;
			break;
		case 5:
			currPos.setAttacker(value);
			step++;
			break;
		}
	}
	
	public void addToPossessionChar(char value) {
		System.out.println("Add Char: " + value);
		switch(step) {
		case 1:
			currPos.setReceiveType(value);
			if(value=='S')
				step=3;
			else
				step=2;
			break;
		case 6:
			currPos.setAttackResult(value);
			if(value=='K') { 
				step=7;
				currPos.setKillTeam(1);
			}
			else
				step=15;
			break;
		case 7:
			currPos.setKillType(value);
			step=8;
			break;
		case 8:
			currPos.setKillX(value);
			step=9;
			break;
		case 9:
			currPos.setKilly(value);
			step=15;
			break;
		}
		
	}
	
	public void addLineUp(ArrayList<Integer> list) {
		sView.setVisible(false);
		this.lineUp = list;
		
	}
	
	public int getStep() {
		return step;
	}
	
	public ArrayList<Integer> getLineUp(){
		return lineUp;
	}
	
	private void go() {
		this.mView = new MainView(this);
		//this.sView = new SetLineUpView(this);
	}
	
}
