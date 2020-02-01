use Volleyball1

Select count(case when BlockResult='BKILL' then 1 end) as #Kills,
		count(case when BlockResult='BCONT'then 1 end) as #Dug,
		count(case when BlockResult='BERROR' then 1 end) as #Net,
		count(case when BlockResult='BTOOL' then 1 end) as #Tool
		from DEC14UPLOAD

		Select count(*) from DEC14UPLOAD where BlockResult is not NULL

		select * from DEC14UPLOAD where BlockResult is not NULL

		select * from DEC14UPLOAD where BlockResult = 'BNET'