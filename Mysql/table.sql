use csit314;
CREATE TABLE Customer
(
    cusNum   int auto_increment,
    cusPw    varchar(50) not null,
    cusName  VARCHAR(50) not null,
    cusDOB   date not null,
    phoneNum VARCHAR(50) not null,
    vipStart date default '2022-04-02',
    vipEnd   date default '2022-04-03',
    email    VARCHAR(80) not null,
    gender   VARCHAR(10) not null,
    plateNum varchar(20) not null,
    vehicleModel varchar(80) not null,
    primary key (cusNum)
);
CREATE TABLE Professional
(
    proNum   int auto_increment,
    proPw    varchar(50) not null,
    proName  VARCHAR(50) not null,
    proDOB   date not null,
    phoneNum VARCHAR(50) not null,
    pLevel   FLOAT,
    balance  FLOAT,
    location varchar(100),
    email    VARCHAR(80) not null,
    gender   VARCHAR(10) not null,
    primary key (proNum)
);
CREATE TABLE Vehicle
(
    plateNum varchar(50) PRIMARY KEY,
    model    VARCHAR(150) NOT NULL,
    cusNum   INT          NOT NULL,
    FOREIGN KEY (cusNum) references Customer (cusNum)
);
CREATE TABLE orders
(
    orderid        int,
    orderStartDate DATE,
    vehiclePlate varchar(50),
    price          FLOAT,
    location       VARCHAR(80),
    issue          varchar(150),
    O_cusNum         int not null,
    O_proNum         int not null,
    orderEndDate   DATE,
    review         text,
    rating         FLOAT,
    payCardNum     varchar(50),
    payType        varchar(20),
    primary key orders (orderid),
    foreign key (O_cusNum) references Customer (cusNum),
    foreign key (O_proNum) references Professional (proNum)
);
CREATE TABLE cur_orders
(
    cur_orderid        int auto_increment,
    orderStartDate DATE,
    vehiclePlate varchar(50),
    price          FLOAT,
    c_location       VARCHAR(80),
    issue          varchar(150),
    O_cusNum         int not null,
    O_proNum         int,
    sstate          varchar(30),
    primary key cur_orders (cur_orderid),
    foreign key (O_cusNum) references Customer (cusNum)
);

create trigger updateBal after insert
    on orders
    for each row
    begin
        update Professional set balance =balance+ NEW.price*0.5 where proNum = NEW.O_proNum;
    end;

create trigger updateplevel after insert
    on orders
    for each row
    begin
        update Professional set pLevel =0.9*plevel+ 0.1*NEW.rating where proNum = NEW.O_proNum;
    end;

create trigger delCurrOrder after insert
    on orders
    for each row
    begin
        delete from cur_orders where cur_orderid = New.orderid;
    end;
drop trigger updateBal;

drop table orders;
drop table Vehicle;
drop table customer;
drop table cur_orders;

drop table Professional;


-- # insert into customer(cusName, phoneNum, vipStart, vipEnd, email, gender)
-- #     value ('name', 'phoneNum', '1999-10-12', '2000-10-12', 'email', 'male');
-- #
-- # insert into professional(proName, phoneNum,pLevel,balance,location, email, gender)
-- #     value ('pname2', 'phoneNum',10,1100,'location','email', 'male');
-- #
-- # insert into orders(orderStartDate,cusNum,price,vehiclePlate,location,issue,proNum,orderEndDate,review,rating,payCardNum,payType)
-- # value ('1999-10-12',1,50,'plate','loaction','issue',3,'1999-10-12','124321535145124123review',
-- #       3,'12415135','income');
-- #
-- # insert into CUSTOMER (cusPw,cusName,cusDOB,phoneNum,vipStart,vipEnd,email,gender) values
-- # ('passw', 'name', '1999-10-12', '14141', '1999-10-12', '1999-10-12','111@131','ma');
-- #
-- # insert into Vehicle(plateNum, model, cusNum) VALUE ('plateNum','BMW',1);
-- # commit ;
-- #
-- #
-- # UPDATE customer  SET cusName='123',gender='male',cusDOB='2022-05-19',phoneNum='1231',cusPw='123133',email='123@312.com',plateNum='1231',vehicleModel='123123' WHERE cusNum = 8;
-- #
-- #

