Select	count(case when PlayerReceiving !=-1 and PassQuality!='0' and AttackResult='K' then 1 end) as Kills, 
		count(case when PlayerReceiving !=-1and PassQuality!='0' and AttackResult='D' then 1 end) as Dug,
		count(case when PlayerReceiving !=-1 and PassQuality!='0' and AttackResult='E'  then 1 end) as Error,
		count(case when PlayerReceiving !=-1 and PassQuality!='0' and AttackResult='B' or AttackResult='BC' then 1 end) as Blocked,
		count(case when PlayerReceiving !=-1 and PassQuality!='0' and Attacker=-1  then 1 end) as Free,
		count(case when PlayerReceiving !=-1 and PassQuality!='0' and Attacker is Null  then 1 end) as Lost
from DEC14UPLOAD where ReceiveType!='F' and ReceiveType!='S' and PlayerReceiving!=''

Select * from DEC14UPLOAD where Attacker is null and ReceiveType='BC'
