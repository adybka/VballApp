use Volleyball1

/* Tounrament 1
--FOR ALL BUT ALEXA
Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftFree3,
		count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleFree3,
		count(case when Attacker='9' or Attacker='19' then 1 end) as RightFree3 from PossessionRaw where ReceiveType='F' and PassQuality='3'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftFree2,
		count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleFree2,
		count(case when Attacker='9' or Attacker='19' then 1 end) as RightFree2 from PossessionRaw where ReceiveType='F' and PassQuality='2'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftFree1,
	count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleFree1,
	count(case when Attacker='9' or Attacker='19' then 1 end) as RightFree1 from PossessionRaw where ReceiveType='F' and PassQuality='1'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftFree,
	count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleFree0,
	count(case when Attacker='9' or Attacker='19' then 1 end) as RightFree0 from PossessionRaw where ReceiveType='F' and PassQuality='0'


--FOR ALEXA

Select count(case when Attacker = '15' and PassQuality='3' then 1 end) as AlexaLeftFree3,
		count(case when Attacker = '15'	and PassQuality='2'then 1 end) as AlexaLeftFree2,
		count(case when Attacker = '15' and PassQuality='1' then 1 end) as AlexaLeftFree3 from PossessionRaw where ReceiveType='F' and (SetID=9 or SetID=8 or SetID=7)
		*/


--Tournament 2

--set 13-21

Select count(case when (Attacker=16 or Attacker=21 or Attacker=9)then 1 end) as LeftServe3,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe3,
		count(case when (Attacker=15 or Attacker=19) then 1 end) as RightServe3 
		from NOV23UPLOAD where ReceiveType='F' and PassQuality='3'and setID>=13

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=9))  then 1 end) as LeftServe2,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe2,
		count(case when (Attacker=15 or Attacker=19) then 1 end) as RightServe2 
		from NOV23UPLOAD where ReceiveType='F' and PassQuality='2' and setID>=13

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=9))  then 1 end) as LeftServe1,
	count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe1,
	count(case when (Attacker=15 or Attacker=19) then 1 end) as RightServe1 
	from NOV23UPLOAD where ReceiveType='F' and PassQuality='1' and setID>=13

--Set 10-12
Select count(case when (Attacker=16 or Attacker=21 or Attacker=15)then 1 end) as LeftServe3,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe3,
		count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe3 
		from NOV23UPLOAD where ReceiveType='F' and PassQuality='3'and setID<13 and SetID>=10

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=15))  then 1 end) as LeftServe2,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe2,
		count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe2 
		from NOV23UPLOAD where ReceiveType='F' and PassQuality='2' and setID<13 and SetID>=10

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=15))  then 1 end) as LeftServe1,
	count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe1,
	count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe1 
	from NOV23UPLOAD where ReceiveType='F' and PassQuality='1' and setID<13 and SetID>=10