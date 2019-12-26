package Models;

import java.util.ArrayList;

public class Set {
	
	private LineUp lineUp;
	private ArrayList subs;
	private ArrayList possessions;
	
	
	public Set() {
		subs = new ArrayList<Substitution>();
		possessions = new ArrayList<Possession>();
	}


	public LineUp getLineUp() {
		return lineUp;
	}


	public void setLineUp(LineUp lineUp) {
		this.lineUp = lineUp;
	}


	public ArrayList<Possession> getSubs() {
		return subs;
	}


	public void setSubs(ArrayList subs) {
		this.subs = subs;
	}


	public ArrayList<Possession> getPossessions() {
		return possessions;
	}


	public void setPossessions(ArrayList possessions) {
		this.possessions = possessions;
	}
	
	public void addPossession(Possession p) {
		possessions.add(p);
	}
	
	
	public void addSub(Substitution s) {
		subs.add(s);
	}
	
	
}
