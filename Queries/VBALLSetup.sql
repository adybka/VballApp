Use Volleyball1;

Drop table if exists Teams;
Drop table if exists Players;

IF NOT EXISTS(select * from sys.objects WHERE name='Teams')
	CREATE TABLE Teams(
		TName varchar(64) primary key
		)

IF NOT EXISTS(select * from sys.objects WHERE name='Players')
	CREATE TABLE Players(
		PName varchar(64),
		TeamName varchar(64) NOT NULL,
		Number integer NOT NULL,
		position varchar(2),
		foreign key(TeamName) references Teams(TName) on delete cascade
		)
