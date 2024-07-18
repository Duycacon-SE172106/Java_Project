create database MyShop
use MyShop
use master

create table Mobiles(
mobileId varchar(10) primary key,
description varchar(250) not null,
price float,
mobileName varchar(200) not null,
yearOfProduction int,
quantity int,
notSale bit 
)

create table Users(
userId varchar(20) primary key,
fullName varchar(50) not null,
role int,
password varchar(20) not null
)

drop database MyShop
insert into Mobiles values('1','IP',35000000,'Iphone 15 ProMax',2023,30,0)
insert into Mobiles values('2','IP',30000000,'Iphone 15 Pro',2023,25,0)
insert into Mobiles values('3','IP',25000000,'Iphone 14 ProMax',2022,35,0)
insert into Mobiles values('4','IP',23000000,'Iphone 14 Pro',2022,40,0)
insert into Mobiles values('5','SS',28000000,'SamSung Galaxy S9',2023,35,0)
insert into Mobiles values('6','SS',10000000,'SamSung A54',2022,30,0)
insert into Mobiles values('7','SS',15000000,'SamSung Galaxy Note 10',2021,15,0)
insert into Mobiles values('8','OP',4000000,'Oppo A55 ',2022,25,0)
insert into Mobiles values('9','OP',9000000,'Oppo Reno11',2023,25,0)
insert into Mobiles values('10','RM',7000000,'Redmi Note 12',2023,35,0)

insert into Users values('Bob',123,'Alert Bob',0)
insert into Users values('Anna',123,'Anni Anna',0)
insert into Users values('Join',123,'Leo Join',0)
insert into Users values('Christ',123,'Than Christina',1)
insert into Users values('Emi',123,'Rose Emi',1)
insert into Users values('Rob',123,'Fatina Rob',1)

SELECT fullName, role FROM Users WHERE userId = 'Bob' AND password = 123
SELECT fullName, role FROM Users WHERE userId ='Rob' AND password ='123'
select * from Users