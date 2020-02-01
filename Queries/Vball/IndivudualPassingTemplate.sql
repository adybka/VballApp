Select	[Name],
		count(case when PassQuality=3 and ReceiveType='S' then 1 end) as '3s',
		count(case when PassQuality=2 and ReceiveType='S' then 1 end) as '2s',
		count(case when PassQuality=1 and ReceiveType='S' then 1 end) as '1s',
		count(case when PassQuality=0 and ReceiveType='S' then 1 end) as '0s'
		from NOV23UPLOAD
		join Players on CAST(NOV23UPLOAD.PlayerReceiving as int) = Players.Number
		where NOV23UPLOAD.PlayerReceiving='16'
		group by [Name]