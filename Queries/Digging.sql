use Volleyball1

Select count(case when PlayerReceiving!=-1 and PassQuality!='0' then 1 end) as DIGS,
	   count(case when PlayerReceiving != -1 and PassQuality='0' then 1 end) as Shanks,
	   count(case when PlayerReceiving = -1 then 1 end) as NoTouchKills
	from DEC14UPLOAD where ReceiveType!='S' and ReceiveType!='F' and PlayerReceiving!='' and ReceiveType!='BC'

	Select count(*) from DEC14UPLOAD where ReceiveType!='S' and ReceiveType!='F' and PlayerReceiving!='' and ReceiveType!='BC'


Select count(case when PlayerReceiving!=-1 and PassQuality!='0' then 1 end) as DIGS,
	   count(case when PlayerReceiving != -1 and PassQuality='0' then 1 end) as Shanks,
	   count(case when PlayerReceiving = -1 then 1 end) as NoTouchKills
		from DEC14UPLOAD where ReceiveType='BC'

		select count(*) from DEC14UPLOAD where AttackResult='B' or AttackResult='BC'