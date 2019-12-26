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
	private LineUp lineUp;
	
	public BaseController() {
		lineUp = new LineUp();
		go();
	}
	
	
	public void addToPossessionChar(String param, char value) {
		
		switch(param) {
		case "ReceiveType":
			currPos.setReceiveType(value);
			break;
		}
		
	}
	
	public void addLineUp(ArrayList list) {
		
	}
	
	private void go() {
		//this.view = new MainView(this);
		this.sView = new SetLineUpView(this);
	}
	
}
