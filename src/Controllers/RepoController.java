package Controllers;

import Repositories.HittingRepo;
import Views.HittingStatsView;

public class RepoController {
	
	private static final int[]  players = {1, 4, 8, 9, 11, 13, 15, 16, 18, 19, 21};
	private static final int[] hitResult = {'K', 'D', 'E'};
	public HittingRepo hitRepo;
	public HittingStatsView hitView;
	
	public RepoController() {
		hitRepo = new HittingRepo(players);
		hitView = new HittingStatsView(hitRepo.hittingStats);
	}
	
	public void addHit(int player, char result) {
		int iresult=0;
		if(result=='K')
			iresult=2;
		else if (result=='D')
			iresult=3;
		else if(result=='E')
			iresult=4;
		else 
			iresult=5;
		int iplayer = indexOfPlayer(player);
		//hitRepo.updateStat(iplayer, iresult);
		//hitView.setValueAt(hitRepo.hittingStats[iplayer][1], iplayer, iresult);
		//hitView.setValueAt(hitRepo.hittingStats[iplayer][iresult], iplayer, iresult);
		//hitView.setValueAt(hitRepo.hittingStats[iplayer][6], iplayer, iresult);
	}
	
	private int indexOfPlayer(int player){
		for(int i=0; i<players.length; i++) {
			if(players[i]==player)
				return i;
		}
		return 0;
	}

}
