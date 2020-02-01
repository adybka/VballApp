DECLARE @firstSet Int = 12
	/*(Select MIN(SetID) from Tournaments 
		join Matches on Tournaments.TournamentID=Matches.TournamentID
		join MatchSets on  Matches.MatchID=MatchSets.MatchID
		where Tournaments.TournamentID=2);*/

DECLARE @lastSet Int = 
	(Select Max(SetID) from Tournaments 
		join Matches on Tournaments.TournamentID=Matches.TournamentID
		join MatchSets on  Matches.MatchID=MatchSets.MatchID
		where Tournaments.TournamentID=2);


		WHILE @firstSet<@lastSet
		BEGIN
			