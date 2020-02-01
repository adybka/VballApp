use Volleyball1

Select count(case when PassQuality='3' and ReceiveType='F' then 1 end) as #3PassFromServe,
		count(case when PassQuality='2' and ReceiveType='F' then 1 end) as #2PassFromServe,
		count(case when PassQuality='1' and ReceiveType='F' then 1 end) as #1PassFromServe,
		count(case when PassQuality='0' and ReceiveType='F' then 1 end) as #0PassFromServe,
		count(case when PassQuality='-1' and ReceiveType='F' then 1 end) as '#-1PassFromServe'
		from DEC14UPLOAD


Select count(*) from DEC14UPLOAD where ReceiveType='F'

Select * from DEC14UPLOAD where ReceiveType='F'

