package Repositories;

public class HittingRepo {

	public Integer[][] hittingStats = new Integer[11][7];
	//columns player[0], total hits[1], kills[2], continuations[3], errors[4], blocks[5], +/- [6]
	
	public HittingRepo(int[] players) {
		for(int i = 0; i<11; i++) {
			for(int j=0; j<7; j++) {
				if(j==0)
					hittingStats[i][j] = players[i];
				else
					hittingStats[i][j] = 0;
			}
		}
	}
	
	public void updateStat(int playerIndex, int result) {
		hittingStats[playerIndex][result]++;
		hittingStats[playerIndex][1]++;
		if(result==2)
			hittingStats[playerIndex][6]++;
		else if(result==4||result==5)
			hittingStats[playerIndex][6]--;
	}
	
	
}
