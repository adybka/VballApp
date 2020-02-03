package Controllers;

import Views.MainView;
import Views.SetLineUpView;
import Views.SubView;
import Models.Possession;
import Models.Set;
import Models.Substitution;

import java.util.ArrayList;
import java.util.Stack;

import Models.LineUp;

public class BaseController {
	
	private SetLineUpView sView;
	private MainView mView;
	private SubView subView;
	private Possession currPos;
	private ArrayList<Integer> currLineUp;
	private int step;
	private int currSetterPos;
	private Set currSet;
	private CsvSaver csvSaver;
	private Stack<Integer> undoStack;
	
	public BaseController() {
		step = 1;
		csvSaver = new CsvSaver();
		undoStack = new Stack<Integer>();
		/*currSet = new Set("TEST");
		/*for TESTING
		currLineUp = new ArrayList<Integer>();
		currLineUp.add(4);
		currLineUp.add(16);
		currLineUp.add(1);
		currLineUp.add(9);
		currLineUp.add(21);
		currLineUp.add(13);
		currLineUp.add(11);
		currSet.setLineUp(new LineUp(currLineUp, 1));
		currSet.getLineUp().setLib(11);
		currSet.getLineUp().setP1(4);
		currSet.getLineUp().setP2(16);
		currSet.getLineUp().setP3(1);
		currSet.getLineUp().setP4(9);
		currSet.getLineUp().setP5(21);
		currSet.getLineUp().setP6(13);
		currSet.getLineUp().setSetterStartingPosition(1);
		
		currPos = new Possession(currSet.getLineUp().getSetterStartingPosition());
		currSetterPos=currSet.getLineUp().getSetterStartingPosition();
		*/
		
		go();
	}
	
	public void rotate() {
		if(currSetterPos!=1) {
			currSetterPos--;
			currPos.setSetterPosition(currSetterPos);
		}
		else {
			currSetterPos=6;
			currPos.setSetterPosition(currSetterPos);
		}
	}
	
	public void addToPossessionInt(int value) {
		System.out.println("add int: " + value);
		undoStack.push(step);
		switch(step) {
		case 3:
			if(value==-2) {
				step=12; 
			}
			else{
				currPos.setReceivingPlayer(value);
				if(value==-1 && currPos.getReceiveType()!='S' && currPos.getReceiveType()!='F' && currPos.getReceiveType()!='O') {
					currPos.setKillTeam(0);
					step=7;
					break;
				}
				else if(value==-1 && currPos.getReceiveType()=='S' && currPos.getReceiveType()=='F' && currPos.getReceiveType()=='O') {
					step=-1;
					break;
				}
				step++;
			}
			break;
		case 4:
			currPos.setPassQuality(value);
			//was a hit and a shank
			if(value==0 && currPos.getReceiveType()!='S' && currPos.getReceiveType()!='F' && currPos.getReceiveType()!='O') {
				currPos.setKillTeam(0);
				step=7;
				break;
			}
			step++;
			break;
		case 5:
			currPos.setAttacker(value);
			step++;
			break;
		case 8:
			currPos.setKillX(value);
			step++;
			break;
		case 9:
			currPos.setKilly(value);
			step=-1;
			break;
		case 13:
			currPos.setBlockingPlayer(value);
			if(currPos.getBlockingNUm()<1.5)
				step=-1;
			else
				step++;
			break;
		case 14: 
			currPos.setBlockingAssist(value);
			step=-1;
			break;
		}
	}
	
	public void addToPossessionBlockNum(double value) {
		System.out.println("Add double: " + value);
		undoStack.push(step);
		currPos.setBlockingNUm(value);
		step++;
	}
	
	public void addToPossessionChar(char value) {
		System.out.println("Add Char: " + value);
		undoStack.push(step);
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
				step=-1;
			break;
			
		case 7:
			currPos.setKillType(value);
			step=8;
			break;
		case 8:
			currPos.setKillX(value);
			step++;
			break;
		case 9:
			currPos.setKilly(value);
			step=-1;
			break;
		case 12:
			currPos.setBlockResult(value);
			step++;
			break;
		
		}
		
	}
	
	public void addPos() {
		undoStack.clear();
		currSet.addPossession(currPos);
		mView.history.model.insertRow(0, currPos.getAllThings().toArray());
		currPos = new Possession(currSetterPos);
		step=1;
		mView.nextStep(step);
	}
	
	public void addLineUp(ArrayList<Integer> list, int setterPos, String setName) {
		currSet = new Set(setName);
		sView.setVisible(false);
		this.currLineUp = list;
		this.currSetterPos=setterPos;
		currSet.setLineUp(new LineUp(list, setterPos));
		currPos = new Possession(currSet.getLineUp().getSetterStartingPosition());
		this.mView = new MainView(this, setName);
	}
	
	public void undo() {
		step=undoStack.pop();
		if(step==1 || step==6 || step==7 || step==12) {
			currPos.setCharStep(step, ' ');
			mView.nextStep(step);
		}
		else if(step==2) {
			currPos.setBlockingNUm(-10);
			mView.nextStep(step);
		}
		else {
			currPos.setIntStep(step, -10);
			mView.nextStep(step);
		}
		
	}
	
	public int getStep() {
		return step;
	}
	
	public Possession getCurrPos() {
		return currPos;
	}
	
	public int getCurrSetterPos() {
		return currSetterPos;
	}
	
	public ArrayList<Integer> getLineUp(){
		return currLineUp;
	}
	
	public void saveCurrentSet() {
		csvSaver.newFile(currSet);
		csvSaver.writeAllPossessions(currSet.getPossessions());
	}
	
	public void startSub() {
		this.subView=new SubView(this);
	}
	
	public void saveSub(int pOff, int pOn) {
		currSet.addSub(new Substitution(pOff, pOn));
		currLineUp.set(currLineUp.indexOf(pOff), pOn);
	}
	
	public void fullSave() {
		saveCurrentSet();
		csvSaver.saveSetInformation(currSet);
	}
	

	private void go() {
		//this.mView = new MainView(this, this.currSet.name);
		this.sView = new SetLineUpView(this);
		//this.subView = new SubView(this);
	}
	
}
