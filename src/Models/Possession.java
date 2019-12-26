package Models;



public class Possession {
	private int setterPosition;
	private char receiveType; //1=S	2=F	3=O	4=L	5=M	6=R	7=A	8=P	9=D 10=C
	private double blockingNUm;
	private int receivingPlayer;
	private int passQuality;
	private int attacker;
	private char attackResult; //1=K 2=D 3=E 4=B 5=BC=C 6=BE=E
	private char killType; //1=S	2=R	3=T
	private int killX;
	private int killy;
	private int killTeam;
	private int hitFix;
	private char blockResult; //1=K 2=D 3=T	4=E
	private int blockingPlayer;
	private int blockingAssist;
	
	
	public Possession() {}
	
	public int getSetterPosition() {
		return setterPosition;
	}
	
	public char getReceiveType() {
		return receiveType;
	}
	public void setReceiveType(char receiveType) {
		this.receiveType = receiveType;
	}
	public double getBlockingNUm() {
		return blockingNUm;
	}
	public void setBlockingNUm(double blockingNUm) {
		this.blockingNUm = blockingNUm;
	}
	public int getReceivingPlayer() {
		return receivingPlayer;
	}
	public void setReceivingPlayer(int receivingPlayer) {
		this.receivingPlayer = receivingPlayer;
	}
	public int getPassQuality() {
		return passQuality;
	}
	public void setPassQuality(int passQuality) {
		this.passQuality = passQuality;
	}
	public int getAttacker() {
		return attacker;
	}
	public void setAttacker(int attacker) {
		this.attacker = attacker;
	}
	public char getAttackResult() {
		return attackResult;
	}
	public void setAttackResult(char attackResult) {
		this.attackResult = attackResult;
	}
	public char getKillType() {
		return killType;
	}
	public void setKillType(char killType) {
		this.killType = killType;
	}
	public int getKillX() {
		return killX;
	}
	public void setKillX(int killX) {
		this.killX = killX;
	}
	public int getKilly() {
		return killy;
	}
	public void setKilly(int killy) {
		this.killy = killy;
	}
	public int getKillTeam() {
		return killTeam;
	}
	public void setKillTeam(int killTeam) {
		this.killTeam = killTeam;
	}
	public int getHitFix() {
		return hitFix;
	}
	public void setHitFix(int hitFix) {
		this.hitFix = hitFix;
	}
	public char getBlockResult() {
		return blockResult;
	}
	public void setBlockResult(char blockResult) {
		this.blockResult = blockResult;
	}
	public int getBlockingPlayer() {
		return blockingPlayer;
	}
	public void setBlockingPlayer(int blockingPlayer) {
		this.blockingPlayer = blockingPlayer;
	}
	public int getBlockingAssist() {
		return blockingAssist;
	}
	public void setBlockingAssist(int blockingAssist) {
		this.blockingAssist = blockingAssist;
	}
	
	
	
	
}
