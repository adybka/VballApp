package Models;


public class Substitution {
	
	private int playerOff;
	private int playerOn;
	
	public Substitution(int pOff, int pOn) { 
		this.setPlayerOff(pOff);
		this.setPlayerOn(pOn);
	}
	
	public int getPlayerOff() {
		return playerOff;
	}
	public void setPlayerOff(int playerOff) {
		this.playerOff = playerOff;
	}
	public int getPlayerOn() {
		return playerOn;
	}
	public void setPlayerOn(int playerOn) {
		this.playerOn = playerOn;
	}
	

}
