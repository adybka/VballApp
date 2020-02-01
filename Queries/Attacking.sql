use Volleyball1

Select count(case when AttackResult='K' then 1 end) as #Kills,
		count(case when AttackResult='D'then 1 end) as #Dug,
		count(case when AttackResult='B' or AttackResult='BC' then 1 end) as #Blocked,
		count(case when AttackResult='E' then 1 end) as #Errors
		from DEC14UPLOAD where AttackResult!='BE' and Attacker!=-1


		Select count(*) from DEC14UPLOAD where Attacker!=-1 and AttackResult!='BE'

		Select * from DEC14UPLOAD where Attacker!=-1 and AttackResult!='BE' and AttackResult!='K' and AttackResult!='D' and AttackResult!='E'  and AttackResult!='B'  and AttackResult!='BC'   


		Select count(case when AttackResult='K' then 1 end) as #Kills,
		count(case when AttackResult='D'then 1 end) as #Dug,
		count(case when AttackResult='B' or AttackResult='BC' then 1 end) as #Blocked,
		count(case when AttackResult='E' then 1 end) as #Errors
		from DEC14UPLOAD where AttackResult!='BE' and Attacker!=-1 and (Attacker=13 or Attacker=1 or Attacker=18)


/*	Select [Name],
		count(case when AttackResult='K' then 1 end) as #Kills,
		count(case when AttackResult='D'then 1 end) as #Dug,
		count(case when AttackResult='E' then 1 end) as #Errors,
		count(case when AttackResult='B' or AttackResult='BC' then 1 end) as #Blocked
		from NOV23UPLOAD
		join Players on Attacker=Number
		where AttackResult!='BE' and Attacker=9
		group by Name
		*/

