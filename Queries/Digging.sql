
Select count(case when ReceivingPlayer!=-1 and PassQuality!='0' then 1 end) as DIGS,
	   count(case when ReceivingPlayer != -1 and PassQuality='0' then 1 end) as Shanks,
	   count(case when ReceivingPlayer = -1 then 1 end) as NoTouchKills
	from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType!='S' and ReceiveType!='F' and ReceivingPlayer!='' and ReceiveType!='BC' 
	and ReceivingPlayer=11

	select count(*) from [DurhamAttack-Semis(02-01-20)UPLOAD] where KillX=3 and ReceivingPlayer=-1

	Select count(*) from [Evolution-P2(02-01-20)] where 
	ReceiveType!='S' 
	and ReceiveType!='F' 
	and ReceivingPlayer!='' 
	and ReceiveType!='C' 
	and ReceiveType!='O'

/*
Select count(case when ReceivingPlayer!=-1 and PassQuality!='0' then 1 end) as DIGS,
	   count(case when ReceivingPlayer != -1 and PassQuality='0' then 1 end) as Shanks,
	   count(case when ReceivingPlayer = -1 then 1 end) as NoTouchKills
		from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='BC'

		select count(*) from [DurhamAttack-Semis(02-01-20)UPLOAD] where AttackResult='B' or AttackResult='BC'
		*/