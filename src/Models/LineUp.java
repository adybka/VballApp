 
package Models;

import java.util.ArrayList;

public class LineUp {

	private int P1;
	private int P2;
	private int P3;
	private int P4;
	private int P5;
	private int P6;
	private int Lib;
	private int SetterStartingPosition;
	
	
	public LineUp(ArrayList<Integer> list, int setterPos) { 
		P1=list.get(0);
		P2=list.get(1);
		P3=list.get(2);
		P4=list.get(3);
		P5=list.get(4);
		P6=list.get(5);
		Lib=list.get(6);
		SetterStartingPosition=setterPos;
	} 
	
	
	public int getP1() {
		return P1;
	}
	public void setP1(int p1) {
		P1 = p1;
	}
	public int getP2() {
		return P2;
	}
	public void setP2(int p2) {
		P2 = p2;
	}
	public int getP3() {
		return P3;
	}
	public void setP3(int p3) {
		P3 = p3;
	}
	public int getP4() {
		return P4;
	}
	public void setP4(int p4) {
		P4 = p4;
	}
	public int getP5() {
		return P5;
	}
	public void setP5(int p5) {
		P5 = p5;
	}
	public int getP6() {
		return P6;
	}
	public void setP6(int p6) {
		P6 = p6;
	}
	public int getLib() {
		return Lib;
	}
	public void setLib(int lib) {
		Lib = lib;
	}
	public int getSetterStartingPosition() {
		return SetterStartingPosition;
	}
	public void setSetterStartingPosition(int setterStartingPosition) {
		SetterStartingPosition = setterStartingPosition;
	}
	
	

}
