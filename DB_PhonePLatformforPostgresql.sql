create table users(
	Username varchar(255),
    Password varchar(255),
    Idnumber varchar(255),
    Name varchar(25),
    Surname varchar(25),
    Phonenumber varchar(25),
    Address varchar(25),
    Primary key (Username,Password)
);

create table StatusBuy(
	Status varchar(25),
    Username varchar(255),
    Password varchar(255),
    model varchar(25),
    price varchar(25),
    date varchar(25),
    primary key(Status,Username,Password,model,price,date)
);

create table admin(
	username varchar(255),
    password char(255),
    primary key (username,password)    
);
