package Models;

import java.util.ArrayList;

public class Set {
	
	private LineUp startingLineUp;
	private ArrayList<Substitution> subs;
	private ArrayList<Possession> possessions;
	public String name;
	
	
	public Set(String name) {
		subs = new ArrayList<Substitution>();
		possessions = new ArrayList<Possession>();
		this.name = name;
	}


	public LineUp getLineUp() {
		return startingLineUp;
	}


	public void setLineUp(LineUp lineUp) {
		this.startingLineUp = lineUp;
	}


	public ArrayList<Substitution> getSubs() {
		return subs;
	}


	public void setSubs(ArrayList<Substitution> subs) {
		this.subs = subs;
	}


	public ArrayList<Possession> getPossessions() {
		return possessions;
	}
	
	public void addPossession(Possession p) {
		possessions.add(p);
		//printPossessions();
	}
	
	
	public void addSub(Substitution s) {
		subs.add(s);
	}
	
	public void printPossessions() {
		for(Possession p: possessions)
			for(String s: p.getAllThings())
				System.out.println(s + " | ");
	}
	
	
}
