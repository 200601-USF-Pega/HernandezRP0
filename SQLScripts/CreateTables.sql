Create table users (
	uId serial primary key,
	username varchar(50),
	fName varchar(25),
	lName varchar(25),
	passwd varchar(15),
	role varchar(10)
);
Create table products(
	pId serial primary key,
	name varchar(25),
	price decimal,
	description varchar(250),
	status varchar(25)
);
Create table bikes(
	bikeId serial primary key,
	model varchar(25),
	uId serial references users(uId)
);
Create table repair(
	repairId serial primary key,
	status varchar(25),
	uId serial references users(uId),
	bikeId serial references bikes(bikeId)
);
Create table bills(
	billId serial primary key,
	balance decimal,
	status varchar(25),
	uId serial references users(uId),
	bikeId serial references bikes(bikeId)
);
