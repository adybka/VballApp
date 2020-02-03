

Select	count(case when PassQuality=3 and ReceiveType='S' then 1 end) as #3PassFromServe,
		count(case when PassQuality=2 and ReceiveType='S' then 1 end) as #2PassFromServe,
		count(case when PassQuality=1 and ReceiveType='S' then 1 end) as #1PassFromServe,
		count(case when PassQuality=0 and ReceiveType='S' then 1 end) as #0PassFromServe,
		count(case when (PassQuality=-1 or ReceivingPlayer=-1) and ReceiveType='S' then 1 end) as '#-1PassFromServe'
		from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceivingPlayer=11
		


Select count(*) from [DurhamAttack-Semis(02-01-20)UPLOAD] where ReceiveType='S' 



