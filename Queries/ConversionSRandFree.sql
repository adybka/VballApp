Select	count(case when PassQuality=3 and AttackResult='K' then 1 end) as Kill3, 
		count(case when PassQuality=2 and AttackResult='K' then 1 end) as Kill2,
		count(case when PassQuality=1 and AttackResult='K' then 1 end) as Kill1 ,
		count(case when PassQuality=0 and AttackResult='K' then 1 end) as Kill0 ,
		count(case when PassQuality=-1 and AttackResult='K' then 1 end) as KillN 
from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S'

Select	count(case when PassQuality=3 and AttackResult='D' then 1 end) as Dug3, 
		count(case when PassQuality=2 and AttackResult='D' then 1 end) as Dug2,
		count(case when PassQuality=1 and AttackResult='D' then 1 end) as Dug1 ,
		count(case when PassQuality=0 and AttackResult='D' then 1 end) as Dug0 ,
		count(case when PassQuality=-1 and AttackResult='D' then 1 end) as DugN 
from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S'

Select	count(case when PassQuality=3 and AttackResult='E' then 1 end) as Error3, 
		count(case when PassQuality=2 and AttackResult='E' then 1 end) as Error2,
		count(case when PassQuality=1 and AttackResult='E' then 1 end) as Error1 ,
		count(case when PassQuality=0 and AttackResult='E' then 1 end) as Error0 ,
		count(case when PassQuality=-1 and AttackResult='E' then 1 end) as ErrorN 
from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S'


Select	count(case when PassQuality=3 and (AttackResult='B' OR AttackResult='BC')  then 1 end) as Block3, 
		count(case when PassQuality=2 and (AttackResult='B' OR AttackResult='BC') then 1 end) as Block2,
		count(case when PassQuality=1 and (AttackResult='B' OR AttackResult='BC') then 1 end) as Block1 ,
		count(case when PassQuality=0 and (AttackResult='B' OR AttackResult='BC')then 1 end) as Block0 ,
		count(case when PassQuality=-1 and (AttackResult='B' OR AttackResult='BC') then 1 end) as BlockN 
from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S'

Select	count(case when PassQuality=3 and AttackResult!='' then 1 end) as Total3, 
		count(case when PassQuality=2 and AttackResult!='' then 1 end) as Total2,
		count(case when PassQuality=1 and AttackResult!='' then 1 end) as Total1 ,
		count(case when PassQuality=0 and AttackResult!='' then 1 end) as Total0 ,
		count(case when PassQuality='-1' and AttackResult!='' then 1 end) as TotalN 
from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S'


select count(*) as missed from [DurhamAttack-Semis(02-01-20)UPLOAD] where (Attacker IS NULL) and ReceiveType='S'

select count(*) as Free from [DurhamAttack-Semis(02-01-20)UPLOAD] where (Attacker=-1) and ReceiveType='S'