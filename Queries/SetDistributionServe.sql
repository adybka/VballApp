use Volleyball1

/*TOURNAMENT 1
--FOR ALL BUT ALEXA
Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftServe3,
		count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleServe3,
		count(case when Attacker='9' or Attacker='19' then 1 end) as RightServe3 from PossessionRaw where ReceiveType='S' and PassQuality='3'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftServe2,
		count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleServe2,
		count(case when Attacker='9' or Attacker='19' then 1 end) as RightServe2 from PossessionRaw where ReceiveType='S' and PassQuality='2'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftServe1,
	count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleServe1,
	count(case when Attacker='9' or Attacker='19' then 1 end) as RightServe1 from PossessionRaw where ReceiveType='S' and PassQuality='1'

Select count(case when Attacker='16' or Attacker='21' then 1 end) as LeftServe1,
	count(case when Attacker='1' or Attacker='13' or Attacker='18' then 1 end) as MiddleServe1,
	count(case when Attacker='9' or Attacker='19' then 1 end) as RightServe1 from PossessionRaw where ReceiveType='S' and PassQuality='0'

--FOR ALEXA
Select count(case when Attacker = '15' and PassQuality='3' then 1 end) as AlexaRightServe3,
		count(case when Attacker = '15'	and PassQuality='2'then 1 end) as AlexaRightServe2,
		count(case when Attacker = '15' and PassQuality='1' then 1 end) as AlexaRightServe1 from PossessionRaw where ReceiveType='S' and (SetID<7)
*/

--Tournament 2

Select * from NOV23UPLOAD where SetterPosition is null and ReceiveType='S' and SetID>=13

--SetID 13-21
Select count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition!=1) or ((Attacker=15 or Attacker=19) and SetterPosition=1) then 1 end) as LeftServe3,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe3,
		count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition=1) or ((Attacker=15 or Attacker=19) and SetterPosition!=1) then 1 end) as RightServe3 
		from NOV23UPLOAD where ReceiveType='S' and PassQuality='3'and setID>=13

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition!=1) or ((Attacker=15 or Attacker=19) and SetterPosition=1)  then 1 end) as LeftServe2,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe2,
		count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition=1) or ((Attacker=15 or Attacker=19) and SetterPosition!=1) then 1 end) as RightServe2 
		from NOV23UPLOAD where ReceiveType='S' and PassQuality='2' and setID>=13

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition!=1) or ((Attacker=15 or Attacker=19) and SetterPosition=1)  then 1 end) as LeftServe1,
	count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe1,
	count(case when ((Attacker=16 or Attacker=21 or Attacker=9) and SetterPosition=1) or ((Attacker=15 or Attacker=19) and SetterPosition!=1) then 1 end) as RightServe1 
	from NOV23UPLOAD where ReceiveType='S' and PassQuality='1' and setID>=13


--Set 10-12
Select count(case when (Attacker=16 or Attacker=21 or Attacker=15)then 1 end) as LeftServe3,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe3,
		count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe3 
		from NOV23UPLOAD where ReceiveType='S' and PassQuality='3'and setID<13 and SetID>=10

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=15))  then 1 end) as LeftServe2,
		count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe2,
		count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe2 
		from NOV23UPLOAD where ReceiveType='S' and PassQuality='2' and setID<13 and SetID>=10

Select count(case when ((Attacker=16 or Attacker=21 or Attacker=15))  then 1 end) as LeftServe1,
	count(case when Attacker=1 or Attacker=13 or Attacker=18 then 1 end) as MiddleServe1,
	count(case when (Attacker=9 or Attacker=19) then 1 end) as RightServe1 
	from NOV23UPLOAD where ReceiveType='S' and PassQuality='1' and setID<13 and SetID>=10